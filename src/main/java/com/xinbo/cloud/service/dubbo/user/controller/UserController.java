package com.xinbo.cloud.service.dubbo.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.service.api.MerchantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 熊二
 * @date 2020/4/2 23:52
 * @desc file desc
 */
@RestController
public class UserController {


    @Reference(version = "1.0.0", mock = "com.xinbo.cloud.common.service.mock.MerchantServiceMock")
    private MerchantService merchantService;

    @GetMapping("getMerchant")
    public String getMerchant() {
        Merchant merchant = merchantService.getMerchant();
        return merchant.getMerchantCode()+" -- "+merchant.getMerchantName();
    }

}
