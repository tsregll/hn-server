package com.ruoyi.web.controller.business;
// package com.test;


import java.util.Date;
import java.util.concurrent.TimeUnit;
import com.modules.Edoc2Version;
import com.modules.TransferConfig;
import com.modules.UpdateStrategy;
import com.ruoyi.common.utils.DateUtils;
import com.transferClient.EDoc2TransferClient;
import com.transferClient.GetFileClient;
import com.transferClient.UploadFileClient;
import com.transferRequest.CreateFileRequest;
import com.transferRequest.GetFileRequest;
import com.transferRequest.UpdateFileRequest;
import com.transferResponse.CreateFileResponse;
import com.transferResponse.GetFileResponse;
import com.transferResponse.TransferBaseResponse;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.util.Set;

/**
 * @author dw
 */
@RestController
@RequestMapping("/business")
public class MeetingSummary_xny {
    @PostMapping ("/CreateFile")
   //"LoginName:"admin"","IPAddress"10.219,245,29"","IntegrationKey:"0b79394-fa86-45da-8hf3-aa7cc35430b8"

    public void GetJsessionID(String token) throws Exception {

//        Process proc;
//        try {
//            proc = Runtime.getRuntime().exec("python D:\\sqlText.py");
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gb2312"));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            proc.waitFor();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        File  myfile = null;
        /**
         * 生成会议纪要
         * 执行sqlText.exe
         */
        try{
            Runtime mt =Runtime.getRuntime();
            //找到相对应的绝对路径。启动文件
            myfile =new File("D:\\前期基建会议纪要\\dist","sqlText.exe");
            mt.exec(myfile.getAbsolutePath());

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("1000");

        /**
         * 暂停一下等文件生成好
         */
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }




        TransferConfig config = new TransferConfig("http://172.22.192.201/", Edoc2Version.V5_18);
        System.out.println("1001");
        config.setCacheHttpClient(false);
        System.out.println("1002");
        config.setMaxErrorRetry(2);  // 重试次数
        System.out.println("1003");
        config.setOpenSpeedLog(true);  // 是否开启上传速率日志,打印至控制台
        System.out.println("1004");
        config.setTimeout(1000*60);  // 超时时间(毫秒ms)
        System.out.println("1005");
        // 用户的登录令牌,如需运行请自行，找一个，或者使用 Samples.1_auth.GetToken
//        String token = new GetToken().getIntegrationToken("admin").getData();


        UploadFileClient client = new UploadFileClient(config);

        System.out.println("1006");


        /**
         * 上传更新文件
         * @param client
         * @param token
         * @throws Exception
         */
        token = "0034db856113ccdb42938f28566540a6ed03";
        // 指定一个文件"D:\\trest.docx"
        String filePath ="D:\\会议纪要"+DateUtils.getDate()+".docx";

        // 文件至少是一个真实存在的文件
        File file = new File(filePath);
        System.out.println("1007");
        if(!file.exists()){
            System.out.println("文件不存在，请指定一个存在的文件");
            return;
        }

        FileInputStream fileStream = new FileInputStream(file);
        System.out.println("1008");
        String fileName = file.getName();
        System.out.println("1009");
        // 注意此处的传参类型
        CreateFileRequest request = new CreateFileRequest();
        System.out.println("1010");
        request.setToken(token);
        request.setFileName(fileName);
        request.setFileRemark("ha@ha$#h++=a!");
        System.out.println("1011");
        request.setFileSize(fileStream.available());  // 真实的文件大小
        System.out.println("1012");
        request.setFolderId(139);
        System.out.println("1013");
        /*
         * 上传遇到同名文件处理策略
         * UpdateStrategy.Skip 跳过上传,不再继续上传
         * UpdateStrategy.UpdateVersion 自动将上传新文件改成更新同名文件的版本
         */
        request.setUpdateStrategy(UpdateStrategy.UpdateVersion);
        System.out.println("1014");
        request.setChunkSize(5*1024*1024); //单位 byte
        System.out.println("1015");
        CreateFileResponse resp = client.createFile(request, filePath);
        System.out.println("1016");




    }



//
//    public static void main(String [] args) throws Exception {
//
//
//
//        TransferConfig config = new TransferConfig("http://172.22.192.201/", Edoc2Version.V5_18);
//
//        config.setCacheHttpClient(false);
//
//        config.setMaxErrorRetry(2);  // 重试次数
//
//        config.setOpenSpeedLog(true);  // 是否开启上传速率日志,打印至控制台
//
//        config.setTimeout(1000*60);  // 超时时间(毫秒ms)
//
//        // 用户的登录令牌,如需运行请自行，找一个，或者使用 Samples.1_auth.GetToken
////        String token = new GetToken().getIntegrationToken("admin").getData();
//
//
//        UploadFileClient client = new UploadFileClient(config);
//
//        String token="0034db856113ccdb42938f28566540a6ed03";
//        // 指定一个文件
//        String filePath = "D:\\sqlText.py";
//        // 文件至少是一个真实存在的文件
//        File file = new File(filePath);
//        System.out.println("1007");
//        if(!file.exists()){
//            System.out.println("文件不存在，请指定一个存在的文件");
//            return;
//        }
//
//        FileInputStream fileStream = new FileInputStream(file);
//        System.out.println("1008");
//        String fileName = file.getName();
//        System.out.println("1009");
//        // 注意此处的传参类型
//        CreateFileRequest request = new CreateFileRequest();
//        System.out.println("1010");
//        request.setToken(token);
//        request.setFileName(fileName);
//        request.setFileRemark("ha@ha$#h++=a!");
//        System.out.println("1011");
//        request.setFileSize(fileStream.available());  // 真实的文件大小
//        System.out.println("1012");
//        request.setFolderId(139);
//        System.out.println("1013");
//        /*
//         * 上传遇到同名文件处理策略
//         * UpdateStrategy.Skip 跳过上传,不再继续上传
//         * UpdateStrategy.UpdateVersion 自动将上传新文件改成更新同名文件的版本
//         */
//        request.setUpdateStrategy(UpdateStrategy.UpdateVersion);
//        System.out.println("1014");
//        request.setChunkSize(5*1024*1024); //单位 byte
//        System.out.println("1015");
//        CreateFileResponse resp = client.createFile(request, filePath);
//        System.out.println("1016");
//
//    }







}
