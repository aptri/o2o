package com.imooc.o2o.service;

import com.imooc.o2o.dto.HeadLineDto;

import java.util.List;

public interface HeadLineService {
    List<HeadLineDto> queryHeadLine();
    HeadLineDto queryHeadLineById(Integer lineId);
    int insertHeadLine(HeadLineDto headLine);
    int updateHeadLine(HeadLineDto headLine);
}
