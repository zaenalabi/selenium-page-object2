package com.juaracoding.pageobject.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver", "J:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
