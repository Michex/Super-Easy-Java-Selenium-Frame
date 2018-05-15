package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Config {

    private static String yamlSource = "src/test/java/config/test-config.yaml";

    @JsonProperty("url")
    String url;


    public static Config initConfig() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(yamlSource), Config.class);
    }

    public String getUrl() {
        return url;
    }



}
