package com.ruoyi.business.service;


import com.ruoyi.business.domain.BusinessFuheDTO;
import com.ruoyi.business.domain.BusinessFuheDuibiDTO;
import com.ruoyi.business.vo.BusinessFuheVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IBusinessFuheService {

    public void uploadData(@Param("params")BusinessFuheDTO params);

    public List<BusinessFuheVo> GetfuheduibiData(@Param("params") BusinessFuheDuibiDTO params);

}

