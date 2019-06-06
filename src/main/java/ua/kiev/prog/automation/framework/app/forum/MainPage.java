package ua.kiev.prog.automation.framework.app.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.app.forum.blocks.MainMenuBlock;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.PageObject;
import ua.kiev.prog.automation.framework.base.widget.GUILink;

public class MainPage extends PageObject
{
    final public MainMenuBlock mainMenu = new MainMenuBlock();

    private GUILink _loginLink = new GUILink(Locator.create("//div[@class='user_block']//a[text()='войдите']"));

    @Override
    protected Locator readyLocator() {
        return Locator.create("//li[@id='button_home']//a[contains(@class,'active')]");
    }

    final public LoginPage getLoginPage ()
    {
        _loginLink.click();
        return new LoginPage();
    }
}
