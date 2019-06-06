package ua.kiev.prog.automation.framework.base.widget;

import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.Widget;

public class GUITextBox extends Widget
{
    public GUITextBox(Locator locator) {
        super(locator);
    }

    final public void setValue (String value)
    {
        this.element().clear();
        this.element().sendKeys(value);
        this.waitAction();
    }
}
