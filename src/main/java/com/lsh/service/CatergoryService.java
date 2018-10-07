package com.lsh.service;

import com.lsh.dataobject.ProductCategory;

import java.util.List;

/**
    * @Description: 类目
	* @Param
	* @Return  
    * @author lsh
    * @date 2018/10/7 13:05
    */
public interface CatergoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
