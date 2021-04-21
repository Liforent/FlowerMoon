package com.zss.liforent.flowermoon.mytest;

import androidx.annotation.Nullable;

import java.util.Arrays;

class TestJava {
    public static void main(String[] args) {
        A c = new A(10);
        A d = new A(10);
        String e = "11";
        String aa = new String(e);
        System.out.println(c == d);
        System.out.println("args = " + c.equals(d));
        System.out.println(aa == e);
        System.out.println(aa.equals(e));
    }


}

class A {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public A(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null;
        return this.a == ((A) obj).a;
    }
}