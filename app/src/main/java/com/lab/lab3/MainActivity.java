package com.lab.lab3;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lab.lab3.AnimalsListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void skip1(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,AnimalsListView.class);
        startActivity(intent);
    }

    public void skip2(View view){
        MyDialog alertDialog = new MyDialog(this);

        alertDialog.show();
//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this,MyDialog.class);
//        startActivity(intent);
    }

    public void skip3(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,MenuTest.class);
        startActivity(intent);
    }

    public void skip4(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,ContextActionMode.class);
        startActivity(intent);
    }
}
