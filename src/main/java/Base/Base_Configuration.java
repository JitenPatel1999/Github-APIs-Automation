package Base;

import io.restassured.RestAssured;
import java.io.*;
import java.util.*;

public class Base_Configuration {
	public static Properties properties = new Properties();
	static {
        try {
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void setBaseUri() {
		String BaseUri = properties.getProperty("baseUri");
		RestAssured.baseURI = BaseUri;
	}
	
	public static void setAuthToken() {
		String token = properties.getProperty("token");
		RestAssured.authentication = RestAssured.oauth2(token);
	}
}
