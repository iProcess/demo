package com.example.demo.jdk8.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/28 16:08
 * Description: TODO
 */
public class TestSort {

    public static void main(String[] args) {
        List<Person> peopleList = new ArrayList<>();

        Person person1 = new Person();
        person1.setUserId(1);
        person1.setFirstName("pop_" + 1);
        person1.setLastName("test_" + 1);

        Person person2 = new Person();
        person2.setUserId(5);
        person2.setFirstName("pop_" + 5);
        person2.setLastName("test_" + 5);

        Person person3 = new Person();
        person3.setUserId(6);
        person3.setFirstName("pop_" + 6);
        person3.setLastName("test_" + 6);

        Person person4 = new Person();
        person4.setUserId(2);
        person4.setFirstName("pop_" + 2);
        person4.setLastName("test_" + 2);

        peopleList.add(person1);
        peopleList.add(person2);
        peopleList.add(person3);
        peopleList.add(person4);

        System.out.println(peopleList);

//        Collections.sort(peopleList, new Comparator<Person>(){
//            @Override
//            public int compare(Person x, Person y) {
//                return x.getLastName().compareTo(y.getLastName());
//            }
//        });
//        System.out.println(peopleList);

//        Collections.sort(peopleList, Comparator.comparing((Person p) -> p.getLastName()));
////        System.out.println(peopleList);

//        Collections.sort(peopleList, comparing(p -> p.getLastName()));
//        System.out.println(peopleList);

//        Collections.sort(peopleList, comparing(Person::getLastName));
//        System.out.println(peopleList);

        peopleList.sort(comparing(Person::getLastName));
        System.out.println(peopleList);
    }
}
