import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BrowserConfig;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


@Slf4j
public class DeleteTicketTest {
    private final TicketListPage ticketListPage = new TicketListPage();
    private final AddUpdateTicketWindowPage addUpdateTicketWindowPage = new AddUpdateTicketWindowPage();

    @Before
    public void before(){
        new BrowserConfig().openBrowser();
        String title = "Task 1";

        ticketListPage.addNewTask();
        addUpdateTicketWindowPage.setTitle(title);
        addUpdateTicketWindowPage.confirmAddNewTask();
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(title));
    }

    @Test
    public void deleteTicketTest() {

        ticketListPage.deleteTask();
        ticketListPage.getNoToDosElement().shouldBe(visible);
    }

    @After
    public void after(){
        Selenide.closeWebDriver();
    }
}
