package com.yyc.o2o.service;

import com.yyc.o2o.entity.ProductSellDaily;

import java.util.Date;
import java.util.List;

/**
 * @Auther:Cc
 * @Date: 2020/03/27/16:28
 */
public interface ProductSellDailyService {
    //每日定时对所有店铺的商品销量进行统计
    void dailyCalculate();
    //根据查询条件返回商品销售的统计列表
    List<ProductSellDaily> listProductSellDaily(
            ProductSellDaily productSellDailyCondition,Date beginTime,
            Date endTime);
}
