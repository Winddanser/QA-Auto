package ua.kiev.prog.automation.framework.base;

import org.openqa.selenium.By;

public class Locator
{
    private By      _wdLocator;
    private Locator _parent;

    public Locator (String strLocator)
    {
        this._wdLocator = By.xpath(strLocator);
    }

    public Locator (String strLocator, Locator parent)
    {
        this(strLocator);
        this._parent = parent;
    }

    public static Locator create(String strLocator)
    {
        return new Locator(strLocator);
    }

    public Locator createChild (String strLocator)
    {
        return new Locator(strLocator, this);
    }

    public By getWDLocator()
    {
        return this._wdLocator;
    }

    public Locator getParent()
    {
        return this._parent;
    }
}
