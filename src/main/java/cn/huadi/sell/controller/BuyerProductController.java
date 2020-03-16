package cn.huadi.sell.controller;

import cn.huadi.sell.VO.ProductInfoVO;
import cn.huadi.sell.VO.ProductCategoryVO;
import cn.huadi.sell.VO.ResultVO;
import cn.huadi.sell.entity.ProductCategory;
import cn.huadi.sell.entity.ProductInfo;
import cn.huadi.sell.service.CategoryService;
import cn.huadi.sell.service.ProductService;
import cn.huadi.sell.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 蔡鹏
 * @version 1.0.0
 * @Description 买家商品
 * @createTime 2020年02月22日 16:06:00
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1.查询所有上架商品
        List<ProductInfo> productInfos = productService.selectUpAll();
        //2.查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<>();
//        //传统方法
//        for(ProductInfo productInfo:productInfos){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //Lambda表达式
        List<Integer> categoryTypeList = productInfos.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.selectListByTypeIn(categoryTypeList);
        //3.拼装数据
        List<ProductCategoryVO> productCategoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
            productCategoryVO.setCategoryName(productCategory.getCategoryName());
            productCategoryVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productCategoryVO.setProductInfoVOList(productInfoVOList);
            productCategoryVOList.add(productCategoryVO);
        }

        return ResultVOUtil.success(productCategoryVOList);
    }
}
