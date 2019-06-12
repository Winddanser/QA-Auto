package ua.kiev.prog.automation.framework.app.forum;

import ua.kiev.prog.automation.framework.app.forum.blocks.MainMenuBlock;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.PageObject;

public class ProffPage extends PageObject {
    final public MainMenuBlock mainMenu = new MainMenuBlock();
    @Override
    protected Locator readyLocator() {
        return Locator.create("//li[@id='button_profile']//a[contains(@class,'active')]");
    }
}
