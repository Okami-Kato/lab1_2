package com.okarin.runner;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;

public class CustomRunner extends Runner {
    private final Class<?> testClass;

    public CustomRunner(Class<?> testClass) {
        this.testClass = testClass;
    }

    @Override
    public Description getDescription() {
        return Description.createTestDescription(testClass, "My runner description");
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println("running the tests from MyRunner. " + testClass);
        try {
            Object testObject = testClass.newInstance();
            for (Method method : testClass.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    notifier.fireTestStarted(Description.EMPTY);
                    method.invoke(testObject);
                    notifier.fireTestFinished(Description.EMPTY);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
