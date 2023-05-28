package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {


    @Test
    static void getFirstLetterOfNameTest() {
        System.out.println("Testing method");
        Cat cat = new Cat(2, "Linux");
        assertEquals(cat.getFirstLetterOfName(), 'L');
    }
}
