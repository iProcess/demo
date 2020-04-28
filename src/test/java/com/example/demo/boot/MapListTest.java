package com.example.demo.boot;

import com.example.demo.service.MaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 注入说明：https://blog.csdn.net/qq_32867467/article/details/82944196
 * Map、List中的对象 自动注入
 */
@Component
public class MapListTest {

    @Autowired
    private Map<String, MaoService> maoServiceMap;

    @Autowired
    private List<MaoService> maoServiceList;

    /**
     * 默认顺序：Cat、Dog、Fish
     */
    public void  sendMap(){
        this.maoServiceMap.get("cat").say();
    }

    /**
     * 默认顺序：Cat、Dog、Fish
     */
    public void  sendList(){
        this.maoServiceList.get(0).say();
    }

}
