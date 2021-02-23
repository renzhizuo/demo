package com.renzhi.demo.test.function;

import com.renzhi.demo.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.*;

/**
 * Description : 类描述
 * Created on : 2021-02-23
 * author : renzhi.zuo
 */
@Slf4j
public class FunctionTest extends BaseTest {
    Function<String, String> function = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s + ",gaga";
        }
    };

    Consumer<String> consumer = (a) -> log.info("consumer:{}", a);

    Predicate<Integer> predicate = (a) -> a >= 0;

    Predicate<Integer> predicate2 = (t) -> t % 2 == 0;

    Supplier<Integer> supplier = () -> 2;

    @Test
    public void test() {
        log.info("function-result:{}", function.apply("haha"));
        consumer.accept("consumer");
        log.info("predicate:{}", predicate.and(predicate2).test(10));
        log.info("supplier:{}", supplier.get());
    }


    DoubleToIntFunction doubleToIntFunction = (a) -> Integer.parseInt(a + "");
    BiFunction<Integer, Long, String> biFunction = (a, b) -> a + b + "字符串";
    BiConsumer<Integer, Long> biConsumer = (a, b) -> log.info("a={},b={}", a, b);

    /**
     * 在学习 Lambda 表达式时，
     * 我们提到如果接口中只有一个抽象方法（可以包含多个默认方法或多个 static 方法），
     * 那么该接口就是函数式接口
     */
    @FunctionalInterface
    interface CalService {
        int cal(int a, int b);

        //以下都是多余
        static void a(int a) {
            System.out.println(a);
        }

        default void b() {
            System.out.println("b");
        }

        default void c() {
            System.out.println("c");
        }
    }

    private int calWith(int a, int b, CalService calService) {
        CalService.a(1);
        calService.b();
        calService.c();
        return calService.cal(a, b);
    }

    @Test
    public void testCal() {
        log.info("加:{}", calWith(1, 2, (a, b) -> a + b));
        log.info("减:{}", calWith(1, 2, (a, b) -> a - b));
        log.info("乘:{}", calWith(1, 2, (a, b) -> a * b));
        log.info("除:{}", calWith(1, 2, (a, b) -> a / b));
    }

}
