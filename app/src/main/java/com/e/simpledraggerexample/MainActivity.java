package com.e.simpledraggerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    //injecting retrofit
    @Inject
    Retrofit retrofit;
    ListView listView;
    @Inject
    Add add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getNetComponent().inject(this);
        listView = findViewById(R.id.listViewHeroes);
        Toast.makeText(this, add.Sum(10, 20) + "", Toast.LENGTH_SHORT).show();
        getTodos();
    }

    private void getTodos() {
        Api api = retrofit.create(Api.class);
        Call<List<Todos>> call = api.getTodos();
        call.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                List<Todos> heroList = response.body();
                String[] heroes = new String[heroList.size()];
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getTitle();
                }
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
