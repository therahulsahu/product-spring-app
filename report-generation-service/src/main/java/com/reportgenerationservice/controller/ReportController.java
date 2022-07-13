package com.reportgenerationservice.controller;

import com.product.model.Product;
import com.reportgenerationservice.excelConfig.ProductExcelExporter;
import com.reportgenerationservice.service.ReportService;
import com.reportgenerationservice.repository.ProductRepository;
import com.sun.net.httpserver.Authenticator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/report/v1")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/generateReport/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }

    @GetMapping("/pdf")
    public ResponseEntity<Resource> downloadPdf(HttpServletResponse res) throws IOException, JRException {

        reportService.exportReport("pdf");

        Resource resource;
        File file;
        try {
            file = new File("products.pdf");
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file.toPath()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }

    @GetMapping("/excel")
    public HttpServletResponse exportToExcelAndDownload(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Product> listProducts = productRepository.findAll();

        ProductExcelExporter excelExporter = new ProductExcelExporter(listProducts);

        excelExporter.export(response);

        return response;
    }

    @GetMapping("/csv")
    public ResponseEntity<?> exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Product> listProducts = productRepository.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = { "Product Id", "Product Name", "Product Price", "Product Quantity", "Product Description",
                "Product Type" };
        String[] nameMapping = { "productId", "productName", "productPrice", "productDesc", "productQuantity",
                "productType" };

        csvWriter.writeHeader(csvHeader);

        for (Product products : listProducts) {
            csvWriter.write(products, nameMapping);
        }
        csvWriter.close();

        return new ResponseEntity<Authenticator.Success>(HttpStatus.OK);
    }

}
