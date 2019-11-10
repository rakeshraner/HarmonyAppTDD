package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.DropdownHelper;
import com.harmony.qa.utility.GenericHelper;
import com.harmony.qa.utility.TextBoxHelper;

public class AddUserPage extends TestBase
{
	GenericHelper generic=new GenericHelper();
	TextBoxHelper textBox=new TextBoxHelper();
	DropdownHelper dropdown=new DropdownHelper();
	ButtonHelper button=new ButtonHelper();

	private By addNewUserHeader=By.xpath("//td[@title='AddEditUser - My Visual WebPart']");
	private By saveUserButton=By.xpath("//a[contains(@id,'lnkSaveDemoghraphic')]");
	private By cancelUserButton=By.xpath("//a[contains(@id,'lnkCancelDemoghraphic')]");
	private By userNameInput=By.xpath("//input[contains(@id,'txtUserName')]");
	private By passwordInput=By.xpath("//input[contains(@id,'txtPassword')]");
	private By confirmPasswordInput=By.xpath("//input[contains(@id,'txtConfPassword')]");
	private By firstNameInput=By.xpath("//input[contains(@id,'txtFirstName')]");
	private By middleInitialInput=By.xpath("//input[contains(@id,'txtMiddleInit')]");
	private By lastNameInput=By.xpath("//input[contains(@id,'txtLastName')]");
	private By fullNameInput=By.xpath("//input[contains(@id,'txtFullName')]");
	private By emailInput=By.xpath("//input[contains(@id,'txtEmail')]");
	private By addressInput=By.xpath("//textarea[contains(@id,'txtAddress1')]");
	private By changeRequestInput=By.xpath("//textarea[contains(@id,'txtChangeRequester')]");
	private By invoiceInput=By.xpath("//textarea[contains(@id,'txtInvoice')]");
	private By notesInput=By.xpath("//textarea[contains(@id,'txtNotes')]");
	private By workPhoneInput=By.xpath("//input[contains(@id,'txtWorkPhone')]");
	private By homePhoneInput=By.xpath("//input[contains(@id,'txtHomePhone')]");
	private By stateDropdown=By.xpath("//select[contains(@id,'ddlState')]");
	private By townDropdown=By.xpath("//select[contains(@id,'ddlCity')]");
	private By zipDropdown=By.xpath("//select[contains(@id,'ddlZipCode')]");
	private By userSavedSuccessfullyMessage=By.xpath("//span[contains(@id,'lblSuccessMessage')]");


	public void addNewUser(String uName, String pass, String cPass, String fName, String lName, String mName, String fullName, String eMail, 
			String addrs, String notes, String requestPerson, String state, String town, String zip, String workPhone, String homePhone, String invoice)
	{
		textBox.clearAndSendKeys(userNameInput, uName);
		textBox.clearAndSendKeys(passwordInput, pass);
		textBox.clearAndSendKeys(confirmPasswordInput, cPass);
		textBox.clearAndSendKeys(firstNameInput, fName);
		textBox.clearAndSendKeys(lastNameInput, lName);
		textBox.clearAndSendKeys(middleInitialInput, mName);
		textBox.clearAndSendKeys(fullNameInput, fullName);
		textBox.clearAndSendKeys(emailInput, eMail);
		textBox.clearAndSendKeys(addressInput, addrs);
		dropdown.SelectUsingValue(stateDropdown, state);
		dropdown.SelectUsingValue(townDropdown, town);
		dropdown.SelectUsingValue(zipDropdown, zip);
		textBox.clearAndSendKeys(workPhoneInput, workPhone);
		textBox.clearAndSendKeys(homePhoneInput, homePhone);
		textBox.clearAndSendKeys(changeRequestInput, requestPerson);
		textBox.clearAndSendKeys(invoiceInput, invoice);
		textBox.clearAndSendKeys(notesInput, notes);
		button.click(saveUserButton);	
	}
	
	public void addNewUser()
	{
		button.click(saveUserButton);
	}
	
	public void clickOnCancelButton()
	{
		button.click(cancelUserButton);
	}

	public boolean isUserSavedSuccessfullyMessageDisplayed()
	{
		return generic.IsElementPresentQuick(userSavedSuccessfullyMessage);
	}
	
	public boolean isAddNewUserHeaderDisplayed()
	{
		return generic.IsElementPresentQuick(addNewUserHeader);
	}
	
}
