package com.example.demo.boot;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试说明：https://www.cnblogs.com/harrychinese/p/springboot_unittesting.html
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AppTest {

    @Test
    public void test1(){
        System.out.println("1213");
    }

    @Autowired
    private MapListTest mapListTest;
    @Test
    public  void sayMap(){
        mapListTest.sendMap();
    }

    @Test
    public  void sayList(){
        mapListTest.sendList();
    }

}
