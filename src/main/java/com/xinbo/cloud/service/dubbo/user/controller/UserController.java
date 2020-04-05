package com.xinbo.cloud.service.dubbo.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.domain.common.UserInfo;
import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.dto.ResultFactory;
import com.xinbo.cloud.common.service.api.MerchantServiceApi;
import com.xinbo.cloud.common.service.common.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 熊二
 * @date 2020/4/2 23:52
 * @desc file desc
 */
@RestController
public class UserController {


    /* 内部RPC接口 */
    @Reference(version = "A1.0.0", mock = "com.xinbo.cloud.common.service.mock.MerchantServiceMock")
    private MerchantServiceApi merchantServiceApi;

    /* 外部RESTFUL接口 */
    @Autowired
    @Qualifier("userInfoServiceImpl")
    private UserInfoService userInfoService;



    @GetMapping("getMerchant")
    public String getMerchant() {
        Merchant merchant = merchantServiceApi.getMerchant();
        return merchant.getMerchantCode()+" -- "+merchant.getMerchantName();
    }


    @GetMapping("getUser")
    public ActionResult getUser() {
        List<UserInfo> list = userInfoService.getAll();
        return ResultFactory.success(list);
    }

}
