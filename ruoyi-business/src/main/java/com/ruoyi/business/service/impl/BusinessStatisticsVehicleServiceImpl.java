package com.ruoyi.business.service.impl;

import com.ruoyi.business.mapper.BusinessStatisticsVehicleMapper;
import com.ruoyi.business.service.IBusinessStatisticsVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusinessStatisticsVehicleServiceImpl implements IBusinessStatisticsVehicleService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BusinessStatisticsVehicleMapper businessStatisticsVehicleMapper;

    /**
     * 查询车辆累计里程
     *
     * @return 所有车辆累计里程
     */
    @Override
    public List<Object> BusinessStatisticsVehicleForAll() {
        List<Map<String, Object>> result = businessStatisticsVehicleMapper.BusinessStatisticsVehicleForAll();
        List<Object> newResult = new ArrayList<>();
        String[] num = new String[result.size()];
        double[] fo = new double[result.size()];
        for (int i = 0; i < result.size(); i++) {
            if ("".equals(result.get(i).get("licensePlateNumber")) || null == result.get(i).get("licensePlateNumber")) {
                result.get(i).put("licensePlateNumber", "/");
            }
            if ("".equals(result.get(i).get("sumVehicleMileage")) || null == result.get(i).get("sumVehicleMileage")) {
                result.get(i).put("sumVehicleMileage", 0);
            }
            num[i] = result.get(i).get("licensePlateNumber").toString();
            fo[i] = (Double) result.get(i).get("sumVehicleMileage");
        }
        newResult.add(num);
        newResult.add(fo);
        return newResult;
    }
    /**
     * 查询车辆累计里程
     *
     * @return 所有车辆累计里程
     */
    @Override
    public List<Object> businessStatisticsVehicleForAll() {
        List<Map<String, Object>> result = businessStatisticsVehicleMapper.BusinessStatisticsVehicleForAll();
        List<Object> newResult = new ArrayList<>();
        String[] num = new String[result.size()>0&&result.size()<5?result.size():5];
        double[] fo = new double[result.size()>0&&result.size()<5?result.size():5];
        for (int i = 0; i < 5; i++) {
            if ("".equals(result.get(i).get("licensePlateNumber")) || null == result.get(i).get("licensePlateNumber")) {
                result.get(i).put("licensePlateNumber", "/");
            }
            if ("".equals(result.get(i).get("sumVehicleMileage")) || null == result.get(i).get("sumVehicleMileage")) {
                result.get(i).put("sumVehicleMileage", 0);
            }
            num[i] = result.get(i).get("licensePlateNumber").toString();
            fo[i] = (Double) result.get(i).get("sumVehicleMileage");
        }
        newResult.add(num);
        newResult.add(fo);
        return newResult;
    }

    /**
     * 查询车辆本年照片以及公里数
     *
     * @param id 指定车辆id
     * @return 车辆本年照片以及公里数
     */
    @Override
    public List<Object> BusinessStatisticsVehicleForOne(Long id) {
        List<Map<String, Object>> result;
        List<Object> newResult = new ArrayList<>();
        int[] years = {0, 1, 2};
        for (int i = 0; i < years.length; i++) {
            result = businessStatisticsVehicleMapper.businessStatisticsVehicleForOne(id, i);
            int[] far = new int[result.size()];
            for (int k = 0; k < result.size(); k++) {
                if ("".equals(result.get(k).get("VehicleMileage")) || null == result.get(k).get("VehicleMileage")) {
                    result.get(k).put("VehicleMileage", "-");
                }
                far[k] = Integer.parseInt(result.get(k).get("VehicleMileage").toString());
            }
            newResult.add(far);
        }
        return newResult;
    }

    /**
     * 查询本年年度里程数 以及前几年年度总数
     *
     * @return 本年年度里程数 以及前几年年度总数
     */
    @Override
    public List<Object> BusinessStatisticsVehicleForYear() {
        List<Map<String, Object>> vid= businessStatisticsVehicleMapper.selectVid();
        List<Object> results= new ArrayList<>();
        String[] head ={"product","今年","去年","前年"};
        results.add(head);
        for(int i=0;i<vid.size();i++){
            Object[] result= new Object[4];
            result[0]=vid.get(i).get("licensePlateNumber");
            for(int j=0;j<3;j++){
                List<Map<String, Object>> maps=businessStatisticsVehicleMapper.selectForYear((long)vid.get(i).get("id"),j);

                if(j==0){
                    try{
                        result[1]=Double.parseDouble(maps.get(0).get("sumYearVehicleMileage").toString());
                    }catch (Exception e){
                        result[1]=0;
                    }

                }
                if(j==1){
                    try{
                        result[2]=Double.parseDouble(maps.get(0).get("sumYearVehicleMileage").toString());
                    }catch (Exception e){
                        result[2]=0;
                    }
                }
                if(j==2){
                    try{
                        result[3]=Double.parseDouble(maps.get(0).get("sumYearVehicleMileage").toString());
                    }catch (Exception e){
                        result[3]="-";
                    }
                }
            }
            results.add(result);
        }
        return results;
    }

    /**
     * 查询本年年度里程数 以及前几年年度总数
     *
     * @return 本年年度里程数 以及前几年年度总数
     */
    @Override
    public List<Object> businessStatisticsVehicleForYear() {
        List<Map<String, Object>> vnumber= businessStatisticsVehicleMapper.selectVnumber();
        List<Object> results= new ArrayList<>();
        String[] head ={"product","今年","去年","前年"};
        results.add(head);
        for(int i=0;i<(vnumber.size()>0&&vnumber.size()<5?vnumber.size():5);i++){
            Object[] result= new Object[4];
            result[0]=vnumber.get(i).get("licensePlateNumber");
            for(int j=0;j<3;j++){
                List<Map<String, Object>> maps=businessStatisticsVehicleMapper.selectForYear2((String)vnumber.get(i).get("licensePlateNumber"),j);

                if(j==0){
                    try{
                        result[1]=Double.parseDouble(maps.get(0).get("sumYearVehicleMileage").toString());
                    }catch (Exception e){
                        result[1]=0;
                    }

                }
                if(j==1){
                    try{
                        result[2]=Double.parseDouble(maps.get(0).get("sumYearVehicleMileage").toString());
                    }catch (Exception e){
                        result[2]=0;
                    }
                }
                if(j==2){
                    try{
                        result[3]=Double.parseDouble(maps.get(0).get("sumYearVehicleMileage").toString());
                    }catch (Exception e){
                        result[3]="-";
                    }
                }
            }
            results.add(result);
        }
        return results;
    }
}
