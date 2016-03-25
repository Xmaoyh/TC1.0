package com.example.tcwl_manage.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by suanzi on 2016/3/24.
 */
public final class RetrofitUtil{

    public final String URL="http://192.168.199.110:8080/mockjs/1/";
    private Retrofit retrofit;

    public <T> T create(final Class<T> service){
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return  retrofit.create(service);
    }

    private OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            okhttp3.Response response = chain.proceed(chain.request());
            ResponseBody body = response.body();
            BufferedSource source = Okio.buffer(new ForwardingSource(body.source()) {
                @Override
                public long read(Buffer sink, long byteCount) throws IOException {
                    throw new IOException("cause");
                }
            });
            body = ResponseBody.create(body.contentType(), body.contentLength(), source);
            return response.newBuilder().body(body).build();
        }
    }).build();

}
