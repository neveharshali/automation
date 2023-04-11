package AutomationConcept;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ColourPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
		driver.manage().window().maximize();
		
		 // identify text
	      WebElement t = driver.findElement(By.xpath("//a[@class='btn btn-grey-border mb-0']"));
	      //obtain color in rgba
	      String s = t.getCssValue("color");
	      // convert rgba to hex
	      String c = Color.fromString(s).asHex();
	      System.out.println("Color is :" + s);
	      System.out.println("Hex code for color:" + c);
	      driver.quit();
	      Alert a=driver.switchTo().alert();

	}



	}


