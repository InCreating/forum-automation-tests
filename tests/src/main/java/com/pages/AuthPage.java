package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@name='email']")
    WebElement emailElement;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordElement;

    @FindBy(xpath = "//*[@name='username']")
    WebElement userElement;

    @FindBy(xpath = "//*[@id='signup-toggle-btn']")
    WebElement switchTypeElement;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign up']")
    WebElement signUpElement;

    @FindBy(xpath = "//input[@type='submit' and @value='Log In']")
    WebElement logInElement;

    @FindBy(xpath = "//*[@name='confirm-password']")
    WebElement confirmPassElement;

    @FindBy(xpath = "//*[@id='signup-email']")
    WebElement signUpEmailElement;

    @FindBy(xpath = "//*[@id='signup-password']")
    WebElement signUpPassElement;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        emailElement.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordElement.sendKeys(password);
    }

    public void setUsername(String username) {
        userElement.sendKeys(username);
    }

    public void setConfirmPassElement (String confPass) {
        confirmPassElement.sendKeys(confPass);
    }

    public void clickFinishSignUp() {
        signUpElement.click();
    }

    public void clickSwitchToSignUp() {
        switchTypeElement.click();
    }

    public void setPasswordSignUp(String mess) {
        signUpPassElement.sendKeys(mess);
    }

    public void setEmailSignUp(String mess) {
        signUpEmailElement.sendKeys(mess);
    }

    public void clickFinishLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logInElement)).click();
    }

    public String getCurrentLing() {
        return driver.getCurrentUrl();
    }

    public void waitForUrlChange(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
