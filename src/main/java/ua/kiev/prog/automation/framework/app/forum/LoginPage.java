package ua.kiev.prog.automation.framework.app.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.base.Locator;
import ua.kiev.prog.automation.framework.base.PageObject;
import ua.kiev.prog.automation.framework.base.widget.GUIButton;
import ua.kiev.prog.automation.framework.base.widget.GUITextBox;

public class LoginPage extends PageObject
{
    final private GUITextBox _username = new GUITextBox(Locator.create("//input[@name='user']"));
    final private GUITextBox _password = new GUITextBox(Locator.create("//input[@name='passwrd']"));

    final private GUIButton _loginButton = new GUIButton(Locator.create("//input[@type='submit']"));

    @Override
    final protected Locator readyLocator() {
        return _password.locator();
    }

    final public MainLoggedInPage login (String username, String password)
    {
        this._username.setValue(username);
        this._password.setValue(password);
        this._loginButton.click();

        return new MainLoggedInPage();
    }
}
