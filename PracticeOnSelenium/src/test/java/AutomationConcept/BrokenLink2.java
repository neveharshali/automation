package AutomationConcept;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink2 {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are"+ links.size());
		for(int i=0;i<links.size();i++)
		{
			WebElement ele=links.get(i);
			String url=ele.getAttribute("href");
			verifyLinkActive(url);
		}
	}
	
	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url=new URL(linkUrl);
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()==200) 
			{
				System.out.println(linkUrl+"_"+httpURLConnect.getResponseMessage());
			}
			if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) 
			{
				System.out.println(linkUrl+"-"+httpURLConnect.getResponseMessage()+"_"+HttpURLConnection.HTTP_NOT_FOUND);
			  }
		}
		catch(Exception e) {
				System.out.println(e);
			}

	}
}
