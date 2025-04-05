package pl.goral.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import pl.goral.config.ConfigProvider;

public abstract class BaseApi {

    protected static final MediaType JSON_MEDIA_TYPE = MediaType.get("application/json");
    protected static final OkHttpClient CLIENT = new OkHttpClient();
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected static String apiUrl(String endpoint) {
        return ConfigProvider.get("backend.url") + endpoint;
    }
}
