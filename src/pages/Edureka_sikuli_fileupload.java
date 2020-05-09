package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Edureka_sikuli_fileupload {

	@Test
	public void TC_Edureka_sikuli_fileupload() throws InterruptedException, FindFailed {

		WebDriver driver;
		String currDir=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.edureka.co");
		driver.manage().window().maximize();
		WebElement btn_Login =driver.findElement(By.xpath("//a[text()='Log In']"));
		btn_Login.click();
		driver.findElement(By.id("si_popup_email")).sendKeys("aarthy.587@gmail.com");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("New@2020");
		WebElement btn_submit = driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']"));
		btn_submit.click();
		Thread.sleep(2000);
		

  Actions actions = new Actions(driver);
  actions.moveToElement(driver.findElement(By.xpath("//div[@class='pull-right url_list']/ul/li[8]")));
  actions.click().build().perform();
	Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='My Profile']")).click();
		Thread.sleep(4000);
		String actualpagetitle = driver.getTitle();
		String expectedpagetitle="My Profile | Edureka";
		if(actualpagetitle.contains(expectedpagetitle)) {
			System.out.println("Page Title is displayed:" +actualpagetitle);
		}
		else
			System.out.println("Page Title is not displayed as expected");
		driver.findElement(By.xpath("//a[@id='personal_details']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon-camera']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='file-upload']")).click();
		Thread.sleep(2000);
		Pattern fileNameInput = new Pattern("E:\\Capture.PNG");
        Pattern openButton = new Pattern("E:\\OpenBtn.PNG");
		
        Screen screen = new Screen();
        screen.type(fileNameInput,"E:\\pinky.JPG");
        screen.click(openButton);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='submitbtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
 
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='pull-right url_list']/ul/li[8]")));
        actions.click().build().perform();
      	Thread.sleep(2000);

      		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
      		System.out.println("TC Pass");
      		driver.quit();
	}

}
