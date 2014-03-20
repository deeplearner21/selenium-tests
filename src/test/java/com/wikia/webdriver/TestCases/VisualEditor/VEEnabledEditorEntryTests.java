package com.wikia.webdriver.TestCases.VisualEditor;

import org.testng.annotations.Test;

import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Properties.Credentials;
import com.wikia.webdriver.Common.Templates.NewTestTemplateBeforeClass;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Article.ArticlePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.VisualEditor.VisualEditorPageObject;

/**
 * @author Robert 'Rochan' Chan
 *
 * Editor Entry Point Test on wiki that has wgEnabledRTEExt = true, wgVisualEditorUI = true
 *
 */

public class VEEnabledEditorEntryTests extends NewTestTemplateBeforeClass {

	Credentials credentials = config.getCredentials();

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_VEPreferred", "VEEnabledEditorEntryTests_001"}
	)
	public void VEEnabledEditorEntryTests_001_CreatePageEntry_vePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameVEPreferred, credentials.passwordVEPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_VEPreferred", "VEEnabledEditorEntryTests_002"}
	)
	public void VEEnabledEditorEntryTests_002_MainEditEntry_vePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameVEPreferred, credentials.passwordVEPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_VEPreferred", "VEEnabledEditorEntryTests_003"}
	)
	public void VEEnabledEditorEntryTests_003_RedlinkEntry_vePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameVEPreferred, credentials.passwordVEPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_VEPreferred", "VEEnabledEditorEntryTests_004"}
	)
	public void VEEnabledEditorEntryTests_004_SectionEditEntry_vePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameVEPreferred, credentials.passwordVEPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_VEPreferred", "VEEnabledEditorEntryTests_005"}
	)
	public void VEEnabledEditorEntryTests_005_URLEntry_vePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameVEPreferred, credentials.passwordVEPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_CKPreferred", "VEEnabledEditorEntryTests_006"}
	)
	public void VEEnabledEditorEntryTests_006_CreatePageEntry_ckPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameCKPreferred, credentials.passwordCKPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_CKPreferred", "VEEnabledEditorEntryTests_007"}
	)
	public void VEEnabledEditorEntryTests_007_MainEditEntry_ckPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameCKPreferred, credentials.passwordCKPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_CKPreferred", "VEEnabledEditorEntryTests_008"}
	)
	public void VEEnabledEditorEntryTests_008_RedlinkEntry_ckPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameCKPreferred, credentials.passwordCKPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_CKPreferred", "VEEnabledEditorEntryTests_009"}
	)
	public void VEEnabledEditorEntryTests_009_SectionEditEntry_ckPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameCKPreferred, credentials.passwordCKPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_CKPreferred", "VEEnabledEditorEntryTests_010"}
	)
	public void VEEnabledEditorEntryTests_010_URLEntry_ckPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameCKPreferred, credentials.passwordCKPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_sourcePreferred", "VEEnabledEditorEntryTests_011"}
	)
	public void VEEnabledEditorEntryTests_011_CreatePageEntry_sourcePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameSourcePreferred, credentials.passwordSourcePreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_sourcePreferred", "VEEnabledEditorEntryTests_012"}
	)
	public void VEEnabledEditorEntryTests_012_MainEditEntry_sourcePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameSourcePreferred, credentials.passwordSourcePreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_sourcePreferred", "VEEnabledEditorEntryTests_013"}
	)
	public void VEEnabledEditorEntryTests_013_RedlinkEntry_sourcePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameSourcePreferred, credentials.passwordSourcePreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_sourcePreferred", "VEEnabledEditorEntryTests_014"}
	)
	public void VEEnabledEditorEntryTests_014_SectionEditEntry_sourcePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameSourcePreferred, credentials.passwordSourcePreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_sourcePreferred", "VEEnabledEditorEntryTests_015"}
	)
	public void VEEnabledEditorEntryTests_015_URLEntry_sourcePreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameSourcePreferred, credentials.passwordSourcePreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_defaultPreferred", "VEEnabledEditorEntryTests_016"}
	)
	public void VEEnabledEditorEntryTests_016_CreatePageEntry_defaultPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameDefaultPreferred, credentials.passwordDefaultPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_defaultPreferred", "VEEnabledEditorEntryTests_017"}
	)
	public void VEEnabledEditorEntryTests_017_MainEditEntry_defaultPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameDefaultPreferred, credentials.passwordDefaultPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_defaultPreferred", "VEEnabledEditorEntryTests_018"}
	)
	public void VEEnabledEditorEntryTests_018_RedlinkEntry_defaultPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameDefaultPreferred, credentials.passwordDefaultPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_defaultPreferred", "VEEnabledEditorEntryTests_019"}
	)
	public void VEEnabledEditorEntryTests_019_SectionEditEntry_defaultPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameDefaultPreferred, credentials.passwordDefaultPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}

	@Test(
			groups = {"VEEnabledEditorEntryTests", "VEEanbledEditorEntryTests_defaultPreferred", "VEEnabledEditorEntryTests_020"}
	)
	public void VEEnabledEditorEntryTests_020_URLEntry_defaultPreferred() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.veEnabledTestMainPage);
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameDefaultPreferred, credentials.passwordDefaultPreferred, wikiURL);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, base.getTimeStamp());
		VisualEditorPageObject ve = article.clickVEEditButton();
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
		ve.logOut(wikiURL);
	}
}
