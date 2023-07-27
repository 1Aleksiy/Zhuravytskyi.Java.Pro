package com.hillel.zhuravytskyi.homeworks.homework19;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeSuiteMethods = new ArrayList<>();
        List<Method> afterSuiteMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (!beforeSuiteMethods.isEmpty()) {
                    throw new RuntimeException("Multiple methods with @BeforeSuite annotation found");
                }
                beforeSuiteMethods.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (!afterSuiteMethods.isEmpty()) {
                    throw new RuntimeException("Multiple methods with @AfterSuite annotation found");
                }
                afterSuiteMethods.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

        if (!beforeSuiteMethods.isEmpty()) {
            beforeSuiteMethods.get(0).invoke(null);
        }
        for (Method method : testMethods) {
            method.invoke(null);
        }
        if (!afterSuiteMethods.isEmpty()) {
            afterSuiteMethods.get(0).invoke(null);
        }
    }
}
