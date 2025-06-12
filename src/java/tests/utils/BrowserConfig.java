package utils;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Configuration.baseUrl;

@Slf4j
public class BrowserConfig {

    public void openBrowser() {
        log.info("Open browser");
        baseUrl = "https://wc-react-todo-app.netlify.app/";
        Selenide.open(baseUrl);
    }
}
