package com.juaracoding.pageobject.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.AccountPage;


public class MainApp {

	public static void main(String[] args) {
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = "https://shop.demoqa.com/my-account/";
		driver.get(url);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		js.executeScript("arguments[0].scrollIntoView()", username);
		
		AccountPage accountPage = new AccountPage();
		accountPage.login("Admin","admin1234");
		System.out.println("Maaf login tidak sesuai");
		
		WebElement accRegister = driver.findElement(By.xpath("//input[@id='reg_username']"));
		js.executeScript("arguments[0].scrollIntoView()", accRegister);
		
		//attempt to register
		Register register = new Register();
		register.register("zain","zain@gmail.com","admin1234");
		System.out.println("Selamat kamu berhasil mendaftar");
		
		delay(3);
		driver.quit();

	}
	
	@BeforeMethod
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
