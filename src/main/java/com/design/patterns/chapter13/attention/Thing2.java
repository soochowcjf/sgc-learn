package com.design.patterns.chapter13.attention;

import java.util.ArrayList;

/**
 * 深拷贝和浅拷贝
 *
 * @author cjf on 2019/12/4 15:57
 */
public class Thing2 implements Cloneable {

    private String name;
    private int age;

    private ArrayList<String> addresses = new ArrayList<>();

    public Thing2() {
    }

    public Thing2(String name, int age, ArrayList<String> addresses) {
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<String> addresses = new ArrayList<>();
        addresses.add("北京");
        addresses.add("上海");
        Thing2 thing2 = new Thing2("张三", 20, addresses);
        System.out.println("Thing2: " + thing2);
        Thing2 clone = thing2.clone();
        clone.getAddresses().add("深圳");
        clone.setName("王五");
        clone.setAge(22);
        System.out.println("Thing2: " + thing2);
        System.out.println("clone: " + clone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<String> addresses) {
        this.addresses = addresses;
    }

//    /**
//     * 浅拷贝
//     *
//     * @return
//     * @throws CloneNotSupportedException
//     */
//    @Override
//    protected Thing2 clone() throws CloneNotSupportedException {
//        Thing2 thing2 = null;
//        try {
//            thing2 = (Thing2) super.clone();
//        } catch (CloneNotSupportedException e) {
//            //
//        }
//        return thing2;
//    }

    @Override
    public String toString() {
        return "Thing2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }

    /**
     * 深拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Thing2 clone() throws CloneNotSupportedException {
        Thing2 thing2 = null;
        try {
            thing2 = (Thing2) super.clone();
            thing2.addresses = (ArrayList<String>) this.addresses.clone();
        } catch (CloneNotSupportedException e) {
            //
        }
        return thing2;
    }
}
