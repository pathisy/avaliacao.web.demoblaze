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

public class Carrinho {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {

		url = ("https://www.demoblaze.com/");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void carrinho() throws InterruptedException {
		driver.get(url);
		Thread.sleep(1000);
		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("pathisy");
		driver.findElement(By.id("loginpassword")).sendKeys("teste123");
		driver.findElement(By.xpath("//*[@onclick = 'logIn()']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Samsung galaxy s6" + "")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@onclick = 'addToCart(1)']")).click();
		driver.findElement(By.xpath("//div[@id='navbarExample']/ul/li/a")).click();
		driver.findElement(By.linkText("Nokia lumia 1520")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@onclick = 'addToCart(2)']")).click();
		driver.findElement(By.id("Cart")).click();

	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));

		driver.quit();

	}
}
