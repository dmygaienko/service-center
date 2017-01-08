package com.mygaienko.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * Created by dmygaenko on 15/11/2016.
 */
public class TestUtils {

    @Test
    public void testEncoder() throws Exception {
        System.out.println(new BCryptPasswordEncoder(16).encode("password"));
    }

    @Test
    public void testAction() {
        test(() -> System.out.println("ololo"));
    }

    public static void test(Action action){
        action.doAction();
    }

    @FunctionalInterface
    interface Action {
        void doAction();
    }

    @Test
    public void test1() {
        final List<Integer> numbers = range(1, 12)
                .boxed()
                .collect(toList());
        System.out.println(numbers);

        final List<List<Integer>> groups = range(0, numbers.size())
                .boxed()
                .collect(groupingBy(index -> index / 4))
                .values()
                .stream()
                .map(indices -> indices
                        .stream()
                        .map(numbers::get)
                        .collect(toList()))
                .collect(toList());
        System.out.println(groups);

       /* final Collection map1 = range(0, numbers.size())
                .mapToObj(i -> range());
        System.out.println(map1);*/
    }


}
