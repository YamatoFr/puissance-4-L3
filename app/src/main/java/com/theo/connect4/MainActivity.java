package com.theo.connect4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText time;
    EditText boardsize;
    EditText name_1, name_2;
    int checktime;
    int checksize;
    int status;

    public void showToast() {
        if (checksize < 5 || checksize > 7) {
            Toast.makeText(this, "Please, Enter a size between 5-7.", Toast.LENGTH_LONG).show();
        }
        else if (checktime < 5 || checktime > 60) {
            Toast.makeText(this, "Please, Enter a time between 5-60.Enter 0 For Infinite Time.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findViewById(R.id.layout);

        boardsize = (EditText) findViewById(R.id.boardsize);
        boardsize.setInputType(InputType.TYPE_CLASS_NUMBER);
        time = (EditText) findViewById(R.id.time);
        time.setInputType(InputType.TYPE_CLASS_NUMBER);
        name_1 = (EditText) findViewById(R.id.Player_1_name);
        name_2 = (EditText) findViewById(R.id.Player_2_name);

        Button single = findViewById(R.id.single);
        Button multi = findViewById(R.id.multi);

        multi.setOnClickListener(v -> {
            if(!(time.getText().toString().equals("") || boardsize.getText().toString().equals(""))) {
                checktime = Integer.parseInt(time.getText().toString());
                checksize = Integer.parseInt(boardsize.getText().toString());
                status = 1;
                if(checktime == 0){
                    status=1;
                }
                else if (checktime < 5 || checktime > 60){
                    showToast();
                    status = 0;
                }
                if (checksize < 5 || checksize > 7) {
                    showToast();
                    status = 0;
                }
                if (status == 1) {
                    Intent i = new Intent(MainActivity.this, Board.class);
                    i.putExtra("Boardsize: ", boardsize.getText().toString());
                    i.putExtra("Time: ", time.getText().toString());
                    i.putExtra("Mode: ", "multi");
                    i.putExtra("Name_1", name_1.getText().toString());
                    i.putExtra("Name_2", name_2.getText().toString());
                    startActivity(i);
                }
            }
            else{
                showToast();
            }
        });

        single.setOnClickListener(v -> {
            if(!(time.getText().toString().equals("") || boardsize.getText().toString().equals(""))) {
                checktime = Integer.parseInt(time.getText().toString());
                checksize = Integer.parseInt(boardsize.getText().toString());
                status = 1;
                if(checktime == 0){
                    status=1;
                }
                else if (checktime < 5 || checktime > 60){
                    showToast();
                    status = 0;
                }
                if (checksize < 5 || checksize > 7) {
                    showToast();
                    status = 0;
                }
                if (status == 1) {
                    Intent i = new Intent(MainActivity.this, Board.class);
                    i.putExtra("Boardsize: ", boardsize.getText().toString());
                    i.putExtra("Time: ", time.getText().toString());
                    i.putExtra("Mode: ", "single");
                    i.putExtra("Name_1", name_1.getText().toString());
                    i.putExtra("Name_2", name_2.getText().toString());
                    startActivity(i);
                }
            }
            else{
                showToast();
            }
        });
    }
}