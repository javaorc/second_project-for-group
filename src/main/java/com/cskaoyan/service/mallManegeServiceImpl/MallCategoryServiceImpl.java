package com.cskaoyan.service.mallManegeServiceImpl;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Kind;
import com.cskaoyan.mapper.mallManege.MallCategoryMapper;
import com.cskaoyan.service.MallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallCategoryServiceImpl implements MallCategoryService {
    @Autowired
    MallCategoryMapper mallCategoryMapper;

    @Override
    public List<Kind> showAllCategory() {
        return mallCategoryMapper.showAllCategory();
    }

    @Override
    public int deleteCategory(Category category) {
        return mallCategoryMapper.deleteCategory(category);
    }

    @Override
    public List<Kind> showKindCategory() {
        return mallCategoryMapper.showKindCategory();
    }

    @Override
    public int createCategory(Category category) {
        return mallCategoryMapper.createCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return mallCategoryMapper.updateCategory(category);
    }

    @Override
    public List<Kind> queryKindCategories() {
        return mallCategoryMapper.queryKindCategories();
    }
}
