package Base;
import com.aventstack.extentreports.model.Log;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import Base.Constants;
import requestPOJO.GetRepository;
import requestPOJO.PostRepository;
import requestPOJO.PutRepository;
import requestPOJO.DeleteRepository;
import org.apache.http.HttpStatus;

import org.testng.Assert;

public class API_Helper {
	
	 RequestSpecification reqSpec;
	 String token = "";
	 String baseURI = "";
	 private static final Logger log = LogManager.getLogger(API_Helper.class);
		
	 public API_Helper() {
		 baseURI = Constants.baseURI;
		 token = Constants.token;
		 reqSpec = RestAssured.given().baseUri(baseURI).header("Authorization", "Bearer "+token)
		 .header("Content-Type", "application/json");
		 
	 }
	 
	 public Response getData(String owner, String repo) {
		 Response response = null;
		 try {
			 	log.info("Getting repository "+repo+ "from the owner "+owner);
	            response = reqSpec.get("/repos/"+owner+"/"+repo);
	            response.then().log().headers();
	            String responseBody = response.getBody().asString();
	            String repositoryName = JsonPath.from(responseBody).getString("name");
	            String repositoryOwner = JsonPath.from(responseBody).getString("owner.login");
	            System.out.println(repositoryName+" is the name and the owner is: "+repositoryOwner);
	        } catch (Exception e) {
	            Assert.fail("Get data is failing due to: " + e.getMessage());
	        }
		 return response;
	 }
	 
	 public Response getAllData(String user) {
		 Response response = null;
		 try {
			 log.info("Getting all repositories from "+user);
			 response = reqSpec.get("/users/"+user+"/repos");
			 response.then().log().headers();
			 String body = response.getBody().asString();
			 List<Object> repos = JsonPath.from(body).getList("");
			 int size = repos.size();
			 String owner = JsonPath.from(body).getString("[0].owner.login");
			 System.out.println("The number of repositories returned is: "+size);
			 System.out.println("The owner of these repositories is: "+owner);
		 }catch(Exception e) {
			 Assert.fail("Get all data is failing due to: "+e.getMessage());
		 }
		 return response;
	 }
	 
	 public Response postData(String name, String description, String homepage, boolean isPrivate) {
		 Response response = null;
		 try {
			 PostRepository pr = PostRepository.builder()
					 .name(name)
					 .description(description)
					 .homepage(homepage)
					 .isPrivate(isPrivate)
					 .build();
			 log.info("Adding below data: " + new ObjectMapper().writeValueAsString(pr));
			 reqSpec.body(pr);
			 response = reqSpec.post("/user/repos");
			 response.then().log().headers();
		 } catch(Exception e) {
			 Assert.fail("Post data is failing due to: "+e.getMessage());
		 }
		 return response;
	 }
	 
	 public Response putData(String owner, String repo, String newrepo,  String description, boolean isPrivate) {
		 Response response = null;
		 try {
			 PutRepository pr = PutRepository.builder()
					 .name(newrepo)
					 .description(description)
					 .isPrivate(isPrivate)
					 .build();
			 reqSpec.body(pr);
			 log.info("Updating repository's owner: "+owner+", repo: "+repo+", and description: "+description);
			 response = reqSpec.patch("/repos/"+owner+"/"+repo);
			 response.then().log().headers();
		 } catch(Exception e) {
			 Assert.fail("Put data is failing due to: "+e.getMessage());
		 }
		 return response;
	 }
	 
	 public Response deleteData(String owner, String repo) {
		 Response response = null;
		 try {
			 log.info("Deleting repository "+repo+" by "+owner);
			 response = reqSpec.delete("/repos/"+owner+"/"+repo);
			 response.then().log().headers();
			 if (response.statusCode() == 204) {
		            log.info("Repository deleted successfully: " + repo);
		        } else {
		            log.error("Failed to delete repository: " + repo);
		        }
		 } catch(Exception e) {
			 Assert.fail("Delete data is failing due to: "+e.getMessage());
		 }
		 return response;
	 }
}
