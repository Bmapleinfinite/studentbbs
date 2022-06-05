package com.example.studentbbs.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.studentbbs.util.Result;
import com.example.studentbbs.util.ResultGenerator;

@Controller
public class uploadController {
    private final static String FILE_UPLOAD_DIC = "D:\\upload\\";
    
    @PostMapping("/uploadFile")
    @ResponseBody
    public Result uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(FILE_UPLOAD_DIC);

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
