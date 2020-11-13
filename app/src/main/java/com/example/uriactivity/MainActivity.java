package com.example.uriactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private Button button;
    private ArrayList<CheckBox> checkBoxes=new ArrayList<>();
    private String content="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1=findViewById(R.id.checkbox);
        checkBox2=findViewById(R.id.checkbox1);
        checkBox3=findViewById(R.id.checkbox2);
        checkBox4=findViewById(R.id.checkbox3);
        button=findViewById(R.id.button);
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);
        checkBoxes.add(checkBox4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue(v);
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


    }
    private void getValue(View v){
        for(CheckBox cbx:checkBoxes){
            if(cbx.isChecked()){
                content+=cbx.getText()+" ";
            }
        }
        if("".equals(content)){
            content="请您选择爱好";
        }
    }
}