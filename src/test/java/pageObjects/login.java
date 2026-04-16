package pageObjects;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

	}

}
