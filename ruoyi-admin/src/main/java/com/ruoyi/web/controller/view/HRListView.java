package com.ruoyi.web.controller.view;

import com.ruoyi.common.core.domain.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("人资近三年统计字段描述")
public class HRListView {
    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<HrListViewData> getData() {
        return data;
    }

    public void setData(List<HrListViewData> data) {
        this.data = data;
    }

    @ApiModelProperty(value = "总数", name = "totalNumber", dataType = "String")
    private String totalNumber;

    @ApiModelProperty(value = "数据列表", name = "data", dataType = "List<HrListViewData>")
    private List<HrListViewData> data;


    @Override
    public String toString() {
        return "HRListView{" +
                "totalNumber='" + totalNumber + '\'' +
                ", data=" + data +
                '}';
    }
}

@ApiModel("人资每一个部门的统计")
class HrListViewData {

    @ApiModelProperty(value = "当前部门名称", name = "deptName", dataType = "String")
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<SysUser> getItems() {
        return items;
    }

    public void setItems(List<SysUser> items) {
        this.items = items;
    }

    @ApiModelProperty(value = "当前部门人员总数", name = "number", dataType = "String")
    private String number;

    @ApiModelProperty(value = "当前部门人员列表", name = "number", dataType = "String")
    private List<SysUser> items;

    @Override
    public String toString() {
        return "HrListViewData{" +
                "deptName='" + deptName + '\'' +
                ", number='" + number + '\'' +
                ", items=" + items +
                '}';
    }
}

