package com.xie.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.xie.easyexcel.dto.ExcelStudentDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelWriteTest {

    @Test
    public void simpleWriteTest() {
        //在路径下创建一个excel文件 可以+上时间戳 再加后缀
        String fileName = "D:/WorkSpace/excel20220403/simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写(要用那个数据对象)，然后写到 路径下的我们的excel文件中，第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可 可以给表中的sheet取名
        EasyExcel.write(fileName, ExcelStudentDTO.class)
                .sheet("模板")
                //doWrite 写具体的数据
                .doWrite(data());
              /*  .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });*/

    }
    //xls只能写65535行+1行标题行
    @Test
    public void simpleWriteTestXls() {
        //在路径下创建一个excel文件 可以+上时间戳 再加后缀
        String fileName = "D:/WorkSpace/excel20220403/simpleWrite.xls";
        // 这里 需要指定写用哪个class去写(要用那个数据对象)，然后写到 路径下的我们的excel文件中，第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 需要传入excelType参数即可 可以给表中的sheet取名
        EasyExcel.write(fileName, ExcelStudentDTO.class)
                .excelType(ExcelTypeEnum.XLS)
                .sheet("模板")
                //doWrite 写具体的数据
                .doWrite(data());
              /*  .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });*/

    }
    private List<ExcelStudentDTO> data() {
        List<ExcelStudentDTO> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ExcelStudentDTO data = new ExcelStudentDTO();
            data.setName("jack" + i);
            data.setBirthday(new Date());
            data.setSalary(2.5);
            list.add(data);
        }
        return list;
    }
}
