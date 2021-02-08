package com.reactor;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by cjf 2020/7/28 15:23
 */
public class Demo {
    @Test
    public void testMono1() {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }

    @Test
    public void testMono2() {
        Mono.fromSupplier(() -> "Mono1").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Mono2")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Mono3")).subscribe(System.out::println);
    }

    @Test
    public void testFlux1() {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
    }

    @Test
    public void testFlux2() {
        Flux.generate(sink -> {
            sink.next("Echo");
            sink.complete();
        }).subscribe(System.out::println);
    }

    @Test
    public void testFlux3() {
        Flux.create(sink -> {
            for (char i = 'a'; i <= 'z'; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::print);
    }


    @Test
    public void testF() {

        //扁平化流
        //找出数组中唯一的字符
        String[] strArray = {"hello", "world"};
        //具体实现
        List<String> res = Arrays.stream(strArray)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());


        System.out.println(res);


        Integer[] nums2 = {1, 2, 3};
        Integer[] nums3 = {3, 4};

        List<Integer> nums2List = Arrays.asList(nums2);
        List<Integer> nums3List = Arrays.asList(nums3);

        //使用2个map嵌套过滤
        List<int[]> res2 = nums2List.stream().flatMap(i -> nums3List.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(res2));


        System.out.println("--------------------------------");

        //Demo3:针对Demo2和Demo1组合返回总和能被3整除的数对
        //(2,4)和(3,3)是满足条件的
        List<int[]> res3 = nums2List.stream().flatMap(i -> nums3List.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(res3));

        List<Stream<int[]>> collect = nums2List.stream().map(i -> nums3List.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));
    }

    @Test
    public void test2() {
        /**获取单词，并且去重**/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world", "hello world welcome");

        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");

        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        System.out.println("---------- ");

        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("================================================");

        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

    }

    @Test
    public void test3() {
        Mono.just("1")
                .map(a -> a + "1")
                .subscribe(System.out::println);
        Mono.just("1").flatMap(a -> Mono.just(a + "1")).subscribe(System.out::println);
        Flux.just("1").map(a -> a + "1").subscribe(System.out::println);
        Flux.just("1").flatMap(a -> Flux.just(a + "1")).subscribe(System.out::println);
    }

    @Test
    public void decode() {
        String str = "eyJhZGRyZXNzIjoi5Zub5bed55yB5oiQ6YO95biC5q2m5L6v5Yy655uK5bee5aSn6YGT5Y2X5q61KOaIkOmDveW4guatpuS+r+WMuinlpKnlupzkupTooZfliJvkuJrlpKfljqZHNeagizEz5qW8IiwiYmlsbE5vIjoiMjAwODIxMTYzNzEwNzgwOTk2NDgiLCJjaGFuZ2UiOjAsImN1ck9yZ0NvZGUiOiJDMDAyIiwiY3VzdEZsYWciOjAsImN1c3RvbU1vYmlsZSI6IjE1MTk4MTEwNTI2IiwiY3VzdG9tTmFtZSI6IumZiOaeneiusCIsImN1c3RvbVRlbCI6IjE1MTk4MTEwNTI2IiwiZGVhbFR5cGUiOjAsImVjd0NoYW5nZSI6MCwiZmtUb3RhbCI6MSwiZnJlZUFtdCI6MCwiZnJlZUNoZyI6MCwiaXNNdWx0aSI6MCwiaXNSdG5lZCI6MCwib3JkRGF0ZSI6IjIiLCJvcmRTdGF0dXMiOjEwLCJvcmRUaW1lIjoiMCIsIm9yZFRvdGFsIjoxLCJvcmRUeXBlIjoiRDAxIiwib3JnQ29kZSI6IkMwMDIiLCJvcmdOYW1lIjoi5omr56CB6LSt5rWL6K+V6Zeo5bqXIiwicG9zTm8iOiIwNTkxIiwicmVtYXJrIjoiIiwicm91bmRBbXQiOjAsInNlbmRGbGciOjAsInNuZFRrdCI6MCwic291cmNlQmlsbE5vIjoiIiwidGhEYXRlIjoiMiIsInRoTW9kZSI6IkMwMiIsInRoT3JnQ29kZSI6IkMwMDIiLCJ0aFRpbWUiOiIwIiwidG90YWxEc2MiOjAsInRvdGFsUGF5IjoxLCJ0cmFkZURhdGUiOiIyIiwid2ZrVG90YWwiOjAsInlma1RvdGFsIjoxLCJ5alRvdGFsIjowfQ==";
        byte[] decode = Base64.getDecoder().decode(str);
        String s = new String(decode);
        System.out.println(s);
    }

}
