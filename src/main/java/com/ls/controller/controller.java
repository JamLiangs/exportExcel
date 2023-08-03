package com.ls.controller;

import com.ls.bean.Student;
import com.ls.service.service;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/student")
public class controller {


    @Autowired
    private service service;


    @ApiOperation(value = "导出")
    @PostMapping("/exportExcel")
    public void exportExcel (HttpServletResponse response,@RequestBody Student student){
        service.exportUserExcel(response,student);
    }

}
