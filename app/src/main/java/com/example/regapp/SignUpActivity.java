package com.example.regapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private AppCompatEditText nameUser,emailUser,pass1,pass2;
    private AppCompatButton register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameUser=findViewById(R.id.nameUser);
        emailUser=findViewById(R.id.nameEMail);
        pass1=findViewById(R.id.pass1);
        pass2=findViewById(R.id.pass2);
        register=findViewById(R.id.registerUser);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass1.getText().toString().equals(pass2.getText().toString()))
                {
                    Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.URL).
                            addConverterFactory(GsonConverterFactory.create()).build();
                    APIService service=retrofit.create(APIService.class);
                    Call<Result> call=service.registerUser(nameUser.getText().toString(),
                            emailUser.getText().toString(),
                            pass1.getText().toString());
                    call.enqueue(new Callback<Result>() {
                        @Override
                        public void onResponse(Call<Result> call, Response<Result> response) {
                            Toast.makeText(SignUpActivity.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Result> call, Throwable t) {
                            Toast.makeText(SignUpActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(SignUpActivity.this,"Пароли не равны",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}