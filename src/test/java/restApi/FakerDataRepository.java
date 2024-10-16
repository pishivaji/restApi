package restApi;

import com.github.javafaker.Faker;

import restApi.FakerDataRepository;

public class FakerDataRepository 
{
	Faker faker = new Faker();
	// Generate fake name
    public String namef = faker.name().fullName();
    //System.out.println("Name: " + namef);

    // Generate fake email
    String emailf = faker.internet().emailAddress();
    //System.out.println("Email: " + emailf);

    // Generate fake job title
    String jobf = faker.job().title();
    //System.out.println("Job: " + jobf);

    // Generate fake mobile number
    String mobileNumberf = faker.phoneNumber().cellPhone();
    //System.out.println("Mobile Number: " + mobileNumberf);
    
    String fnamef = faker.name().firstName();
    String lnamef= faker.name().lastName();


	public static void main(String[] args) 
	{
		FakerDataRepository fdr = new FakerDataRepository();
		
		String one = fdr.namef;
		System.out.println(one);
	}

}
