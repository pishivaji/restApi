package restApi;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToGetRandomDataByGet 
{

	
	@Test
	public void ToGetRandomDataByGet()
	{
		
		String baseUrl = "https://reqres.in/";
		String listUsers = "api/users/"; // List of users
		double randomDouble = Math.random();
        System.out.println("Random Double: " + randomDouble);

        // To generate a random integer between 0 and 99
        int randomInt = (int) (Math.random() * 10);
        System.out.println("Random Integer: " + randomInt);
		
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) 
		{
			// Create a GET request
			HttpGet request = new HttpGet(baseUrl + listUsers +randomInt);
			request.addHeader("Accept", "application/fhir+json");

			// Execute the request
			HttpResponse response = httpClient.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			String responseBody = EntityUtils.toString(response.getEntity());

			// Print the status code and response body
			System.out.println("Status Code: " + statusCode);
			System.out.println("Response Body: " + responseBody);
			Assert.assertEquals(statusCode, 200);

			// Validate the response (simple checks)
			if (statusCode == 200) 
			{
				System.out.println("User resource retrieved successfully.");
			} else 
			{
				System.out.println("Failed to retrieve User resource.");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
