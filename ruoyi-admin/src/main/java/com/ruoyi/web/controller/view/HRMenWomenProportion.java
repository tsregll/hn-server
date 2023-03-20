package com.ruoyi.web.controller.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("男女比例")
public class HRMenWomenProportion {
    @ApiModelProperty(value = "女生对象", name = "girl", dataType = "MenWomenProportionItem")
    private MenWomenProportionItem girl;

    @ApiModelProperty(value = "男生对象", name = "boy", dataType = "MenWomenProportionItem")
    private MenWomenProportionItem boy;

    public MenWomenProportionItem getGirl() {
        return girl;
    }

    public void setGirl(MenWomenProportionItem girl) {
        this.girl = girl;
    }

    public MenWomenProportionItem getBoy() {
        return boy;
    }

    public void setBoy(MenWomenProportionItem boy) {
        this.boy = boy;
    }
}


@ApiModel("比例对象详情")
class MenWomenProportionItem {
    @ApiModelProperty(value = "总数量", name = "number", dataType = "String")
    private String number;
    @ApiModelProperty(value = "比率", name = "absolutely", dataType = "String")
    private String absolutely;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAbsolutely() {
        return absolutely;
    }

    public void setAbsolutely(String absolutely) {
        this.absolutely = absolutely;
    }
}