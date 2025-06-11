package utils;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BrowserConfig {

    public void openBrowser(){
        log.info("Open browser");
        Selenide.open("https://wc-react-todo-app.netlify.app/");
    }
}
