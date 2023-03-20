package com.ruoyi.business.mapper;

import com.ruoyi.business.vo.BusinessXnyProjectVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessXnyMapper {

    public List<BusinessXnyProjectVo> getProject(String selectYear);

    public void insertProject(@Param("businessXnyProjectVo")BusinessXnyProjectVo businessXnyProjectVo);

    public void truncateTable();
}
