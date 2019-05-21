package com.imooc.o2o.dao;

import com.imooc.o2o.dto.HeadLineDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HeadLineDao {
    List<HeadLineDto> queryHeadLine();
    HeadLineDto queryHeadLineById(@Param("lineId") Integer lineId);
    int insertHeadLine(HeadLineDto headLine);
    int updateHeadLine(HeadLineDto headLine);
}
