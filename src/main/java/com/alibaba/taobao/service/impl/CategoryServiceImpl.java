package com.alibaba.taobao.service.impl;

import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
import com.alibaba.taobao.model.dao.Category;
import com.alibaba.taobao.model.repository.CategoryRepository;
import com.alibaba.taobao.model.request.AddCategoryReq;
import com.alibaba.taobao.model.vo.CategoryVO;
import com.alibaba.taobao.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void delete(Integer id) {
        Optional<Category> categoryOld = categoryRepository.findById(id);
        // 查不到记录，无法删除，删除失败
        if (!categoryOld.isPresent()) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.DELETE_FAILED);
        }
        long size = categoryRepository.count();
        categoryRepository.deleteById(id);
        if (size == categoryRepository.count()) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public PageInfo listForAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, "type, orderNum");
        List<Category> categoryList = categoryRepository.findAll();
        PageInfo pageInfo = new PageInfo(categoryList);
        return pageInfo;
    }

    @Override
    @Cacheable(value = "listForCustomer")
    public List<CategoryVO> listForCustomer() {
        List<CategoryVO> categoryVOList = new ArrayList<>();
        recursiveFindCategories(categoryVOList, 0);
        return categoryVOList;
    }

    private void recursiveFindCategories(List<CategoryVO> categoryVOList, Integer parentId) {
        // 递归获取所有子类别，并组合成为一个"目录树"
        List<Category> categoryList = categoryRepository.findAllByParentId(parentId);
        if (!CollectionUtils.isEmpty(categoryList)) {
            for (int i = 0; i < categoryList.size(); i++) {
                Category category = categoryList.get(i);
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
                categoryVOList.add(categoryVO);
                recursiveFindCategories(categoryVO.getChildCategory(), categoryVO.getId());
            }
        }
    }
}
