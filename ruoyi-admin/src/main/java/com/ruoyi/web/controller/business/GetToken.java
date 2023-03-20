package com.ruoyi.web.controller.business;

import EDoc2.IAppService.IOrgAppService;
import EDoc2.IAppService.Model.CreateShortcutDto;
import EDoc2.IAppService.Model.ReturnValueResult;
import EDoc2.IAppService.Model.UserLoginDto;
import EDoc2.IAppService.Model.UserLoginIntegrationByUserLoginNameDto;
import com.edoc2.proxy.FacadeProxy;
import com.ruoyi.web.util.MapCache;

/**
 * 用户登陆
 */
public class GetToken {

    /**
     * 获取集成登陆的token
     * @param account
     * @return
     */
    public ReturnValueResult<String> getIntegrationToken(String account){
//        // 定义登陆token的缓存key
//        String cacheKey = "IntegrationToken:" + account;
//        // 尝试读取缓存,减少频繁请求
        ReturnValueResult<String> integrationReponse = new ReturnValueResult<>();
        System.out.println("2001");
//        if(integrationReponse == null){
            // 获取服务类
            IOrgAppService orgService = FacadeProxy.newProxyInstance(IOrgAppService.class);
        System.out.println("2002");
            // 1. 初始化集成登陆的DTO
            UserLoginIntegrationByUserLoginNameDto userLoginIntegrationByUserLoginNameDto = new UserLoginIntegrationByUserLoginNameDto();
        System.out.println("2003");
            // 1.1 集成登陆key : 系统管理=>安全策略=》登陆验证=》集成登陆密钥
            userLoginIntegrationByUserLoginNameDto.setIntegrationKey("0b793940-fa86-45da-8bf3-aa7cc35430b8");
        System.out.println("2004");
            // 1.2 本机ip，根据服务的环境自行调整
            userLoginIntegrationByUserLoginNameDto.setIPAddress("127.0.0.1");
        System.out.println("2005");
            // 1.3 登陆用户的账号
            userLoginIntegrationByUserLoginNameDto.setLoginName(account);
        System.out.println("2006");
            // 2. 发起 获取集成登陆的token 请求
            integrationReponse = orgService.UserLoginIntegrationByUserLoginName(userLoginIntegrationByUserLoginNameDto);
        System.out.println("2007");
            System.out.println("判断执行了吗");
//        }
//        else {
//            return integrationReponse;
//        }

//        if(integrationReponse.getResult()!=0){
//            // 处理登陆失败的逻辑
//            return integrationReponse;
//        }
//        else {
//            // 添加到缓存,防止多次请求
//            cache.add(cacheKey,integrationReponse,1000*60*60*2);
//        }

        return integrationReponse;
    }

}

