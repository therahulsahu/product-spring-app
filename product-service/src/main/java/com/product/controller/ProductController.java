package com.product.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.product.client.EmailNotificationClient;
import com.product.client.ReportGenerationClient;
import com.product.config.ProductExcelExporter;
import com.product.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/productlist/v1")
@Slf4j
public class ProductController {

	private static final String UPLOADED_FOLDER = "/Users/rahul.b.sahu/dev/demo-project/product-service/uploads";
	@Autowired
	ProductService productService;

	@Autowired
	ReportGenerationClient reportGenerationClient;

	@Autowired
	EmailNotificationClient emailNotificationClient;

	@GetMapping("/getlist")
	public List<Product> getlist() {
		log.info("Get list called");
		return productService.getProductList();
	}

	@PostMapping("/createproduct")
	public Map<String, String> createProduct(@RequestBody List<Product> productRequest) {
		log.info(">>>>>productRequest--->>>>" + productRequest);
		HashMap<String, String> map = new HashMap<>();
		boolean res = productService.createProducts(productRequest);
		if(res) {
			map.put("response", "Successfully product created");
			EmailDetails emailDetails = new EmailDetails();
			emailDetails.setRecipient("therahulsahu7@gmail.com");
			emailDetails.setSubject("Product Spring App - New Product Created");
			emailDetails.setMsgBody("A new product - " + productRequest.get(0).getProductName() + " has been created.");
			Smsrequest sms = new Smsrequest("+917000571622", "Hello, A new Product has been created");
			try{
				emailNotificationClient.sendMail(emailDetails);
				log.info("email sent");
				emailNotificationClient.sendMessage(sms);
				log.info("message sent");
			} catch (Exception e) {
				log.error(e.getMessage());
				log.error("Email Notification service might be down !");
			}
		} else {
			map.put("response", "Products not created");
		}
		return map;
	}
	
	@PostMapping("/deleteproduct")
	public ProductResponse deleteproduct(@RequestBody List<Product> productRequest) {
		log.info("Start 2>>>>>In newlistController::deleteproduct()>>>>>>>>>>>>");
		log.info("Before Size of product List" + productService.getProductsCount());
		ProductResponse response = new ProductResponse();
		
		boolean res = productService.deleteProducts(productRequest);
		
		if(res) {
			response.setStatusCode("200");
			response.setStatusMessage("Successfully Deleted");
		} else {
			response.setStatusCode("401");
			response.setStatusMessage("Not Deleted");
		}
		return response;
	}


	@GetMapping("/download/excel")
	public void exportToExcelAndDownload(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=products_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Product> listProducts = productService.getProductList();

		ProductExcelExporter excelExporter = new ProductExcelExporter(listProducts);
		log.info("excel file generated");
		excelExporter.export(response);

	}

	@PostMapping("/updateProduct")
	public ProductResponse updateProduct(@RequestBody Product product) {
		boolean res = productService.updateProduct(product);
		ProductResponse response = new ProductResponse();
		if(res) {
			response.setStatusCode("200");
			response.setStatusMessage("Successfully Updated");
		} else {
			response.setStatusCode("401");
			response.setStatusMessage("Not Updated");
		}
		return response;
	}

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			log.error("no file selected");
			return "no file selected";
		}
		try {
			Path path = Paths.get(UPLOADED_FOLDER);
			if (!Files.exists(path)) {
				Files.createDirectories(path);
			}
			Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("uploaded successfully");
		return "uploaded successfully";
	}
	
	@PostMapping("/login")
	public UserBean login(@RequestBody UserBean userBean) {
		log.info("Start 2 In HelloWorldController::login()>>>>>>>>>>>>");
		
		if ((userBean.getUserName().equals("abc") && userBean.getUserPassword().equals("abc"))) {
			log.info("User is login succesful ");
			userBean.setErrorCode("200");
			// navigate to welcome screen where it shows product page with links or tabs
			return userBean;
		} else {
			log.error("User is login faild due to invalid credientials ");
			userBean.setErrorCode("400");
			// show same login page
			return userBean;
		}
	}

	@GetMapping("/download/pdf")
	public ResponseEntity<Resource> downloadPdf(HttpServletResponse res) {
		return reportGenerationClient.downloadPdf();
	}

//	@GetMapping("/download/excel")
//	public void downloadExcel(HttpServletResponse res) {
//		reportGenerationClient.exportToExcelAndDownload();
//	}

	@GetMapping("/download/csv")
	public void downloadCsv(HttpServletResponse res) {
		reportGenerationClient.exportToCSV();
	}

	// single product
//	@PostMapping("/pro/{id}")
//	public product getlist(@pathVariable("id")int id) {
//		return productList.getListById(id);
//	}
//	
//	
//	@PostMapping("/pro/{proid}")
//	public List deleteproduct(@pathvariable("proid") int proId)
//	{
//		this.productList.deleteproduct(proId);
//	}

}
