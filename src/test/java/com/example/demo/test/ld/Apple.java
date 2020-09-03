package com.example.demo.test.ld;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Data
public class Apple {

    private String color;
    private int weight;


    public static List<Apple> filterGreenApples(List<Apple> inventory ){

        List<Apple> result = new ArrayList<>();
        for ( Apple apple : inventory ){
            if ( "green".equals( apple.getColor() ) ){
                result.add( apple );
            }
        }
        return(result);
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory ){
        List<Apple> result = new ArrayList<>();
        for ( Apple apple : inventory ){
            if ( apple.getWeight() > 150 ){
                result.add( apple );
            }
        }
        return(result);
    }

    public static boolean isGreenApple( Apple apple ){
        return("green".equals( apple.getColor() ) );
    }


    public static boolean isHeavyApple( Apple apple ){
        return(apple.getWeight() > 150);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p ){
        List<Apple> result = new ArrayList<>();
        for ( Apple apple : inventory ){
            if ( p.test( apple ) ){
                result.add( apple );
            }
        }
        return(result);
    }


    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            Apple apple = new Apple();
            apple.setColor( i % 2 == 0 ? "red" : "green");
            apple.setWeight(i);
            inventory.add(apple);
        }
        System.out.println(JSON.toJSONString(inventory));
        List<Apple> greenApple = filterApples(inventory, Apple::isGreenApple);
        System.out.println(JSON.toJSONString(greenApple));
        List<Apple> heavyApple = filterApples(inventory, Apple::isHeavyApple);
        System.out.println(JSON.toJSONString(heavyApple));

        List<Apple> greenApple1 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()) );
        System.out.println(JSON.toJSONString(greenApple1));

        List<Apple> heavyApple1 = filterApples(inventory, (Apple a) -> a.getWeight() > 3 );
        System.out.println(JSON.toJSONString(heavyApple1));

        List<Apple> heavyAppleGreen = filterApples(inventory, (Apple a) -> a.getWeight() < 3 || "green".equals(a.getColor()) );
        System.out.println(JSON.toJSONString(heavyAppleGreen));

    }

}
