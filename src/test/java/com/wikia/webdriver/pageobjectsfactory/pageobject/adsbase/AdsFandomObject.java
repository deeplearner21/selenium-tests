package com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase;

import com.wikia.webdriver.common.contentpatterns.AdsContent;
import com.wikia.webdriver.common.contentpatterns.AdsFandomContent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdsFandomObject extends AdsBaseObject {
  private static final By F2_MOBILE_NAVIGATION_BAR = By.cssSelector(".global-navigation-mobile");
  private static final By F2_DESKTOP_NAVIGATION_BAR = By.cssSelector(".wds-global-navigation");

  public AdsFandomObject(WebDriver driver, String testedPage) {
    super(driver, testedPage);
  }

  public AdsFandomObject(WebDriver driver, String testedPage, Dimension resolution) {
    super(driver, testedPage, resolution);
  }

  private WebElement findSlotElement(String slotSelector) {
    return driver.findElement(By.cssSelector(AdsFandomContent.getSlotSelectorString(slotSelector)));
  }

  public void triggerOnScrollSlots() {
    jsActions.scrollToBottom();
  }

  public void fixScrollPositionByNavbarOnF2(boolean isMobile) {
    if(isMobile){
      int mobileNavbarHeight = -1 * driver.findElement(F2_MOBILE_NAVIGATION_BAR).getSize().getHeight();
      jsActions.scrollBy(0, mobileNavbarHeight);
    } else {
      int desktopNavbarHeight = -1 * driver.findElement(F2_DESKTOP_NAVIGATION_BAR).getSize().getHeight();
      jsActions.scrollBy(0, desktopNavbarHeight);
    }
  }

  public void verifySlot(String slotName) {
    String selector = AdsFandomContent.getSlotSelectorString(slotName);

    scrollTo(AdsFandomContent.getSlotSelector(slotName));
    verifyAdVisibleInSlot(selector, findSlotElement(slotName));
  }

  public WebElement getSlot(String slotName) {
    String selector = AdsFandomContent.getSlotSelectorString(slotName);

    if (isElementOnPage(By.cssSelector(selector))) {
      return driver.findElement(By.cssSelector(selector));
    }

    return null;
  }

  public By getIframeSelector(String slotName) {
    return By.cssSelector(AdsContent.IFRAME_SLOT_SELECTORS.getOrDefault(slotName, getDefaultIframeSelector(slotName)));
  }

  private String getDefaultIframeSelector(String slotName) {
    return String.format("iframe[id^='google_ads_iframe_/5441/wka.fandom/_article/ARTICLE_%s_0']", slotName);
  }

}
