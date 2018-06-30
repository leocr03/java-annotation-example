package com.leocr.example;

import com.leocr.annotations.LogMetric;

public class Example {

    public int sum(int a, int b) {
        return a + b;
    }

    @LogMetric
    public int multiply(int a, int b) {
        return a * b;
    }

    @LogMetric(verbose = true)
    public int divide(int a, int b) {
        return a / b;
    }
}
