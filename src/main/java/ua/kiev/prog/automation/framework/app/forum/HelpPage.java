package ua.kiev.prog.automation.framework.app.forum;

import ua.kiev.prog.automation.framework.app.forum.blocks.MainMenuBlock;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.PageObject;

public class HelpPage extends PageObject
{
    final public MainMenuBlock mainMenu = new MainMenuBlock();

    @Override
    protected Locator readyLocator() {
        return Locator.create("//li[@id='button_help']//a[contains(@class,'active')]");
    }
}
