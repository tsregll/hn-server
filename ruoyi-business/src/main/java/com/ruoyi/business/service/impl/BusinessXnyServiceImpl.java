package com.ruoyi.business.service.impl;

import com.ruoyi.business.mapper.BusinessXnyMapper;
import com.ruoyi.business.vo.BusinessXnyProjectVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessXnyServiceImpl {

    @Resource
    private BusinessXnyMapper businessXnyMapper;

    public List<BusinessXnyProjectVo> getProject(String selectYear){
        return businessXnyMapper.getProject(selectYear);
    }

    public void importFile(List<BusinessXnyProjectVo> businessXnyProjectVos){
        businessXnyMapper.truncateTable();
        for (BusinessXnyProjectVo b:businessXnyProjectVos) {
            businessXnyMapper.insertProject(b);
        }

    }


    /**
     * 检验文件是否有效
     *
     * @param file
     * @throws Exception
     */
    public static void checkFile(MultipartFile file) throws Exception {
        // 判断文件是否存在
        if (null == file) {
            throw new FileNotFoundException("文件不存在！");
        }
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 判断文件是否是excel文件
        if (!fileName.endsWith("xls") && !fileName.endsWith("xlsx")) {
            throw new IOException(fileName + "不是excel文件");
        }
    }


    /**
     * 获取workbook
     *
     * @param file
     * @return
     */
    public static Workbook getWorkBook(MultipartFile file) {
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            // 获取excel文件的io流
            InputStream is = file.getInputStream();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith("xls")) {
                // 2003
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith("xlsx")) {
                // 2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {

        }
        return workbook;
    }


    /**
     * 获取解析后的文件内容
     *
     * @return
     */
    public static List<BusinessXnyProjectVo> readExcel(MultipartFile file) {
        List<BusinessXnyProjectVo> list = new ArrayList<BusinessXnyProjectVo>();
        try {
            checkFile(file);
            // 获得Workbook工作薄对象
            Workbook workbook = getWorkBook(file);
            int sheetSize = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetSize; i++) {// 遍历sheet页
                // 获取第一个张表
                Sheet sheet = workbook.getSheetAt(0);
                // 获取每行中的字段
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j); // 获取行
                    if (row == null) {//略过空行
                        continue;
                    }else{
                        // 获取单元格中的值并存到对象中
                        BusinessXnyProjectVo businessXnyProjectVo = new BusinessXnyProjectVo();
                        businessXnyProjectVo.setProjectId((int) row.getCell(0).getNumericCellValue());
                        businessXnyProjectVo.setProjectName(row.getCell(1).getStringCellValue());
                        businessXnyProjectVo.setProjectType(row.getCell(2).getStringCellValue());
                        businessXnyProjectVo.setNode1_0(row.getCell(3).getStringCellValue());
                        businessXnyProjectVo.setNode1_1(row.getCell(4).getStringCellValue());
                        businessXnyProjectVo.setNode2_0(row.getCell(5).getStringCellValue());
                        businessXnyProjectVo.setNode2_1(row.getCell(6).getStringCellValue());
                        businessXnyProjectVo.setNode3_0(row.getCell(7).getStringCellValue());
                        businessXnyProjectVo.setNode3_1(row.getCell(8).getStringCellValue());
                        businessXnyProjectVo.setNode4_0(row.getCell(9).getStringCellValue());
                        businessXnyProjectVo.setNode4_1(row.getCell(10).getStringCellValue());
                        businessXnyProjectVo.setNode5_0(row.getCell(11).getStringCellValue());
                        businessXnyProjectVo.setNode5_1(row.getCell(12).getStringCellValue());
                        businessXnyProjectVo.setNode6_0(row.getCell(13).getStringCellValue());
                        businessXnyProjectVo.setNode6_1(row.getCell(14).getStringCellValue());
                        businessXnyProjectVo.setNode7_0(row.getCell(15).getStringCellValue());
                        businessXnyProjectVo.setNode7_1(row.getCell(16).getStringCellValue());
                        businessXnyProjectVo.setNode8_0(row.getCell(17).getStringCellValue());
                        businessXnyProjectVo.setNode8_1(row.getCell(18).getStringCellValue());
                        businessXnyProjectVo.setNode9_0(row.getCell(19).getStringCellValue());
                        businessXnyProjectVo.setNode9_1(row.getCell(20).getStringCellValue());
                        businessXnyProjectVo.setNode10_0(row.getCell(21).getStringCellValue());
                        businessXnyProjectVo.setNode10_1(row.getCell(22).getStringCellValue());
                        businessXnyProjectVo.setNode11_0(row.getCell(23).getStringCellValue());
                        businessXnyProjectVo.setNode11_1(row.getCell(24).getStringCellValue());
                        businessXnyProjectVo.setNode12_0(row.getCell(25).getStringCellValue());
                        businessXnyProjectVo.setNode12_1(row.getCell(26).getStringCellValue());
                        businessXnyProjectVo.setNode13_0(row.getCell(27).getStringCellValue());
                        businessXnyProjectVo.setNode13_1(row.getCell(28).getStringCellValue());
                        businessXnyProjectVo.setNode14_0(row.getCell(29).getStringCellValue());
                        businessXnyProjectVo.setNode14_1(row.getCell(30).getStringCellValue());
                        businessXnyProjectVo.setNode15_0(row.getCell(31).getStringCellValue());
                        businessXnyProjectVo.setNode15_1(row.getCell(32).getStringCellValue());
                        businessXnyProjectVo.setNode16_0(row.getCell(33).getStringCellValue());
                        businessXnyProjectVo.setNode16_1(row.getCell(34).getStringCellValue());
                        businessXnyProjectVo.setNode17_0(row.getCell(35).getStringCellValue());
                        businessXnyProjectVo.setNode17_1(row.getCell(36).getStringCellValue());
                        businessXnyProjectVo.setNode18_0(row.getCell(37).getStringCellValue());
                        businessXnyProjectVo.setNode18_1(row.getCell(38).getStringCellValue());
                        businessXnyProjectVo.setNode19_0(row.getCell(39).getStringCellValue());
                        businessXnyProjectVo.setNode19_1(row.getCell(40).getStringCellValue());
                        businessXnyProjectVo.setNode20_0(row.getCell(41).getStringCellValue());
                        businessXnyProjectVo.setNode20_1(row.getCell(42).getStringCellValue());
                        businessXnyProjectVo.setNode21_0(row.getCell(42).getStringCellValue());
                        businessXnyProjectVo.setNode21_1(row.getCell(44).getStringCellValue());
                        businessXnyProjectVo.setNode22_0(row.getCell(45).getStringCellValue());
                        businessXnyProjectVo.setNode22_1(row.getCell(46).getStringCellValue());
                        businessXnyProjectVo.setNode23_0(row.getCell(47).getStringCellValue());
                        businessXnyProjectVo.setNode23_1(row.getCell(48).getStringCellValue());
                        businessXnyProjectVo.setNode24_0(row.getCell(49).getStringCellValue());
                        businessXnyProjectVo.setNode24_1(row.getCell(50).getStringCellValue());
                        businessXnyProjectVo.setNode25_0(row.getCell(51).getStringCellValue());
                        businessXnyProjectVo.setNode25_1(row.getCell(52).getStringCellValue());
                        businessXnyProjectVo.setNode26_0(row.getCell(53).getStringCellValue());
                        businessXnyProjectVo.setNode26_1(row.getCell(54).getStringCellValue());
                        businessXnyProjectVo.setNode27_0(row.getCell(55).getStringCellValue());
                        businessXnyProjectVo.setNode27_1(row.getCell(56).getStringCellValue());
                        businessXnyProjectVo.setNode28_0(row.getCell(57).getStringCellValue());
                        businessXnyProjectVo.setNode28_1(row.getCell(58).getStringCellValue());
                        businessXnyProjectVo.setNode29_0(row.getCell(59).getStringCellValue());
                        businessXnyProjectVo.setNode29_1(row.getCell(60).getStringCellValue());
                        businessXnyProjectVo.setNode30_0(row.getCell(61).getStringCellValue());
                        businessXnyProjectVo.setNode30_1(row.getCell(62).getStringCellValue());
                        businessXnyProjectVo.setNode31_0(row.getCell(63).getStringCellValue());
                        businessXnyProjectVo.setNode31_1(row.getCell(64).getStringCellValue());
                        businessXnyProjectVo.setNode32_0(row.getCell(65).getStringCellValue());
                        businessXnyProjectVo.setNode32_1(row.getCell(66).getStringCellValue());
                        businessXnyProjectVo.setNode33_0(row.getCell(67).getStringCellValue());
                        businessXnyProjectVo.setNode33_1(row.getCell(68).getStringCellValue());
                        list.add(businessXnyProjectVo);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("导入失败");;
        }
        return list;
    }
}
