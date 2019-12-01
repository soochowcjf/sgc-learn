package com.design.patterns.chapter5.enhanced;

import com.design.patterns.chapter5.Girl;

import java.util.List;

/**
 * @author cjf on 2019/12/1 22:51
 */
public class GroupLeader {

    private List<Girl> list;

    public void setList(List<Girl> list) {
        this.list = list;
    }

    public void countList() {
        System.out.println(list.size());
    }
}
