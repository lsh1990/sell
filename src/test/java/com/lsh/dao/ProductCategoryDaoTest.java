package com.lsh.dao;

import com.lsh.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());

    }
    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(6);
        productCategory.setCategoryName("最爱");
        productCategory.setCategoryType(6);
        productCategoryDao.save(productCategory);
    }
    @Test
    public void updateTest() {
        ProductCategory productCategory = productCategoryDao.findOne(3);
        productCategory.setCategoryType(8);
        productCategoryDao.save(productCategory);
        System.out.println("productCategory" + productCategory.toString());
    }
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

}