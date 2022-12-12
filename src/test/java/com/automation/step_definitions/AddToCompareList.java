package com.automation.step_definitions;
import com.automation.pages.CompareList;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddToCompareList {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    CompareList addToComparelist = new CompareList((ChromeDriver) Hooks.driver);

    @Given("logged user")
    public void logged_user(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("click on product tabs")
    public void clckproductTab(){
        addToComparelist.chooseProductTab();
    }
    @When("click on required product")
    public void clckproduct(){
        addToComparelist.chooseReqProduct();
    }
    @When("click on add to compare list")
    public void addcompareList(){
        addToComparelist.addCompare();
    }
    @Then("related products added successfully")
    public void addedsuccessfully(){
        addToComparelist.AssertAdd();
        String ExpectedMesg ="Apple MacBook Pro 13-inch";
        String Actual = addToComparelist.product.getText();
        Assert.assertTrue(addToComparelist.compareProducts.isDisplayed());
        Assert.assertEquals(Actual, ExpectedMesg);
    }
}
