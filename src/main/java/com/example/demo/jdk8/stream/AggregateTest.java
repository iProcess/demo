package com.example.demo.jdk8.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregateTest {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            Apple apple = new Apple(i%2 + "", 10 + "");
            apples.add(apple);
        }

        int sum = apples.parallelStream()
                .map(apple -> {
                    apple.setWeightInt(Integer.parseInt(apple.getWeight()));
                    return apple;
                })
                .mapToInt(Apple::getWeightInt).sum();
        System.out.println(sum);

        Map<String, IntSummaryStatistics> collect = apples.parallelStream().collect(
                Collectors.groupingBy(Apple::getId,
                        Collectors.summarizingInt(Apple::getWeightInt)));

        for (Map.Entry<String, IntSummaryStatistics> entry : collect.entrySet()) {
            IntSummaryStatistics longSummaryStatistics = entry.getValue();
            System.out.println("----------------key----------------" + entry.getKey());
            System.out.println("求和:" + longSummaryStatistics.getSum());
            System.out.println("求平均" + longSummaryStatistics.getAverage());
            System.out.println("求最大:" + longSummaryStatistics.getMax());
            System.out.println("求最小:" + longSummaryStatistics.getMin());
            System.out.println("求总数:" + longSummaryStatistics.getCount());
        }
    }
}
