package ua.kiev.prog.automation.framework.app.forum.blocks.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.app.forum.TopicListPage;
import ua.kiev.prog.automation.framework.base.BlockObject;
import ua.kiev.prog.automation.framework.base.Locator;

import java.util.ArrayList;
import java.util.List;

public class CategoryBoardBlock extends BlockObject
{
    final private List<BoardItemWidget> _list = new ArrayList<>();

    public CategoryBoardBlock(Locator locator) {
        super(locator);
        WebElement category = this.driver().findElement(locator.getWDLocator());
        List<WebElement> elements = category.findElements(By.xpath("./tr"));
        for (int i = 1; i <= elements.size(); i ++) {
            this._list.add(new BoardItemWidget(locator.createChild("./tr["+i+"]")));
        }
    }

    final public List<BoardItemWidget> getBoardItems ()
    {
        return this._list;
    }

    final public BoardItemWidget findBoard (String name)
    {
        BoardItemWidget result = null;
        for (BoardItemWidget item : _list) {
            if (item.name().getText().equals(name)) {
                result = item;
                break;// Прерывает выполнение цикла
            }
        }
        return result;
    }

    final public TopicListPage openBoard (String name)
    {
        this.findBoard(name).name().click();
        return new TopicListPage();
    }

}
