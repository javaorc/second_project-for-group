package com.cskaoyan.service;

import com.cskaoyan.bean.Keyword;

import com.cskaoyan.mapper.KeywordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class  KeywordServiceImpl implements KeywordService{
    @Autowired
    KeywordMapper keywordMapper;


        @Override
        public List<Keyword> queryAllKeywordList(String keyword, String url) {
            return keywordMapper.queryAllKeywordList(keyword,url);
        }

        @Override
        public int updateKeyword(Integer id,String keyword,String url,boolean isHot,boolean isDefault) {
            return keywordMapper.updateKeyword(id,keyword,url,isHot,isDefault);
        }

        @Override
        public int deleteKeyword(Integer id) {
            return keywordMapper.deleteKeyword(id);
        }

        @Override
        public int queryKeywordByKeywordAndUrl(String keyword,String url) {
            return keywordMapper.queryKeywordByKeywordAndUrl(keyword,url);
        }

        @Override
        public int insertKeyword(Keyword keyword) {
            return keywordMapper.insertKeyword(keyword);
        }
    }
