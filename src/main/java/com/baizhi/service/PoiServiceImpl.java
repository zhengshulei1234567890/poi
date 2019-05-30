package com.baizhi.service;

import com.baizhi.dao.PoiDao;
import com.baizhi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PoiServiceImpl implements PoiService {
    @Autowired
    PoiDao poiDao;

    @Override
    public void insert(List<Student> list) {
        poiDao.insert(list);
    }
}
