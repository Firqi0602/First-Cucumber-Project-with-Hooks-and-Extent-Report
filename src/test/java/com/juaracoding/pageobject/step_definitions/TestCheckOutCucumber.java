package com.juaracoding.pageobject.step_definitions;


import static org.testng.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginAccountCucumber;
import com.juaracoding.pageobject.pages.SampleWishlistCucumber;
import com.juaracoding.pageobject.utils.one.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.Before;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCheckOutCucumber {
	public static WebDriver driver;
	private static ExtentTest extentTest;
	private LoginAccountCucumber loginAccountCucumber = new LoginAccountCucumber();
	private SampleWishlistCucumber sampleWishlistCucumber = new SampleWishlistCucumber();

	public TestCheckOutCucumber() {
		driver = Hooks.driver;
		extentTest = Hooks.extentTest;
	}
	
	@When("Go to Web automationpractice")
	public void Go_to_Web_automationpractice() {
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Go to Web automationpractice");
	}
	
	@And("User enter email address password invalid")
	public void User_enter_email_address_password_invalid() {
		loginAccountCucumber.login("nandiardana0@gmail.com", "firqi0602");			
		extentTest.log(LogStatus.PASS, "User enter email address password invalid");
	}
	
	@And("User press button login")
	public void User_press_button_login() {
		loginAccountCucumber.btnLogin();
		extentTest.log(LogStatus.PASS, "User press button login");
	}
	
	@Then("User authentication failed")
	public void User_authentication_failed() {
		AssertJUnit.assertEquals(loginAccountCucumber.msgFailed(), "Authentication failed.");
		extentTest.log(LogStatus.PASS, "User authentication failed");
	}
	
	@When("User enter email address password valid")
	public void User_enter_email_address_password_valid() {
		loginAccountCucumber.login("nandiardana08@gmail.com", "firqi0602");
		extentTest.log(LogStatus.PASS, "User enter email address password valid");
	}
	
	@And("User press button login valid")
	public void User_press_button_login_valid() {
		loginAccountCucumber.btnLogin();
		extentTest.log(LogStatus.PASS, "User press button login valid");
	}
	 
	@Then("User can see my account text")
	public void User_can_see_my_account_text() {
		AssertJUnit.assertEquals(loginAccountCucumber.getTxtMyAccount(), "MY ACCOUNT");
		extentTest.log(LogStatus.PASS, "User can see my account text");
	}
	
	@When("User type printed dress")
	public void User_type_printed_dress() {
		sampleWishlistCucumber.Search("printed dress");
		extentTest.log(LogStatus.PASS, "User type printed dress");
	}
	
	@And("User click button search")
	public void User_click_button_search() {
		sampleWishlistCucumber.btnSearchProduct();
		extentTest.log(LogStatus.PASS, "User click button search");
	}
	
	@Then("User can see printed dress product")
	public void User_can_see_printed_dress_product() {
		AssertJUnit.assertEquals(sampleWishlistCucumber.msgResult(), "5 results have been found.");
		scroll(450);
		extentTest.log(LogStatus.PASS, "User can see printed dress product");
	}
	
	@Given("User select add to chart in first product")
	public void User_select_add_to_chart_in_first_product() {
		sampleWishlistCucumber.cssPilih1();
		sampleWishlistCucumber.btnChart1();
		extentTest.log(LogStatus.PASS, "User select add to chart in first product");
	}
	
	@And("After succes close first product")
	public void After_succes_close_first_product() {
		sampleWishlistCucumber.btnCloseChart1();
		extentTest.log(LogStatus.PASS, "After succes close first product");
	}
	
	@And("User select add to chart in second product")
	public void User_select_add_to_chart_in_second_product() {
		sampleWishlistCucumber.cssPilih2();
		sampleWishlistCucumber.btnChart2();
		extentTest.log(LogStatus.PASS, "User select add to chart in second product");
	}
	
	@And("User click proceed to checkout")
	public void User_click_proceed_to_checkout() {
		sampleWishlistCucumber.btnCheckOut();
		extentTest.log(LogStatus.PASS, "User click proceed to checkout");
	}
	
	@Then("User can see shoppingcart summary")
	public void User_can_see_shoppingcart_summary(){
		System.out.println(sampleWishlistCucumber.msgSummary()+"xxxxxx");
		AssertJUnit.assertEquals(sampleWishlistCucumber.msgSummary(), "Your shopping cart contains: 2 ");
	scroll(200);
	delay(5);
	scroll(200);
	delay(5);
	scroll(300);
		extentTest.log(LogStatus.PASS, "User can see shoppingcart summary");
	}
	
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + vertical + ")");
	}
}

