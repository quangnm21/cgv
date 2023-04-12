package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitetest.databases.Fimdatabases;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText edt_ma;
    private EditText edt_ten;
    private Button btAdd_fim;
    private RecyclerView rcv_fim;
    private FimAdapter fimAdapter;
    private List<Fim> list_fims;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        fimAdapter = new FimAdapter();
        list_fims = new ArrayList<>();
        fimAdapter.setData(list_fims);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_fim.setLayoutManager(linearLayoutManager);
        rcv_fim.setAdapter(fimAdapter);
        btAdd_fim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFim();
            }
        });
    }

    private void initUi(){
        edt_ma = findViewById(R.id.edt_Ma);
        edt_ten = findViewById(R.id.edt_Ten);
        btAdd_fim = findViewById(R.id.bt_addFim);
        rcv_fim = findViewById(R.id.rcv_fim);
    }
    private void addFim(){
        String ma = edt_ma.getText().toString().trim();
        String ten = edt_ten.getText().toString().trim();
        if(TextUtils.isEmpty(ma)||TextUtils.isEmpty(ten)){
            return;
        }
        Fim fim = new Fim(ma,ten);
        Fimdatabases.getInstance(this).fimDAO().insertFim(fim);
        Toast.makeText(this,"Add fim successfully", Toast.LENGTH_LONG).show();
        edt_ma.setText("");
        edt_ten.setText("");
        hideKeyboard(MainActivity.this, btAdd_fim);
        list_fims = Fimdatabases.getInstance(this).fimDAO().getFimList();
        fimAdapter.setData(list_fims);
    }

    public static void hideKeyboard(Context context, View view) {
        try{
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

}