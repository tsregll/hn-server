package com.ruoyi.business.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.business.toolUtil.ToolUtils;
import com.ruoyi.business.vo.IndustryVo;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BusinessFiveGroupIndustryMapper;
import com.ruoyi.business.domain.BusinessFiveGroupIndustry;
import com.ruoyi.business.service.IBusinessFiveGroupIndustryService;

/**
 * 行业对标Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-08-20
 */
@Service
public class BusinessFiveGroupIndustryServiceImpl implements IBusinessFiveGroupIndustryService 
{
    @Autowired
    private BusinessFiveGroupIndustryMapper businessFiveGroupIndustryMapper;

    /**
     * 查询行业对标
     * 
     * @param id 行业对标ID
     * @return 行业对标
     */
    @Override
    public BusinessFiveGroupIndustry selectBusinessFiveGroupIndustryById(Long id)
    {
        return businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryById(id);
    }

    /**
     * 查询行业对标列表
     * 
     * @param businessFiveGroupIndustry 行业对标
     * @return 行业对标
     */
    @Override
    public List<BusinessFiveGroupIndustry> selectBusinessFiveGroupIndustryList(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        return businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryOrderByQueryTimeList(businessFiveGroupIndustry);
    }

    /**
     * 新增行业对标
     * 
     * @param businessFiveGroupIndustry 行业对标
     * @return 结果
     */
    @Override
    public int insertBusinessFiveGroupIndustry(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        businessFiveGroupIndustry.setCreateTime(DateUtils.getNowDate());
        businessFiveGroupIndustry.setIndustryMd(ToolUtils.size2(businessFiveGroupIndustry.getIndustryMd()));
        businessFiveGroupIndustry.setIndustrySd(ToolUtils.size2(businessFiveGroupIndustry.getIndustrySd()));
        businessFiveGroupIndustry.setIndustryFd(ToolUtils.size2(businessFiveGroupIndustry.getIndustryFd()));
        businessFiveGroupIndustry.setIndustryGf(ToolUtils.size2(businessFiveGroupIndustry.getIndustryGf()));
        businessFiveGroupIndustry.setIndustryQt(ToolUtils.size2(businessFiveGroupIndustry.getIndustryQt()));
        businessFiveGroupIndustry.setIndustryHj(ToolUtils.size2(businessFiveGroupIndustry.getIndustryHj()));

        return businessFiveGroupIndustryMapper.insertBusinessFiveGroupIndustry(businessFiveGroupIndustry);
    }

    /**
     * 修改行业对标
     * 
     * @param businessFiveGroupIndustry 行业对标
     * @return 结果
     */
    @Override
    public int updateBusinessFiveGroupIndustry(BusinessFiveGroupIndustry businessFiveGroupIndustry)
    {
        //原来的数据
        BusinessFiveGroupIndustry oldbf = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryById(businessFiveGroupIndustry.getId());
        //新数据和旧数据的差值
        Double md = Double.parseDouble(businessFiveGroupIndustry.getIndustryMd())-Double.parseDouble(oldbf.getIndustryMd());
        Double sd = Double.parseDouble(businessFiveGroupIndustry.getIndustrySd())-Double.parseDouble(oldbf.getIndustrySd());
        Double fd = Double.parseDouble(businessFiveGroupIndustry.getIndustryFd())-Double.parseDouble(oldbf.getIndustryFd());
        Double gf = Double.parseDouble(businessFiveGroupIndustry.getIndustryGf())-Double.parseDouble(oldbf.getIndustryGf());
        Double qt = Double.parseDouble(businessFiveGroupIndustry.getIndustryQt())-Double.parseDouble(oldbf.getIndustryQt());
        String newHj =updateBusinessFiveGroupIndustryHj(businessFiveGroupIndustry);
        Double hj = Double.parseDouble(newHj)-Double.parseDouble(oldbf.getIndustryHj());
        businessFiveGroupIndustry.setUpdateTime(DateUtils.getNowDate());
        businessFiveGroupIndustry.setIndustryMd(ToolUtils.size2(businessFiveGroupIndustry.getIndustryMd()));
        businessFiveGroupIndustry.setIndustrySd(ToolUtils.size2(businessFiveGroupIndustry.getIndustrySd()));
        businessFiveGroupIndustry.setIndustryFd(ToolUtils.size2(businessFiveGroupIndustry.getIndustryFd()));
        businessFiveGroupIndustry.setIndustryGf(ToolUtils.size2(businessFiveGroupIndustry.getIndustryGf()));
        businessFiveGroupIndustry.setIndustryQt(ToolUtils.size2(businessFiveGroupIndustry.getIndustryQt()));
        //刷新合计
        businessFiveGroupIndustry.setIndustryHj(newHj);
        int returnresult= businessFiveGroupIndustryMapper.updateBusinessFiveGroupIndustry(businessFiveGroupIndustry);
        Integer group = Integer.parseInt(businessFiveGroupIndustry.getIndustryGroup());
        //五大合计变动，全省的不变
        if(group<=4){
            BusinessFiveGroupIndustry select1 = new BusinessFiveGroupIndustry();
            select1.setQueryTime(businessFiveGroupIndustry.getQueryTime());
            List<BusinessFiveGroupIndustry> list1 = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(select1);
            if(list1.size()>0){
                for (BusinessFiveGroupIndustry temp : list1) {
                    Integer groupName = Integer.parseInt(temp.getIndustryGroup());
                    if(groupName==5){
                        //五大合计各项数值：原数值加上更新后的差值
                        temp.setIndustryMd(ToolUtils.size2(Double.parseDouble(temp.getIndustryMd())+md));
                        temp.setIndustrySd(ToolUtils.size2(Double.parseDouble(temp.getIndustrySd())+sd));
                        temp.setIndustryFd(ToolUtils.size2(Double.parseDouble(temp.getIndustryFd())+fd));
                        temp.setIndustryGf(ToolUtils.size2(Double.parseDouble(temp.getIndustryGf())+gf));
                        temp.setIndustryQt(ToolUtils.size2(Double.parseDouble(temp.getIndustryQt())+qt));
                        temp.setIndustryHj(ToolUtils.size2(Double.parseDouble(temp.getIndustryHj())+hj));
                        businessFiveGroupIndustryMapper.updateBusinessFiveGroupIndustry(temp);
                    }
                    if(groupName==7){
                        //其他各项数值：原数值减去更新后的差值
                        temp.setIndustryMd(ToolUtils.size2(Double.parseDouble(temp.getIndustryMd())-md));
                        temp.setIndustrySd(ToolUtils.size2(Double.parseDouble(temp.getIndustrySd())-sd));
                        temp.setIndustryFd(ToolUtils.size2(Double.parseDouble(temp.getIndustryFd())-fd));
                        temp.setIndustryGf(ToolUtils.size2(Double.parseDouble(temp.getIndustryGf())-gf));
                        temp.setIndustryQt(ToolUtils.size2(Double.parseDouble(temp.getIndustryQt())-qt));
                        temp.setIndustryHj(ToolUtils.size2(Double.parseDouble(temp.getIndustryHj())-hj));
                        businessFiveGroupIndustryMapper.updateBusinessFiveGroupIndustry(temp);
                    }
                }
            }
        }
        //合计变化时，自动计算五大集团的合计、保持全省不变、自动计算其他
        if(group==5 ){
            BusinessFiveGroupIndustry select1 = new BusinessFiveGroupIndustry();
            md = 0.0;
            sd = 0.0;
            fd = 0.0;
            gf = 0.0;
            qt = 0.0;
            Long hjid= -1L;
            Long qgid= -1L;
            Long qtid= -1L;
            select1.setQueryTime(businessFiveGroupIndustry.getQueryTime());
            List<BusinessFiveGroupIndustry> list1 = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(select1);
            if(list1.size()>0){
                for (BusinessFiveGroupIndustry temp : list1) {
                    Integer groupName = Integer.parseInt(temp.getIndustryGroup());
                    if(groupName<=4){
                        md += Double.parseDouble(temp.getIndustryMd());
                        sd += Double.parseDouble(temp.getIndustrySd());
                        fd += Double.parseDouble(temp.getIndustryFd());
                        gf += Double.parseDouble(temp.getIndustryGf());
                        qt += Double.parseDouble(temp.getIndustryQt());
                    }
                    if(groupName==5){
                        hjid=temp.getId();
                    }
                    if(groupName==6){
                        qgid=temp.getId();
                    }
                    if(groupName==7){
                        qtid=temp.getId();
                    }

                }
                businessFiveGroupIndustry.setIndustryMd(ToolUtils.size2(md));
                businessFiveGroupIndustry.setIndustrySd(ToolUtils.size2(sd));
                businessFiveGroupIndustry.setIndustryFd(ToolUtils.size2(fd));
                businessFiveGroupIndustry.setIndustryGf(ToolUtils.size2(gf));
                businessFiveGroupIndustry.setIndustryQt(ToolUtils.size2(qt));
                businessFiveGroupIndustryMapper.updateBusinessFiveGroupIndustry(businessFiveGroupIndustry);
                if(-1!=qtid){
                    BusinessFiveGroupIndustry temp1 = new BusinessFiveGroupIndustry();
                    temp1.setIndustryMd("0.00");
                    temp1.setIndustrySd("0.00");
                    temp1.setIndustryFd("0.00");
                    temp1.setIndustryGf("0.00");
                    temp1.setIndustryQt("0.00");
                    if(-1!=qgid){
                        temp1=businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryById(qgid);
                    }
                    BusinessFiveGroupIndustry temp2 = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryById(qtid);
                    temp2.setIndustryMd(ToolUtils.size2(Double.parseDouble(temp1.getIndustryMd())-md));
                    temp2.setIndustrySd(ToolUtils.size2(Double.parseDouble(temp1.getIndustrySd())-sd));
                    temp2.setIndustryFd(ToolUtils.size2(Double.parseDouble(temp1.getIndustryFd())-fd));
                    temp2.setIndustryGf(ToolUtils.size2(Double.parseDouble(temp1.getIndustryGf())-gf));
                    temp2.setIndustryQt(ToolUtils.size2(Double.parseDouble(temp1.getIndustryQt())-qt));
                    businessFiveGroupIndustryMapper.updateBusinessFiveGroupIndustry(temp2);
                }
            }
        }
        //全省或其他变动，其对应的也要改变
        if(group==6 || group==7 ){
            BusinessFiveGroupIndustry select1 = new BusinessFiveGroupIndustry();
            select1.setQueryTime(businessFiveGroupIndustry.getQueryTime());
            select1.setIndustryGroup("5");
            List<BusinessFiveGroupIndustry> list2 = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(select1);
            if(group==6){
                select1.setIndustryGroup("7");
            }else {
                select1.setIndustryGroup("6");
            }
            List<BusinessFiveGroupIndustry> list1 = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(select1);
            if(list1.size()>0){
                BusinessFiveGroupIndustry temp2 = new BusinessFiveGroupIndustry();
                if(list2.size()>0){
                    temp2 = list2.get(0);
                }
                BusinessFiveGroupIndustry temp = list1.get(0);
                //当变动其他时，全省=合计+其他
                if(group==7){
                    temp.setIndustryMd(ToolUtils.size2(Double.parseDouble(temp2.getIndustryMd())+Double.parseDouble(businessFiveGroupIndustry.getIndustryMd())));
                    temp.setIndustrySd(ToolUtils.size2(Double.parseDouble(temp2.getIndustrySd())+Double.parseDouble(businessFiveGroupIndustry.getIndustrySd())));
                    temp.setIndustryFd(ToolUtils.size2(Double.parseDouble(temp2.getIndustryFd())+Double.parseDouble(businessFiveGroupIndustry.getIndustryFd())));
                    temp.setIndustryGf(ToolUtils.size2(Double.parseDouble(temp2.getIndustryGf())+Double.parseDouble(businessFiveGroupIndustry.getIndustryGf())));
                    temp.setIndustryQt(ToolUtils.size2(Double.parseDouble(temp2.getIndustryQt())+Double.parseDouble(businessFiveGroupIndustry.getIndustryQt())));
                    temp.setIndustryHj(ToolUtils.size2(Double.parseDouble(temp2.getIndustryHj())+Double.parseDouble(businessFiveGroupIndustry.getIndustryHj())));
                }
                //当变动全省时，其他=全省-合计
                if(group==6){
                    temp.setIndustryMd(ToolUtils.size2(-Double.parseDouble(temp2.getIndustryMd())+Double.parseDouble(businessFiveGroupIndustry.getIndustryMd())));
                    temp.setIndustrySd(ToolUtils.size2(-Double.parseDouble(temp2.getIndustrySd())+Double.parseDouble(businessFiveGroupIndustry.getIndustrySd())));
                    temp.setIndustryFd(ToolUtils.size2(-Double.parseDouble(temp2.getIndustryFd())+Double.parseDouble(businessFiveGroupIndustry.getIndustryFd())));
                    temp.setIndustryGf(ToolUtils.size2(-Double.parseDouble(temp2.getIndustryGf())+Double.parseDouble(businessFiveGroupIndustry.getIndustryGf())));
                    temp.setIndustryQt(ToolUtils.size2(-Double.parseDouble(temp2.getIndustryQt())+Double.parseDouble(businessFiveGroupIndustry.getIndustryQt())));
                    temp.setIndustryHj(ToolUtils.size2(-Double.parseDouble(temp2.getIndustryHj())+Double.parseDouble(businessFiveGroupIndustry.getIndustryHj())));
                }
                businessFiveGroupIndustryMapper.updateBusinessFiveGroupIndustry(temp);
            }
        }
        return  returnresult;
    }

    /**
     * 批量删除行业对标
     * 
     * @param ids 需要删除的行业对标ID
     * @return 结果
     */
    @Override
    public int deleteBusinessFiveGroupIndustryByIds(Long[] ids)
    {
        return businessFiveGroupIndustryMapper.deleteBusinessFiveGroupIndustryByIds(ids);
    }

    /**
     * 删除行业对标信息
     * 
     * @param id 行业对标ID
     * @return 结果
     */
    @Override
    public int deleteBusinessFiveGroupIndustryById(Long id)
    {
        return businessFiveGroupIndustryMapper.deleteBusinessFiveGroupIndustryById(id);
    }
    //刷新合计
    @Override
    public String updateBusinessFiveGroupIndustryHj(BusinessFiveGroupIndustry businessFiveGroupIndustry) {
        String Hj = ToolUtils.size2(Double.parseDouble(businessFiveGroupIndustry.getIndustryMd()) + Double.parseDouble(businessFiveGroupIndustry.getIndustrySd())
                + Double.parseDouble(businessFiveGroupIndustry.getIndustryFd()) + Double.parseDouble(businessFiveGroupIndustry.getIndustryGf())
                + Double.parseDouble(businessFiveGroupIndustry.getIndustryQt()));
        return Hj;
    }

    /**
     * 通过年or类型查询总和（饼状图）
     *
     * @param businessFiveGroupIndustry 查询条件对象
     * @return 数据
     */
    @Override
    public Map<String,Object> selectByYearOrQuarter(BusinessFiveGroupIndustry businessFiveGroupIndustry) {
        String dateYear = null==businessFiveGroupIndustry.getIndustryYear()||"".equals(businessFiveGroupIndustry.getIndustryYear())?LocalDate.now().getYear()+"":businessFiveGroupIndustry.getIndustryYear();
        int month =LocalDate.now().getMonthValue();
        String quarter = "第一季度";
        if(month>3&&month<=6){
            quarter = "第二季度";
        } else if(month>6&&month<=9){
            quarter = "第三季度";
        } else if(month>9&&month<=12){
            quarter = "第四季度";
        }
        String dateQuarter = null==businessFiveGroupIndustry.getIndustryQuarter()||"".equals(businessFiveGroupIndustry.getIndustryQuarter())?quarter:businessFiveGroupIndustry.getIndustryQuarter();
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("dateYear",dateYear);
        returnMap.put("dateQuarter",dateQuarter);
        return returnMap;
    }

    @Override
    public Map<String, Object> selectChart(BusinessFiveGroupIndustry businessFiveGroupIndustry) {
        Map<String,Object> returnmap = selectByYearOrQuarter(businessFiveGroupIndustry);
        List<IndustryVo> list = new ArrayList<>();
        businessFiveGroupIndustry.setIndustryYear((String)returnmap.get("dateYear"));
        businessFiveGroupIndustry.setIndustryQuarter((String)returnmap.get("dateQuarter"));
        List<BusinessFiveGroupIndustry> selectList = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(businessFiveGroupIndustry);
        //全省
        BusinessFiveGroupIndustry qs = businessFiveGroupIndustry;
        qs.setIndustryGroup("6");
        List<BusinessFiveGroupIndustry> selectQs = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(businessFiveGroupIndustry);
        if(selectQs.size()>0){
            qs = selectQs.get(0);
        }else {
            qs.setIndustryMd("0.00");
            qs.setIndustrySd("0.00");
            qs.setIndustryFd("0.00");
            qs.setIndustryGf("0.00");
            qs.setIndustryQt("0.00");
        }
//        0=大唐,1=国电投,2=华能,3=华电,4=国能投,5=五大合计,6=全省
        for (BusinessFiveGroupIndustry temp : selectList) {
            Integer group = Integer.parseInt(temp.getIndustryGroup());
            String name = group == 1 ? "国电投" : group == 4 ? "国能投" : group == 0 ? "大唐" : group == 3 ? "华电" : group == 2 ? "华能" : group == 5 ? "五大合计" :group == 6 ? "全省" :"其他";
            if(group<=4 || group==7){
                //控制台通过设置备注进行类别区分
                String s = businessFiveGroupIndustry.getRemark();
                if("md".equals(businessFiveGroupIndustry.getRemark())){
                    Double value = "0.00".equals(qs.getIndustryMd())?new Double(0):Double.parseDouble(temp.getIndustryMd())/Double.parseDouble(qs.getIndustryMd());
                    IndustryVo industryVo = new IndustryVo(ToolUtils.size2(100*value),name);
                    list.add(industryVo);
                }
                if("sd".equals(businessFiveGroupIndustry.getRemark())){
                    Double value = "0.00".equals(qs.getIndustrySd())?new Double(0):Double.parseDouble(temp.getIndustrySd())/Double.parseDouble(qs.getIndustrySd());
                    IndustryVo industryVo = new IndustryVo(ToolUtils.size2(100*value),name);
                    list.add(industryVo);
                }
                if("fd".equals(businessFiveGroupIndustry.getRemark())){
                    Double value = "0.00".equals(qs.getIndustryFd())?new Double(0):Double.parseDouble(temp.getIndustryFd())/Double.parseDouble(qs.getIndustryFd());
                    IndustryVo industryVo = new IndustryVo(ToolUtils.size2(100*value),name);
                    list.add(industryVo);
                }
                if("gf".equals(businessFiveGroupIndustry.getRemark())){
                    Double value = "0.00".equals(qs.getIndustryGf())?new Double(0):Double.parseDouble(temp.getIndustryGf())/Double.parseDouble(qs.getIndustryGf());
                    IndustryVo industryVo = new IndustryVo(ToolUtils.size2(100*value),name);
                    list.add(industryVo);
                }
                if("qt".equals(businessFiveGroupIndustry.getRemark())){
                    Double value = "0.00".equals(qs.getIndustryQt())?new Double(0):Double.parseDouble(temp.getIndustryQt())/Double.parseDouble(qs.getIndustryQt());
                    IndustryVo industryVo = new IndustryVo(ToolUtils.size2(100*value),name);
                    list.add(industryVo);
                }
            }
        }
        returnmap.put("data",list);
        return returnmap;
    }

    @Override
    public List<Map<String,Object>> selectBar(BusinessFiveGroupIndustry businessFiveGroupIndustry) {
        Map<String,Object> returnmap = selectByYearOrQuarter(businessFiveGroupIndustry);
        businessFiveGroupIndustry.setIndustryYear((String)returnmap.get("dateYear"));
        businessFiveGroupIndustry.setIndustryQuarter((String)returnmap.get("dateQuarter"));
//        List<BusinessFiveGroupIndustry> selectList = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryByGroupList(businessFiveGroupIndustry);
        List<BusinessFiveGroupIndustry> selectList = businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(businessFiveGroupIndustry);
        List<Map<String,Object>> returnList = new ArrayList<>();
        for (Integer group = 0; group < 8; group++) {
            String name = group == 1 ? "国电投" : group == 4 ? "国能投" : group == 0 ? "大唐" : group == 3 ? "华电" : group == 2 ? "华能" : group == 5 ? "五大合计" :group == 6 ? "全省" :"其他";
            Object[] result= new Object[6];
            Map<String,Object> map = new HashMap<>();
            for (BusinessFiveGroupIndustry temp : selectList) {
                if(!"5".equals(temp.getIndustryGroup())){
                    Integer group2 = Integer.parseInt(temp.getIndustryGroup());
                    if(group==group2){
                        result[0]=temp.getIndustryMd();
                        result[1]=temp.getIndustrySd();
                        result[2]=temp.getIndustryFd();
                        result[3]=temp.getIndustryGf();
                        result[4]=temp.getIndustryQt();
                        result[5]=temp.getIndustryHj();
                    }
                }
                //
            }
            map.put("name",name);
            map.put("type","bar");
            map.put("data",result);
            //五大合计不计入，其他 放在 全国 的后面
            if(group == 7){
                returnList.add(5,map);
            }else if(group != 7 && group != 5) {
                returnList.add(map);
            }
        }
        return returnList;
    }

    //默认返回当前年份季度的表格给前端
    @Override
    public List<BusinessFiveGroupIndustry> selectBusinessFiveGroupIndustryList2(BusinessFiveGroupIndustry businessFiveGroupIndustry) {
        Map<String,Object> returnmap = selectByYearOrQuarter(businessFiveGroupIndustry);
        businessFiveGroupIndustry.setIndustryYear((String)returnmap.get("dateYear"));
        businessFiveGroupIndustry.setIndustryQuarter((String)returnmap.get("dateQuarter"));
        return businessFiveGroupIndustryMapper.selectBusinessFiveGroupIndustryList(businessFiveGroupIndustry);
    }

    //季度转换成月、日
    private String getMonthAndDay(String industryQuarter) {
        String temp = "-01-01";
        if("第一季度".equals(industryQuarter)){
            temp = "-03-31";
        }
        if("第二季度".equals(industryQuarter)){
            temp = "-06-30";
        }
        if("第三季度".equals(industryQuarter)){
            temp = "-09-30";
        }
        if("第四季度".equals(industryQuarter)){
            temp = "-12-31";
        }
        return temp;
    }
}
