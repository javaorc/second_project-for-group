package com.cskaoyan.controller.wxCategory;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.service.MallCategoryService;
import com.cskaoyan.service.wxCategory.WxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WxCategoryController {

    @Autowired
    WxCategoryService categoryService;

    /*分类首页*/
    @RequestMapping("wx/catalog/index")
    @ResponseBody
    public ResponseVO<Map> index() {
        ResponseVO<Map> responseVO = new ResponseVO<>();
        Map<String, Object> map = new HashMap<>();

        List<Category> categoryList = categoryService.queryParentCategories();
        map.put("categoryList", categoryList);

        if (categoryList != null) {
            map.put("currentCategory", categoryList.get(0));
            map.put("currentSubCategory", categoryService.querySubCategories(categoryList.get(0).getId()));
        }

        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    /*分类切换*/
    @RequestMapping("wx/catalog/current")
    @ResponseBody
    public ResponseVO<Map> current(int id) {
        ResponseVO<Map> responseVO = new ResponseVO<>();
        Map<String, Object> map = new HashMap<>();

        map.put("currentCategory", categoryService.queryCategoryById(id));
        map.put("currentSubCategory", categoryService.querySubCategories(id));

        responseVO.setData(map);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

}
