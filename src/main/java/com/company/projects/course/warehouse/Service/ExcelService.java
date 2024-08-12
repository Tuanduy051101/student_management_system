package com.company.projects.course.warehouse.Service;

import com.company.projects.course.coursemanagementsystem.entity.Product;
import com.company.projects.course.coursemanagementsystem.repository.ProductRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ProductRepository productRepository;

    public void importProducts(MultipartFile file) throws IOException {
        List<Product> products = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            if (currentRow.getRowNum() == 0) {
                continue; // Skip header row
            }

            Product product = new Product();
            product.setName(currentRow.getCell(0).getStringCellValue());
            product.setDescription(currentRow.getCell(1).getStringCellValue());
            product.setPrice(currentRow.getCell(2).getNumericCellValue());
            product.setQuantity((int) currentRow.getCell(3).getNumericCellValue());
            products.add(product);
        }

        productRepository.saveAll(products);
        workbook.close();
    }
}
