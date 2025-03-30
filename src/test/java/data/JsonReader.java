package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import models.LoginCredential;
import utilities.Logs;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    private static final String jsonPath = "src/test/resources/data/loginErrorData.json";

    public static List<LoginCredential> getLoginCredential() {
        final var objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(jsonPath),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, LoginCredential.class));
        } catch (IOException ioException) {
            Logs.error(ioException.getLocalizedMessage());
            throw new RuntimeException();
        }
    }
}
