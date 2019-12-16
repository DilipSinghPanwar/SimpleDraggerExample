package com.e.simpledraggerexample;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dilip-MavenCluster on 16-12-2019 15:53.
 */
public interface Api {
    @GET("todos")
    Call<List<Todos>> getTodos();
}