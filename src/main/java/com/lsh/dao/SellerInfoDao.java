package com.lsh.dao;

import com.lsh.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName SellerInfoDao
 * @Description: TODO
 * @Author lsh
 * @Date 2018/10/30 21:12
 * @Version
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
