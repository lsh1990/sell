package com.lsh.service.impl;

import com.lsh.dto.OrderDTO;
import com.lsh.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PushMessageImpl
 * @Description: TODO
 * @Author lsh
 * @Date 2018/11/24 17:08
 * @Version
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {
    @Autowired
    private WxMpService wxMpService;
    /**
     * @param orderDTO
     * @Description: 订单状态变更消息
     * @Param [orderDTO]
     * @Return void
     * @author lsh
     * @date 2018/11/24 17:06
     */
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        //微信配置的模板id
        templateMessage.setTemplateId("fPnMM4cs4Cp1s4M_OY_1bvKQlcZRHmLeCte2nfMnm2Q");
        templateMessage.setToUser("oF31q08l8rlD-0aWAdeAWMlb4Qbk");
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "记得收货。"),
                new WxMpTemplateData("keyword1","微信点餐")
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);

        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败,{}",e);
            e.printStackTrace();
        }
    }
}
