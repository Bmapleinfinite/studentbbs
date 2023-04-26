/**
 * 上传文件控制层
 */
package com.example.studentbbs.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.studentbbs.common.SystemVarEnum;
import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

@Controller
public class UploadController {
    private final static String FILE_UPLOAD_DIC = SystemVarEnum.FILE_UPLOAD_DIC.getValue();
    
    /**
     * 上传文件操作
     * @param request
     * @param file 文件对象
     * @return
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public Result uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        /* 获取原文件名 */
        String fileName = file.getOriginalFilename();
        /* 获取文件后缀名 */
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        /* 获取文件名称 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        /* 获取存放路径 */
        File fileDirectory = new File(FILE_UPLOAD_DIC);

        /* 获取目标文件路径 */
        File destFile = new File(FILE_UPLOAD_DIC + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
            String destfileDirectory = "/upload/" + newFileName;
            return ResultGenerator.genSuccessResultWithFileDirectory(destfileDirectory);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult();
        }
    }
}
