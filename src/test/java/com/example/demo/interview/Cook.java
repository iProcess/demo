package com.example.demo.interview;


/**
 * 烹饪接口提供食物制作服务
 */
interface CookService{
    /**
     * 食物制作
     */
    public void cook();
}

/**
 * 烘培服务模版类为烹饪接口的实现，
 * 实现食物制作服务的流程编排，
 * 流程如下：材料准备 -> 烘烤，其中烘烤为通用能力。
 */
abstract class BakeServiceTemplate implements CookService{

    /**
     * 准备材料
     */
    protected abstract void ready();

    /**
     * 烘烤
     */
    public void bake(){
        System.out.println("开始烘烤");
    }

    @Override
    public void cook() {
        //1、准备材料
        ready();
        //2、烘烤
        bake();
    }
}

/**
 * 烘培饼干服务类使用烘培服务模版，实现具体化的材料准备。
 */
class BakeCookieServiceImpl extends BakeServiceTemplate{

    @Override
    protected void ready() {
        System.out.println("准备烘培饼干材料");
    }
}

/**
 * 烘培蛋糕服务类使用烘培服务模版，实现具体化的材料准备。
 */
class BakeCakeServiceImpl extends BakeServiceTemplate{

    @Override
    protected void ready() {
        System.out.println("准备烘培蛋糕材料");
    }
}

public class Cook {
    public static void main(String[] args) {
        //烘培饼干
        BakeCookieServiceImpl bakeCookieService = new BakeCookieServiceImpl();
        bakeCookieService.cook();
        //烘培蛋糕
        BakeCakeServiceImpl bakeCakeService = new BakeCakeServiceImpl();
        bakeCakeService.cook();
    }
}
