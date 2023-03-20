package com.ruoyi.web.controller.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("学历比例")
public class HRXLView {
    @ApiModelProperty(value = "专科", name = "specializedSubjects", dataType = "MenWomenProportionItem")
    private MenWomenProportionItem specializedSubjects;

    @ApiModelProperty(value = "本科", name = "undergraduateCourses", dataType = "MenWomenProportionItem")
    private MenWomenProportionItem undergraduateCourses;

    @ApiModelProperty(value = "研究生", name = "graduateStudents", dataType = "MenWomenProportionItem")
    private MenWomenProportionItem graduateStudents;

    @ApiModelProperty(value = "中专及以下学历", name = "others", dataType = "MenWomenProportionItem")
    private MenWomenProportionItem others;


    public MenWomenProportionItem getSpecializedSubjects() {
        return specializedSubjects;
    }

    public void setSpecializedSubjects(MenWomenProportionItem specializedSubjects) {
        this.specializedSubjects = specializedSubjects;
    }

    public MenWomenProportionItem getUndergraduateCourses() {
        return undergraduateCourses;
    }

    public void setUndergraduateCourses(MenWomenProportionItem undergraduateCourses) {
        this.undergraduateCourses = undergraduateCourses;
    }

    public MenWomenProportionItem getGraduateStudents() {
        return graduateStudents;
    }

    public void setGraduateStudents(MenWomenProportionItem graduateStudents) {
        this.graduateStudents = graduateStudents;
    }

    public MenWomenProportionItem getOthers() {
        return others;
    }

    public void setOthers(MenWomenProportionItem others) {
        this.others = others;
    }
}



