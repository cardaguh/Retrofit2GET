package com.jikansoftware.retrofitgetsencillo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jikansoftware.retrofitgetsencillo.model.Ip;
import com.jikansoftware.retrofitgetsencillo.services.IpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    Button btnIp;
    TextView tvIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();

        btnIp = findViewById(R.id.button);
        tvIp = findViewById(R.id.tvIp);

        btnIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIpAddress();
            }
        });
    }

    public void getIpAddress(){
        mService.getIp().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                tvIp.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}
