package com.example.demo.jdk8.map;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/1 12:19
 * Description: TODO
 */
public class TestMap3 {

    public Map<String, String> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
    }

    public Map<Integer, Book> listToMapWithDupKeyError(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity()));
    }

    public Map<Integer, Book> listToMapWithDupKey(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (existing, replacement) -> existing));
    }

    public Map<Integer, Book> listToMapWithDupKey1(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (existing, replacement) -> {
                    System.out.println(JSON.toJSONString(existing));
                    System.out.println(JSON.toJSONString(replacement));
                    return existing;
                }));
    }

    public Map<Integer, String> listToMapWithDupKey2(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Book::getName,
                //key重复时，才会执行第三个参数
                (existing, replacement) -> {
                    System.out.println(JSON.toJSONString(existing));
                    System.out.println(JSON.toJSONString(replacement));
                    return existing;
                }));
    }

    public Map<Integer, Book> listToConcurrentMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
                (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public Map<Integer, String> listToConcurrentMap1(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Book::getName,
                (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public TreeMap<String, Book> listToSortedMap(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getName))
                .collect(Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new));
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));

        TestMap3 map3 = new TestMap3();
        //测试map： {"0395489318":"The Fellowship of the Ring","0618129111":"The Return of the King","0345339711":"The Two Towers"}
//        System.out.println(JSON.toJSONString(map3.listToMap(bookList)));
        //测试map：java.lang.IllegalStateException: Duplicate key Book(name=The Fellowship of the Ring, releaseYear=1954, isbn=0395489318)
        //System.out.println(JSON.toJSONString(map3.listToMapWithDupKeyError(bookList)));
        //测试map：
//        System.out.println(JSON.toJSONString(map3.listToMapWithDupKey(bookList)));

//        System.out.println(JSON.toJSONString(map3.listToMapWithDupKey1(bookList)));

//        System.out.println(JSON.toJSONString(map3.listToMapWithDupKey2(bookList)));

//        Map map = map3.listToConcurrentMap(bookList);
//        System.out.println(JSON.toJSONString(map));

//        Map map1 = map3.listToConcurrentMap1(bookList);
//        System.out.println(JSON.toJSONString(map1));

        Map map = map3.listToSortedMap(bookList);
        System.out.println(JSON.toJSONString(map));
    }




}
