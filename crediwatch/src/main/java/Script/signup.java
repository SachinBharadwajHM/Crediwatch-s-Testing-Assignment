package Script;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


public class signup {
	
	String dir = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sachin\\Downloads\\Desktop\\New folder (4)\\crediwatch\\src\\browser\\drivers\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://moneycontrol.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='sitepull_btndesk']"));
		driver.findElement(By.xpath("//*[@class='toplinks1 blp dropdown']//a[@title='Sign Up']")).click();
		
		driver.switchTo().frame("myframe");
	
		driver.findElement(By.xpath("//a[@id='ACCT_SIGNUP_BTN']")).click();
		
		
		driver.findElement(By.id("first_name")).sendKeys("firstname");
		driver.findElement(By.id("last_name")).sendKeys("lastname");
		driver.findElement(By.id("email")).sendKeys("sachin.bharadwaj@mailinator.com");
		driver.findElement(By.id("pwd")).sendKeys("1qaz!QAZ1qaz");
		
		driver.findElement(By.id("ACT_SIGNUP_SUBMIT")).click();
		
		WebElement errormsg = driver.findElement(By.id("error_reg_email"));
		String message = errormsg.getText();
		if(message == "Email already exists, Please try another one" ) {
			System.out.println("Email ID already registered");
			driver.quit();
		}
		
		WebElement registermessage = driver.findElement(By.xpath("//*[@id='emailverimailmsg']"));
		System.out.println(registermessage.getText());
			
			
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		driver.navigate().to("https://mailinator.com");
				    
	    WebElement searchbox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
	    searchbox.sendKeys("sachin.bharadwaj@mailinator.com");
	    searchbox.sendKeys(Keys.ENTER);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.findElement(By.xpath("//td[contains(text(),'Action Required: Verify Your Moneycontrol Account')]")).click();
	    
	    driver.switchTo().frame("msg_body");
	    
	    driver.findElement(By.xpath("//*[contains(text(),'Please click the below given link to verify your account:')]/following-sibling::a")).click();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
		
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    
	    driver.switchTo().window(tabs.get(1));
		
	    System.out.println("Email account verification successful");
	    
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.navigate().to(driver.getCurrentUrl());
	    
	    //driver.navigate().refresh();
	    driver.findElement(By.xpath("//*[@class='toplinks1 blp dropdown']//a[@title='Log In']")).click();
	    
	    driver.switchTo().frame("myframe");
	    
	    driver.findElement(By.xpath("//*[@id='login_form']//div[1]/input")).sendKeys("sachin.bharadwaj@mailinator.com");
		driver.findElement(By.xpath("//*[@id='login_form']/div[3]/input")).sendKeys("1qaz!QAZ1qaz");
		
		driver.findElement(By.id("ACCT_LOGIN_SUBMIT")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
	    
		WebElement companysearchbox = driver.findElement(By.id("search_str"));
		companysearchbox.sendKeys("Infosys");
		companysearchbox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("((//table)[2]/tbody/tr/td/p/a)[1]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement BSEValue = driver.findElement(By.xpath("//*[@id='Bse_Prc_tick']"));
		
		System.out.println(BSEValue.getText());
		
		WebElement NSEValue = driver.findElement(By.xpath("//*[@id='Nse_Prc_tick']"));
		
		System.out.println(NSEValue.getText());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//*[@id='floating-box']/div/dl/dt[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@class='FL month']/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement newsresultspage1 = driver.findElement(By.xpath("(//*[@class='FL'])[7]/div"));
		System.out.println(newsresultspage1.getSize());
		
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//*[@class='pages MR10 MT15']/span/following-sibling::a"));
		
		WebElement newsresultspage2 = driver.findElement(By.xpath("(//*[@class='FL'])[7]/div"));
		System.out.println(newsresultspage2.getSize());
		
		driver.close();
		
	}

}





