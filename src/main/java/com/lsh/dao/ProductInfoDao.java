package com.lsh.dao;

import com.lsh.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoDao
 * @Description: TODO
 * @Author lsh
 * @Date 2018/10/7 14:28
 * @Version
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
