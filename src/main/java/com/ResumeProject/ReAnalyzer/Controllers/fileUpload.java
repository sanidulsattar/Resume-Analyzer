package com.ResumeProject.ReAnalyzer.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class fileUpload {
    @PostMapping("/upload")
    public String handleUpload(@RequestParam("file") MultipartFile file){

        if(file.isEmpty()){
            return "Error: File is empty";
        }
        String contentType = file.getContentType();
        if(!"application/pdf".equals(contentType) && !"application/vnd.openxmlformats-officedocument.wordprocessingml.document".equals(contentType)){
            return "Error : Only Pdf and doc (txt) files are allowed";
        }

      //  return "Success: " + file.getOriginalFilename() + " is size of " + file.getSize()+ " bytes is uploaded";


        try{
            Path uploadDir = Paths.get("uploads");
            if(!Files.exists(uploadDir))
            {
                Files.createDirectories(uploadDir);
            }

            Path filePath = uploadDir.resolve(file.getOriginalFilename());
            file.transferTo(filePath);
            System.out.println("Absolute path: " + uploadDir.toAbsolutePath());
            return "saved to :" + filePath.toString();
        } catch (Exception e){
            return "Error : " + e.getMessage();
        }

    }
}
