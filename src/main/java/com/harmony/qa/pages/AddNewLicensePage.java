package com.harmony.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.CheckBoxAndRadioButtonHelper;
import com.harmony.qa.utility.DropdownHelper;
import com.harmony.qa.utility.GenericHelper;
import com.harmony.qa.utility.JavaScriptHelper;
import com.harmony.qa.utility.TextBoxHelper;

public class AddNewLicensePage extends TestBase
{
	ButtonHelper button=new ButtonHelper();
	TextBoxHelper text=new TextBoxHelper();
	DropdownHelper dropdown=new DropdownHelper();
	CheckBoxAndRadioButtonHelper cb=new CheckBoxAndRadioButtonHelper();
	GenericHelper generic=new GenericHelper();
	JavaScriptHelper jshelp=new JavaScriptHelper();
	
	private By addNewLicenseButton=By.xpath("//a[contains(@id,'lnkCreateLicenses')]");
	private By applicationNameDD=By.xpath("//select[contains(@id,'ddlApplicationNameNew')]");
	private By applicationUrlDD=By.xpath("//select[contains(@id,'ddlApplicationURLNew')]");
	private By portalTypeDD=By.xpath("//select[contains(@id,'ddlDeploymentType')]");
	private By serverNameDD=By.xpath("//select[contains(@id,'ddlServerNameNew')]");
	private By deploymentDescInput=By.xpath("//input[contains(@id,'txtDeploymentDescription')]");
	private By dataBaseNameInput=By.xpath("//input[contains(@id,'txtDatabaseNameNew')]");
	private By userNameInput=By.xpath("//input[contains(@id,'txtUserNameNew')]");
	private By passwordInput=By.xpath("//input[contains(@id,'txtPasswordNew')]");
	private By sDrivePathInput=By.xpath("//input[contains(@id,'txtSDrivepath')]");
	private By isActiveCB=By.xpath("//input[contains(@id,'cbIsActive')]");
	private By applicationLinkCB=By.xpath("//input[contains(@id,'cbShowApplicationLink')]");
	private By payeeDD=By.xpath("//select[contains(@id,'ddlInvoiceeType1Footer')]");
	private By licensesNumberInput=By.xpath("//input[contains(@id,'txtLicCountFooter')]");
	private By renewalDateInput=By.xpath("//input[contains(@id,'dtRenewalDateFooterDate')]");
	private By insertLicenseButton=By.xpath("//a[contains(@id,'lnkbtnInsert')]");
	private By submitLicenseButton=By.xpath("//input[contains(@id,'btnSubmit')]");
	private By loadingBar=By.xpath("//div//h1[@id='dialogTitleSpan']");
	
	public void addNewLicense(String applicationName, String desc, String applicationUrl, String portalType, String dbServer, String username, 
			String password, String sDrivePath, String dbName, String payee, String licensesNumber, String renewDate)
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		button.click(addNewLicenseButton);
		jshelp.scrollIntoView(submitLicenseButton);
		dropdown.SelectUsingVisibleValue(applicationNameDD, applicationName);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
		text.clearAndSendKeys(deploymentDescInput, desc);
		dropdown.SelectUsingValue(applicationUrlDD, applicationUrl);
		dropdown.SelectUsingVisibleValue(portalTypeDD, portalType);
		dropdown.SelectUsingVisibleValue(serverNameDD, dbServer);
		text.clearAndSendKeys(dataBaseNameInput, dbName);
		text.clearAndSendKeys(userNameInput, username);
		text.clearAndSendKeys(passwordInput, password);
		text.clearAndSendKeys(sDrivePathInput, sDrivePath);
		if(!cb.isIselected(isActiveCB))
		{
			button.click(isActiveCB);
		}
		if(cb.isIselected(applicationLinkCB))
		{
			button.click(applicationLinkCB);
		}
		dropdown.SelectUsingVisibleValue(payeeDD, payee);
		text.clearAndSendKeys(licensesNumberInput, licensesNumber);
		text.clearAndSendKeys(renewalDateInput, renewDate);
		button.click(insertLicenseButton);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
		button.click(submitLicenseButton);
	}
	
	public void clickOnEditLicenseButton(String orgDescNameToEdit)
	{
		WebElement ele=driver.findElement(By.xpath("//div/table[contains(@id,'dlViewDetails')]//tr//td//span[contains(text(),'"+orgDescNameToEdit+"')]/parent::td/parent::tr//td//a[contains(text(),'Edit')]"));
		ele.click();
	}
	
	public void clickOnDeleteLicenseButton(String orgDescNameToDelete)
	{
		WebElement ele=driver.findElement(By.xpath("//div/table[contains(@id,'dlViewDetails')]//tr//td//span[contains(text(),'"+orgDescNameToDelete+"')]/parent::td/parent::tr//td//a[contains(text(),'Delete')]"));
		ele.click();
	}

	public boolean isLicenseAddedSucessfully(String LicenseName)
	{
		WebElement ele=driver.findElement(By.xpath("//div/table[contains(@id,'dlViewDetails')]//tr//td//span[contains(text(), '"+LicenseName+"')]"));
		return ele.isDisplayed();
	}
	
}
