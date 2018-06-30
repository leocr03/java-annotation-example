package com.leocr.processor;

import com.leocr.annotations.LogMetric;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class LogMetricProcessor {
    public void process(Class obj) {
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogMetric.class)) {
                Annotation annotation = method.getAnnotation(LogMetric.class);
                LogMetric logMetric = (LogMetric) annotation;

                if (logMetric.verbose()) {
                    System.out.println("Hey! It's a verbose. Let's talk about this method. Its name is ["
                            + method.getName() + "]");
                } else {
                    System.out.println("Simple: " + method.getName());
                }
            }
        }
    }
}
