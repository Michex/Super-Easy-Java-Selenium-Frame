package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Config {

    private static String yamlSource = "test-config.yaml";

    @JsonProperty("url")
    String url;

    @JsonProperty("browser")
    String browser;

    @JsonProperty("window size")
    String windowSize;

    @JsonProperty("implicitly wait")
    int waitTime;

    @JsonProperty("selenium server")
    Map<String, String> seleniumServer;

    public static Config initConfig() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(yamlSource), Config.class);
    }

    public String getUrl() {
        return url;
    }


    public String getBrowser() {
        return browser;
    }

    public String getWindowSize() {
        return windowSize;
    }

    public String getSeleniumUrl() {
        String seleniumUrl = seleniumServer.get("url");
        return seleniumUrl;
    }

    public String getSeleniumPort() {
        String seleniumPort = seleniumServer.get("port");
        return seleniumPort;
    }

    public int getWaitTime() {
        return waitTime;
    }
}
