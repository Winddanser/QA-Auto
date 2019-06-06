package ua.kiev.prog.automation.framework.base;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Widget
{
    final private Locator _locator;

    public Widget (Locator locator)
    {
        this._locator = locator;
    }

    final public Locator locator ()
    {
        return this._locator;
    }

    final protected WebDriver driver ()
    {
        return Session.get().driver();
    }

    final public WebElement element ()
    {
        final SearchContext context = getLocatorContext(this._locator);
        WebDriverWait wait = new WebDriverWait(Session.get().driver(), Timeouts.DEF_TIMEOUT_WIDGET_WAIT);
        wait.until(d -> {
            List<WebElement> list = context.findElements(this._locator.getWDLocator());
            return list.size() != 0;
        });
        Locator temp = this._locator;
        while (temp.getParent() != null) {
            temp = temp.getParent();
            System.out.print(this._locator.getWDLocator().toString() + " <- ");
        }
        System.out.println(temp.getWDLocator().toString());
        return context.findElement(this._locator.getWDLocator());
    }

    static private SearchContext getLocatorContext (Locator locator)
    {
        SearchContext result;
        if (locator.getParent() == null) {
            result = Session.get().driver();
        } else {
            SearchContext parentContext = getLocatorContext(locator.getParent());
            result = parentContext.findElement(locator.getParent().getWDLocator());
        }
        return result;
    }

    final protected void waitAction ()
    {
        try { Thread.sleep(Timeouts.DEF_TIMEOUT_WIDGET_ACTION_WAIT); } catch (Throwable e) { /* Ignore */ }
    }

    final public String getText ()
    {
        // trim() - обрезает у троки пробелы по краям
        return this.element().getText().trim();
    }

}
