package com.template.provider.admin.biz;

import org.springframework.stereotype.Service;

import com.template.provider.admin.entity.Notice;
import com.template.provider.admin.mapper.NoticeMapper;
import com.template.common.biz.BaseBiz;

/**
 * 系统通知表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:53
 */
@Service
public class NoticeBiz extends BaseBiz<NoticeMapper,Notice> {
}