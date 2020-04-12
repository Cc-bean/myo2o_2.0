package com.yyc.o2o.service.impl;

import com.yyc.o2o.dao.ProductSellDailyDao;
import com.yyc.o2o.entity.ProductSellDaily;
import com.yyc.o2o.service.ProductSellDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther:Cc
 * @Date: 2020/03/27/16:29
 */
@Service
public class ProductSellDailyServiceImpl implements ProductSellDailyService {
    private static final Logger log= LoggerFactory.getLogger(ProductSellDailyServiceImpl.class);
    @Autowired
    private ProductSellDailyDao productSellDailyDao;
    @Override
    public void dailyCalculate() {
        //System.out.println("Quartz跑起来了1");
        log.info("Quartz Running");
        //统计zaitb_user_product_map里面产生销量的每天的每个店铺的条件商品的日销量
        productSellDailyDao.insertProductSellDaily();
        //统计余下的商品的销量，全部置为0
        productSellDailyDao.insertDefaultProductSellDaily();
        //System.out.println("Quartz跑起来了2");
    }
    public List<ProductSellDaily> listProductSellDaily(ProductSellDaily productSellDailyCondition, Date beginTime,Date endTime){
        return productSellDailyDao.queryProductSellDailyList(productSellDailyCondition,beginTime,endTime);
    }



}
