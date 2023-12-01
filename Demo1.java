package Day1Dec2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	static WebDriver driver;
	
	
	
	// method to check the contact page text is visible or not 
	public static void checkText(By by , String text)
	{
		WebElement ele = driver.findElement(by);
		if (ele.getText().contains(text))
		{
			System.out.println("Text Matches!!");
		}
		else
		{
			System.out.println("Not Matched");
		}
	}

	
	
	
	// method to send keys to the leave message form
	
	public static void sendKeys(WebDriver driver , String xpath , String text)
	{
		try
		{
			WebElement ele1 = driver.findElement(By.xpath(xpath));
			ele1.clear();
			ele1.sendKeys(text);
		}
		catch(Exception e)
		{
			System.out.println("Error element not found"+e.getMessage());
		}
	}
	
	
	
	
	// method to click on btn
	public static void clickBtn(By by )
	{
		driver.findElement(by).click();
	}
	
	
	// method to check button is clickable or not
	
	public static void btnClickable(WebDriver driver,String xpath)
	{
		WebElement ele2 = driver.findElement(By.xpath(xpath));
		if(ele2.isEnabled())
		{
			System.out.println("Button is Working");
		}
		else
		{
			System.out.println("Button is not working");
		}
	}
	
	
	// method to check link is working or not
	public static void linkWorking(WebDriver driver , String xpath)
	{
		WebElement ele3 = driver.findElement(By.xpath(xpath));
		if(ele3.isEnabled())
		{
			System.out.println("Link is Working properly");
		}
		else
		{
			System.out.println("Link is NOT working");
		}
	}
	
	
	public static void main(String[] args) {
		
		 driver = new ChromeDriver();
		driver.get("https://techpub-connect-demo.netlify.app/html/contactus.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
		checkText(By.xpath("//div//h1"),"Contact Us");
		
		sendKeys(driver , "(//div//input[@type='text'])[1]","samiksha");
		sendKeys(driver , "(//div//input[@type='text'])[2]","1234567890");
		sendKeys(driver , "(//div//input[@type='text'])[3]","samiksha@gmail.com");
		sendKeys(driver , "(//div//input[@type='text'])[4]","IT");
		sendKeys(driver , "//div//textarea[@id='commnent']","Hello I am samiksha!!");
		
		
		//clickBtn(By.xpath("(//div//button)[1]"));
		btnClickable(driver,"(//div//button)[1]");
		btnClickable(driver,"(//div//button)[2]");
		
		linkWorking(driver,"(//div//ul//li//a)[1]");
		
		
		// checks the the location,mobile no , email  is correct or not
		checkText(By.xpath("(//div//p[@class='mt-20 fs-25'])[1]"),"3517 W. Gray St. Utica, Pennsylvania 57867");
		checkText(By.xpath("(//div//p[@class='mt-20 fs-25'])[2]"),"(406) 555-0120");
		checkText(By.xpath("(//div//p[@class='mt-20 fs-25'])[3]"),"tranthuy.nute@gmail.com");
		//checkText(By.xpath("(//div//p[@class='mt-20 fs-25'])[1]","3517 W. Gray St. Utica, Pennsylvania 57867"));
		driver.quit();
		
	}

}
