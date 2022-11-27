package com.xie.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.xie.easyexcel.dto.ExcelStudentDTO;
import com.xie.easyexcel.listener.ExcelStudentDtoListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class ExcelReadTest {
    @Test
    public void simpleReadXlsx(){
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:/WorkSpace/excel20220403/simpleWrite1649000719043.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, ExcelStudentDTO.class, new ExcelStudentDtoListener()).sheet().doRead();
    }
    //如果读取的是xls版本文件，需要在sheet()方法之前加上excelType()版本号跟写一样
    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@linkr}
     * <p>
     * 3. 直接读即可
     */

    @Test
    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:/WorkSpace/excel20220403/simpleWrite1649000719043.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, ExcelStudentDTO.class,
                new PageReadListener<ExcelStudentDTO>(dataList -> {
                    for (ExcelStudentDTO demoData : dataList) {
                        log.info("读取到一条数据{}", JSON.toJSONString(demoData));
                    }
                    })).sheet().doRead();
}
}

