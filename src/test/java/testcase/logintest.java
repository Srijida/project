package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilities.ReadExcelData;
import Pages.loginPage;
@Listeners(generalTest.ListenerTestNG.class)
public class logintest extends BaseTest {
    loginPage objLogin;
   

    @Test(dataProviderClass=ReadExcelData.class, dataProvider="testdata")
    
    public void LoginTest(String username, String password) throws InterruptedException {
        objLogin = new loginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        String welcome= objLogin.getText();
        System.out.println(welcome);
    
        
    }
}
