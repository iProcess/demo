package com.example.demo.controller;

import com.example.demo.dao.BoyRepository;
import com.example.demo.domain.Boy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/boy")
@RestController
public class BoyController {

    private static Logger logger = LoggerFactory.getLogger(BoyController.class);

    @Autowired
    private BoyRepository boyRepository;

    @GetMapping("/findAll")
    public List<Boy> findAll(){
        System.out.println("findAll");
        logger.info("BoyController-->findAll");
        return boyRepository.findAll();
    }

    @GetMapping("/addBoy")
    public Boy addBoy(String name, String sex){
        System.out.println("addBoy");
        Boy boy = new Boy();
        boy.setName(name);
        boy.setSex(sex);
        return boyRepository.save(boy);
    }

    @GetMapping("/findById/{id}")
    public Optional<Boy> findById(@PathVariable("id") Integer id){
        System.out.println("findById");
        return boyRepository.findById(id);
    }

    @GetMapping("/delBoy")
    public Boolean delBoy(Integer id){
        System.out.println("delBoy");
        boyRepository.deleteById(id);
        return true;
    }

    @GetMapping("/updateBoy")
    public Boy updateBoy(Integer id, String name, String sex){
        System.out.println("updateBoy");
        Boy boy = new Boy();
        boy.setId(id);
        boy.setName(name);
        boy.setSex(sex);
        return boyRepository.save(boy);
    }

    @GetMapping("/findBySex")
    public List<Boy> findBySex(String sex){
        System.out.println("findBySex");
        return boyRepository.findBySex(sex);
    }

    @GetMapping("/batchAddBoy")
    @Transactional
    public Boolean batchAddBoy(){
        System.out.println("batchAddBoy");
        for(int i = 1; i <= 10; i++){
            Boy boy = new Boy();
            boy.setName("test-" + i);
            if(i % 2 == 0){
                boy.setSex("男");
            }else {
                boy.setSex("女");
            }
            boy.setCreateDate(new Date());
            boyRepository.save(boy);
        }
        Boy boy = new Boy();
        boy.setName("测试");
        boy.setSex("男");
        boyRepository.save(boy);
        return true;
    }
}
