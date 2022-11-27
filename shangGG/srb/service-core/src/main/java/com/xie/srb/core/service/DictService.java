package com.xie.srb.core.service;

import com.xie.srb.core.pojo.dto.ExcelDictDTO;
import com.xie.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
public interface DictService extends IService<Dict> {

    void importData(InputStream inputStream);

    List<ExcelDictDTO> listDictData();

    List<Dict> listByParentId(Long parentId);
}
