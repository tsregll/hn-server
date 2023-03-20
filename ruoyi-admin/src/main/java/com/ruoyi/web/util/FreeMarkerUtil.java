package com.ruoyi.web.util;

import freemarker.core.TemplateElement;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author: liangw(460098508 @ qq.com)
 * @time: 2021/3/6 7:51
 * @description:
 */
@Component
public class FreeMarkerUtil {

    private final Logger log = LoggerFactory.getLogger(FreeMarkerUtil.class);

    @Autowired
    private Configuration freeMarkerConfig;

    /**
     * @param templateName
     * @return
     * @throws IOException
     */
    public String getTemplateString(String templateName) throws IOException {

        Template template = this.freeMarkerConfig.getTemplate(templateName);
        //获取所有的标签项
        TemplateElement te = template.getRootTreeNode();

        for (Enumeration children = te.children(); children.hasMoreElements(); ) {
            Object obj = children.nextElement();
            if ("class freemarker.core.DollarVariable".equals(obj.getClass().toString())) {

                String tagName = obj.toString();
                if (tagName.startsWith("$")) {
                    tagName = tagName.substring(2, tagName.length() - 1);
                }
                log.info(obj.toString() + "=============" + tagName);
            }

        }
        return template.toString();
    }

    /**
     * @param templateName
     * @param map
     * @param filePath
     * @throws IOException
     * @throws TemplateException
     */
    public void getTemplateHTML(String templateName, Map<String, Object> map, String filePath) throws
            IOException, TemplateException {
        Template template = this.freeMarkerConfig.getTemplate(templateName);
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)), StandardCharsets.UTF_8));
        template.process(map, out);
    }

    /**
     *
     * @param templateName
     * @return
     * @throws IOException
     */
    public List<String> getTemplateTag(String templateName) throws IOException {
        List<String> tags = new ArrayList<>();
        Template template = this.freeMarkerConfig.getTemplate(templateName);
        //获取所有的标签项
        TemplateElement te = template.getRootTreeNode();

        for (Enumeration children = te.children(); children.hasMoreElements(); ) {
            Object obj = children.nextElement();
            if ("class freemarker.core.DollarVariable".equals(obj.getClass().toString())) {

                String tagName = obj.toString();
                if (tagName.startsWith("$")) {
                    tagName = tagName.substring(2, tagName.length() - 1);
                    tags.add(tagName);
                }
            }

        }
        return tags;
    }


}
