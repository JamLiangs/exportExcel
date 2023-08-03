package com.ls.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.ls.bean.Student;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class service {



    public void exportUserExcel(HttpServletResponse response,Student student) {
        try {
            Student student1 = new Student();
            student1.setName("ac1");
            student1.setAge("12");
            student1.setClassName("二班");

            List<Student>  list = new ArrayList<>();
            list.add(student);
            list.add(student1);
            String fileName = URLEncoder.encode("test", "UTF-8");

            response.addHeader("Content-Disposition","attachment;filename=" + fileName);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            ServletOutputStream outputStream = response.getOutputStream();

            EasyExcel.write(outputStream, Student.class).excelType(ExcelTypeEnum.XLSX).sheet("模板").doWrite(list);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static OutputStream getOutputStream(String fileName,HttpServletResponse response) throws Exception {
        String fileNameN = fileName + ExcelTypeEnum.XLSX;
        try{
            fileName = new String(fileNameN.getBytes(),"ISO-8859-1");
            response.addHeader("Content-Disposition","attachment;filename=" + fileName);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            return response.getOutputStream();
        }catch (Exception e){
            throw new Exception("错误");
        }
    }



}
