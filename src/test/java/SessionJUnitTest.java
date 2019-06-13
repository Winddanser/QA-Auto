import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.kiev.prog.automation.framework.app.forum.LoginPage;
import ua.kiev.prog.automation.framework.app.forum.MainLoggedInPage;
import ua.kiev.prog.automation.framework.app.forum.MainPage;
import ua.kiev.prog.automation.framework.app.forum.TopicListPage;
import ua.kiev.prog.automation.framework.base.Session;

public class SessionJUnitTest extends Assert
{
    private String _url = "https://www.google.com.ua/";

    @Before
    public void setup ()
    {

    }

    @Test
    public void smokeTest() {
        Session.get().driver().get("https://prog.kiev.ua/forum/index.php");
        MainPage mainPage = new MainPage();
        mainPage.confirmPage();
        mainPage.mainMenu.getHelpPage().mainMenu.getMainPage();
        LoginPage loginPage = mainPage.getLoginPage();
        MainLoggedInPage mainPageLogged = loginPage.login("qaAutomationAccount","135798642");
        TopicListPage topics = mainPageLogged.categoryList.getCategory("Программирование").openBoard("Java SE");
//        topics.openTopicByName("Java Start Online ДЗ romanvoznyy");
    }

    @Test
    public void closeTest() {
        // Создаем новую сессию
        Session session = Session.get();
        // Загружаем URL
        session.driver().get(this._url);
        // Закрываем сессию
        session.close();
        // Проверяем что загруженный URL не соответствует ожидаемому
        // При вызове session.driver() драйвер откроется заново
        assertNotEquals(this._url, session.driver().getCurrentUrl());
        // Закрываем сессию
        session.close();
    }
    @After
    public void after(){
        Session.get().close();
    }

}