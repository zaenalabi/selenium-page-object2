package com.juaracoding.pageobject;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;

public class TestLogin {

	public static WebDriver driver;
	private LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		loginPage = new LoginPage();
	}

	@Test
	public void testValidLogin() {
		loginPage.login("Admin", "admin1234");
		assertEquals(loginPage.getTxtDashboard(), "Dashboard");
//		assertEquals(loginPage.msgInvalid(),"Invalid ");
	}

	@AfterClass
	public void closeBrowser() {
		delay(3);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
