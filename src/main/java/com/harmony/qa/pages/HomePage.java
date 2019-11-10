package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.GenericHelper;
import com.harmony.qa.utility.NavigationHelper;

public class HomePage extends TestBase
{
	ButtonHelper button=new ButtonHelper();
	GenericHelper generic=new GenericHelper();
	NavigationHelper navigate=new NavigationHelper();

	private By organizationLink=By.xpath("//a[contains(text(),'Manage Organizations')]");
	private By userLink=By.xpath("//a[contains(text(),'Manage Users')]");
	private By trainingLink=By.xpath("//a[contains(text(),'WellSky Training Site')]");
	private By newsLink=By.xpath("//a[contains(text(),'WellSky News Management')]");
	private By panelLink=By.xpath("//a[contains(text(),'Manage Panels')]");
	private By logo=By.xpath("//img[@src='/_layouts/images/HISTITAN_Images/Mediware_logo.png']");

	public String homePageUrl()
	{
		return navigate.getCurrentUrl();
	}
	
	public OrganizationPage clickOnOrganizationLink()
	{
		button.click(organizationLink);
		return new OrganizationPage();
	}
	
	public UserListPage clickOnUserLink()
	{
		button.click(userLink);
		return new UserListPage();
	}
	
	public TrainingPage clickOnTrainingLink()
	{
		button.click(trainingLink);
		return new TrainingPage();
	}

	public NewsPage clickOnNewsLink()
	{
		button.click(newsLink);
		return new NewsPage();
	}

	public PanelPage clickOnPanelLink()
	{
		button.click(panelLink);
		return new PanelPage();
	}

	public boolean verifyLogo()
	{
		boolean flag=false;
		if(generic.IsElementPresentQuick(logo))
		{
			log.info("User is already logged In");
			flag=true;
		}
		return flag;
	}
	
}
