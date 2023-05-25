package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ClassesInfo ci = new ClassesInfo();
        ci.loadClasses();
        System.out.println(ci.getPackage());
        for(Method method : ci.getMethodsClass()) {
            System.out.println(method);
        }

        ci.invokeStaticTestNoArgsMethods();



    }
}