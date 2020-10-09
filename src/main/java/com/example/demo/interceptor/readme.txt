http://localhost:8888/demo/index/init

拦截器执行顺序：
2020-10-09 18:09:48.159  INFO 95454 --- [nio-8888-exec-1] c.e.d.interceptor.SpringSSOInterceptor   : SpringSSOInterceptor-->preHandle
2020-10-09 18:09:49.615  INFO 95454 --- [nio-8888-exec-1] c.e.d.interceptor.DemoLoginInterceptor   : DemoLoginInterceptor-->preHandle
2020-10-09 18:09:53.122  INFO 95454 --- [nio-8888-exec-1] c.e.demo.controller.IndexController      : init
2020-10-09 18:09:54.503  INFO 95454 --- [nio-8888-exec-1] c.e.demo.controller.IndexController      : sjc
2020-10-09 18:10:00.447  INFO 95454 --- [nio-8888-exec-1] c.e.d.interceptor.DemoLoginInterceptor   : DemoLoginInterceptor-->postHandle
2020-10-09 18:10:01.839  INFO 95454 --- [nio-8888-exec-1] c.e.d.interceptor.SpringSSOInterceptor   : SpringSSOInterceptor-->postHandle
2020-10-09 18:10:05.879  INFO 95454 --- [nio-8888-exec-1] c.e.d.interceptor.DemoLoginInterceptor   : DemoLoginInterceptor-->afterCompletion
2020-10-09 18:10:07.775  INFO 95454 --- [nio-8888-exec-1] c.e.d.interceptor.SpringSSOInterceptor   : SpringSSOInterceptor-->afterCompletion

