package TestPackage;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;


public class Block {
	//public Properties prop;
	String ConsumerKey="WNUqaC2Ti0inkaValaGpNguc7";
	String ConsumerKeySecret="Od6k21cNtidTNoBwaYwH8dI926msHdo4DE440VI3eyUcdABu9s";
	String AccessToken="1376441413534019585-IKB0vYSIObbNUy4IYLxbk9vb5qpmGZ";
    String AccessSecretToken="Ik4KRsFU3Oo1Ifl0WQ4gWfOUNt51WPd5AhompvkErp5Pu";
	
	@Test	
	public void blockingUser() throws IOException
	{
		
	
		
			RestAssured.baseURI="https://api.twitter.com/1.1/blocks/";
			Response res=given().auth().oauth(ConsumerKey, ConsumerKeySecret, AccessToken, AccessSecretToken).
			queryParam("screen_name","Lavanya74290975").
			when().post("/create.json").then().extract().response();
			
			
			String response=res.asString();
			System.out.println(response);
			//JsonPath js=new JsonPath(response);
//			String id= js.get("id").toString();
//			System.out.println(id);
//			String text= js.get("text").toString();
//			System.out.println(text);

}
}
