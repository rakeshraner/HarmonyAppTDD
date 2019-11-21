package com.harmony.qa.pages;

import org.openqa.selenium.By;

import com.harmony.qa.base.TestBase;
import com.harmony.qa.constants.Links;
import com.harmony.qa.utility.ButtonHelper;
import com.harmony.qa.utility.GenericHelper;
import com.harmony.qa.utility.NavigationHelper;

public class HomePage extends TestBase
{
	ButtonHelper button=new ButtonHelper();
	GenericHelper generic=new GenericHelper();
	NavigationHelper navigate=new NavigationHelper();

	private By organizationLink=By.xpath("//a[contains(text(),'"+Links.Manage_Organizations.chapter+"')]");
    private By userLink=By.xpath("//a[contains(text(),'"+Links.Manage_Users.chapter+"')]");
    private By trainingLink=By.xpath("//a[contains(text(),'"+Links.WellSky_Training_Site.chapter+"')]");
    private By newsLink=By.xpath("//a[contains(text(),'"+Links.WellSky_News_Management.chapter+"')]");
    private By panelLink=By.xpath("//a[contains(text(),'"+Links.Manage_Panels.chapter+"')]");
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
	
	public void navigationThroughChapters(String inputChapterName)
	{
		Links chapter=Links.valueOf(inputChapterName);
            switch (chapter) 
           {
            case Manage_Organizations:
        		button.click(organizationLink);
        		log.info("Manage Org Link gets clicked and Opened");
        		break;
            case Manage_Users:
        		button.click(userLink);
        		log.info("Manage User Link gets clicked and Opened");
                break;
            case WellSky_Training_Site:
        		button.click(trainingLink);
        		log.info("Training Link gets clicked and Opened");
                break;
            case WellSky_News_Management:
        		button.click(newsLink);
        		log.info("Manage News Link gets clicked and Opened");
                break;
            case Manage_Panels:
        		button.click(panelLink);
        		log.info("Manage Panels Link gets clicked and Opened");
                break;
		}
	}
	
}


