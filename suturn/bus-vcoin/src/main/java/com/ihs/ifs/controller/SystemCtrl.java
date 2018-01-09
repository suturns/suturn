package com.ihs.ifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suturn.framework.core.service.ITestService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class SystemCtrl {
    @Autowired
    private ITestService testService;

    @RequestMapping("index")
    @ResponseBody
    public Map readKey(){
        Map map = new HashMap();
//        map.put("test",systemDao.selectByPrimaryKey("test"));

        testService.batchInsert();
        return map;
    }
}
