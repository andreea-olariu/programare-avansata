package org.example.cat;

import org.junit.jupiter.api.Test;

public class Cat {
    private int age;
    private String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysOfLife() {
        return this.age * 365 + this.age % 4;
    }

    public char getFirstLetterOfName() {
        return this.name.charAt(0);
    }

}
