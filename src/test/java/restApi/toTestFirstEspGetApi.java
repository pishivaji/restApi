package restApi;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class toTestFirstEspGetApi 
{
  
	@Test
	public void getFirstESPApi()
	{
		 //String baseUrl = "http://your-smile-cdr-server-url/fhir/Patient/";
        //String patientId = "12345"; // Replace with a valid patient ID
          String baseUrl = "https://api.zippopotam.us/us/";
          String zipCode = "33162";
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Create a GET request
            //HttpGet request = new HttpGet(baseUrl + patientId);
        	HttpGet request = new HttpGet(baseUrl + zipCode);
           // request.addHeader("Accept", "application/fhir+json");
            request.addHeader("Accept", "application/json");

            // Execute the request
            CloseableHttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(response.getEntity());
            
            
            // Execute the request
          

            // Print the status code and response body
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);

            // Validate the response (simple checks)
            if (statusCode == 200) {
                System.out.println("Patient resource retrieved successfully.");
            } else {
                System.out.println("Failed to retrieve patient resource.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        
}
	}
}
