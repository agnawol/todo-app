import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$x;

@Slf4j
public class AddUpdateTicketWindowPage {

    public void cancelAddNewTask(){
        log.info("Click Cancel button");
        $x("//button[contains(text(), 'Cancel')]").click();
    }

    public void confirmAddNewTask(){
        log.info("Click Submit button");
        $x("//button[@type='submit']").click();
    }

    public void setTitle(String title){
        log.info("Set title {}", title);
        $x("//input[@id='title']").setValue(title);
    }

    public void setStatus(String status){
        log.info("Set status {}", status);
        String statusPath = "//select[@id='type']";
        $x(statusPath).click();
        $x(String.format(statusPath.concat("//option[@value='%s']"), status)).click();
    }
}
