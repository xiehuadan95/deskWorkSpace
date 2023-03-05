package com.xie.srb.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xie.srb.core.hfb.FormHelper;
import com.xie.srb.core.hfb.HfbConst;
import com.xie.srb.core.hfb.RequestHelper;
import com.xie.srb.core.mapper.UserBindMapper;
import com.xie.srb.core.pojo.entity.UserBind;
import com.xie.srb.core.pojo.vo.UserBindVO;
import com.xie.srb.core.service.UserBindService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户绑定表 服务实现类
 * </p>
 *
 * @author eric
 * @since 2022-03-19
 */
@Service
public class UserBindServiceImpl extends ServiceImpl<UserBindMapper, UserBind> implements UserBindService {

    @Override
    public String commitBindUser(UserBindVO userBindVO, Long userId) {

        Map<String ,Object > paramMap=new HashMap<>();
        paramMap.put("agentId", HfbConst.AGENT_ID);
        paramMap.put("agentUserId",userId);
        paramMap.put("idCard",userBindVO.getIdCard());
        paramMap.put("personalName", userBindVO.getName());
        paramMap.put("bankType", userBindVO.getBankType());
        paramMap.put("bankNo", userBindVO.getBankNo());
        paramMap.put("mobile", userBindVO.getMobile());
        paramMap.put("returnUrl", HfbConst.USERBIND_RETURN_URL);
        paramMap.put("notifyUrl", HfbConst.USERBIND_NOTIFY_URL);
        paramMap.put("timestamp", RequestHelper.getTimestamp());
        paramMap.put("sign", RequestHelper.getSign(paramMap));
        //生成动态表单字符串
        String formStr = FormHelper.buildForm(HfbConst.USERBIND_URL, paramMap);
        return formStr;
    }
}
/**
 *  //不同的user_id, 相同的身份证，如果存在，则不允许
 *         QueryWrapper<UserBind> userBindQueryWrapper = new QueryWrapper<>();
 *         userBindQueryWrapper
 *                 .eq("id_card", userBindVO.getIdCard())
 *                 .ne("user_id", userId);
 *         UserBind userBind = baseMapper.selectOne(userBindQueryWrapper);
 *         Assert.isNull(userBind, ResponseEnum.USER_BIND_IDCARD_EXIST_ERROR);
 *
 *         //用户是否曾经填写过绑定表单
 *         userBindQueryWrapper = new QueryWrapper<>();
 *         userBindQueryWrapper.eq("user_id", userId);
 *         userBind = baseMapper.selectOne(userBindQueryWrapper);
 *
 *         if(userBind == null){
 *             //创建用户绑定记录
 *             userBind = new UserBind();
 *             BeanUtils.copyProperties(userBindVO, userBind);
 *             userBind.setUserId(userId);
 *             userBind.setStatus(UserBindEnum.NO_BIND.getStatus());
 *             baseMapper.insert(userBind);
 *         }else{
 *             //相同的user_id，如果存在，那么就取出数据，做更新
 *             BeanUtils.copyProperties(userBindVO, userBind);
 *             baseMapper.updateById(userBind);
 *         }
 *
 *         //组装自动提交表单的参数
 *         Map<String, Object> paramMap = new HashMap<>();
 *         paramMap.put("agentId", HfbConst.AGENT_ID);
 *         paramMap.put("agentUserId", userId);
 *         paramMap.put("idCard",userBindVO.getIdCard());
 *         paramMap.put("personalName", userBindVO.getName());
 *         paramMap.put("bankType", userBindVO.getBankType());
 *         paramMap.put("bankNo", userBindVO.getBankNo());
 *         paramMap.put("mobile", userBindVO.getMobile());
 *         paramMap.put("returnUrl", HfbConst.USERBIND_RETURN_URL);
 *         paramMap.put("notifyUrl", HfbConst.USERBIND_NOTIFY_URL);
 *         paramMap.put("timestamp", RequestHelper.getTimestamp());
 *         paramMap.put("sign", RequestHelper.getSign(paramMap));
 */