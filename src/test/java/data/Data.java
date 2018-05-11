package data;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

import java.io.File;
import java.io.IOException;

public class Data {

    static class Config {
        @JsonProperty("Url")
        String url;
    }

    static class TestData {
        @JsonProperty("searchValue")
        String searchValue;
    }

    public static Data get() throws JsonParseException, JsonMappingException,  IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/test/java/data/data.json"), Data.class);

    }

    public String getUrl() {
        return url;
    }

    public String getSearchValue() {
        return searchValue;
        }
}