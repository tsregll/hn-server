package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.BusinessFuheDTO;
import com.ruoyi.business.domain.BusinessFuheDuibiDTO;
import com.ruoyi.business.domain.BusinessfuheDataDTO;
import com.ruoyi.business.vo.BusinessFuheVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface BusinessFuheMapper {

    public void uploadData(@Param("params")BusinessFuheDTO params);

    public  List<String> selectData(@Param("params")BusinessFuheDTO params);

    public void insertData(@Param("data")BusinessfuheDataDTO data,@Param("uploadDate")String uploadDate,@Param("time")String time,@Param("type")int type);

    public Map<String,Double> GetfuheduibiData0(@Param("params") BusinessFuheDuibiDTO params);
    public Map<String,Double> GetfuheduibiData1(@Param("params") BusinessFuheDuibiDTO params);

}
