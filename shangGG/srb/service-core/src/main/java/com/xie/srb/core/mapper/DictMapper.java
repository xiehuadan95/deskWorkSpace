package com.xie.srb.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xie.srb.core.pojo.dto.ExcelDictDTO;
import com.xie.srb.core.pojo.entity.Dict;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
//J2EE的 先按照名字寻找 再Type
//@Repository
public interface DictMapper extends BaseMapper<Dict> {

    void insertBatch(List<ExcelDictDTO> list);
}
