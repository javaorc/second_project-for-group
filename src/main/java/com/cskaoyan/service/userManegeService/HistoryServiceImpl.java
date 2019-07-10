package com.cskaoyan.service.userManegeService;

import com.cskaoyan.bean.History;
import com.cskaoyan.mapper.userManege.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;
    @Override
    public List<History> queryHistory() {
        List<History> histories = historyMapper.queryHistory();
        return histories;
    }
}
