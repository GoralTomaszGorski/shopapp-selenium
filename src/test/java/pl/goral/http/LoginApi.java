package pl.goral.http;

import lombok.SneakyThrows;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pl.goral.http.dto.LoginRequestDto;
import pl.goral.http.dto.LoginResponseDto;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.goral.config.ConfigProvider.get;
import static pl.goral.http.ObjectMapperProvider.getObjectMapper;

public class LoginApi extends BaseApi {

    private static final String SIGNIN_URL = apiUrl("/users/signin");

    @SneakyThrows
    public static String login(String username, String password) {

        LoginRequestDto loginRequestDto = getLoginRequestDto(username, password);
        String body = getObjectMapper().writeValueAsString(loginRequestDto);

        Request request = new Request.Builder()
                .url(SIGNIN_URL)
                .post(RequestBody.create(body, JSON_MEDIA_TYPE))
                .build();
        try (Response response = getClient().newCall(request).execute()) {
            assertThat(response.code()).isEqualTo(200);
            return extractTokenFrom(response);
        }
    }

    @SneakyThrows
    private static String extractTokenFrom(Response response) {
        String responseBody = response.body().string();
        LoginResponseDto loginResponseDto = getObjectMapper().readValue(responseBody, LoginResponseDto.class);
        return loginResponseDto.getToken();
    }

    private static LoginRequestDto getLoginRequestDto(String username, String password) {
        return LoginRequestDto.builder()
                .username(username)
                .password(password)
                .build();
    }

}
