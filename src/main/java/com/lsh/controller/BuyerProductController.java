package com.lsh.controller;

import com.lsh.VO.ProductInfoVo;
import com.lsh.VO.ProductVo;
import com.lsh.VO.ResultVo;
import com.lsh.dataobject.ProductCategory;
import com.lsh.dataobject.ProductInfo;
import com.lsh.service.CatergoryService;
import com.lsh.service.ProductService;
import com.lsh.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BuyerProductController
 * @Description: 买家商品
 * @Author lsh
 * @Date 2018/10/7 20:14
 * @Version
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CatergoryService catergoryService;

    @GetMapping("/list")
    public ResultVo list()  {
        //1.查询所有上架商品
        List<ProductInfo> productInfos = productService.findUpAll();
        //2.查询类目(一次性查询 )
        //传统方法
//        ArrayList<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo :productInfos) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8,lambda）
        List<Integer> categoryTypeList = productInfos.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = catergoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVo> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVo> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVOList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVOList);
            productVOList.add(productVo);
        }
        return ResultVoUtil.success(productVOList);
    }

}
