package com.ruoyi.business.service.sk;


import com.ruoyi.business.domain.sk.SkBbLabel;

import java.util.List;

public interface ISkBbLabelService {

    List<SkBbLabel> findByName(String name);

    List<SkBbLabel> findByLabelName(String name, String labelName);
    List<SkBbLabel> findByLabelNameOrder( String name,  String labelName);

    List<SkBbLabel> findByPlace( String name,  String place);
    List<SkBbLabel> findByPlaceOrder( String name,  String place);

    SkBbLabel find(String name, String labelName,String place);
}
