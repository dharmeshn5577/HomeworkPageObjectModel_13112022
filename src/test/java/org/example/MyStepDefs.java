package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {

    Homepage homepage = new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    @Given("user is on registration page")
    public void user_is_on_registration_page() {
      homepage.clickOnRegistrationButton();
      registrationPage.verifyUserIsOnRegistrationPage();
    }

    @When("user enter registration details and click on register button")
    public void userEnterRegistrationDetailsAndClickOnRegisterButton() {
        registrationPage.enterRegistrationDetailsAndClickOnRegisterButton();
    }
    @Then("registration complete message should display")
    public void registration_complete_message_should_display() {
       registrationResultPage.verifyUserIsOnRegistrationResultPage();
       registrationResultPage.verifyUserRegistrationIsCompleted();
    }



    @When("I click on {string} link")
    public void i_click_on_link(String category_name) {
        homepage.iClickOnLink(category_name);

    }
    @Then("User should able to navigate to related {string} page")
    public void user_should_able_to_navigate_to_related_page(String category_link) {
        Utils.assertCurrentUrl(category_link);

    }
}
