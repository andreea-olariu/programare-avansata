package org.example;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, MalformedURLException {
        List<Class<?>> classes = new ArrayList<>();
        ClassesInfo.loadClassesFromDirectory("target/test-classes", classes);
        for(Class<?> clazz : classes) {
            ClassesInfo.testStatistics(clazz);
        }

    }
}