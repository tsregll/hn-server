package com.ruoyi.test.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.BusinessInstallationStatistics;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.ServiceTestBase;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * excel导入功能测试
 *
 * @ClassName ExcelImportTest
 * @Author wangliang(460098508 @ qq.com)
 * @Date 2021-03-13 0:03
 * @Description
 */
public class ExcelImportTest extends ServiceTestBase {


    /**
     * 获取文件流对象
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    private InputStream readFile(String filePath) {
        File f = new File(filePath);
        if (f.isFile()) {
            try {
                return new FileInputStream(new File(filePath));
            } catch (FileNotFoundException e) {
                log.warn("文件不存在或路径不正确！");
            }
        }
        return null;
    }


    /**
     * 关闭文件流
     *
     * @param is
     */
    private void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                log.warn("关闭文件流出错！");
            }
        }
    }

    @Test
    public void testReadExcelToObj() {
        String filePath = "e:/test.xlsx";
        InputStream is = this.readFile(filePath);
        try {
            ExcelUtil<BusinessInstallationStatistics> excelUtil = new ExcelUtil<>(BusinessInstallationStatistics.class);
            List<BusinessInstallationStatistics> list = excelUtil.importExcel(is);

            log.info("导入数据共【" + list.size() + "】条，记录如下=================================");
            log.info(JSONArray.toJSONString(list));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeInputStream(is);
        }


    }
}
