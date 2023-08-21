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

public class Cadastro_Usuario {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {

		url = ("https://www.demoblaze.com/");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void cadastro_usuario() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("signin2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("pathisy1");
		driver.findElement(By.id("sign-password")).sendKeys("teste123");
		driver.findElement(By.xpath("//*[@onclick = 'register()']")).click();

	}

	@Test
	public void cadastro_usuarioExistente() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("signin2")).click();
		driver.findElement(By.id("sign-username")).sendKeys("‘USUARIO_EXISTENTE’");
		driver.findElement(By.id("sign-password")).sendKeys("SENHA_EXISTENTE");
		driver.findElement(By.xpath("//*[@onclick = 'register()']")).click();
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));

		driver.quit();

	}
}
