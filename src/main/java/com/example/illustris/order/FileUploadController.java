package com.example.illustris.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model; 

@RestController
@RequestMapping(path = "medical")
public class FileUploadController {
    
    @GetMapping("/imaging")
    public String uploadOneFileGet(Model model) {
       FileUpload fileUpload = new FileUpload();
        model.addAttribute("FileUpload", fileUpload);
        return "imaging";
    }

    @PostMapping(path="/oneFile")
    public String uploadOneFilePost(@RequestBody HttpServletRequest request,
    Model model, @ModelAttribute("FileUpload") FileUpload fileUpload){
        return this.doUpload(request, model, fileUpload);
    }


    @GetMapping("/multiFile")
    public String uploadMultiFileGet() {
       FileUpload fileUpload = new FileUpload();
        //model.addAttribute("FileUpload", fileUpload);
        return fileUpload.toString();
    }

    @PostMapping(path="/multiFile")
    public String uploadMultiFilePost(@RequestBody HttpServletRequest request,
    Model model, @ModelAttribute("FileUpload") FileUpload fileUpload){
        return this.doUpload(request, model, fileUpload);
    }

    /*https://o7planning.org/11679/spring-boot-file-upload#:~:text=Spring%20Boot%
    20File%20Upload%20Example%201%20Create%20Spring,...%204%20Thymeleaf%20Templates%205%20Run%20the%20application*/
    private String doUpload(HttpServletRequest request, Model model, 
    FileUpload fileUpload) {
 
      String description = fileUpload.getDescription();
      System.out.println("Description: " + description);
 
      // Root Directory.
      String uploadRootPath = request.getServletContext().getRealPath("upload");
      System.out.println("uploadRootPath=" + uploadRootPath);
 
      File uploadRootDir = new File(uploadRootPath);
      // Create directory if it not exists.
      if (!uploadRootDir.exists()) {
         uploadRootDir.mkdirs();
      }
      MultipartFile[] fileDatas = fileUpload.getFileDatas();
      //
      List<File> uploadedFiles = new ArrayList<File>();
      List<String> failedFiles = new ArrayList<String>();
 
      for (MultipartFile fileData : fileDatas) {
 
         // Client File Name
         String name = fileData.getOriginalFilename();
         System.out.println("Client File Name = " + name);
 
         if (name != null && name.length() > 0) {
            try {
               // Create the file at server
               File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
 
               BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
               stream.write(fileData.getBytes());
               stream.close();
               //
               uploadedFiles.add(serverFile);
               System.out.println("Write file: " + serverFile);
            } catch (Exception e) {
               System.out.println("Error Write file: " + name);
               failedFiles.add(name);
            }
         }
      }
      model.addAttribute("description", description);
      model.addAttribute("uploadedFiles", uploadedFiles);
      model.addAttribute("failedFiles", failedFiles);
      return "imaging";
   }
}
