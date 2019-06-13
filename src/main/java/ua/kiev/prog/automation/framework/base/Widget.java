package ua.kiev.prog.automation.framework.base;

import jdk.nashorn.internal.runtime.linker.JavaAdapterServices;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;

public class Widget {
    final private Locator _locator;

    public Widget(Locator locator) {
        this._locator = locator;
    }

    final public Locator locator() {
        return this._locator;
    }

    final protected WebDriver driver() {
        return Session.get().driver();
    }

    final public WebElement element() {
        return this.element(Timeouts.DEF_TIMEOUT_WIDGET_WAIT);
    }
    final public WebElement element(int timeoutSeconds) {
        final SearchContext context = getLocatorContext(this._locator);
        WebDriverWait wait = new WebDriverWait(Session.get().driver(), timeoutSeconds);
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

    static private SearchContext getLocatorContext(Locator locator) {
        SearchContext result;
        if (locator.getParent() == null) {
            result = Session.get().driver();
        } else {
            SearchContext parentContext = getLocatorContext(locator.getParent());
            result = parentContext.findElement(locator.getParent().getWDLocator());
        }
        return result;
    }

    final protected void waitAction() {
        try {
            Thread.sleep(Timeouts.DEF_TIMEOUT_WIDGET_ACTION_WAIT);
        } catch (Throwable e) { /* Ignore */ }
    }

    final public String getText() {
        // trim() - обрезает у троки пробелы по краям
        return this.element().getText().trim();
    }

    private JavascriptExecutor _executor;

    final protected JavascriptExecutor executor() {
        if (this._executor == null)
            this._executor = (JavascriptExecutor) this.driver();
        return this._executor;
    }

    final protected WebElement scrollToElement() {
        WebElement element = this.element();
        this.executor().executeScript("arguments[0].scrollIntoView(false);", element);
        return element;
    }


    final public void moveCursorToElement() {
        this.scrollToElement();
        this.dispatchMouseEvent("mouseenter");
        this.dispatchMouseEvent("mouseover");
    }

    final public void moveCursorOut() {
        this.scrollToElement();
        this.dispatchMouseEvent("mouseleave");
        this.dispatchMouseEvent("mouseout");
    }


    private void dispatchMouseEvent(String eventName) {
        this.executor().executeScript(
                "var e = document.createEvent('Events');" +
                        "e.initEvent('" + eventName + "',true,false);" +
                        "arguments[0].dispatchEvent(e);",
                this.element()
        );
    }
    final public boolean isExist(){
        return this.isExist(Timeouts.DEF_TIMEOUT_WIDGET_WAIT);
    }
    final public boolean isExist(int timeoutSeconds){
        boolean exists=false;
        long endTime =Instant.now().getEpochSecond()+timeoutSeconds;
        while (true){
            try{
                this.element(0);
                exists=true;
            }catch (Throwable e){/*Ignore*/}
            if (exists||endTime<=Instant.now().getEpochSecond())
                break;
            try {
                Thread.sleep(500);
            }catch (Throwable e){/*Ignore*/}
        }
        return exists;
    }

}
