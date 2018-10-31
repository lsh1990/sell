package com.lsh.dao;

import com.lsh.dataobject.SellerInfo;
import com.lsh.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo save = sellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(save);

    }

    @Test
    public void findByOpenid() {
        SellerInfo abc = sellerInfoDao.findByOpenid("abc");
        Assert.assertEquals("abc", abc.getOpenid());
    }
}