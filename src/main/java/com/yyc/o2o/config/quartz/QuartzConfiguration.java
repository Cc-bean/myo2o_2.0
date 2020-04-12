package com.yyc.o2o.config.quartz;

import com.yyc.o2o.dao.ProductSellDailyDao;
import com.yyc.o2o.entity.ProductSellDaily;
import com.yyc.o2o.service.ProductSellDailyService;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Auther:Cc
 * @Date: 2020/03/27/16:23
 */
@Configuration
public class QuartzConfiguration {
    @Autowired
    private ProductSellDailyService productSellDailyService;
    @Autowired
    private MethodInvokingJobDetailFactoryBean jobDetailFactory;
    @Autowired
    private CronTriggerFactoryBean productSellDailyTriggerFactory;

    //创建jobDetailFactory并返回
    @Bean(name = "jobDetailFactory")
    public MethodInvokingJobDetailFactoryBean createJobDetail() {
        // new出JobDetailFactory对象,此工厂主要用来制作一个jobDetail，即制作一个任务。
        // 由于我们所做的定时任务根本上讲其实就是执行一个方法。所以用这个工厂比较方便。
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        // 设置jobDetail的名字
        jobDetailFactoryBean.setName("product_sell_daily_job1");
        // 设置jobDetail的组名
        jobDetailFactoryBean.setGroup("job_product_sell_daily_group1");
        // 对于相同的JobDetail，当指定多个Trigger时, 很可能第一个job完成之前，第二个job就开始了。
        // 指定concurrent设为false，多个job不会并发运行，第二个job将不会在第一个job完成之前开始。
        jobDetailFactoryBean.setConcurrent(false);
        // 指定运行任务的类
        jobDetailFactoryBean.setTargetObject(productSellDailyService);
        // 指定运行任务的方法
        jobDetailFactoryBean.setTargetMethod("dailyCalculate");
        return jobDetailFactoryBean;
    }

    /**
     * 创建cronTriggerFactory并返回
     * @return
     */
    @Bean("productSellDailyTriggerFactory")
    public CronTriggerFactoryBean createProductSellDailyTrigger() {
        // 创建triggerFactory实例，用来创建trigger
        CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
        // 设置triggerFactory的名字
        triggerFactory.setName("product_sell_daily_trigger");
        // 设置triggerFactory的组名
        triggerFactory.setGroup("job_product_sell_daily_group");
        // 绑定jobDetail
        triggerFactory.setJobDetail(jobDetailFactory.getObject());
        JobDetail a=jobDetailFactory.getObject();
        // 设定cron表达式
        //每3秒：0/3 * * * * ?
        //每天晚上0点：0 0 0 * * ? *
        triggerFactory.setCronExpression("0 0 0 * * ? *");
        return triggerFactory;
    }

    /**
     * 创建调度工厂并返回
     *
     * @return
     */
    @Bean("schedulerFactory")
    public SchedulerFactoryBean createSchedulerFactory() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTriggers(productSellDailyTriggerFactory.getObject());
        return schedulerFactory;
    }
}

