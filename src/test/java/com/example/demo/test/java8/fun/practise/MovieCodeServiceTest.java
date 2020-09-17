package com.example.demo.test.java8.fun.practise;

/**
 * https://blog.csdn.net/u010191034/article/details/87623030
 * https://blog.csdn.net/shichen2010/article/details/105022321
 * https://www.jianshu.com/p/0746aaf5f955
 * https://blog.csdn.net/huo065000/article/details/78964382
 * https://www.jianshu.com/p/8dc46a2dc21d
 *
 * 适用于同一类型参数，且返回同一类型结果的多个方法，通过Function或BiFunction进行合并
 *
 */
public class MovieCodeServiceTest {

    public static void main(String[] args) {

        MovieCodeReq req = new MovieCodeReq();
        req.setMovieId(1000L);
        req.setMovieName("测试movie");
        req.setUserName("测试");

        MovieCodeService service = new MovieCodeServiceImpl();
        System.out.println(service.getMyMovieId(req));

        MovieCodeService service1 = new MovieCodeServiceProxy();
        System.out.println(service1.getMyMovieId(req));

        AbstractProxy proxy1 = new MovieCodeServiceProxy();
        System.out.println(proxy1.proxy(req, (t, u) -> t.getMyMovieId(u)));
        System.out.println(proxy1.proxy(req, (t, u) -> t.getMyMovieName(u)));

//        BiFunction<T, U, R> mapper, T service, U req, Class<R> clazz, Object ...args
//        AbstractProxy proxy2 = new MovieCodeServiceProxy();
//        System.out.println(proxy2.getDataProxy((t, u) -> t.getMyMovieId(u)), null, null, MovieCodeRes.class, null);//无法解析

    }

}
