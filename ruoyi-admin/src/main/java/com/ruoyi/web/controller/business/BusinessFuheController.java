package com.ruoyi.web.controller.business;


import com.ruoyi.business.domain.BusinessFuheDTO;
import com.ruoyi.business.domain.BusinessFuheDuibiDTO;
import com.ruoyi.business.service.impl.BusinessFuheServiceImpl;
import com.ruoyi.business.vo.BusinessFuheVo;
import org.apache.ibatis.annotations.Param;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class BusinessFuheController {

    @Resource
    private BusinessFuheServiceImpl businessFuheService;

    @PostMapping("yingxiaoguanli/UploadData")
    public void uploadData(@RequestBody BusinessFuheDTO params){
        businessFuheService.uploadData(params);
    }

    @PostMapping("yingxiaoguanli/GetfuheduibiData")
    public List<BusinessFuheVo> GetfuheduibiData(@RequestBody BusinessFuheDuibiDTO params){
        return businessFuheService.GetfuheduibiData(params);
    }

    @RequestMapping(value="downloadExcel", method = RequestMethod.GET)//method = RequestMethod.GET将数据传递给前端
    public HttpServletResponse downloadExcel(HttpServletResponse response, HttpServletRequest request)throws IOException {
        //获取输入流，原始模板位置
        String fileName="subaoding.xls";
//        String  filePath = getClass().getResource(fileName1).getPath();
        ClassPathResource resource = new ClassPathResource("/templates/"+fileName);
//        String userAgent = request.getHeader("User-Agent");
//        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
//            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//        } else {
//            // 非IE浏览器的处理：
//            fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
//        }
//        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        InputStream bis = resource.getInputStream();
//        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = "导入模板.xls";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = bis.read(bytes)) != -1){
            out.write(bytes,0,len);
            out.flush();
        }
        out.close();
        return response;

//        ServletOutputStream out;
//        response.setContentType("multipart/form-data");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        //getResource无法读取压缩文件里的路径，本地可以，打成jar包会报错
////        String filePath = getClass().getResource("/static/excel/" + fileName).getPath();
//        String fileName="subaoding.xls";
//        ClassPathResource resource = new ClassPathResource("/templates/"+fileName);
//        String userAgent = request.getHeader("User-Agent");
//        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
//            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//        } else {
//            // 非IE浏览器的处理：
//            fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
//        }
//        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
//        InputStream inputStream = resource.getInputStream();
//        out = response.getOutputStream();
//        int b = 0;
//        byte[] buffer = new byte[1024];
//        while ((b = inputStream.read(buffer)) != -1) {
//            out.write(buffer, 0, b);
//        }
//        inputStream.close();
//
//        if (out != null) {
//            out.flush();
//            out.close();
//        }

    }



}
