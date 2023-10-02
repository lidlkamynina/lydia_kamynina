package com.example.pr_w2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firt_page);


        Button btn1 = findViewById(R.id.button_dialog);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Dialog.class));
            }
        });
        Button btn2 = findViewById(R.id.button_act2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] multiChoiceItems = getResources().getStringArray(R.array.names);


                MyDialog dialog = new MyDialog(multiChoiceItems);
                dialog.show(getSupportFragmentManager(), "MyDialog");
            }
        });


    }
}