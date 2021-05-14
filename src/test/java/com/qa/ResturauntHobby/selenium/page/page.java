package com.qa.ResturauntHobby.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class page {
	
	@FindBy(xpath = "/html/body/div/div[1]/h3")
	private WebElement heading;

	public WebElement getHeading() {
		return heading;
	}

}
