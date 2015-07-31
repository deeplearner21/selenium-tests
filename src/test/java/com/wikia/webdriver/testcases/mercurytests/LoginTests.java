package com.wikia.webdriver.testcases.mercurytests;

import com.wikia.webdriver.common.core.annotations.Execute;
import com.wikia.webdriver.pageobjectsfactory.componentobject.mercury.TopBarComponentObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.mercury.ArticlePageObject;
import com.wikia.webdriver.pageobjectsfactory.pageobject.mercury.JoinPage;
import com.wikia.webdriver.pageobjectsfactory.pageobject.mercury.SignupPageObject;
import org.testng.annotations.Test;

import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.configuration.Configuration;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.mercury.LoginPage;

/**
 * Created by Qaga on 2015-06-29.
 */
@Test(groups = {"MercuryMobileLogin"})
public class LoginTests extends NewTestTemplate {

  private static final String ERROR_MESSAGE =
          "Hm, we don't recognize these credentials. Please try again or register a new account.";

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void validUserCanLogIn() {
    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn(Configuration.getCredentials().userName10,
            Configuration.getCredentials().password10);

    Assertion.assertTrue(loginPage.getNav().isUserLoggedIn(
            Configuration.getCredentials().userName10));
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void userCanNotLogInWithWrongPassword() {
    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn(Configuration.getCredentials().userName10, "thisIsWrongPassword");

    Assertion.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void invalidUserCanNotLogIn() {
    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn("notExistingUserName", Configuration.getCredentials().password10);

    Assertion.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void notPossibleToLogInWhenUsernameFieldBlank() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn("", Configuration.getCredentials().password10);

    Assertion.assertTrue(loginPage.isSubmitButtonDisabled(2));
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void notPossibleToLogInWhenPasswordFieldBlank() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn(Configuration.getCredentials().userName10, "");

    Assertion.assertTrue(loginPage.isSubmitButtonDisabled(2));
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void closeButtonWorksAndRedirectsProperly() {
    ArticlePageObject homePage = new ArticlePageObject(driver);
    homePage.openMainPage(wikiURL);
    String expectedHomePageTitle = homePage.getArticleTitle();

    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.clickOnCloseButton();

    Assertion.assertEquals(expectedHomePageTitle, homePage.getArticleTitle());
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void registerNowLinkWorks() {
    SignupPageObject registrationPage = new SignupPageObject(driver);
    registrationPage.openRegisterPage();
    String expectedHeader = registrationPage.getRegisterHeaderText();

    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.clickOnRegisterLink();
    String currentHeader = registrationPage.getRegisterHeaderText();
    Assertion.assertEquals(expectedHeader, currentHeader);
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void userIsTakenToJoinPage() {
    JoinPage joinPage = new JoinPage(driver).get();
    String expectedMessage = joinPage.getJoinTodayText();

    ArticlePageObject homePage = new ArticlePageObject(driver);
    homePage.openMainPage(wikiURL);
    TopBarComponentObject loginIcon = new TopBarComponentObject(driver);
    loginIcon.clickLogInIcon();

    Assertion.assertEquals(joinPage.getJoinTodayText(), expectedMessage);
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void registerButtonWorksOnJoinPage() {
    SignupPageObject registrationPage = new SignupPageObject(driver);
    registrationPage.openRegisterPage();
    String expectedHeader = registrationPage.getRegisterHeaderText();

    JoinPage joinPage = new JoinPage(driver).get();
    joinPage.clickRegisterWithEmail();

    Assertion.assertEquals(registrationPage.getRegisterHeaderText(), expectedHeader);
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void signInLinkWorksOnJoinPage() {
    LoginPage loginPage = new LoginPage(driver).get();
    String expectedHeader = loginPage.getLoginHeaderText();

    JoinPage joinPage = new JoinPage(driver).get();
    joinPage.clickSignInLink();

    Assertion.assertEquals(loginPage.getLoginHeaderText(), expectedHeader);
  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void redirectToMainPageAfterSuccessfulLogin() {
    ArticlePageObject homePage = new ArticlePageObject(driver);
    homePage.openMainPage(wikiURL);
    String expectedHomePageTitle = homePage.getArticleTitle();

    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn(Configuration.getCredentials().userName10,
            Configuration.getCredentials().password10);

    Assertion.assertEquals(homePage.getArticleTitle(), expectedHomePageTitle);

  }

  @Test
  @Execute(onWikia = "mobileregressiontesting")
  public void redirectToArticlePageAfterSuccessfulLogin() {

    LoginPage loginPage = new LoginPage(driver).get();
    loginPage.logUserIn(Configuration.getCredentials().userName10,
            Configuration.getCredentials().password10);

  }
}

