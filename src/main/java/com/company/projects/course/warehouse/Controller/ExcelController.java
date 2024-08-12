package com.company.projects.course.warehouse.Controller;

import com.company.projects.course.coursemanagementsystem.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/import")
    public String importProducts(@RequestParam("file") MultipartFile file) {
        try {
            excelService.importProducts(file);
            return "File imported successfully!";
        } catch (Exception e) {
            return "Failed to import file: " + e.getMessage();
        }
    }
}
