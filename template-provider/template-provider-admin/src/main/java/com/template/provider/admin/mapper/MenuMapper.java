package com.template.provider.admin.mapper;

import com.template.provider.admin.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 系统菜单表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:54
 */
public interface MenuMapper extends Mapper<Menu> {

    List<Menu> selectAuthorityMenuByUserId(@Param("userId") int userId);
}
