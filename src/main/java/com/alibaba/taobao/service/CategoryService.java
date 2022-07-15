package com.alibaba.taobao.service;

import com.alibaba.taobao.model.dao.Category;
import com.alibaba.taobao.model.request.AddCategoryReq;

/**
 * 描述: 分类目录Service
 */
public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(Category updateCategory);
}
