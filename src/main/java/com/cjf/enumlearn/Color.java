package com.cjf.enumlearn;

/**
 * @author:chenjinfeng
 * @Date:2018/5/30
 * @Time:21:53 用法三：向枚举中添加新方法
 */
public enum Color implements Behaviour{
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLO("黄色", 4);
    //成员变量
    private String name;
    private int index;

    //构造方法
    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //普通方法
    public static String getName(int index) {
        for (Color color : Color.values()) {
            if (color.index == index) {
                return color.name;
            }
        }
        return null;
    }

    //用法四：覆盖枚举的方法
    @Override
    public String toString() {
        return this.name+" : "+this.index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
//        String name = getName(5);
//        System.out.println(name);

        Color blank = Color.BLANK;
        System.out.println(blank);
    }
    //接口中的方法
    public void print() {
        System.out.println(this.name + " : " + this.index);
    }

    public String getInfo() {
        return this.name;
    }
}
