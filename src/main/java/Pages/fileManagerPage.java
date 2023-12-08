package Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtility;

public class fileManagerPage {  WebDriver driver;
ElementUtility elementutility;


@FindBy (xpath="//a[i[contains(@class, 'fa-file-text-o')]]")
WebElement fileManager;
@FindBy (xpath="//select[@id='department_id']")
WebElement department;
@FindBy (xpath="//input[@name='xin_file']")
WebElement fileupload;
@FindBy (xpath="(//button[contains(@class, 'btn btn-primary')])[1]")
WebElement save;

public fileManagerPage(WebDriver driver) {
      this.driver = driver;
      this.elementutility = new ElementUtility(driver); 
      PageFactory.initElements(driver, this);
}
      
      public void clickfileManager() {
    	  elementutility.scrollToElement(fileManager);
      	elementutility.clickOnElement(fileManager);
     
      }
     
      public void strdept(String name) {
      	elementutility.selectDrpdown(department, name);
      }
     
      public void clickfileUpload() throws AWTException, InterruptedException{
    	  elementutility.mouseHoverAndClickonElement(fileupload);
        	elementutility.FileUploadUsingRobotClass(driver, "C:\\Users\\USER\\OneDrive\\Desktop\\MyProject\\file1.png");
        }
      public void clicksave() {
      	elementutility.mouseHoverAndClickonElement(save);
      	elementutility.clickOnElement(save);
      }


}
