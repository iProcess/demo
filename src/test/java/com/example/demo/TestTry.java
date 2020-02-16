package com.example.demo;

/**
 * @author shijincheng
 * @version V1.0
 * date 2019/12/29 11:48
 * Description: TODO
 */
public class TestTry {

    private String getType(String userName){
        Integer userId = 0;
        try {
            if("test_1".equals(userName)){
                userId = 1;
                return userId + "," + userName;
            }
            if("test_2".equals(userName)){
                userId = 2;
                return userId + "," + userName;
            }
            return userId + "," + userName;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception==>" + userName);
            return userId + "," + "未知";
        }finally {
            System.out.println("finally==>" + userName);
        }
    }

    public static void main(String[] args) {
        TestTry testTry = new TestTry();
        System.out.println(testTry.getType("test_1"));
    }

}
