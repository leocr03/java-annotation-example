package com.leocr.processor;

import com.leocr.annotations.GenerateValuesFrom;
import com.leocr.example.Example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateValuesProcessor {
    public void process(Example example) {
        for (Field field : Example.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(GenerateValuesFrom.class)) {
                final GenerateValuesFrom annotation = field.getAnnotation(GenerateValuesFrom.class);
                try {
                    final String range = field.get(example).toString();
                    final Class type = annotation.type();

                    if (type == Integer.class) {
                        final List<Integer> endValues = Stream.of(range)
                                .map(r -> r.split("-"))
                                .map(rs -> {
                                    final List<Integer> values = new ArrayList<>();
                                    //noinspection ResultOfMethodCallIgnored
                                    IntStream.rangeClosed(Integer.valueOf(rs[0]), Integer.valueOf(rs[1]))
                                            .mapToObj(value -> {
                                                values.add(value);
                                                System.out.println("the value: " + value);
                                                return value;
                                            })
                                            .count();
                                    return values;
                                })
                                .reduce((integers, integers2) -> integers)
                                .orElse(new ArrayList<>());

                        System.out.println(endValues);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
