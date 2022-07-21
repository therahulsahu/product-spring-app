package com.product.client;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.sun.net.httpserver.Authenticator;

@FeignClient(name = "report-generation-client", url = "http://localhost:8082/api/report/v1")
public interface ReportGenerationClient {

    @GetMapping("/pdf")
    ResponseEntity<Resource> downloadPdf();

    @GetMapping("/excel")
    HttpServletResponse exportToExcelAndDownload();

    @GetMapping("/csv")
    ResponseEntity<Authenticator.Success> exportToCSV();



}
