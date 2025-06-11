import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.BrowserConfig;

import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class AddTicketTest {
    private final TicketListPage ticketListPage = new TicketListPage();
    private final AddUpdateTicketWindowPage addUpdateTicketWindowPage = new AddUpdateTicketWindowPage();

    @Before
    public void before(){
        new BrowserConfig().openBrowser();
    }

    @Test
    public void addNewTicketTest(){

        String title = "Task 1";

        ticketListPage.addNewTask();
        addUpdateTicketWindowPage.cancelAddNewTask();

        ticketListPage.addNewTask();
        addUpdateTicketWindowPage.setTitle(title);
        addUpdateTicketWindowPage.confirmAddNewTask();
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(title));
        assertThat(ticketListPage.checkTaskStatusForItem(0)).doesNotContain(Status.COMPLETED.getStatus());
    }

    @After
    public void after(){
        Selenide.closeWebDriver();
    }
}
