package com.juaracoding.pageobject.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class MainApp {

	public static void main(String[] args) {
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		
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
