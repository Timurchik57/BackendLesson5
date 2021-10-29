package lesson5.utils;

import lesson5.enums.CategoryType;
import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;



import java.time.Duration;

@UtilityClass
public class RetrofitUtils {

    CategoryType logging = new CategoryType();

    public Retrofit getRetrofit(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofMinutes(1L))
                .addInterceptor(logging.setLevel(CategoryType.Level.BASIC))
                .build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl("http://80.78.248.82:8189/market/api/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
