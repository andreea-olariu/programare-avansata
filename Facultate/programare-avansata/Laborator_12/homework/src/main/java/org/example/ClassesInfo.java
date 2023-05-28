package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ClassesInfo {

    static void loadClassesFromDirectory(String directoryPath, List<Class<?>> classes) throws MalformedURLException {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        URLClassLoader clazzLoader = URLClassLoader.newInstance(new URL[]{directory.toURI().toURL()});

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    loadClassesFromDirectory(file.getAbsolutePath(), classes);
                } else if (file.isFile() && file.getName().endsWith(".class")) {
                    String className = getClassNameFromFile(file);
                    if (className != null) {
                        try {
                            Class<?> clazz = Class.forName(className, true, clazzLoader);
                            classes.add(clazz);
                        } catch (ClassNotFoundException e) {
                            System.err.println("Failed to load class: " + className);
                        }
                    }
                }
            }
        }
    }

    private static String getClassNameFromFile(File file) {
        String absolutePath = file.getAbsolutePath();
        return absolutePath.substring(absolutePath.indexOf("classes") + 8, absolutePath.lastIndexOf('.'))
                .replace(File.separatorChar, '.');
    }

    static String classDetails(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: " + clazz.getName() + ":\n");
        stringBuilder.append("in the package " + clazz.getPackage() + "\n");
        stringBuilder.append("fields:\n");
        for (var field : clazz.getDeclaredFields()) {
            stringBuilder.append("\t" + field.getName() + "\n");
        }

        stringBuilder.append("methods:\n");
        for (var method : clazz.getMethods()) {
            stringBuilder.append("\t" + method.getName() + "\n");
        }

        return stringBuilder.toString();
    }

    public static int invokeMethod(Class<?> clazz, Method method) {
        int passed = 0;
        Random random = new Random();
        List<Integer> params = new ArrayList<>();

//        Class<?>[] paramsType = method.getParameterTypes();
//
//        for (var paramType : paramsType) {
//            if (paramType.getTypeName().equals("int")) {
//                params.add(random.nextInt(200));
//            }
//        }
//
        try {
            method.invoke(null);
            passed++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return passed;
    }


    public static void invokeTestNoArgsMethods(List<Class<?>> classes) {

        for (Class<?> clazz : classes) {
            if (Modifier.isPublic(clazz.getModifiers())) {
                for (Method method : clazz.getMethods()) {
                    if (method.isAnnotationPresent(Test.class)) {
                        invokeMethod(clazz, method);
                    }
                }
            }
        }
    }



    public static void testStatistics(Class<?> clazz) {
        int passed = 0;
        System.out.println(clazz.getName());
        if (Modifier.isPublic(clazz.getModifiers())) {
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    System.out.println("\n\t" + method.getName());
                    System.out.println("\t\tNumber of parameters:" + method.getParameterCount());
                    System.out.println("\t\tArguments:" + Arrays.toString(method.getParameterTypes()));
                    passed += invokeMethod(clazz, method);
                }
            }
        }
        System.out.println("\n\n\tS-au trecut: " + passed);
    }
}
