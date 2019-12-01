package com.design.patterns.chapter5;

/**
 * @author cjf on 2019/12/1 23:01
 */
public class Client {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        GroupLeader groupLeader = new GroupLeader();
        teacher.commond(groupLeader);
    }
}
