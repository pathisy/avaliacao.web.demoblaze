package avaliacao.web.demoblaze;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import bases.DriverFactory;

public class Login_Logout {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {

		url = ("https://www.demoblaze.com/");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void login() throws InterruptedException {
		driver.get(url);
		Thread.sleep(1000);
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("pathisy");
		driver.findElement(By.id("loginpassword")).sendKeys("teste123");
		driver.findElement(By.xpath("//*[@onclick = 'logIn()']")).click();

	}
	
	@Test
	public void logout() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("login2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("loginusername")).sendKeys("pathisy");
		driver.findElement(By.id("loginpassword")).sendKeys("teste123");
		driver.findElement(By.xpath("//*[@onclick = 'logIn()']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@onclick = 'logOut()']")).click();
		
		
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));

		driver.quit();

	}

}
