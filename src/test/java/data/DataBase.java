package data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataBase {


    private static String jsonFile = "src/test/java/data/data.json";
    protected JsonNode jsonNode;

    public void initData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        jsonNode = mapper.readTree(new File(jsonFile));
    }

}