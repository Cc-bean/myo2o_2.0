package com.yyc.o2o.dao;

import com.yyc.o2o.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface AreaDao {

    List<Area> queryArea();//查询出区域列表



}
