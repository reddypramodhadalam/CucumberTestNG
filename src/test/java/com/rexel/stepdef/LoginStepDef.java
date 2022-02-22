package com.rexel.stepdef;

import com.rexel.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	@Given("^Rexel app is launched$")
	public void rexelAppIsLaunched() throws InterruptedException {
		new LoginPage().clickOnCloseButton();
	}

	@When("^User enters username and password$")
	public void userEntersUsernameAndPassword() throws InterruptedException {
	    new LoginPage().enterUserName();
	    new LoginPage().enterPassword();
	}

	@And("^Clicks on login button$")
	public void clicksOnLoginButton() {
	   new LoginPage().clickOnSignInButton();
	}

	@Then("^Home screen should be displayed$")
	public void homeScreenShouldBeDisplayed() {
	    new LoginPage().validateStartShoppingButton();
	}
	
	@When("^User enters invalid username and password$")
	public void userEntersInvalidUsernameAndPassword() {
		new LoginPage().enterInvalidCredentials();
	}
	
	@Then("^Invalid credentials pop up should be displayed$")
	public void invalidCredentialsPopUpShouldBeDisplayed() {
		new LoginPage().validateInvalidCredentialsPopUp();
	}
}
