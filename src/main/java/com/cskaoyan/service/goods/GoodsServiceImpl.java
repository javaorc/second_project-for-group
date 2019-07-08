package com.cskaoyan.service.goods;

import com.cskaoyan.bean.Goods;
import com.cskaoyan.bean.GoodsAttribute;
import com.cskaoyan.bean.GoodsProduct;
import com.cskaoyan.bean.GoodsSpecification;
import com.cskaoyan.bean.vo.QueryList;
import com.cskaoyan.bean.vo.QueryMapVO;
import com.cskaoyan.mapper.goods.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public QueryList queryList(int page, int limit, String sort, String order, String goodsSn, String name) {

        int total = goodsMapper.queryTotalRecords(goodsSn, name);
        int offset = (page - 1) * limit;
        List<Goods> items = goodsMapper.queryList(limit, offset, sort, order, goodsSn, name);

        QueryList queryList = new QueryList();

        queryList.setTotal(total);
        queryList.setItems(items);

        return queryList;
    }

    @Override
    public Goods queryGoodsById(int id) {
        return goodsMapper.queryGoodsById(id);
    }

    @Override
    public Map queryGoodsDetailById(int id) {

        Map<String, Object> map = new LinkedHashMap<>();

        map.put("goods", goodsMapper.queryGoodsById(id));
        map.put("attributes", goodsMapper.queryGoodsAttributeByGoodsId(id));
        map.put("categoryIds", goodsMapper.queryCategoryIdsByGoodsId(id));
        map.put("products", goodsMapper.queryProductsByGoodsId(id));
        map.put("specifications", goodsMapper.querySpecificationsByGoodsId(id));

        return map;
    }

    @Override
    public Map queryCatAndBrand() {
        Map map = new LinkedHashMap();
        map.put("brandList", goodsMapper.queryBrandList());
        map.put("categoryList", goodsMapper.queryCategoryList());
        return map;
    }

    @Override
    public int deleteGoods(Goods goods) {

        try {
            int a = goodsMapper.deleteGoodsAttributesByGoodsId(goods.getId());
            int b = goodsMapper.deleteGoodsSpecificationsByGoodsId(goods.getId());
            int c = goodsMapper.deleteGoodsProductsByGoodsId(goods.getId());
            int d = goodsMapper.deleteGoodsByGoodsId(goods.getId());

            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int updateGoods(QueryMapVO queryMapVO) {

        Goods goods = queryMapVO.getGoods();
        Date date = new Date();

        /*1.更新商品参数*/
        List<GoodsAttribute> attributes = queryMapVO.getAttributes();
        //先删除
        goodsMapper.deleteGoodsAttributesByGoodsId(goods.getId());
        //再遍历（存在则恢复， 不存在则添加）
        for (GoodsAttribute attribute : attributes) {
            boolean exists = attribute.getId() != 0;

            //参数存在，更新时间，并置deleted = 0
            if (exists) {
                attribute.setUpdateTime(date);
                attribute.setDeleted(false);
                goodsMapper.updateGoodsAttribute(attribute);
            }
            //参数不存在
            else {
                attribute.setGoodsId(goods.getId());
                attribute.setAddTime(date);
                attribute.setUpdateTime(date);
                attribute.setDeleted(false);
                goodsMapper.insertGoodsAttribute(attribute);
            }
        }

        /*2.更新商品规格*/
        List<GoodsSpecification> specifications = queryMapVO.getSpecifications();
        //先删除
        goodsMapper.deleteGoodsSpecificationsByGoodsId(goods.getId());
        //再遍历（存在则恢复， 不存在则添加）
        for (GoodsSpecification specification : specifications) {
            boolean exists = specification.getId() != 0;

            //参数存在，更新时间，并置deleted = 0
            if (exists) {
                specification.setUpdateTime(date);
                specification.setDeleted(false);
                goodsMapper.updateGoodsSpecification(specification);
            }
            //参数不存在
            else {
                specification.setGoodsId(goods.getId());
                specification.setAddTime(date);
                specification.setUpdateTime(date);
                specification.setDeleted(false);
                goodsMapper.insertGoodsSpecification(specification);
            }
        }
        /*3.更新商品库存*/
        List<GoodsProduct> products = queryMapVO.getProducts();
        //先删除
        goodsMapper.deleteGoodsProductsByGoodsId(goods.getId());
        //再遍历（存在则恢复， 不存在则添加）
        for (GoodsProduct product : products) {
            boolean exists = product.getAddTime() != null;

            //参数存在，更新时间，并置deleted = 0
            if (exists) {
                product.setUpdateTime(date);
                product.setDeleted(false);
                goodsMapper.updateGoodsProduct(product);
            }
            //参数不存在
            else {
                product.setGoodsId(goods.getId());
                product.setAddTime(date);
                product.setUpdateTime(date);
                product.setDeleted(false);
                goodsMapper.insertGoodsProduct(product);
            }
        }
        /*4.更新商品信息*/
        goods.setUpdateTime(date);
        goodsMapper.updateGoods(goods);

        return 1;
    }

    @Override
    public int insertGoods(QueryMapVO queryMapVO) {

        Date date = new Date();

        /*1.添加商品*/
        Goods goods = queryMapVO.getGoods();
        goods.setAddTime(date);
        goods.setUpdateTime(date);
        goods.setDeleted(false);
        goodsMapper.insertGoods(goods);

        /*2.添加商品参数*/
        List<GoodsAttribute> attributes = queryMapVO.getAttributes();
        for (GoodsAttribute attribute : attributes) {
            attribute.setGoodsId(goods.getId());
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            attribute.setDeleted(false);
            goodsMapper.insertGoodsAttribute(attribute);
        }

        /*3.添加商品规格*/
        List<GoodsSpecification> specifications = queryMapVO.getSpecifications();
        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(goods.getId());
            specification.setAddTime(date);
            specification.setUpdateTime(date);
            specification.setDeleted(false);
            goodsMapper.insertGoodsSpecification(specification);
        }

        /*4.添加商品库存*/
        List<GoodsProduct> products = queryMapVO.getProducts();
        for (GoodsProduct product : products) {
            product.setGoodsId(goods.getId());
            product.setAddTime(date);
            product.setUpdateTime(date);
            product.setDeleted(false);
            goodsMapper.insertGoodsProduct(product);
        }

        return 1;
    }

    @Override
    public Integer queryTotalRecords() {
        return goodsMapper.queryTotalRecords(null, null);
    }
}
