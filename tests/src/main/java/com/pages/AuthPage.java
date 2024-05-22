package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@name='email']")
    WebElement emailElement;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordElement;

    @FindBy(xpath = "//*[@name='username']")
    WebElement userElement;

    @FindBy(xpath = "/html/body/app-root/app-login-signup-page/div/div/div/div/div/div[1]/div/div/div")
    WebElement switchTypeElement;

    @FindBy(xpath = "/html/body/app-root/app-login-signup-page/div/div/div/div/div/div[2]/div/form/div[2]/div/input")
    WebElement signUpElement;

    @FindBy(xpath = "/html/body/app-root/app-login-signup-page/div/div/div/div/div/div[1]/div/form/div[2]/div/input")
    WebElement logInElement;

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

    public void clickSwitchToSignUp() {
        switchTypeElement.click();
    }

    public void clickFinishSignUp() {
        signUpElement.click();
    }

    public void clickFinishLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logInElement)).click();
    }
}
