package com.automation.step_definitions;
import com.automation.pages.ProductHover;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ProductHoverMenu {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    ProductHover productHover = new ProductHover((ChromeDriver) Hooks.driver);

    @Given("Log user")
    public void logged_user(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("Choose different category")
    @Then("Category page open successfully")
    public void opencategory(){
        productHover.SelectCategory();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("digital-downloads"));
    }
    @Then("Sub-category page open successfully")
    public void opensubCategory(){
        productHover.SelectSubCategory();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("desktops"));
    }



}
