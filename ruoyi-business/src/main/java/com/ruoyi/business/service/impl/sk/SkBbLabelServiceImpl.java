package com.ruoyi.business.service.impl.sk;


import com.ruoyi.business.domain.sk.SkBbLabel;
import com.ruoyi.business.mapper.sk.SkBbLabelMapper;
import com.ruoyi.business.service.sk.ISkBbLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkBbLabelServiceImpl implements ISkBbLabelService {

    @Autowired
    private SkBbLabelMapper skBbLabelMapper;

    @Override
    public List<SkBbLabel> findByName(String name) {
        return skBbLabelMapper.findByName (name);
    }

    @Override
    public List<SkBbLabel> findByLabelName(String name, String labelName) {
        return skBbLabelMapper.findByLabelName (name,labelName);
    }
    @Override
    public List<SkBbLabel> findByLabelNameOrder(String name, String labelName) {
        return skBbLabelMapper.findByLabelNameOrder (name,labelName);
    }

    @Override
    public List<SkBbLabel> findByPlace(String name, String place) {
        return skBbLabelMapper.findByPlace (name,place);
    }

    @Override
    public List<SkBbLabel> findByPlaceOrder(String name, String place) {
        return skBbLabelMapper.findByPlaceOrder (name,place);
    }

    @Override
    public SkBbLabel find(String name, String labelName, String place) {
        return skBbLabelMapper.find (name,labelName,place);
    }


}
