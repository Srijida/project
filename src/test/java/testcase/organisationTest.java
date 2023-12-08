package testcase;

import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.organisationPage;
import utilities.ReadExcelData;

public class organisationTest extends BaseTest {
    loginPage objLogin;
    organisationPage objorg;

    public void performLogin(String username, String password) throws InterruptedException {
        objLogin = new loginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        System.out.println("login successful");
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
    public void LoginTest(String username, String password) throws InterruptedException {
        performLogin(username, password);
    }

    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata", dependsOnMethods = "LoginTest")
    public void OrganisationTest(String username, String password, String name, String company, String location, String DeptHead) throws InterruptedException {
        performLogin(username, password);
        objorg = new organisationPage(driver);
        objorg.clickorg();
        objorg.clickdept();
        objorg.setName(name);
        objorg.setcomp(company);
        objorg.setloc(location);
        objorg.setdeptHead(DeptHead);
        objorg.clicksave();
    }
}
