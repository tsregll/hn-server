package com.ruoyi.test.excel;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.business.domain.BusinessInstallationStatistics;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.ServiceTestBase;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * excel导出功能测试
 *
 * @ClassName ExcelImportTest
 * @Author wangliang(460098508 @ qq.com)
 * @Date 2021-03-13 0:03
 * @Description
 */
public class ExcelexportTest extends ServiceTestBase {


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
    public void testExportExcelTmplate() {
        String filePath = "test_tmplate.xlsx";
        InputStream is = null;
        try {
            ExcelUtil<BusinessInstallationStatistics> excelUtil = new ExcelUtil<>(BusinessInstallationStatistics.class);
            excelUtil.importTemplateExcel(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeInputStream(is);
        }


    }
}
