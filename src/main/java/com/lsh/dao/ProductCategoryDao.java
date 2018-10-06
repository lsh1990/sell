package com.lsh.dao;

import com.lsh.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ProductCategoryDao
 * @Description: TODO
 * @Author lsh
 * @Date 2018/9/28 21:12
 * @Version
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

}
