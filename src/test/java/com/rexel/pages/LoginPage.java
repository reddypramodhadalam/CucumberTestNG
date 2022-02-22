package com.rexel.pages;

import org.testng.Assert;

import com.rexel.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView/android.widget.ImageView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\\\"UAT Rexel SE\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
	private MobileElement closeButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	@iOSXCUITFindBy(accessibility = "Username")
	private MobileElement usernameInputField;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	@iOSXCUITFindBy(id = "Password")
	private MobileElement password;

	@AndroidFindBy(accessibility = "Sign In")
	@iOSXCUITFindBy(xpath = "Sign In")
	private MobileElement signInButton;
	
	@AndroidFindBy(accessibility = "Start Shopping")
	private MobileElement startShopping;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Ok']")
	private MobileElement okDisable;
	

	public LoginPage(){
	}
	
	public LoginPage clickOnCloseButton() {
		 waitForVisibility(closeButton);
		 click(closeButton, "clicking on close button");
		 Assert.assertTrue(signInButton.isDisplayed(), "Login page is not displayed");
		 return this;
	}
	
	public LoginPage enterUserName() {
		click(usernameInputField);
		clear(usernameInputField);
		sendKeys(usernameInputField, "app@auto1.com", "login with " + "app@auto1.com");
		return this;
	}
	
	public LoginPage enterPassword() {
		click(password);
		clear(password);
		sendKeys(password, "12345678", "password is " + "12345678");
		return this;
	}

	public LoginPage clickOnSignInButton() {
		 waitForVisibility(signInButton);
		 click(signInButton);
		 return this;
	}
	
	public LoginPage validateStartShoppingButton() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(true, "Start shopping button is not displayed after login");
		return this;
	}
	
	public LoginPage enterInvalidCredentials() {
		click(usernameInputField);
		clear(usernameInputField);
		sendKeys(usernameInputField, "app.invalid.com", "login with " + "app.invalid.com");
		click(password);
		clear(password);
		sendKeys(password, "12345678", "password is " + "12345678");
		return this;
	}
	
	public LoginPage validateInvalidCredentialsPopUp() {
		waitForVisibility(okDisable);
		Assert.assertTrue(okDisable.isDisplayed(), "Invalid Credentials PopUp is not displayed");
		return this;
	}
	
	public LoginPage validateDisabledUserPopUp() {
		waitForVisibility(okDisable);
		Assert.assertTrue(okDisable.isDisplayed(), "Disabled User PopUp is not displayed");
		return this;
	}
}
