package H_W.main;

import H_W.test.TestClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;

public class TestRunner {
    public static void start(Class<?> inputClass) throws Exception {
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<Method> testMethods = new ArrayList<>();

        Method[] methods = inputClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Multiple @BeforeSuite methods found");
                }
                beforeSuiteMethod = method;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Multiple @AfterSuite methods found");
                }
                afterSuiteMethod = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(null);
        }

        for (Method method : testMethods) {
            method.invoke(null);
        }

        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(null);
        }
    }

    public static void main(String[] args) throws Exception {
        start(TestClass.class);
    }

}