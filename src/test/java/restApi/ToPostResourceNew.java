package restApi;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import restApi.FakerDataRepository;
import io.restassured.path.json.JsonPath;

public class ToPostResourceNew 
{

	
	@Test
	public void ToPostResourceNew()
	{
		//System.out.println("Testing first Post Method");
		FakerDataRepository fdr = new FakerDataRepository();
    	String payName = fdr.fnamef;
    	String payJob = fdr.lnamef;
    	
    	//String payLoad = "{\r\n" + "    \"name\": \"namef\",\r\n" + "    \"job\": \"jobf\"\r\n" + "}";
    	
    	//{ "name": "morpheus", "job": "leader"} - payload required for post request
    	String payLoad = "{\"name\": \r\n" + "\""+ payName + "\"" + ", \"job\": \r\n" + "\"" + payJob + "\"" + "}";
    	System.out.println(payLoad);
    	//https://reqres.in/api/users
    	
    	String baseUrl = "https://reqres.in/";
		String Users = "api/users";
    	
    	try (CloseableHttpClient client = HttpClients.createDefault())
    	{
    		HttpPost request = new HttpPost(baseUrl + Users);
    		request.addHeader("Accept", "application/fhir+json");
    		request.setEntity(new StringEntity(payLoad));
    		CloseableHttpResponse response = client.execute(request);
    		
    		int statusCode = response.getStatusLine().getStatusCode();
    		System.out.println("Status code is: " + statusCode);
    		Assert.assertEquals(201, statusCode);
    		
    		String responseString = EntityUtils.toString(response.getEntity());
    		System.out.println(responseString);
    		
    		
    		JsonPath xpath = new JsonPath(responseString);
    		int id = xpath.getInt("id");
    		System.out.println("ID Returned is : " + id);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}	
	}
}
