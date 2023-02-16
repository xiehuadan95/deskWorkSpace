package com.xie.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xie.easyexcel.dto.ExcelStudentDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * easyExcel 的监听器
 */
@Slf4j
public class ExcelStudentDtoListener extends AnalysisEventListener<ExcelStudentDTO> {
    //解析到一行数据 会封装到这个对象里面
    @Override
    public void invoke(ExcelStudentDTO data, AnalysisContext Context) {
        log.info("解析到一条记录：{}", data);
        //可以调用方法存到数据库
    }

    //所有的表格行执行完以后会进行一个收尾工作
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }
}
