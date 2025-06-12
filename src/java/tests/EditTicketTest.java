import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BrowserConfig;

import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class EditTicketTest {
    private final TicketListPage ticketListPage = new TicketListPage();
    private final AddUpdateTicketWindowPage addUpdateTicketWindowPage = new AddUpdateTicketWindowPage();
    private static final String TITLE = "Task 1";
    private static final String NEW_TITLE = "Task 1 - edited";

    @Before
    public void before(){
        new BrowserConfig().openBrowser();

        ticketListPage.addNewTask();
        addUpdateTicketWindowPage.setTitle(TITLE);
        addUpdateTicketWindowPage.confirmAddNewTask();
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(TITLE));
    }

    @Test
    public void editTicketTest(){
        ticketListPage.editTask();
        addUpdateTicketWindowPage.setTitle(NEW_TITLE);
        addUpdateTicketWindowPage.cancelAddNewTask();
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(TITLE));

        ticketListPage.editTask();
        addUpdateTicketWindowPage.setTitle(NEW_TITLE);
        addUpdateTicketWindowPage.setStatus(Status.COMPLETE.getStatus());
        addUpdateTicketWindowPage.confirmAddNewTask();

        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(NEW_TITLE));
        assertThat(ticketListPage.checkTaskStatusForItem(0)).contains(Status.COMPLETED.getStatus());

        ticketListPage.setTaskStatusForItem(0);
        assertThat(ticketListPage.checkTaskStatusForItem(0)).doesNotContain(Status.COMPLETED.getStatus());
    }

    @After
    public void after(){
        Selenide.closeWebDriver();
    }
}
