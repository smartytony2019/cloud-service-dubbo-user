package com.xinbo.cloud.service.dubbo.user.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Service;
import com.xinbo.cloud.common.domain.common.UserInfo;
import com.xinbo.cloud.common.mapper.common.UserInfoMapper;
import com.xinbo.cloud.common.service.api.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 熊二
 * @date 2020/4/2 21:30
 * @desc file desc
 */

@Slf4j
@Service(version = "1.0.0")
public class UserInfoServiceImpl implements UserInfoService {



    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUser() {
        UserInfo userInfo = new UserInfo();
        List<UserInfo> list = userInfoMapper.selectAll();
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return userInfo;
    }
}
