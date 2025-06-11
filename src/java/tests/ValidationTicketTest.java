import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.BrowserConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Slf4j
public class ValidationTicketTest {
    private final TicketListPage ticketListPage = new TicketListPage();
    private final AddUpdateTicketWindowPage addUpdateTicketWindowPage = new AddUpdateTicketWindowPage();

    @Before
    public void before(){
        new BrowserConfig().openBrowser();
    }

    @Test
    public void validationTicketTest(){

        String title = "Task 1";

        ticketListPage.addNewTask();
        addUpdateTicketWindowPage.confirmAddNewTask();
        checkValidation("Please enter a title");

        addUpdateTicketWindowPage.setTitle(title);
        addUpdateTicketWindowPage.confirmAddNewTask();
        checkValidation("Task added successfully");

        ticketListPage.editTask();
        addUpdateTicketWindowPage.confirmAddNewTask();
        checkValidation("No changes made");

        addUpdateTicketWindowPage.setTitle("Title updated");
        addUpdateTicketWindowPage.confirmAddNewTask();
        checkValidation("Task Updated successfully");

        ticketListPage.deleteTask();
        checkValidation("Todo Deleted Successfully");
    }

    private void checkValidation(String validationText){
        ticketListPage.getValidationInformation().shouldHave(text(validationText));
        ticketListPage.getValidationInformation().shouldNotBe(visible);
    }

    @After
    public void after(){
        Selenide.closeWebDriver();
    }
}
