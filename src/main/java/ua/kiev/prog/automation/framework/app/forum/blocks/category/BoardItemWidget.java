package ua.kiev.prog.automation.framework.app.forum.blocks.category;

import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.Widget;
import ua.kiev.prog.automation.framework.base.widget.GUILink;

public class BoardItemWidget extends Widget
{
    public BoardItemWidget(Locator locator) {
        super(locator);
    }

    final public GUILink name ()
    {
        return new GUILink(this.locator().createChild("./td[@class='info']//a"));
    }
}
