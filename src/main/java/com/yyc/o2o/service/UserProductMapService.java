package com.yyc.o2o.service;

import com.yyc.o2o.dto.UserProductMapExecution;
import com.yyc.o2o.entity.UserProductMap;
import com.yyc.o2o.exceptions.UserProductMapOperationException;

/**
 * @Auther:Cc
 * @Date: 2020/03/28/10:49
 */
public interface UserProductMapService {
    //通过传入查询条件分页列出用户消费信息列表
    UserProductMapExecution listUserProductMap(UserProductMap userProductCondition, Integer pageIndex, Integer pageSize);
    //根据传入的查询条件分页获取映射列表及总数
    UserProductMapExecution addUserProductMap(UserProductMap userProductMap) throws UserProductMapOperationException;
}
