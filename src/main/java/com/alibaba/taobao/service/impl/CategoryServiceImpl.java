package com.alibaba.taobao.service.impl;

import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
import com.alibaba.taobao.model.dao.Category;
import com.alibaba.taobao.model.repository.CategoryRepository;
import com.alibaba.taobao.model.request.AddCategoryReq;
import com.alibaba.taobao.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: 目录分类Service实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void add(AddCategoryReq addCategoryReq) {
        Category category = new Category();
        BeanUtils.copyProperties(addCategoryReq, category);
        Category categoryOld = categoryRepository.findByName(addCategoryReq.getName());
        if (categoryOld != null) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.NAME_EXISTED);
        }
        int count = categoryRepository.insertSelective(category);
        if (count == 0) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.CREATE_FAILED);
        }
    }

    @Override
    public void update(Category updateCategory) {
        if (updateCategory.getName() != null) {
            Category categoryOld = categoryRepository.findByName(updateCategory.getName());
            if (categoryOld != null && categoryOld.getId() != updateCategory.getId()) {
                throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.NAME_EXISTED);
            }
        }
        int count = categoryRepository.updateByPrimaryKeySelective(updateCategory);
        if (count == 0) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.UPDATE_FAILED);
        }
    }
}
