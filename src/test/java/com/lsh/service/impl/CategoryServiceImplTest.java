package com.lsh.service.impl;

import com.lsh.dataobject.ProductCategory;
import com.lsh.service.CatergoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void save() {
        ProductCategory category = new ProductCategory("老牛专享", 6);
        ProductCategory productCategory = categoryService.save(category);
        Assert.assertNotNull(productCategory);
    }
}