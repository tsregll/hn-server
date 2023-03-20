//package com.ruoyi.web.controller.data;
//
//import com.ruoyi.common.utils.DateUtils;
//import com.ruoyi.common.utils.StringUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author: liangw(460098508 @ qq.com)
// * @time: 2021/3/6 9:07
// * @description:
// */
//@Controller
//@RequestMapping("/web/data")
//@Api(value = "中台数据获取并生成表单接口", tags = {"中台数据获取并生成表单接口"})
//public class ZongTaiTableController {
//    private final Logger log = LoggerFactory.getLogger(ZongTaiTableController.class);
//    private final static String errorPage = "error.html";
//    private final static String suffix = ".html";
//    @Autowired
//    private FreeMarkerUtil freeMarkerUtil;
//
//    /**
//     * 直接根据模板编号获取内容
//     *
//     * @param code 模板编号
//     */
//    @ApiOperation(value = "根据模板编号查询对应中台数据，并返回对应表单的HTML内容", notes = "中台数据接口查询并返回")
//    @RequestMapping(value = "/view/{code}", method = RequestMethod.GET)
//    public void view(@PathVariable String code,
//                     HttpServletResponse response) {
//        try {
//            //1、获取模板名称并取到模板中的标签
//            String templateName = code + suffix;
//            List<String> tags = this.freeMarkerUtil.getTemplateTag(templateName);
//
//            //2、根据标签从中台中获取对应的数据
//            Map<String, Object> map = this.getZhongTaiData(tags, null, null);
//
//            //3、将数据和模板结合并输出到response
//
//            this.freeMarkerUtil.writeOut(templateName, map, response.getWriter());
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            Map<String, Object> map = new HashMap<>();
//            map.put("message", "获取数据出错！");
//            try {
//                this.freeMarkerUtil.writeOut(errorPage, map, response.getWriter());
//            } catch (Exception ex) {
//                log.error(ex.getMessage(), ex);
//            }
//        }
//    }
//
//    /**
//     * 直接根据模块获取内容
//     *
//     * @param code  模块名称
//     * @param start 开始时间【格式：yyyy-MM-dd】
//     * @param end   结束时间【格式：yyyy-MM-dd】
//     */
//    @ApiOperation(value = "根据模板编号和日期查询对应中台数据，并返回对应表单的HTML内容", notes = "查询并返回数据测试")
//    @ApiImplicitParams({@ApiImplicitParam(name = "start", dataType = "String", paramType = "query", required = true),
//            @ApiImplicitParam(name = "end", dataType = "String", paramType = "query", required = true)})
//    @RequestMapping(value = "/view-by-date/{code}", method = RequestMethod.GET)
//    public void viewByDate(@PathVariable String code,
//                           @RequestParam(required = false) String start,
//                           @RequestParam(required = false) String end,
//                           HttpServletResponse response) {
//        try {
//            //1、获取模板名称并取到模板中的标签
//            String templateName = code + suffix;
//            List<String> tags = this.freeMarkerUtil.getTemplateTag(templateName);
//
//            //2、根据标签和日期参数从中台中获取对应的数据
//            Date startDate = null, endDate = null;
//            if (!StringUtils.isEmpty(start)) {
//                startDate = DateUtils.parseDate(start);
//            } else {
//                //TODO 如果开始时间为空，是否要默认值
//            }
//            if (!StringUtils.isEmpty(end)) {
//                endDate = DateUtils.parseDate(end);
//            } else {
//                //TODO 如果结束时间为空，是否要默认值
//            }
//
//
//            Map<String, Object> map = this.getZhongTaiData(tags, startDate, endDate);
//
//            //3、将数据和模板结合并输出到response
//            this.freeMarkerUtil.writeOut(templateName, map, response.getWriter());
//
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            Map<String, Object> map = new HashMap<>();
//            map.put("message", "获取数据出错！");
//            try {
//                this.freeMarkerUtil.writeOut(errorPage, map, response.getWriter());
//            } catch (Exception ex) {
//                log.error(ex.getMessage(), ex);
//            }
//        }
//
//    }
//
//    /**
//     * 根据标签获取中台数据，<br>
//     * 如果开始时间和结束时间为空，则不需要按时间查询数据<br>
//     * 如果不为空则表示需要按时间查询数据<br>
//     *
//     * @param tags  标签集合
//     * @param start 开始时间
//     * @param end   结束时间
//     * @return
//     */
//    private Map<String, Object> getZhongTaiData(List<String> tags, Date start, Date end) {
//        Map<String, Object> map = new HashMap<>();
//
//        return map;
//    }
//}
