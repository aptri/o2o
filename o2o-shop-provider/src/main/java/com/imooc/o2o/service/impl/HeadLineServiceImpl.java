package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.HeadLineDao;
import com.imooc.o2o.dto.HeadLineDto;
import com.imooc.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {

    @Autowired
    private HeadLineDao headLineDao;
    @Override
    public List<HeadLineDto> queryHeadLine() {
        return headLineDao.queryHeadLine();
    }

    @Override
    public HeadLineDto queryHeadLineById(Integer lineId) {
        return headLineDao.queryHeadLineById(lineId);
    }

    @Override
    public int insertHeadLine(HeadLineDto headLine) {
        return headLineDao.insertHeadLine(headLine);
    }

    @Override
    public int updateHeadLine(HeadLineDto headLine) {
        return headLineDao.updateHeadLine(headLine);
    }
}
