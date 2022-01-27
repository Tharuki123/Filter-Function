package com.hit.searchanimationapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;

import com.hit.searchanimationapplication.adapter.RecyclerViewAdapter;
import com.hit.searchanimationapplication.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView userRecycler;
    RecyclerViewAdapter recyclerViewAdapter;
    EditText searchView;
    CharSequence search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.et_search_bar);

        List<UserData> userData = new ArrayList<>();
        userData.add(new UserData("Kalo", "SE", R.drawable.pro1));
        userData.add(new UserData("Mark", "QA", R.drawable.pro2));
        userData.add(new UserData("Henry", "SSE", R.drawable.pro3));
        userData.add(new UserData("Janny", "PM", R.drawable.pro4));
        userData.add(new UserData("Julia", "BA", R.drawable.pro5));
        userData.add(new UserData("Markus", "UI/UX Engineer", R.drawable.pro6));
        userData.add(new UserData("Elisabeth", "SE Intern", R.drawable.pro7));
        userData.add(new UserData("Anne", "AI Engineer", R.drawable.pro8));
        userData.add(new UserData("Jack", "Tech Lead", R.drawable.pro9));
        userData.add(new UserData("John", "SE", R.drawable.pro10));
        userData.add(new UserData("Kalo", "SE", R.drawable.pro1));
        userData.add(new UserData("Mark", "QA", R.drawable.pro2));
        userData.add(new UserData("Henry", "SSE", R.drawable.pro3));
        userData.add(new UserData("Janny", "PM", R.drawable.pro4));
        userData.add(new UserData("Julia", "BA", R.drawable.pro5));
        userData.add(new UserData("Markus", "UI/UX Engineer", R.drawable.pro6));
        userData.add(new UserData("Elisabeth", "SE Intern", R.drawable.pro7));
        userData.add(new UserData("Anne", "AI Engineer", R.drawable.pro8));
        userData.add(new UserData("Jack", "Tech Lead", R.drawable.pro9));
        userData.add(new UserData("John", "SE", R.drawable.pro10));

        setUserRecycler(userData);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                recyclerViewAdapter.getFilter().filter(charSequence);
                search = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setUserRecycler(List<UserData> userDataList){
        userRecycler = findViewById(R.id.userRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        userRecycler.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, userDataList);
        userRecycler.setAdapter(recyclerViewAdapter);
    }

}