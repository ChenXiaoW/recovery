package com.example.recovery.controller;

import com.example.recovery.vo.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @ClassName: OssController
 * @Description: OssController
 * @Author  
 * @Date 2023/03/21 - 22:51
 */
@Api(tags = "OSS管理")
@RestController
@RequestMapping("/oss")
public class OssController {

    @Value("${file.path}")
    private String filePath;

    @Value("${file.urlPrefix}")
    private String urlPrefix;

    @ApiOperation("图片上传")
    @PostMapping("/upload")
    public Response<String> upload(@RequestParam MultipartFile file) {
        File pathFile = new File(filePath);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        //上传文件地址
        String uuid = UUID.randomUUID().toString().replace("-", "");
        File serverFile = new File(pathFile, uuid + "_" + file.getOriginalFilename());
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Response.success("/oss/images/"+uuid + "_" + file.getOriginalFilename());
    }


    @ApiOperation("图片下载")
    @GetMapping("/images/{imageName}")
    public Response upload(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {

        response.reset();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(imageName, "UTF-8"));
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setContentType("application/octet-stream;charset=UTF-8");

        File file = new File(filePath, imageName);
        //2、 读取文件--输入流
        InputStream input = new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff = new byte[1024];
        int index = 0;
        //4、执行 写出操作
        while ((index = input.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return Response.success();
    }
}
