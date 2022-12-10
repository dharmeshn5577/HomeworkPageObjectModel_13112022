package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {

    // created objects of all created webpages classes so can use their property in this class
    Homepage homepage = new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    ElectronicsPage electronicsPage = new ElectronicsPage();
    CameraAndPhotoPage cameraAndPhotoPage = new CameraAndPhotoPage();
    AppleMacBookPro13InchPage appleMacBookPro13InchPage = new AppleMacBookPro13InchPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    NewReleasePage newReleasePage = new NewReleasePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Test      // used test annotation feature of TestNG to run multiple test cases in one class
    public void verifyUserShouldAbleToRegisterSuccessfully() {
        homepage.clickOnRegistrationButton();
        registrationPage.verifyUserIsOnRegistrationPage();
        registrationPage.enterRegistrationDetailsAndClickOnRegisterButton();
        registrationResultPage.verifyUserIsOnRegistrationResultPage();
        registrationResultPage.verifyUserRegistrationIsCompleted();

//      waitForUrlToBe("http://omayo.blogspot.com/", 2);
    }

    @Test
    public void verifyEachProductsHaveTitleOnCameraAndPhotoPage() {
        // navigate to the Electronics page
        homepage.clickOnElectronicsCategory();
        // Navigate to Camera & Photo page
        electronicsPage.clickOnCameraAndPhotoSubCategory();
        // Capture each listed products title
        cameraAndPhotoPage.getTitlesOfAllListedProducts();
    }

    @Test
    public void verifyCorrectCurrencyDisplayedAccordingToSelectedCurrency() {
        homepage.verifyAllProductsHaveUSDollarCurrencySymbolWhenUSDollarSelected();
        homepage.verifyAllProductsHaveEuroCurrencySymbolWhenEuroSelected();
    }

    @Test
    public void verifyAlertShouldAppearWhenClickOnVoteButtonWithoutSelection() {
        homepage.verifyAlertPopUpForVoteButton();
    }

    @Test
    public void verifyUserShouldNavigateToFacebookPageWhenCLickOnFacebookIcon() {
        homepage.userShouldNavigateToFacebookPage();
    }

    @Test
    public void verifyRegisteredUserCanReferAProductToFriendSuccessfully() {
        //click on register button
        homepage.clickOnRegistrationButton();
        // Navigate to registration page
        registrationPage.verifyUserIsOnRegistrationPage();
        //Fill all registration details
        registrationPage.enterRegistrationDetailsAndClickOnRegisterButton();
        //verify user is on registration result page
        registrationResultPage.verifyUserIsOnRegistrationResultPage();
        //verify registration done successfully and click on continue button
        registrationResultPage.verifyUserRegistrationIsCompleted();
        // Click on Apple Macbook pro product
        homepage.navigateToAppleMacBookPro13InchProductPage();
        //Click on send email a friend button
        appleMacBookPro13InchPage.verifyUserShouldAbleToEmailAFriend();
        //navigate to email a friend page, enter the details and send email
        emailAFriendPage.verifyUserShouldAbleToReferProductToFriend();
    }

    @Test
    public void verifyUserShouldAbleToPutCommentOnNewReleaseAndCommentShouldDisplayAtTheBottomOfTheAllPreviousComments() {
        //Navigate to new release page
        homepage.navigateToNewReleasePage();
        //fill comments details and verify comment added successfully
        newReleasePage.verifyUserShouldAbleToWriteCommentSuccessfully();
        // verify recent added comment added at the bottom of the all comments
        newReleasePage.verifyLatestCommentShouldAppearAtTheBottomOfTheList();
    }

    @Test
    public void verifyAllListedProductHaveAddToCartButton() {
        // navigate to the Electronics page
        homepage.clickOnElectronicsCategory();
        // Navigate to Camera & Photo page
        electronicsPage.clickOnCameraAndPhotoSubCategory();
        // check each listed product add to cart button
        cameraAndPhotoPage.verifyAllProductsHaveAddToCartButton();
    }

    @Test
    public void verifyUserShouldBeAbleToNavigateDesktopsPageByHoveringOnComputersCategory() {
        homepage.navigateToDesktopsSubCategoryPage();
        desktopsPage.verifyUserNavigateToDesktopsPage();
    }

    @Test
    public void verifyCategoriesTextColorIsChangesAfterHoveringOnElement() {
        homepage.captureAndVerifyTextColorIsChangesAfterHover();
    }

    @Test
    public void verifySearchFunctionalityWorkingProperly() {
        homepage.verifyUserShouldAbleToSearch();
        searchResultPage.navigateToSearchResultPageAndVerifyReslutShowsAccordingly();

    }
}
