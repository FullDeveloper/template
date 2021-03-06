package com.template.cache.util;

import com.template.cache.bean.CacheTree;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    public static List<CacheTree> buildTree(List<CacheTree> trees) {
        List<CacheTree> list = new ArrayList<CacheTree>();
        for (CacheTree tree : trees) {
            if (tree.getParentId().equals("-1")) {
                list.add(tree);
            }
            for (CacheTree t : trees) {
                if (t.getParentId().equals(tree.getId())) {
                    if (tree.getNodes() == null) {
                        List<CacheTree> myChildrens = new ArrayList<CacheTree>();
                        myChildrens.add(t);
                        tree.setNodes(myChildrens);
                    } else {
                        tree.getNodes().add(t);
                    }
                }
            }
        }
        return list;
    }

}
