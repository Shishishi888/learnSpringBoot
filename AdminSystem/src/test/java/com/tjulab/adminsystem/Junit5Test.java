package com.tjulab.adminsystem;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 使用SpringBoot驱动，允许测试类使用Springboot的容器等功能
@DisplayName("Junit5测试类")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @DisplayName("测试@Displayname注解")
    @Test
    void testDisplayName(){
        System.out.println("*测试方法1");
        System.out.println(jdbcTemplate);
    }

    @Disabled // 禁用该测试方法
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println("*测试方法2");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // 规定测试方法的测试时间，超过设定时间则抛异常
    @Test
    void testTimeout() throws InterruptedException{
        Thread.sleep(600);
    }

    @RepeatedTest(5) // 重复测试5次
    @Test
    void test3(){
        System.out.println("*测试方法2");
    }

    @BeforeEach // 在每个测试方法执行之前执行该方法
    void testBeforeEach(){
        System.out.println("*测试@BeforeEach注解");
    }

    @AfterEach // 在每个测试方法执行之后执行该方法
    void testAfterEach(){
        System.out.println("*测试@AfterEach注解");
    }

    @BeforeAll // 在所有的测试方法执行之前执行该方法
    static void testBeforeAll(){
        System.out.println("*测试@BeforeAll注解");
    }

    @AfterAll // 在所有的测试方法执行之后执行该方法
    static void testAfterAll(){
        System.out.println("*测试@AfterAll注解");
    }

    /**
     * 断言
     */

    /**
     * 简单断言
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(1, 2);
        // Assertions.assertEquals(3, cal);
        // assertEquals(5, cal);
        // assertEquals(5, cal, "业务逻辑计算失败");
        assertEquals(3, cal, "业务逻辑计算失败"); // 如果前面的断言失败，则后面的代码不会执行

        Object obj1 = new Object();
        Object obj2 = new Object();
        // assertSame(obj1, obj2);
        assertSame(obj1, obj2, "不是同一个对象");
    }

    int cal(int i, int j){
        return i + j;
    }

    /**
     * 数组断言
     */
    @Test
    @DisplayName("测试数组断言")
    void array(){
        // assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
        // assertArrayEquals(new int[]{1, 2}, new int[]{3, 2});
        assertArrayEquals(new int[]{2, 1}, new int[]{1, 2}, "数组内容不相等");
    }

    /**
     * 组合断言
     */
    @Test
    @DisplayName("测试组合断言")
    void all(){
//        assertAll("test", ()->assertTrue(true && true),
//                                    ()->assertEquals(1, 1));
//        assertAll("test", ()->assertTrue(true && true),
//                                    ()->assertEquals(1, 2));
        assertAll("test", ()->assertTrue(true && true, "结果不是true"),
                                     ()->assertEquals(1, 2, "两个值不相等"));
        System.out.println("=== === ===");
    }

    /**
     * 异常断言
     */
    @Test
    @DisplayName("测试异常断言")
    void testException(){
        // 断定业务逻辑一定出现异常
        // assertThrows(ArithmeticException.class, ()->{int i = 10 / 0;}, "业务逻辑正常运行。");
        assertThrows(ArithmeticException.class, ()->{int i = 10 / 2;}, "业务逻辑正常运行。");
    }

    /**
     * 超时断言
     */

    /**
     * 快速失败
     */
    @Test
    @DisplayName("快速失败")
    void testFail(){
//        if(2 == 2){
//            fail("测试失败");
//        }
        if(1 == 2){
            fail("测试失败");
        }
    }

    /**
     * 前置条件
     * 相比于断言，不满足前置条件则跳过，而不是打印异常报告
     */
    @Test
    @DisplayName("测试前置条件")
    void testAssumptions(){
        // Assumptions.assumeTrue(true, "结果不是true");
        Assumptions.assumeTrue(false, "结果不是true");
        System.out.println("*** *** ***");
    }

}
