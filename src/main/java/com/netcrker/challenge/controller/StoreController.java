package com.netcrker.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcrker.challenge.service.StoreService;

import Entity.Agreement;

@CrossOrigin
@RestController
@RequestMapping(value="/v1")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping(value="/status")
	public String checkStatus() {
		return "ok";
	}
	
	@GetMapping(value="/products/{path}")
	public ResponseEntity<?>  getFile(@PathVariable String path) {
		
		String response = storeService.getAllProductsStored(path);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value="/store" , consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  storeFiles(@RequestBody Agreement agreement) {	
		String response = "Error";
		if (agreement.isValid()) {
			response = storeService.processStore(agreement);
		}
		response = "{\"path\":\""+response+"\"}";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
