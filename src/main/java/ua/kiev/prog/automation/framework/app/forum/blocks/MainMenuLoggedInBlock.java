package ua.kiev.prog.automation.framework.app.forum.blocks;

import ua.kiev.prog.automation.framework.app.forum.PrivateMessag;
import ua.kiev.prog.automation.framework.app.forum.ProffPage;
import ua.kiev.prog.automation.framework.base.widget.GUILink;

public class MainMenuLoggedInBlock extends MainMenuBlock
{
    final public GUILink profile          = new GUILink(this.getLocator().createChild(".//li[@id='button_profile']//a"));
    final public GUILink privateMessages  = new GUILink(this.getLocator().createChild(".//li[@id='button_pm']//a"));
    final public GUILink users            = new GUILink(this.getLocator().createChild(".//li[@id='button_mlist']//a"));
    final public GUILink logout           = new GUILink(this.getLocator().createChild(".//li[@id='button_logout']//a"));


    public MainMenuLoggedInBlock()
    {
        super();
    }

    public ProffPage getProffPage ()
    {
        this.profile.click();
        ProffPage page = new ProffPage();
        //  page.confirmPage();
        return page;
    }
    public PrivateMessag getPrivateMessag(){
        this.privateMessages.click();
        PrivateMessag page = new PrivateMessag();
        return page;

    }
}
