package com.alibaba.taobao.service.impl;

import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
import com.alibaba.taobao.model.dao.Product;
import com.alibaba.taobao.model.repository.ProductRepository;
import com.alibaba.taobao.model.request.AddProductReq;
import com.alibaba.taobao.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: 商品Service实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(AddProductReq addProductReq) {
        Product product = new Product();
        BeanUtils.copyProperties(addProductReq, product);
        Product productOld = productRepository.findByName(addProductReq.getName());
        if (productOld != null) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.NAME_EXISTED);
        }
        int count = productRepository.insertSelective(product);
        if (count == 0) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.CREATE_FAILED);
        }
    }
}
