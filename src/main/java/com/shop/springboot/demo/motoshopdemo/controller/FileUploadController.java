package com.shop.springboot.demo.motoshopdemo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.springboot.demo.motoshopdemo.entity.Product;
import com.shop.springboot.demo.motoshopdemo.repository.ProductRepository;
import com.shop.springboot.demo.motoshopdemo.service.ProductService;

@Controller
@RequestMapping("/add/update")
public class FileUploadController {
	
	private ProductService productService;

	private ProductRepository productRepository;
	
	private HttpServletRequest request;
	
	@Autowired
	public FileUploadController(ProductService theProductService, ProductRepository productRepository, HttpServletRequest request) {
		this.productService = theProductService;
		this.productRepository = productRepository;
		this.request = request;
	}
	
	@GetMapping("/upload/{id}")
	public String getProductContent(@PathVariable int id, Model theModel) {
		
		Product product = productService.getProductById(id);
		
		theModel.addAttribute("productById", product);
		
		return "upload-image";
		
	}
	
	@PostMapping("/upload/data/{id}")
	public String updateData(@PathVariable int id, @ModelAttribute Product product) {
		
		productService.saveUpdateProduct(product);
		
		return "redirect:/product";
		
	}
	
	@PostMapping("/upload/{id}")
	public String saveImage(@PathVariable int id, @RequestParam("file") MultipartFile file, 
			 @ModelAttribute Product product) {
		
		if (product != null || product == null) {
			if (!file.isEmpty()) {
				try {
					
					String uploadDir = "/image/";
					String pathToUploads = request.getServletContext().getRealPath(uploadDir);
					if (! new File(pathToUploads).exists()) {
						new File(pathToUploads).mkdir();
					}					
					String originalName = file.getOriginalFilename();
					String filePath = pathToUploads + originalName;
					File destination = new File(filePath);
					file.transferTo(destination);
					
					product.setProductImg(originalName);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			productRepository.save(product);
			
		}
		
		return "redirect:/product";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") int id) {
		
		productService.deleteProduct(id);
		
		return "redirect:/product";
		
	}
	
}
