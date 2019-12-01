package com.design.patterns.chapter5.enhanced;


import com.design.patterns.chapter5.Girl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cjf on 2019/12/1 23:01
 */
public class Client {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        GroupLeader groupLeader = new GroupLeader();
        List<Girl> collect = Stream.generate(Girl::new).limit(100).collect(Collectors.toList());
        groupLeader.setList(collect);
        teacher.commond(groupLeader);
    }
}
