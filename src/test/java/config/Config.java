package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Config {

    private static String yamlSource = "test-config.yaml";

    @JsonProperty("url")
    String url;

    @JsonProperty("browser")
    String browser;

    @JsonProperty("window size")
    String windowSize;


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
}
