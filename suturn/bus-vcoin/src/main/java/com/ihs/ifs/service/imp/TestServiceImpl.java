package com.ihs.ifs.service.imp;

import com.suturn.framework.core.dao.business.Test1Dao;
import com.suturn.framework.core.dao.process.Test2Dao;
import com.suturn.framework.core.service.ITestService;

import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements ITestService{
    @Autowired
    Test1Dao test1Dao;
    @Autowired
    Test2Dao test2Dao;

    @Transactional
    @Override
    public void batchInsert() {
        Map map = new HashMap();
        map.put("id","id1");
        map.put("name","name1");
//        test1Dao.insert(map);
        map.put("id","id2");
        map.put("name","name2");
        test2Dao.insert(map);
    }
}
