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

public class Contato {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {

		url = ("https://www.demoblaze.com/");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void contato() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.id("recipient-email")).sendKeys("pathisy.teste@hotmail.com");
		driver.findElement(By.id("recipient-name")).sendKeys("pathisy");
		driver.findElement(By.id("message-text")).sendKeys("Esta\r\n"
				+ "é uma mensagem automatizada.");
		driver.findElement(By.xpath("//*[@onclick = 'send()']")).click();

	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));

		driver.quit();

	}
}
