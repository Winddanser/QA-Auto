package ua.kiev.prog.automation.framework.base.widget;

import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.Widget;

public class GUIButton extends Widget
{
    public GUIButton(Locator locator) {
        super(locator);
    }

    public void click ()
    {
        this.element().click();
        this.waitAction();
    }
}
