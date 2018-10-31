package com.lsh.service.impl;

import com.lsh.dao.SellerInfoDao;
import com.lsh.dataobject.SellerInfo;
import com.lsh.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SellerServiceImpl
 * @Description: 卖家信息实现类
 * @Author lsh
 * @Date 2018/10/30 21:42
 * @Version
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;
    /**
     * @param openid
     * @Description: 通过openid查询卖家端信息
     * @Param [openid]
     * @Return com.lsh.dataobject.SellerInfo
     * @author lsh
     * @date 2018/10/30 21:41
     */
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
