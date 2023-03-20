package com.ruoyi.business.mapper.sk;


import com.ruoyi.business.domain.sk.SkBbLabel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SkBbLabelMapper {

    @Select ("select label from sk_bb_label where `name`=#{name}")
    List<SkBbLabel> findByName(@Param("name") String name);

    @Select ("select label,labelName,unit,place from sk_bb_label where `name`=#{name} and labelName=#{labelName}")
    List<SkBbLabel> findByLabelName(@Param("name") String name, @Param("labelName") String labelName);
    @Select ("select label,labelName,unit,place from sk_bb_label where `name`=#{name} and labelName=#{labelName} order by name,place,labelName desc")
    List<SkBbLabel> findByLabelNameOrder(@Param("name") String name, @Param("labelName") String labelName);

    @Select ("select label,labelName,unit,place from sk_bb_label where `name`=#{name} and labelName=#{labelName} and place=#{place}")
    SkBbLabel find(@Param("name") String name, @Param("labelName") String labelName,@Param("place") String place);

    @Select ("select label,labelName,unit,place from sk_bb_label where `name`=#{name} and place=#{place}")
    List<SkBbLabel> findByPlace(@Param("name") String name, @Param("place") String place);

    @Select ("select label,labelName,unit,place from sk_bb_label where `name`=#{name} and place=#{place} order by name,place,labelName desc")
    List<SkBbLabel> findByPlaceOrder(@Param("name") String name, @Param("place") String place);
}
