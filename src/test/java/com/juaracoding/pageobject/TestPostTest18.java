package com.juaracoding.pageobject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.PostTest18;

public class TestPostTest18 {
	public static WebDriver driver;
	private PostTest18 posttest18;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObjectTwo() {
		posttest18 = new PostTest18();
	}

	@Test
	public void testPostTestDelapaBelas() {

		delay(3);
		posttest18.search();
		delay(3);

		posttest18.searchInput();
		delay(3);

		scroll(700);

		posttest18.wishlist();
		delay(5);

		posttest18.wishlistTwo();
		delay(5);

		posttest18.wishlistList();
		delay(5);

		scroll(700);

		posttest18.getTxtBlackOne();
		System.out.println(posttest18.getTxtBlackOne());
		String txt = posttest18.getTxtBlackOne();
		assertTrue(txt.contains("BLACK"));
		delay(5);

		posttest18.getTxtBlackTwo();
		System.out.println(posttest18.getTxtBlackTwo());
		String txtTwo = posttest18.getTxtBlackOne();
		assertTrue(txtTwo.contains("BLACK"));
		delay(5);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + vertical + ")");
	}
}
