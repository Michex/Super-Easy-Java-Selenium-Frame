package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;


public class SearchValuesData {

    private static String yamlSource = "src/test/java/data/searchValues.yaml";


    @JsonProperty("searchValue1")
    String searchValue1;

    @JsonProperty("searchValue2")
    String searchValue2;

    @JsonProperty("searchValue3")
    String searchValue3;

    public static SearchValuesData initTestData() throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(yamlSource), SearchValuesData.class);

    }

    public String getSearchValue1() {
        return searchValue1;
    }

    public String getSearchValue2() {
        return searchValue2;
    }

    public String getSearchValue3() {
        return searchValue3;
    }
}
