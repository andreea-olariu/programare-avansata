package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassesInfo {

    private Class loadedClass = null;
    private Class loadedTest = null;


    public void loadClasses() {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            loadedClass = classLoader.loadClass("org.example.Cat");
            loadedTest = classLoader.loadClass("org.example.CatTest");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Package getPackage() {
        return loadedClass != null ? loadedClass.getPackage() : null;
    }

    public Method[] getMethodsClass() {
        return loadedClass != null ? loadedClass.getMethods() : null;
    }

    public Method[] getMethodsTest() {
        return loadedTest != null ? loadedTest.getDeclaredMethods() : null;
    }

    public void invokeStaticTestNoArgsMethods() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = getMethodsTest();
        for (Method method : methods) {
            if (method.getParameterCount() == 0 &&
                    Modifier.isStatic(method.getModifiers()) &&
                    method.isAnnotationPresent(Test.class)) {
                method.invoke(null);
            }
        }
    }
}
