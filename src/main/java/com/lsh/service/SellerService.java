package com.lsh.service;

import com.lsh.dataobject.SellerInfo;

/**
    * @Description: 卖家信息-service
	* @Param
	* @Return
    * @author lsh
    * @date 2018/10/30 21:39
    */
public interface SellerService {
    /**
        * @Description: 通过openid查询卖家端信息
    	* @Param [openid]
    	* @Return com.lsh.dataobject.SellerInfo
        * @author lsh
        * @date 2018/10/30 21:41
        */
    SellerInfo findSellerInfoByOpenid(String openid);
}
