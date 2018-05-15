package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Config;

import java.io.File;
import java.io.IOException;


public class TestData {

    private static String yamlSource = "src/test/java/data/testData.yaml";
    public String searchValue;


    @JsonProperty("searchValue")
    public String getSearchData() {
        return searchValue;
    }

    public static TestData initTestData() throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(yamlSource), TestData.class);

    }


}
