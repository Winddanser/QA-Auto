package ua.kiev.prog.automation.framework.app.forum.blocks;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.app.forum.HelpPage;
import ua.kiev.prog.automation.framework.app.forum.MainPage;
import ua.kiev.prog.automation.framework.base.BlockObject;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.widget.GUILink;

public class MainMenuBlock extends BlockObject
{
    final protected GUILink _homeLink   = new GUILink(this.getLocator().createChild(".//li[@id='button_home']//a"));
    final protected GUILink _helpLink   = new GUILink(this.getLocator().createChild(".//li[@id='button_help']//a"));
    final protected GUILink _searchLink = new GUILink(this.getLocator().createChild(".//li[@id='button_search']//a"));
    final protected GUILink _loginLink  = new GUILink(this.getLocator().createChild(".//li[@id='button_login']//a"));
    final protected GUILink _regLink    = new GUILink(this.getLocator().createChild(".//li[@id='button_register']//a"));

    public MainMenuBlock ()
    {
        super(Locator.create("//div[@id='main_menu']"));
    }

    public MainPage getMainPage ()
    {
        this._homeLink.click();
        MainPage page = new MainPage();
        page.confirmPage();
        return page;
    }

    public HelpPage getHelpPage ()
    {
        this._helpLink.click();
        HelpPage page = new HelpPage();
        page.confirmPage();
        return page;
    }
}
