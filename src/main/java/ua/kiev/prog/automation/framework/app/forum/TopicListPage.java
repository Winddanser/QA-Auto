package ua.kiev.prog.automation.framework.app.forum;

import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.PageObject;
import ua.kiev.prog.automation.framework.base.widget.GUILink;

public class TopicListPage extends PageObject
{

    @Override
    protected Locator readyLocator() {
        return Locator.create("//div[@id='messageindex']");
    }

    final public TopicPage openTopicByName (String topicName)
    {
        GUILink link = new GUILink(this.readyLocator().createChild(".//td[contains(@class, 'subject')]//span[contains(@id, 'msg_')]/a[text()='"+topicName+"']"));
        link.click();
        return new TopicPage();
    }
}
