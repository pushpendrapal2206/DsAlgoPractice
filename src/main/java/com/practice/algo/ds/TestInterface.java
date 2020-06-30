package com.practice.algo.ds;


interface A {
    void add();
}

@FunctionalInterface
interface B {
    void add();
}

public class TestInterface implements A, B {
    @Override
    public void add() {
        System.out.print("success");
    }

    public static void main(String[] s) {
        new TestInterface().add();
    }
}
