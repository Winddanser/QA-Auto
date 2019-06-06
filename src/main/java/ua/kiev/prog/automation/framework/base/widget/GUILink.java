package ua.kiev.prog.automation.framework.base.widget;

import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.Widget;

public class GUILink extends Widget
{
    public GUILink(Locator locator) {
        super(locator);
    }

    public void click ()
    {
        this.element().click();
        this.waitAction();
    }
}
