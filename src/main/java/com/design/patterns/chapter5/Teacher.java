package com.design.patterns.chapter5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cjf on 2019/12/1 22:49
 */
public class Teacher {

    public void commond(GroupLeader groupLeader) {
        List<Girl> collect = Stream.generate(Girl::new).limit(100).collect(Collectors.toList());
        groupLeader.countList(collect);
    }
}
