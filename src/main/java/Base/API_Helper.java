package Base;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpStatus;
import org.testng.Assert;

import requestPOJO.GetRepository;
import requestPOJO.PutRepository;
import requestPOJO.PostRepository;
import requestPOJO.DeleteRepository;

@Slf4j
public class API_Helper {
	
	 RequestSpecification reqSpec;
	 String token = "";
	 String baseURI = "";
	 
	 public static Properties properties = new Properties();
		static {
	        try {
	            FileInputStream input = new FileInputStream("config.properties");
	            properties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	 public API_Helper() {
		 this.token = properties.getProperty("token");
		 this.baseURI = properties.getProperty("baseUri");
		 reqSpec.baseUri(baseURI);
		 reqSpec = RestAssured.given().header("Authorization", "Bearer "+token)
		 .header("Content-Type", "application/json");
		 
	 }
	 
	 public Response getData() {
		 Response response = null;
		 return response;
	 }
	 
	 public Response postData() {
		 Response response = null;
		 return response;
	 }
	 
	 public Response putData() {
		 Response response = null;
		 return response;
	 }
	 
	 public Response deleteData() {
		 Response response = null;
		 return response;
	 }
}
