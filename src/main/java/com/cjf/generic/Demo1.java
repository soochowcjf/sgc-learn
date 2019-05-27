package com.cjf.generic;

public class Demo1 {

    public static void main(String[] args) {

        Box<String> name = new Box<>("cjf");
        System.out.println("name:" + name.getData());
        System.out.println(name.getData(111));
    }


    static class Box<T> {

        private T data;

        public Box() {

        }

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public <E> E getData(E e) {
            return e;
        }

    }
}
