package testcase;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Pages.assetsPage;
import Pages.loginPage;
import utilities.ReadExcelData;

public class assetTest extends BaseTest {
	loginPage objLogin;
	assetsPage objasset;
	   
//retryAnalyzer=RetryAnalyzer.class
	public void performLogin(String username, String password) throws InterruptedException {
        objLogin = new loginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        System.out.println("login successful");
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "logdata")
    public void LoginTest(String username, String password) throws InterruptedException {
        performLogin(username, password);
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "logdata", dependsOnMethods = "LoginTest")

        public void AssetTest( String username,String password,String catogory, String name,String assetcode, 
        		              String working,String companyID,String employee,
        		              String prchaseDate, String Invoice,
        		              String manufacture,String Serielnum, String warrenty) throws AWTException, InterruptedException {
    	performLogin(username, password);
        objasset=new assetsPage(driver);
        
        objasset.clickasset();
        objasset.clickassetdrop();
        if (objasset.AlertPresent()) {
            System.out.println("Alert was present. Handled!");}
        objasset.clickadd();;
        objasset.strcatogory(catogory);
        objasset.strassetname(name);
        objasset.strassetcode(assetcode);
        objasset.strworking(working);
        objasset.strcomId(companyID);
        objasset.stremployee(employee);
        String[] parts = prchaseDate.split("-");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];        
        objasset.setpurDate(day, month, year);
        Thread.sleep(4000);
        objasset.strinvoice(Invoice);
        objasset.strmanu(manufacture);
        objasset.strserielnum(Serielnum);
        String[] parts1 = warrenty.split("-");
        String day1 = parts1[0];
        String month1 = parts1[1];
        String year1 = parts1[2];        
        objasset.setwarranty(day1, month1, year1);
        objasset.clickfileUpload();
        objasset.clicksave();
        Thread.sleep(3000);
    
        

}
}
