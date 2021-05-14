package com.qa.ResturauntHobby.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@RunWith(SpringRunner.class)
public class test {
	
	@LocalServerPort
	static int randomPort;
	
	private static final String URL = "http://localhost:"+randomPort;
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1786, 636));
	}
	
	@Test
	public void enterSite() {
		driver.get(URL);
		assertEquals(URL,driver.getCurrentUrl());
	}

	
	@After
	public void shutDown() {
		driver.close();		
	}
}
