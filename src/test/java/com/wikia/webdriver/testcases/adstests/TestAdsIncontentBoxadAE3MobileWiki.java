package com.wikia.webdriver.testcases.adstests;
import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.annotations.InBrowser;
import com.wikia.webdriver.common.core.annotations.NetworkTrafficDump;
import com.wikia.webdriver.common.core.drivers.Browser;
import com.wikia.webdriver.common.core.helpers.Emulator;
import com.wikia.webdriver.common.core.url.Page;
import com.wikia.webdriver.common.core.url.UrlBuilder;
import com.wikia.webdriver.common.logging.PageObjectLogging;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsBaseObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test(groups = "AdsIncontentBoxadAE3Mobile")
@InBrowser(browser = Browser.CHROME, emulator = Emulator.GOOGLE_NEXUS_5)
public class TestAdsIncontentBoxadAE3MobileWiki extends NewTestTemplate {

  private static final Page page = new Page("project43", "SyntheticTests/Slots/Repeatable");

  private static final String AD_INFO_PATTERN = "https?://.*wikia-services\\.com.*kv_pos=INCONTENT_BOXAD.*kv_rv=4.*";
  private static final String LAST_HEADER_AD_INFO_PATTERN =
      "https?://.*wikia-services\\.com.*kv_pos=INCONTENT_BOXAD.*kv_rv=6.*ad_status=viewport-conflict.*";
  private static final String AE3_INSTANT_GLOBAL = "wgAdDriverAdEngine3Countries";
  private static final String MOBILE_INCONTENT_INSTANT_GLOBAL = "wgAdDriverRepeatMobileIncontentCountries";
  private static final String INCONTENT_SELECTOR = "incontent_boxad_%s";
  private static final String ARTICLE_HEADER_SELECTOR = "Section_%s";

  private static final boolean INCONTENT_ENABLED = true;
  private static final boolean INCONTENT_DISABLED = false;

  private static final int HEADERS_WITH_AD_NUMBER = 5;
  private static final int LAST_HEADER_WITHOUT_AD_NUMBER = 6;
  private static final double HEADER_WITHOUT_AD_NUMBER = 2.5;

  @Test()
  public void adDisplayedBeforeSections() {
    AdsBaseObject ads = new AdsBaseObject(driver);
    ads.getUrl(urlWithInstantGlobals(INCONTENT_ENABLED));
    for (int i = 1; i <= HEADERS_WITH_AD_NUMBER ; i++){
      ads.scrollTo(By.id(String.format(ARTICLE_HEADER_SELECTOR, Integer.toString(i))));

      Assertion.assertTrue(isIncontenAdDisplayed(i, ads),
                           "IcontentBoxad is not displayed before section");
    }
  }

  @Test()
  public void adNotDisplayedIfSectionInThisSameViewPort() {
    AdsBaseObject ads = new AdsBaseObject(driver);
    ads.getUrl(urlWithInstantGlobals(INCONTENT_DISABLED));
    ads.scrollTo(By.id(String.format(ARTICLE_HEADER_SELECTOR, Double.toString(HEADER_WITHOUT_AD_NUMBER))));

    Assertion.assertFalse(isIncontenAdDisplayed(3, ads),
                          "IcontentBoxad is displayed before section");
  }

  @Test()
  @NetworkTrafficDump(useMITM = true)
  public void incontentBoxadTracking() {
    networkTrafficInterceptor.startIntercepting();
    AdsBaseObject ads = new AdsBaseObject(driver);
    ads.getUrl(urlWithInstantGlobals(INCONTENT_ENABLED));
    ads.scrollTo(By.id(String.format(ARTICLE_HEADER_SELECTOR, Integer.toString(HEADERS_WITH_AD_NUMBER))));

    ads.wait.forSuccessfulResponseByUrlPattern(networkTrafficInterceptor, AD_INFO_PATTERN);
  }

  @Test()
  @NetworkTrafficDump(useMITM = true)
  public void incontentBoxadTrackingLastSection() {
    networkTrafficInterceptor.startIntercepting();
    AdsBaseObject ads = new AdsBaseObject(driver);
    ads.getUrl(urlWithInstantGlobals(INCONTENT_ENABLED));
    ads.scrollTo(By.id(String.format(ARTICLE_HEADER_SELECTOR, Integer.toString(LAST_HEADER_WITHOUT_AD_NUMBER))));

    Assertion.assertFalse(isIncontenAdDisplayed(LAST_HEADER_WITHOUT_AD_NUMBER, ads),
                          "IcontentBoxad is displayed before section");
    ads.wait.forSuccessfulResponseByUrlPattern(networkTrafficInterceptor, LAST_HEADER_AD_INFO_PATTERN);
  }

  private boolean isIncontenAdDisplayed(int headerNumber, AdsBaseObject ads){
    try {
      WebElement slot =
          driver.findElement(By.id(String.format(INCONTENT_SELECTOR, Integer.toString(headerNumber))));
      ads.waitForSlotExpanded(slot);
      return true;
    } catch (Exception ex){
      PageObjectLogging
          .logInfo("IcontentBoxad is not displayed", ex);
      return false;
    }
  }

  private static String urlWithInstantGlobals(boolean enabled) {
    UrlBuilder urlBuilder = UrlBuilder.createUrlBuilder();
    String url = page.getUrl();
    String newUrl = urlBuilder.globallyEnableGeoInstantGlobalOnPage(url, AE3_INSTANT_GLOBAL);
    if(!enabled) {
      return urlBuilder.globallyDisableGeoInstantGlobalOnPage(newUrl, MOBILE_INCONTENT_INSTANT_GLOBAL);
    } else {
      return urlBuilder.globallyEnableGeoInstantGlobalOnPage(newUrl, MOBILE_INCONTENT_INSTANT_GLOBAL);
    }
  }
}
