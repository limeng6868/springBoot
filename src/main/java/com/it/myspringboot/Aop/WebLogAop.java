package com.it.myspringboot.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author limeng
 * @date 2019/1/5 20:32
 */
@Aspect//这是一个切面
@Component
public class WebLogAop {
    //ThreadLocal保证不受其他线程影响，用于记录接口响应时间
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
    //切点， 每一个controller请求方法
    @Pointcut("execution(public * com.it.myspringboot..*.*(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        //请求的内容，记录url、method、ip
//        System.out.println("URL==>" + request.getRequestURL().toString() + "," +
//                "METHOD==>" + request.getMethod() + "," +
//                "IP==>" + request.getRemoteAddr());
//        //请求参数，将value数组转成字符串
//        Map<String, String[]> params = request.getParameterMap();
//        Map<String,String> args = new HashMap<>();
//        for (Map.Entry<String,String[]> temp : params.entrySet()) {
//            args.put(temp.getKey(), Arrays.toString(temp.getValue()));
//        }
//        //连接点的签名可以跟踪到程序具体类、具体方法，记录一下方法和参数
//        System.out.println("CLASS_METHOD==>" + joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName() + "," +
//                "ARGS==>" + args);
//        //记录请求接口开始时间
//        threadLocal.set(System.currentTimeMillis());
        System.out.println("===============================doBefore");
    }
    /***
     * after returning advice 后置返回增强处理
     * @author 沉鱼
     * @date 2017年12月28日 上午10:41:07
     * @param joinPoint  连接点
     * @param returnMsg return返回的信息(就是response)
     */
    @AfterReturning(pointcut = "pointCut()",returning = "returnMsg")
    public void doAfterReturn(JoinPoint joinPoint,Object returnMsg) {
//        //与前置增强一致记录下方法名
//        System.out.println("CLASS_METHOD==>" + joinPoint.getSignature().getDeclaringTypeName() + "." +
//                joinPoint.getSignature().getName());
//        //记录一下接口响应时间
//        Long reponseTime = System.currentTimeMillis() - threadLocal.get();
//        System.out.println("接口响应时间(毫秒)==>" + reponseTime);
//        //删除threadLocal变量副本
//        threadLocal.remove();
        System.out.println("===============================after");

    }
    /***
     * 后置异常增强处理
     * @author 沉鱼
     * @date 2017年12月28日 上午11:08:16
     * @param joinPoint 连接点
     * @param exception 目标方法抛出的异常与增强处理的异常一致才执行，否则不执行，
     * 如果是throwing对应的是Throwable类型将匹配任何类型异常
     */
    @AfterThrowing(pointcut="pointCut()",throwing = "exception")
    public void doAfterThrow(JoinPoint joinPoint, Throwable exception) {
        //记录空指针异常
        if (exception instanceof NullPointerException) {
            System.out.println("报NullPointerException了！请处理一下！");
        }
    }


}
