package org.dpo.hrr.easy;

public class SingletonStatic {


    private static SingletonStatic instance;

    private SingletonStatic() {
    }

    public String str;

    public static SingletonStatic getSingleInstance() {
        if (instance == null) {
            instance = new SingletonStatic();
        }

        return instance;
    }

}

