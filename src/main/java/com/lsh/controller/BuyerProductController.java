package com.lsh.controller;

import com.lsh.VO.ProductInfoVo;
import com.lsh.VO.ProductVo;
import com.lsh.VO.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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

    @GetMapping("/list")
    public ResultVo list()  {
        ProductVo productVo = new ProductVo();
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productVo.setProductInfoVoList(Arrays.asList(productInfoVo));
        ResultVo resultVo = new ResultVo("200","成功",productVo);
        return resultVo;
    }

}
