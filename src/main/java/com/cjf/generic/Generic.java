package com.cjf.generic;

/**
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 */
public class Generic<T> {

    /**
     * key这个成员变量的类型为T,T的类型由外部指定
     */
    private T key;

    /**
     * 泛型构造方法形参key的类型也为T，T的类型由外部指定
     */
    public Generic(T key) {
        this.key = key;
    }

    /**
     * 泛型方法getKey的返回值类型为T，T的类型由外部指定
     */
    public T getKey() {
        return key;
    }

    /**
     * 泛型方法的基本介绍
     *
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <E> E genericMethod(Class<E> tClass) throws InstantiationException,
            IllegalAccessException {
        return tClass.newInstance();
    }

    public static void showKeyValue(Generic<Number> obj) {
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    public static void showKeyValue1(Generic<?> obj) {
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<>("key_value");
        System.out.println("泛型测试 key is " + genericInteger.getKey());
        System.out.println("泛型测试 key is " + genericString.getKey());


        //---------------------------------------------------------------//

        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);

        showKeyValue(gNumber);

        // showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
        // cannot be applied to Generic<java.lang.Number>
//         showKeyValue(gInteger);


        //可以解决当具体类型不确定的时候，这个通配符就是 ?
        showKeyValue1(gInteger);
        showKeyValue1(gNumber);


        //--------------------------------------------------------------//
        try {

            Generic<String> objectGeneric = new Generic<>("AAA");
            FruitGenerator1 generator = (FruitGenerator1) objectGeneric.genericMethod(Class.forName("com.cjf.generic.FruitGenerator1"));
            System.out.println(generator.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}