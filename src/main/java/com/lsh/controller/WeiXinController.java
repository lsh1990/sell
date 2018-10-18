package com.lsh.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WeiXinController
 * @Description: 微信
 * @Author lsh
 * @Date 2018/10/16 21:24
 * @Version
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeiXinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法！");
    }
}
