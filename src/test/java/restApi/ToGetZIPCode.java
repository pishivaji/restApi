package restApi;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class ToGetZIPCode 
{
   @Test
   public void ToGetZIPCode()
   {
	   
       String baseUrl = "https://api.zippopotam.us/us/";
       String patientId = "33162"; // Replace with a valid patient ID
       try (CloseableHttpClient httpClient = HttpClients.createDefault()) 
       {
       // Create a GET request
       HttpGet request = new HttpGet(baseUrl + patientId);
       request.addHeader("Accept", "application/fhir+json");

       // Execute the request
       HttpResponse response = httpClient.execute(request);
       int statusCode = response.getStatusLine().getStatusCode();
       String responseBody = EntityUtils.toString(response.getEntity());

       // Print the status code and response body
       System.out.println("Status Code: " + statusCode);
       System.out.println("Response Body: " + responseBody);

       // Validate the response (simple checks)
       if (statusCode == 200) 
       {
           System.out.println("Patient resource retrieved successfully.");
       } 
       else 
       {
           System.out.println("Failed to retrieve patient resource.");
       }
       } 
       catch (Exception e) 
       {
       e.printStackTrace();
       }

   }
}
