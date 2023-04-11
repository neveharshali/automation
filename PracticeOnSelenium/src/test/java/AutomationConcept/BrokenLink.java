package AutomationConcept;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws Exception {
		//Browser Open
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		
		
	//
		List<WebElement> AllLinks=driver.findElements(By.tagName("a"));
		
		System.out.println(AllLinks.size());
		
		for(int i=0;i<AllLinks.size();i++) {
			
			verifylink(AllLinks.get(i).getAttribute("href"));
		}
		
		
		
	}

	public static void verifylink(String url) throws Exception {
		
		URL link=new URL(url);
		
		HttpURLConnection connection=(HttpURLConnection) link.openConnection();
		connection.connect();
		
		if(connection.getResponseCode()==200) {
			System.out.println(url+"=="+connection.getResponseMessage());
		}
		
		if(connection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(url+"=="+connection.getResponseMessage());
		}
	}

}
