package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;
import utilities.WaitUtility;

public class attendancePage {
	 WebDriver driver;
	 ElementUtility elementutility;
	 WaitUtility wait;
	 
	  
	  @FindBy (xpath="//a[span[text()='Timesheet']]")
	  WebElement timesheet;
	  @FindBy (xpath="//a[@href='https://hrm.qabible.in/hrms/admin/timesheet/attendance']")
	  WebElement attendance;
	  @FindBy (xpath="//input[@placeholder='Select Date']")
	  WebElement date;	
	  @FindBy (xpath="//button[@class='btn btn-primary save']")
	  WebElement get;
	  @FindBy (xpath="//input[@type='search']")
	  WebElement search;
	  public attendancePage(WebDriver driver) {
	        this.driver = driver;
	        this.elementutility = new ElementUtility(driver); 
	        PageFactory.initElements(driver, this);
	  }
	  public void clicktimesheet() {
		  elementutility.clickOnElement(timesheet);
	  }
	public void clickattendance() {
		  elementutility.clickOnElement(attendance);
	  }
	 public void strdate(String day, String month, String year) {
		 elementutility.enterDate(date, day, month, year);
	 } 
	 public void clickget() {
		  elementutility.clickOnElement(get);
	  }
	 public void clicksearch() {
		  elementutility.clickOnElement(search);
	  }
	 
	  
	        
}
