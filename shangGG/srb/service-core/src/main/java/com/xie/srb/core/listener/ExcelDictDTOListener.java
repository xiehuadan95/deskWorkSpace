package com.xie.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xie.srb.core.mapper.DictMapper;
import com.xie.srb.core.pojo.dto.ExcelDictDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;



import java.util.ArrayList;
import java.util.List;



//加无参构造函数 可以自定义一个构造函数 将mapper层导入
@NoArgsConstructor
@Slf4j
public class ExcelDictDTOListener extends AnalysisEventListener<ExcelDictDTO> {
    //ExcelDictDTOListener 是没有被spring管理的 所以这里不能自动注入mapper

    private DictMapper dictMapper;
    //数据列表
    List<ExcelDictDTO> list = new ArrayList();
    //设置列数 不能太多 比如每5条插入一次 设置一个常量值
    private static final int BATCH_COUNT = 5;

    //自定义有参构造函数 在service层要new 可以注入mapper
    public ExcelDictDTOListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext conctext) {
        log.info("解析到一条数据：{}",JSON.toJSONString(data));
        //调用mapper层save方法 由于数据量问题，可以先将数据存到列表里，100条记录满了再一次性写入数据库
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            //清空记录
            list.clear();
        }

    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext contextontext) {
        //最后剩余数据不足5条的时候 收尾的时候存
        saveData();
        log.info("所有数据解析完成！");
    }
    private void saveData() {
        log.info("{}条数据被存储到数据库", list.size());
        //调用mapper层方法 save list对象
        dictMapper.insertBatch(list);
        log.info("{}条数据被存储到数据库成功", list.size());
    }
}
