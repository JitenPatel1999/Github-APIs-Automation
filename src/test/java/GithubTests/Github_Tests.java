package GithubTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.API_Helper;
import io.restassured.response.Response;

public class Github_Tests {
	@Test
	public void TestCase1() {
		API_Helper helper = new API_Helper();
		String repo = "Quiz_Game";
		String user = "JitenPatel1999";
		Response response = helper.getData(user, repo);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200, "Status validation failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String fullname = response.jsonPath().getString("full_name");
		Assert.assertEquals(fullname, "JitenPatel1999/Quiz_Game", "Full name validation failed!");
		System.out.println("Full name validation passed! The full name is: "+fullname);
		String contentType = response.getHeader("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8", "Content type validation failed!");
		System.out.println("Content type validation passed! The content type is: "+contentType);
		String branch = response.jsonPath().getString("default_branch");
		Assert.assertEquals(branch, "main", "Branch validation failed!");
		System.out.println("Branch validation passed! The branch is: "+branch);
	}
	
	@Test
	public void TestCase2() {
		API_Helper helper = new API_Helper();
		String repo = "Dummy_Test";
		String owner = "JitenPatel1999";
		Response response = helper.getData(owner, repo);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 404, "Status validations failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String message = response.jsonPath().getString("message");
		Assert.assertEquals(message, "Not Found", "Message validation failed!");
		System.out.println("Message validation passed! The message is: "+message);
	}
	
	@Test
	public void TestCase3() {
		API_Helper helper= new API_Helper();
		String user = "JitenPatel1999";
		Response response = helper.getAllData(user);
		int status = response.getStatusCode();
		System.out.println(status);
		String contentType = response.getHeader("Content-Type");
		System.out.println(contentType);
	}
	
	@Test
	public void TestCase4() {
		API_Helper helper = new API_Helper();
		String repo = "Hello-World";
		String description = "This is your first repo!";
		String homepage = "https://github.com";
		boolean isPrivate = false;
		Response response = helper.postData(repo, description, homepage, isPrivate);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 201, "Status validation failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String name = response.jsonPath().getString("name");
		Assert.assertEquals(name, repo, "Name validation failed!");
		System.out.println("Name validation passed! The name is: "+name);
		String login = response.jsonPath().getString("owner.login");
		Assert.assertEquals(login, "JitenPatel1999", "Login validation failed!");
		System.out.println("Login validation passed! The login is: "+login);
		String type = response.jsonPath().getString("type");
		Assert.assertEquals(type, "User", "Type validation failed!");
		System.out.println("Type validation passed! The type is: "+type);
	}
	
	
	@Test
	public void TestCase5() {
		API_Helper helper = new API_Helper();
		String repo = "Hello-World";
		String description = "This is your first repo!";
		String homepage = "https://github.com";
		boolean isPrivate = false;
		Response response = helper.postData(repo, description, homepage, isPrivate);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 422, "Status validation failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String message = response.jsonPath().getString("message");
		Assert.assertEquals(message, "name already exists on this account", "Message validation failed!");
		System.out.println("Message validation passed! The message is: "+message);
	}
	
	@Test
	public void TestCase6() {
		API_Helper helper = new API_Helper();
		String user = "JitenPatel1999";
		String repo = "Hello-World";
		String newrepo = "HelloWorld";
		String description = "my repository created using apis after update";
		boolean isPrivate = false;
		Response response = helper.putData(user, repo, newrepo, description, isPrivate);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200, "Status validation failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String name = response.jsonPath().getString("name");
		Assert.assertEquals(name, repo, "Name validation failed!");
		System.out.println("Name validation passed! The name is: "+name);
	}
	
	
	@Test
	public void TestCase7() {
		API_Helper helper = new API_Helper();
		String user = "JitenPatel1999";
		String repo = "HelloWorld";
		Response response = helper.deleteData(user, repo);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 204, "Status validation failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String body = response.jsonPath().getString("body");
		Assert.assertEquals(body, null, "Body validation failed!");
		System.out.println("Body validation passed! The body is: "+body);
	}
	@Test
	public void TestCase8() {
		API_Helper helper = new API_Helper();
		String user = "JitenPatel1999";
		String repo = "HelloWorld";
		Response response = helper.deleteData(user, repo);
		int status = response.getStatusCode();
		Assert.assertEquals(status, 404, "Status validation failed!");
		System.out.println("Status validation passed! The status is: "+status);
		String message = response.jsonPath().getString("message");
		Assert.assertEquals(message, "Not Found", "Message validation failed!");
		System.out.println("Message validation passed! The message is: "+message);
	}
}

