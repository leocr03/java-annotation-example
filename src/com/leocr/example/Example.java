package com.leocr.example;

import com.leocr.annotations.GenerateValues;
import com.leocr.annotations.GenerateValuesFrom;
import com.leocr.annotations.LogMetric;

import java.util.List;

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

    @GenerateValuesFrom(id = "intValues")
    public String intValuesFrom;

    @GenerateValues(id = "intValues")
    public List<Integer> intValues;

    public String getIntValuesFrom() {
        return intValuesFrom;
    }

    public void setIntValuesFrom(String intValuesFrom) {
        this.intValuesFrom = intValuesFrom;
    }

    public List<Integer> getIntValues() {
        return intValues;
    }

    public void setIntValues(List<Integer> intValues) {
        this.intValues = intValues;
    }
}
