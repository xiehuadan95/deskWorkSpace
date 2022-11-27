package com.xie.srb.core.mapper;

import com.xie.srb.core.pojo.entity.IntegralGrade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xie.srb.core.pojo.entity.IntegralGradeChild;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 积分等级表 Mapper 接口
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
public interface IntegralGradeMapper extends BaseMapper<IntegralGrade> {
    List<IntegralGradeChild> selectByMap(Map map);
}
