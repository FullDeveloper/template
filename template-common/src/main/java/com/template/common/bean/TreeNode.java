package com.template.common.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By Project template
 * <p>
 * author: zrb
 * date: 2018/5/5
 * TIME: 下午12:49
 * description:
 */
@Data
public class TreeNode {

    private String id;

    private String label;

    private List<TreeNode> children = new ArrayList<>();

}
