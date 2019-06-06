package ua.kiev.prog.automation.framework.app.forum.blocks.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.base.BlockObject;
import ua.kiev.prog.automation.framework.base.Locator;

import java.util.ArrayList;
import java.util.List;

public class CategoryListBlock extends BlockObject
{
    public CategoryListBlock() {
        super(Locator.create("//div[@id='boardindex_table']"));
    }

    final public CategoryBoardBlock getCategory (String name)
    {
        return new CategoryBoardBlock(Locator.create("//tbody[contains(@class,'header')]//a[normalize-space()='"+name+"']//ancestor::tbody/following-sibling::tbody[1]"));
    }
}
