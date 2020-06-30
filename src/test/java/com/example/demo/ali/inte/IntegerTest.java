package com.example.demo.ali.inte;

/**
 * 阿里巴巴编码规范：
 * 7. 【强制】所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较。
 * 说明:对于 Integer var = ? 在-128 至 127 范围内的赋值，Integer 对象是在 IntegerCache.cache 产生，会复用已有对象，
 * 这个区间内的 Integer 值可以直接使用==进行 判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，
 * 推荐使用 equals 方法进行判断。
 *
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

    }
}
