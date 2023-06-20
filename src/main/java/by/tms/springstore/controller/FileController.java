package by.tms.springstore.controller;

import by.tms.springstore.domain.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {
    @GetMapping("/test")
    public String file(Model model) {
        File folder = new File("static/css/");
        File[] files = folder.listFiles();
        List<FileInfo> fileInfos = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                FileInfo fileInfo = new FileInfo(file.getName(), file.getPath());
                fileInfos.add(fileInfo);
            }
        }
        model.addAttribute("files", fileInfos);
        System.out.println(fileInfos);
        return "file";
    }
}