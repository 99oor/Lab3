package com.lab.lab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyDialog extends Dialog {

    public MyDialog(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
//        btnCancel = (Button) findViewById(R.id.btn_cancel);
////        btnSignin = (Button) findViewById(R.id.btn_signin);
//        // 创建对话框构建器
//        AlertDialog.Builder builder = new AlertDialog.Builder(MyDialog.);
//        // 获取布局
//        View view2 = View.inflate(getContext(),R.layout.activity_my_dialog, null);
        // 获取布局中的控件
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button btnSignin = (Button) findViewById(R.id.btn_signin);
        final Button btnCancel = (Button) findViewById(R.id.btn_cancel);
//        // 创建对话框
//        final AlertDialog alertDialog = builder.create();

        btnSignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dismiss();
            }
        });
//        alertDialog.show()

    }
}
