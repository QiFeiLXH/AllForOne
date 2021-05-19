package org.qifei.threadLocal;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/23 15:23
 * @Description
 */
public class Person {
    String name;

    public Person() {
    }


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    private void getLoad() {

    }

    private void getLoad(int a ) {
    }
}
