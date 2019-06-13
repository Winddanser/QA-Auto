package ua.kiev.prog.automation.framework.app.forum.blocks;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.app.forum.HelpPage;
import ua.kiev.prog.automation.framework.app.forum.MainPage;
import ua.kiev.prog.automation.framework.base.BlockObject;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.widget.GUILink;

public class MainMenuBlock extends BlockObject
{
    final public GUILink homeLink   = new GUILink(this.getLocator().createChild(".//li[@id='button_home']//a"));
    final public GUILink helpLink   = new GUILink(this.getLocator().createChild(".//li[@id='button_help']//a"));
    final public GUILink searchLink = new GUILink(this.getLocator().createChild(".//li[@id='button_search']//a"));
    final public GUILink loginLink  = new GUILink(this.getLocator().createChild(".//li[@id='button_login']//a"));
    final public GUILink regLink    = new GUILink(this.getLocator().createChild(".//li[@id='button_register']//a"));

    public MainMenuBlock ()
    {
        super(Locator.create("//div[@id='main_menu']"));
    }

    public MainPage getMainPage ()
    {
        this.homeLink.click();
        MainPage page = new MainPage();
        page.confirmPage();
        return page;
    }

    public HelpPage getHelpPage ()
    {
        this.helpLink.click();
        HelpPage page = new HelpPage();
        page.confirmPage();
        return page;
    }
}
