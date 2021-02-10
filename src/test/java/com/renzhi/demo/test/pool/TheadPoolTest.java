package com.renzhi.demo.test.pool;

/**
 * Description : 类描述
 * Created on : 2021-02-10
 * author : renzhi.zuo
 */
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 当一个任务通过 execute(Runnable) 方法欲添加到线程池时，线程池采用的策略如下：
 * 1. 如果此时线程池中的数量小于 corePoolSize ，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
 * 2. 如果此时线程池中的数量等于 corePoolSize ，但是缓冲队列 workQueue 未满，那么任务被放入缓冲队列。
 * 3. 如果此时线程池中的数量大于 corePoolSize ，缓冲队列 workQueue 满，并且线程池中的数量小于maximumPoolSize ，建新的线程来处理被添加的任务。
 * 4. 如果此时线程池中的数量大于 corePoolSize ，缓冲队列 workQueue 满，并且线程池中的数量等于maximumPoolSize ，那么通过 handler 所指定的策略来处理此任务。0
 * 处理任务的优先级为：
 * 核心线程 corePoolSize 、任务队列 workQueue 、最大线程 maximumPoolSize ，如果三者都满了，使用 handler处理被拒绝的任务。
 * 当线程池中的线程数量大于 corePoolSize 时，如果某线程空闲时间超过 keepAliveTime ，线程将被终止。这样，线程池可以动态的调整池中的线程数。
 */
public class TheadPoolTest {
    static class ThreadPoolExecutorI {
        private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();

        private ExecutorService poolOne = new ThreadPoolExecutor(10, 20, 200L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

        private ExecutorService poolTwo = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(500), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * apache.commons
     */
    static class ThreadPoolExecutorII {
        private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("线程-%d").daemon(false).build());
    }

    /**
     * 线程池工厂，启动类或者配置类用
     */
    static class ThreadPoolExecutorIII {
        @Bean
        public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
            ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
            // 设置核心线程数
            threadPoolTaskExecutor.setCorePoolSize(5);
            // 设置最大线程数
            threadPoolTaskExecutor.setMaxPoolSize(10);
            // 设置队列容量
            threadPoolTaskExecutor.setQueueCapacity(100);
            // 设置线程活跃时间（秒）
            threadPoolTaskExecutor.setKeepAliveSeconds(300);
            // 设置默认线程名称
            threadPoolTaskExecutor.setThreadNamePrefix("启动类用-");

            return threadPoolTaskExecutor;
        }
    }

    static class ThreadPoolExecutorIV {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
