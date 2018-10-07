package com.lsh.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName ProductCategory
 * @Description: 商品类目
 * @Author lsh
 * @Date 2018/9/28 20:49
 * @Version
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    /**
     * 类目ID
     */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
