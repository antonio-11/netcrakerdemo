package com.netcrker.challenge.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Entity.Agreement;

@Service
public class StoreService {
	
	public String processStore(Agreement agreement) {
		String json = null;
		String path = null;
		String extension = ".txt";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(agreement);
			//json = mapper.writeValueAsString(agreement);
			path = agreement.getName()+extension;
			saveFile(path, json);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
				
		return path;
	}
	
	private boolean saveFile(String fileName, String content) {
		File file = new File(fileName);		
		
		try(FileOutputStream fop = new FileOutputStream(file)){
			
			if (!file.exists())
				file.createNewFile();
									
			byte[] contentInBytes = content.getBytes();
			
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			
		}catch(IOException  e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String getAllProductsStored(String path) {
		
		return readFile(path);	
	}
	
	private String readFile(String fileName) {
		File file = new File(fileName);		
		String response = "";
		try(FileInputStream fis = new FileInputStream(file)){
			
			if (!file.exists())
				return null;									
			int content;
			while( (content = fis.read())!= -1 ) {
				response = response+(char) content;				
			}			
		}catch(IOException  e) {
			e.printStackTrace();
			return "Data not Found";
		}
		
		return response;
	}

}
