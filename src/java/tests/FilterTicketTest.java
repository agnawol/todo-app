import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BrowserConfig;

import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class FilterTicketTest {
    private final TicketListPage ticketListPage = new TicketListPage();
    private final AddUpdateTicketWindowPage addUpdateTicketWindowPage = new AddUpdateTicketWindowPage();
    private static final String TITLE_1 = "Task 1";
    private static final String TITLE_2 = "Task 2";
    private static final String TITLE_3 = "Task 3";
    private static final String TITLE_4 = "Task 4";

    @Before
    public void before(){
        new BrowserConfig().openBrowser();
        addTask(TITLE_1, 0, false);
        addTask(TITLE_2, 1, false);
        addTask(TITLE_3, 2, true);
        addTask(TITLE_4, 3, true);
    }

    @Test
    public void filterTicketTest(){
        checkTwoFirstListItems();
        ticketListPage.checkTaskTitleForItem(2).shouldHave(text(TITLE_3));
        ticketListPage.checkTaskTitleForItem(3).shouldHave(text(TITLE_4));

        ticketListPage.setFilterStatus(Status.COMPLETE.getStatus());
        assertThat(ticketListPage.getListSize()).isEqualTo("2");
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(TITLE_3));
        ticketListPage.checkTaskTitleForItem(1).shouldHave(text(TITLE_4));
        ticketListPage.checkTaskTitleForItem(0).shouldNotHave(text(TITLE_1));
        ticketListPage.checkTaskTitleForItem(1).shouldNotHave(text(TITLE_2));

        ticketListPage.setFilterStatus(Status.INCOMPLETE.getStatus());
        assertThat(ticketListPage.getListSize()).isEqualTo("2");
        checkTwoFirstListItems();
        ticketListPage.checkTaskTitleForItem(0).shouldNotHave(text(TITLE_3));
        ticketListPage.checkTaskTitleForItem(1).shouldNotHave(text(TITLE_4));

        String firstItemOnListTitle = ticketListPage.checkTaskTitleForItem(0).getText();
        ticketListPage.setTaskStatusForItem(0);
        ticketListPage.setFilterStatus(Status.INCOMPLETE.getStatus());
        assertThat(ticketListPage.getListSize()).isEqualTo("1");

        ticketListPage.setFilterStatus(Status.COMPLETE.getStatus());
        assertThat(ticketListPage.getListSize()).isEqualTo("3");
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(firstItemOnListTitle));
    }

    private void addTask(String title, int itemNumber, boolean changeStatus){
        ticketListPage.addNewTask();
        addUpdateTicketWindowPage.setTitle(title);
        if(changeStatus){
            addUpdateTicketWindowPage.setStatus(Status.COMPLETE.getStatus());
        }
        addUpdateTicketWindowPage.confirmAddNewTask();
        ticketListPage.checkTaskTitleForItem(itemNumber).shouldHave(text(title));
    }

    private void checkTwoFirstListItems(){
        ticketListPage.checkTaskTitleForItem(0).shouldHave(text(TITLE_1));
        ticketListPage.checkTaskTitleForItem(1).shouldHave(text(TITLE_2));
    }

    @After
    public void after(){
        Selenide.closeWebDriver();
    }
}
