package com.harmony.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.DropdownHelper;
import com.harmony.qa.utility.GenericHelper;
import com.harmony.qa.utility.JavaScriptHelper;
import com.harmony.qa.utility.NavigationHelper;
import com.harmony.qa.utility.TextBoxHelper;
import com.harmony.qa.utility.WaitHelper;

public class UserListPage extends TestBase
{
	DropdownHelper dropdown = new DropdownHelper();
	NavigationHelper navigate = new NavigationHelper();
	ButtonHelper button = new ButtonHelper();
	GenericHelper generic = new GenericHelper();
	WaitHelper wait = new WaitHelper();
	TextBoxHelper textBox = new TextBoxHelper();
	JavaScriptHelper jsHelper = new JavaScriptHelper();
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	private By addUserButton = By.xpath("//a[contains(@id,'btnAdd')]");
	private By exportUserButton = By.xpath("//a[contains(@id,'btnImport')]");
	private By errorMessageWhenOrgNotSelected = By.xpath("//span[contains(@id,'lblErrorMessage')]");
	private By userReportButton = By.xpath("//span[contains(@id,'btnUserDetailReport')]");
	private By licenseSummaryReportButton = By.xpath("//a[contains(@id,'btnLicenseSummaryReport')]");
	private By orgDD = By.xpath("//select[contains(@id,'ddlOrgName')]");
	private By searchButton = By.xpath("//input[contains(@id,'btnSearch')]");
	private By userNameInput = By.xpath("//input[contains(@id,'txtUserId')]");
	private By emailIdInput = By.xpath("//input[contains(@id,'txtEmailAddress')]");
	private By firstNameInput = By.xpath("//input[contains(@id,'txtFirstName')]");
	private By lastNameInput = By.xpath("//input[contains(@id,'txtLastName')]");
	private By includeChildOrgChk = By.xpath("//input[contains(@id,'chkIncludeChildOrgUser')]");
	private By showInactiveChk = By.xpath("//input[contains(@id,'chkShowInactives')]");
	private By ResetButton = By.xpath("//input[contains(@id,'btnReset')]");
	private By userListTable = By.xpath("//table[contains(@id,'rgUserList')]");
	private By editUserHeader = By.xpath("//td[@title='AddEditUser - My Visual WebPart']");
	private By nextPageButtonInPagination = By.xpath("//input[@title='Next Page']");

	public String userPageUrl()
	{
		return navigate.getCurrentUrl();
	}

	public AddUserPage clickOnAddNewUserButton(String orgName)
	{
		dropdown.SelectUsingVisibleValue(orgDD, orgName);
		wait.waitForElementVisible(addUserButton, 30, 10);
		button.click(addUserButton);
		return new AddUserPage();
	}

	public ExportUserPage clickOnImportUserButton(String orgName)
	{
		dropdown.SelectUsingVisibleValue(orgDD, orgName);
		wait.waitForElementVisible(exportUserButton, 30, 10);
		button.click(exportUserButton);
		return new ExportUserPage();
	}

	public UserReportPage clickOnUserReportButton(String orgName)
	{
		dropdown.SelectUsingVisibleValue(orgDD, orgName);
		wait.waitForElementVisible(userReportButton, 30, 10);
		button.click(userReportButton);
		return new UserReportPage();
	}

	public LicenseSummaryPage clickOnLicenseReportButton(String orgName)
	{
		dropdown.SelectUsingVisibleValue(orgDD, orgName);
		wait.waitForElementVisible(licenseSummaryReportButton, 30, 10);
		button.click(licenseSummaryReportButton);
		return new LicenseSummaryPage();
	}

	/*public void clickOnEditUserButtonWithXpath(String userName)
	{
		try 
		{
			WebElement ele = driver.findElement(By.xpath("//table[@class='rgMasterTable']//td[text()='"+userName+ "']/parent::tr//td[@style='white-space:nowrap;']//input[contains(@id,'imgbtnEdit')]"));
			jse.executeScript("scroll(0, 250);");
			System.out.println(ele);
			List<WebElement> pagination = driver.findElements(By.xpath("//div[@class = 'rgWrap rgNumPart']//a"));
			int s = pagination.size();
			for (int i = 0; i <= s; i++)
			{
				if (ele.isDisplayed())
				{
					log.info("Element Found in List");
					// ele.click();
					jsHelper.scrollIntoViewAndClick(ele);
					log.info("clicked On Element");
					break;
				}
				else
				{
					jsHelper.scrollIntoViewAndClick(nextPageButtonInPagination);
				}
			}
		} catch (Exception e) 
		{
			log.info("Element Not found " + e.getMessage().toString());
		}
	}*/

	public void clickOnEditUserButton(String orgName, String userNameToEdit)
	{
		dropdown.SelectUsingVisibleValue(orgDD, orgName);
		driver.findElement(By.xpath("//table[@class='rgMasterTable']//td[text()='"+userNameToEdit+"']/parent::tr//td[@style='white-space:nowrap;']//input[contains(@id,'imgbtnEdit')]")).click();
	}

	public void searchUserAndClickOnEditButton(String orgName, String userNameToEdit)
	{
		dropdown.SelectUsingVisibleValue(orgDD, orgName);
		textBox.clearAndSendKeys(userNameInput, userNameToEdit);
		button.click(searchButton);
		driver.findElement(By.xpath("//table[@class='rgMasterTable']//td[text()='"+userNameToEdit+"']/parent::tr//td[@style='white-space:nowrap;']//input[contains(@id,'imgbtnEdit')]")).click();
	}

	public void clickOnResetButton()
	{
		button.click(ResetButton);
	}

	public boolean isOrgNotPresentErrorMessageDisplayed()
	{
		return generic.IsElementPresentQuick(errorMessageWhenOrgNotSelected);
	}

}
