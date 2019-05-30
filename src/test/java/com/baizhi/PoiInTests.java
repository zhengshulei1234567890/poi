package com.baizhi;

import com.baizhi.entity.Student;
import com.baizhi.service.PoiService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiInTests {
    @Autowired
    PoiService poiService;
    @Test
    public void contextLoads2() throws IOException {
        //1, 创建一个workbook 指定读取文件
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("D:/student.xls"));
        //2, 根据workboot获得sheet
        HSSFSheet sheet = workbook.getSheet("学生");
        int lastRowNum = sheet.getLastRowNum();
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <= lastRowNum; i++) {
            int id = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
            String name = sheet.getRow(i).getCell(1).getStringCellValue();
            String password = sheet.getRow(i).getCell(2).getStringCellValue();
            Date bir = sheet.getRow(i).getCell(3).getDateCellValue();
           // System.out.println(id+name+password+bir);
            Student student = new Student(id, name, password, bir);
            list.add(student);
        }
        poiService.insert(list);
    }
}
