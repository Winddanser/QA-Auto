package ua.kiev.prog.automation.framework.app.forum;

import ua.kiev.prog.automation.framework.app.forum.blocks.MainMenuLoggedInBlock;
import ua.kiev.prog.automation.framework.app.forum.blocks.category.CategoryListBlock;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.PageObject;

public class MainLoggedInPage extends PageObject
{
    final public MainMenuLoggedInBlock mainMenu = new MainMenuLoggedInBlock();
    final public CategoryListBlock categoryList = new CategoryListBlock();
    @Override
    protected Locator readyLocator() {
        return mainMenu.logout.locator();
    }


}
