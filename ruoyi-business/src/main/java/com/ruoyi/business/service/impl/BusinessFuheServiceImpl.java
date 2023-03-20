package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.BusinessFuheDTO;
import com.ruoyi.business.domain.BusinessFuheDuibiDTO;
import com.ruoyi.business.domain.BusinessfuheDataDTO;
import com.ruoyi.business.mapper.BusinessFuheMapper;
import com.ruoyi.business.service.IBusinessFuheService;
import com.ruoyi.business.vo.BusinessFuheVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class BusinessFuheServiceImpl implements IBusinessFuheService {

    @Resource
    private BusinessFuheMapper businessFuheMapper;


    @Override
    public void uploadData(BusinessFuheDTO params){
//        查询数据是否已存在
        List<String> upload= businessFuheMapper.selectData(params);
        if (upload.size() > 0){
            System.out.println("该日数据已存在");
        }else {
            businessFuheMapper.uploadData(params);
            String uploadDate=params.getUploadDate();
            String time="";
            int type = params.getType();
            for (BusinessfuheDataDTO data:params.getData()) {
                time=data.getTime().replace(":","_");
                businessFuheMapper.insertData(data,uploadDate,time,type);
            }
        }

    }

    @Override
    public List<BusinessFuheVo> GetfuheduibiData(BusinessFuheDuibiDTO params){
        Map<String,Double> map0=businessFuheMapper.GetfuheduibiData0(params);
        Map<String,Double> map1=businessFuheMapper.GetfuheduibiData1(params);
        List<BusinessFuheVo> list=new ArrayList<>();
        if (map0!=null&&map1!=null&&map0.size()>0&&map1.size()>0){
            List<Double> values0=new ArrayList<>();
            List<Double> values1=new ArrayList<>();
            List<String> keys=new ArrayList<>();
            for (double v:map0.values()) {
                values0.add(v);
            }
            for (double v:map1.values()) {
                values1.add(v);
            }
            for (String key:map0.keySet()) {
                keys.add(key);
            }
            for (int i = 0; i < values0.size(); i++) {
                BusinessFuheVo businessFuheVo = new BusinessFuheVo();
                double f = values0.get(i)-values1.get(i);
                BigDecimal bg = new BigDecimal(f);
                double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                businessFuheVo.setDifference(f1);
                businessFuheVo.setLoadPredict(values0.get(i));
                businessFuheVo.setLoadActual(values1.get(i));
                businessFuheVo.setRealTime(keys.get(i));
                businessFuheVo.setUploadType(params.getSelectStation());
                list.add(businessFuheVo);
            }
            list.sort(Comparator.comparing(BusinessFuheVo ::getRealTime ));
        }else{
            System.out.println("请输入完整数据");
        }
        return list;
    }
}
