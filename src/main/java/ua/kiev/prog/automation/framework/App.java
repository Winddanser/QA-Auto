package ua.kiev.prog.automation.framework;

import ua.kiev.prog.automation.framework.app.forum.LoginPage;
import ua.kiev.prog.automation.framework.app.forum.MainLoggedInPage;
import ua.kiev.prog.automation.framework.app.forum.MainPage;
import ua.kiev.prog.automation.framework.app.forum.TopicListPage;
import ua.kiev.prog.automation.framework.app.forum.blocks.category.BoardItemWidget;
import ua.kiev.prog.automation.framework.base.Session;

public class App
{
    static public void main (String[] args)
    {
        try {
            Session.get().driver().get("https://prog.kiev.ua/forum/index.php");
            MainPage mainPage = new MainPage();
            mainPage.confirmPage();
            mainPage.mainMenu.getHelpPage().mainMenu.getMainPage();
            LoginPage loginPage = mainPage.getLoginPage();
            MainLoggedInPage mainPageLogged = loginPage.login("qaAutomationAccount","135798642");
            TopicListPage topics = mainPageLogged.categoryList.getCategory("Программирование").openBoard("Java SE");
            topics.openTopicByName("Java Start Online ДЗ romanvoznyy");


        } finally {
            Session.get().close();
        }
    }
}
