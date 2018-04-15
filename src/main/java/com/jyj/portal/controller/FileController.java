package com.jyj.portal.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by jiangyijie on 2018-04-15.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = {"/", "/submit"})
    public String home() {
        return "fileupload";
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            //File temp = new File("");
            //String filePath = temp.getAbsolutePath() + "\\" + file.getOriginalFilename();

            String webInf = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
            String filePath = webInf + file.getOriginalFilename();

            BufferedOutputStream out;
            try {
                out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));

                out.write(file.getBytes());
                out.flush();
                out.close();
                return "文件上传成功";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "文件上传失败";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        String webInf = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/";
        String filePath = webInf + "test.txt";

        File file = new File(filePath);
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        headers.setContentDispositionFormData("attachment", file.getName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}

