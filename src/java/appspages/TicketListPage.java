import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class TicketListPage {

    public void addNewTask(){
        log.info("Click Add Task button");
        $x("//button[contains(text(), 'Add Task')]").click();
    }

    public String getListSize(){
        log.info("Get list size");
        return String.valueOf($$x(getStringWithClassName("todoItem_item")).size());
    }

    public SelenideElement checkTaskTitleForItem(int i){
        log.info(("Check title for item ").concat(String.valueOf(i)));
        return $$x("//p[contains(@class,'todoItem_todoText')]").get(i);
    }

    public String checkTaskStatusForItem(int i){
        log.info(("Check status for item ").concat(String.valueOf(i)));
        return $$x(getStringWithClassName("todoItem_item").concat("//div//p"))
                .get(i).getDomAttribute("class");
    }

    public void setTaskStatusForItem(int i){
        log.info(("Set title for item ").concat(String.valueOf(i)));
        $$x(getStringWithClassName("todoItem_svgBox")).get(i).click();
    }

    public void deleteTask(){
        log.info("Click Remove icon");
        $x(getStringWithClassName("todoItem_todoAction").concat("//div[1]")).click();
    }

    public void editTask(){
        log.info("Click Edit icon");
        $x(getStringWithClassName("todoItem_todoAction").concat("//div[2]")).click();
    }

    public SelenideElement getNoToDosElement(){
        log.info("Get element No Todos");
        return $x("//p[text()='No Todos']");
    }

    public void setFilterStatus(String status){
        log.info("Set status {}", status);
        String statusPath = "//select[@id='status']";
        $x(statusPath).click();
        $x(String.format(statusPath.concat("//option[@value='%s']"), status)).click();
    }

    public SelenideElement getValidationInformation(){
        log.info("Get validation information");
        return $x("//div[@role='status']");
    }

    private String getStringWithClassName(String className){
        return String.format("//div[contains(@class,'%s')]", className);
    }
}
