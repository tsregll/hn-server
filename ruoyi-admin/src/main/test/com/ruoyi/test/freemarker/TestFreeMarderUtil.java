package com.ruoyi.test.freemarker;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.test.ServiceTestBase;
import com.ruoyi.web.util.FreeMarkerUtil;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liangw(460098508 @ qq.com)
 * @time: 2021/3/6 7:56
 * @description:
 */
public class TestFreeMarderUtil extends ServiceTestBase {

    @Autowired
    FreeMarkerUtil freeMarkerUtil;

    @Test
    public void testGetTemplateString() throws IOException {
        String s = this.freeMarkerUtil.getTemplateString("test.html");
        log.info("获取的模板信息：" + s);
        List<String> tags = this.freeMarkerUtil.getTemplateTag("test.html");
        log.info("获取模块的标签信息=====" + JSONArray.toJSONString(tags));
    }

    @Test
    public void testGetTemplateHTML() throws IOException, TemplateException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "测试1");
        map.put("age", 120);
        map.put("sex", "男");
        map.put("memo", "这只是一个测试，没有其他的问题");
        this.freeMarkerUtil.getTemplateHTML("test.html", map, "e:/aaa.html");
        log.info("模板生成完成");
    }
}
