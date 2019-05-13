package com.csu.action;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈文件上传demo〉
 *
 * @author yuanlin_csu
 * @create 2019/5/13
 * @since 1.0.0
 */
@Controller
public class FileUploadAction {

    @RequestMapping( value = "/upload.do",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("uploadfile")CommonsMultipartFile multipartFile, HttpServletRequest request){

        if(!multipartFile.isEmpty()){


            String originFileName = multipartFile.getOriginalFilename();
            String fileTpye = StringUtils.substring(originFileName,originFileName.lastIndexOf("."));
            System.out.println("文件：" + originFileName + " : " + fileTpye);

            String fileName = "test" + System.currentTimeMillis() + fileTpye;
            // 存放位置
            String path = request.getSession().getServletContext().getRealPath("/upload/" + fileName);
            File targetFile = new File(path);
            System.out.println("filePath : " + path);
            try {
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),targetFile);
            } catch (IOException e) {
                System.out.println("写入文件异常！！！");
                e.printStackTrace();
            }

            return "redirect:common/fileUploadSuccess.jsp";

        } else {
            return "redirect:common/error.jsp";
        }




    }

}
