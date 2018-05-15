package com.tomiyama.noir.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tomiyama.noir.retrofit.Model.APIResponse;
import com.tomiyama.noir.retrofit.Model.PlaceApiService;
import com.tomiyama.noir.retrofit.Model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit mRetrofit;

    private PlaceApiService mService;

    private final String API_KEY = "AIzaSyDonRgMSNGSG_1dF2YehCscx2eHRYp5JZQ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = mRetrofit.create(PlaceApiService.class);

    }

    public void searchMap(View v){

        Call<APIResponse> mResultCall = mService.requestPlaces("34.7024854,135.4937619",750,"restaurant",API_KEY);

        mResultCall.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                // レスポンスからResultのリストを取得
                List<Result> results = response.body().getResults();

                for (Result r : results) {
                    Log.d("name", r.getName() + "\n");
                }

            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {

            }
        });

    }
}
