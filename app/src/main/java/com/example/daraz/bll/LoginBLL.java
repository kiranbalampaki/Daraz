package com.example.daraz.bll;

import com.example.daraz.api.UserAPI;
import com.example.daraz.server_response.SignUpResponse;
import com.example.daraz.url.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Url;

public class LoginBLL {
    boolean isSuccessful = false;

    public boolean checkUser(String phone, String password) {

        UserAPI usersAPI = URL.getInstance().create(UserAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.checkUser(phone, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful()) {
                URL.token += loginResponse.body().getToken();
                isSuccessful = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }
}
