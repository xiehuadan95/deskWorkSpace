package com.xie.srb.core.mapper;

import com.xie.srb.core.pojo.dto.ExcelDictDTO;
import com.xie.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
public interface DictMapper extends BaseMapper<Dict> {

    void insertBatch(List<ExcelDictDTO> list);
}
