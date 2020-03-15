package com.java8.day02;

import com.java8.day01.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author:chenjinfeng
 * @date: 2018/8/25
 * @time: 23:44
 * @desc
 */
public class TestOptional {

    @Test
    public void test4() {
        Optional<Employee> op = Optional.of(new Employee("张三", 101, 9999.99, Employee.Status.FREE));

        Optional<String> op2 = op.map(Employee::getName);
        System.out.println(op2.get());

        Optional<String> op3 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(op3.get());
    }

    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(new Employee());

        if (op.isPresent()) {
            System.out.println(op.get());
        }

        Employee emp = op.orElse(new Employee("张三"));
        System.out.println(emp);

        Employee emp2 = op.orElseGet(() -> new Employee());
        System.out.println(emp2);
    }

    @Test
    public void test2() {
		/*Optional<Employee> op = Optional.ofNullable(null);
		System.out.println(op.get());*/

//		Optional<Employee> op = Optional.empty();
//		System.out.println(op.get());
    }

    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee emp = op.get();
        System.out.println(emp);
    }

    @Test
    public void test5() {
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }

    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man) {
        if (man != null) {
            Godness g = man.getGod();

            if (g != null) {
                return g.getName();
            }
        }

        return "苍老师";
    }

    //运用 Optional 的实体类
    @Test
    public void test6() {
        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));

        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }

    @Test
    public void test7() {
        Optional<Godness> godness = Optional.ofNullable(new Godness());

        Optional<NewMan> man = Optional.ofNullable(new NewMan(godness));

        String unknow = man.flatMap(NewMan::getGodness)
                .map(Godness::getName)
                .orElse("unknow");
        System.out.println(unknow);
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<NewMan> person, Optional<Godness> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    private Insurance findCheapestInsurance(NewMan p, Godness c) {
        return null;
    }


    public class Person {
        private Optional<Car> car;

        public Optional<Car> getCar() {
            return car;
        }
    }

    public class Car {
        private Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    public class Insurance {
        private String name;

        public String getName() {
            return name;
        }
    }

}
