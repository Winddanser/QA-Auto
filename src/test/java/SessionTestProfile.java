import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.framework.app.forum.LoginPage;
import ua.kiev.prog.automation.framework.app.forum.MainLoggedInPage;
import ua.kiev.prog.automation.framework.app.forum.MainPage;
import ua.kiev.prog.automation.framework.base.Session;

public class SessionTestProfile extends Assert {
    private String _url = "https://prog.kiev.ua/forum/index.php";
    private String _log = "winddanser@gmail.com";
    private String ActRessEM = "winddanser@gmail.com";
    private String _EmaillURI = "//div[@class='content']//em";
    private String _RegDatURI = "//dl[@class='noborder']//dd[1]";
    private String _RegDat = "Января 25, 2019, 08:56:05 pm";
    private String _pass = "P0K8U7W2indForum";

    @BeforeTest
    public void setup() {

    }

    @Test(priority = 0)
    public void closeTest() {
        Session.get().driver().get(_url);
        Session.get().close();
    }

    @Test(priority = 1)
    public void smokeTestProfile() {
        Session.get().driver().get(_url);
        MainPage mainPage = new MainPage();
        //  mainPage.confirmPage();
//        mainPage.mainMenu.getHelpPage().mainMenu.getMainPage();
        LoginPage loginPage = mainPage.getLoginPage();
        loginPage.login(_log, _pass);
        MainLoggedInPage loggInPage = new MainLoggedInPage();
        // loggInPage.confirmPage();
        loggInPage.mainMenu.getPrivateMessag().mainMenu.getMainPage();
        //  loggInPage.confirmPage();
        loggInPage.mainMenu.getProffPage();
        //AssertEquales(_EmaillURI,"_ActRessEM");
        System.out.println(Session.get().driver().findElement(By.xpath(_EmaillURI)).getText());
        assertEquals(Session.get().driver().findElement(By.xpath(_EmaillURI)).getText(), ActRessEM);
        System.out.println(Session.get().driver().findElement(By.xpath(_RegDatURI)).getText());
        assertEquals(Session.get().driver().findElement(By.xpath(_RegDatURI)).getText(), _RegDat);
//        System.out.println();
        Session.get().close();
    }




}



