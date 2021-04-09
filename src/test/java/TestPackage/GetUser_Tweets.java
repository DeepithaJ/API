package TestPackage;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUser_Tweets {
	public Properties prop;
	@Test	
	public void QualitestTweet() throws IOException
	{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Qualitest\\eclipse-workspace\\TwitterAPIProject\\src\\main\\java\\Resources\\data.properties");
	prop.load(fis);
	RestAssured.baseURI="https://api.twitter.com/1.1/search/";
	Response res= given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerKeySecret"),prop.getProperty("AccessToken"),prop.getProperty("AccessSecretToken")).
	queryParam("q","#Qualitest").
	when().get("tweets.json").then().extract().response();
	
	String response=res.asString();
	System.out.println(response);
	JsonPath js=new JsonPath(response);
	ArrayList<Object> arr=new ArrayList<Object>();
	ArrayList<Object> arr1=new ArrayList<Object>();
	arr.addAll(js.getList("statuses.text"));
	arr1.addAll(js.getList("statuses.user.name"));

	 

	Iterator itr=arr.iterator();
	Iterator itr1=arr1.iterator();

	 

	while(itr.hasNext())
	{
	System.out.println("Tweet:"+itr.next()+" UserName"+itr1.next());
	}
	
	}

}
