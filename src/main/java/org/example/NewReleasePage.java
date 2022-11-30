package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class NewReleasePage extends Utils{

    private By _commentTitle = By.id("AddNewComment_CommentTitle");
    private By _commentText = By.id("AddNewComment_CommentText");
    private By _newCommentButton = By.name("add-comment");
    private By _commentStatusMsg = By.className("result");

    public void verifyUserShouldAbleToWriteCommentSuccessfully(){
        String expectedCommentStatusMsg = "News comment is successfully added.";

        typeText(_commentTitle,  "8 DN Products");
        typeText(_commentText,"We have listed so many new products and now you have very large collection of products.");
        clickOnElement(_newCommentButton);
        Assert.assertEquals(getTextFromElement(_commentStatusMsg),expectedCommentStatusMsg, "Add new comment unsuccessful");
    }

    public void verifyLatestCommentShouldAppearAtTheBottomOfTheList() {
        // use JavaScriptExecutor interface to scroll down page to capture bottom added comment
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        // This  will scroll down the page by 5000 pixel vertical
        scroll.executeScript("window.scrollBy(0,5000)");

        String lastCommentsTitle = new String();

        // created arrayList of WebElement to store all added comments title
        List<WebElement> commentsTitleList = driver.findElements(By.className("comment-title"));
//        System.out.println("Total added comments: " + commentsTitleList.size());

        // used for each loop to find all comments titles
        for (WebElement element : commentsTitleList)
            // get the last added comment title
            lastCommentsTitle = element.getText();
//            System.out.println(lastCommentsTitle);

        // with the use of assert compare our comment title with captured last comment title
        Assert.assertEquals(lastCommentsTitle,"8 DN Products", "Added comment cannot found");
        }
    }

