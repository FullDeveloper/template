package com.template.common.util;

import com.template.common.bean.Diff;
import com.template.common.bean.WrapObj;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Author: zrb
 * Date: 2018/4/24
 * Time: 14:20
 * Description:
 */
@Slf4j
public class CompareUtil {

    public static final List<String> COMPARE_FIELD_LIST;

    static {
        COMPARE_FIELD_LIST = new ArrayList<String>();
        COMPARE_FIELD_LIST.add("C1BILLCALSTART"); //账单统计起始日
        COMPARE_FIELD_LIST.add("C3BILLCALLENG");  //账单统计期时长
        COMPARE_FIELD_LIST.add("C4BILLLENG");     //账单统计截止日到账单日之间的时长
        COMPARE_FIELD_LIST.add("CP5BETWEENLENG"); //账单日到账单到期日之间的时长
        COMPARE_FIELD_LIST.add("CP6GRACE");          //账单宽限天数
        COMPARE_FIELD_LIST.add("CP9EXPIRERATE");  //分期后逾期费率
        COMPARE_FIELD_LIST.add("CP12MINPAY");      //最低分期金额
        COMPARE_FIELD_LIST.add("CP13MEMBERFEE");  //会员费金额金额
        COMPARE_FIELD_LIST.add("P14MFTYPE");     //会员费收取方式
        COMPARE_FIELD_LIST.add("P15MFCOUNTS");   //会员费首次收取是多少次
        COMPARE_FIELD_LIST.add("P16MFDAYS");      //或者多少天
        COMPARE_FIELD_LIST.add("C18MFINTERVAL"); //之后的每天频率会员费收取频率
        COMPARE_FIELD_LIST.add("CARD_TYPE_PERIODS"); //之后的每天频率会员费收取频率
    }

    public static Diff compareObjectDifferent(Object oldValue, Object newValue, Diff diffReport) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (oldValue == null || newValue == null)
            return null;
        log.info("begin compare " + oldValue.getClass().toString() + " and " + newValue.getClass().toString());
        //拿到这个类的所有字段
        List<Field> fieldList = FieldUtils.getAllFieldsList(oldValue.getClass());

        for (Field field : fieldList) {
            Diff diff = new Diff();
            //从对象中读取对应字段的值
            diff.setOldValue(FieldUtils.readField(oldValue, field.getName(), true));
            diff.setNewValue(FieldUtils.readField(newValue, field.getName(), true));
            diff.setFieldName(field.getName());
            //将这个字段的比较添加到集合中
            diffReport.getSubDiff().add(diff);

            //如果该字段是List集合
            if (field.getType().isAssignableFrom(List.class)) {
                List<Object> fieldOldList = (List<Object>) FieldUtils.readField(oldValue, field.getName(), true);
                List<Object> fieldNewList = (List<Object>) FieldUtils.readField(newValue, field.getName(), true);
                //空指针处理
                fieldOldList = fieldOldList == null ? new ArrayList<>() : fieldOldList;
                fieldNewList = fieldNewList == null ? new ArrayList<>() : fieldNewList;

                //集合预备操作
                Map<Long, WrapObj> list_OLD_SID = new TreeMap<>();
                Map<Long, WrapObj> list_NEW_SID = new TreeMap<>();

                {
                    for (int i = 0; i < fieldOldList.size(); i++) {
                        Object obj = fieldOldList.get(i);
                        Long sid = (Long) MethodUtils.invokeMethod(obj, "getSid", null);
                        list_OLD_SID.put(sid, new WrapObj(obj));
                    }
                    for (int i = 0; i < fieldNewList.size(); i++) {
                        Object obj = fieldNewList.get(i);
                        Long sid = (Long) MethodUtils.invokeMethod(obj, "getSid", null);
                        list_NEW_SID.put(sid, new WrapObj(obj));
                    }
                    //核心标记
                    Set<Map.Entry<Long, WrapObj>> es = list_OLD_SID.entrySet();
                    for (Map.Entry<Long, WrapObj> entry : es) {
                        Long k = entry.getKey();
                        if (list_NEW_SID.containsKey(k)) {
                            list_NEW_SID.get(k).setInOutside(true);
                            entry.getValue().setInOutside(true);//两边都要标记
                        }
                    }
                }

                //处理３部分：（１）New独有，标记为ADD (2)Old独有，标记为Del　（３）Both,进入递归比较
                Set<Map.Entry<Long, WrapObj>> es = list_NEW_SID.entrySet();
                for (Map.Entry<Long, WrapObj> entry : es) {
                    WrapObj v = entry.getValue();
                    //代表该条记录是新增 老的当中没有
                    if (!v.isInOutside()) {
                        Diff diffAdd = new Diff();
                        diff.getSubDiff().add(diffAdd);
                        diffAdd.setOldValue(null);
                        diffAdd.setNewValue(v.getObj());
                        diffAdd.setFieldName(field.getName());
                        diffAdd.setLevel(0); //实体
                        diffAdd.setType(2); //属于新增加
                        diffAdd.setDiff(1);
                        if (COMPARE_FIELD_LIST.contains(field.getName().toUpperCase())) {
                            diffAdd.setDiff(2);
                            System.err.println("\t [" + field.getName() + "]核心参数被修改 :" + diffAdd.getOldValue() + " ---->" + diffAdd.getNewValue());
                        }
                        if (diff.getDiff() < diffAdd.getDiff()) {
                            diff.setDiff(diffAdd.getDiff());
                        }
                        if(diffReport.getDiff() < diff.getDiff()){
                            diffReport.setDiff(diff.getDiff());
                        }
                    }

                }

            }

        }

        return null;
    }

}
