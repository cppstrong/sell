package cn.huadi.sell.service.impl;

import cn.huadi.sell.dao.ProductInfoDAO;
import cn.huadi.sell.dto.CartDTO;
import cn.huadi.sell.entity.ProductInfo;
import cn.huadi.sell.enums.ProductStatusEnum;
import cn.huadi.sell.enums.ResultEnum;
import cn.huadi.sell.exception.SellException;
import cn.huadi.sell.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月22日 14:49:00
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Override
    public ProductInfo selectById(String productId) {
        return productInfoDAO.selectById(productId);
    }

    @Override
    public List<ProductInfo> selectUpAll() {
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper();
        wrapper.eq("product_status", ProductStatusEnum.UP);
        return productInfoDAO.selectList(wrapper);
    }

    @Override
    public Page<ProductInfo> selectAll(Page<ProductInfo> page) {
        Page<ProductInfo> productPage = productInfoDAO.selectPage(page, null);

        return productPage;
    }

    @Override
    public boolean insert(ProductInfo productInfo) {
        int result = productInfoDAO.insert(productInfo);
        return 0==result;
    }

    @Override
    public boolean updateById(ProductInfo productInfo) {
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper<>();
        productInfoDAO.update(productInfo,wrapper.eq("product_id",productInfo.getProductId()));
        return false;
    }

    @Override
    @Transactional
    public void increaseStore(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = productInfoDAO.selectById(cartDTO.getProductId());
            if (productInfo == null ){
                throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDAO.updateById(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStore(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = productInfoDAO.selectById(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            updateById(productInfo);
        }
    }
}
