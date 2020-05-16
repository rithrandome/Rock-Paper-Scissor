package com.example.rock_paper_scissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main_menu extends AppCompatActivity {

    Button p,s,d;
    int flag;
    int game_mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p = findViewById(R.id.play);
        s = findViewById(R.id.single_p);
        d = findViewById(R.id.double_p);

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = 1;

                p.setVisibility(View.INVISIBLE);
                s.setVisibility(View.VISIBLE);
                d.setVisibility(View.VISIBLE);
                s.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        flag = 2;
                        game_mode = 1;
                        Intent i1 = new Intent(Main_menu.this,Player_Name.class);
                        i1.putExtra("game_mode",game_mode);
                        startActivity(i1);
                        finish();
                    }
                });

                d.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        flag = 3;
                        game_mode = 2;
                        Intent i1 = new Intent(Main_menu.this,Player_Name.class);
                        i1.putExtra("game_mode",game_mode);
                        startActivity(i1);
                        finish();
                    }
                });
            }
        });


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);

        outState.putInt("v_p",p.getVisibility());
        outState.putInt("v_s",s.getVisibility());
        outState.putInt("v_d",d.getVisibility());
        outState.putInt("flag",flag);
        outState.putInt("game_mode",game_mode);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        game_mode = savedInstanceState.getInt("game_mode");
        flag = savedInstanceState.getInt("flag");
        p.setVisibility(savedInstanceState.getInt("v_p"));
        s.setVisibility(savedInstanceState.getInt("v_s"));
        d.setVisibility(savedInstanceState.getInt("v_d"));

        if(flag == 1)
        {
            p.setVisibility(View.INVISIBLE);
            s.setVisibility(View.VISIBLE);
            d.setVisibility(View.VISIBLE);
            s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    flag = 2;
                    game_mode = 1;
                    Intent i1 = new Intent(Main_menu.this,Player_Name.class);
                    i1.putExtra("game_mode",game_mode);
                    startActivity(i1);
                    finish();
                }
            });

            d.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    flag = 3;
                    game_mode = 2;
                    Intent i1 = new Intent(Main_menu.this,Player_Name.class);
                    i1.putExtra("game_mode",game_mode);
                    startActivity(i1);
                    finish();
                }
            });
       }
        else if(flag == 2)
        {
            game_mode = 1;
            Intent i1 = new Intent(Main_menu.this,Player_Name.class);
            i1.putExtra("game_mode",game_mode);
            startActivity(i1);
            finish();

        }
        else if(flag == 3)
        {
            game_mode = 2;
            Intent i1 = new Intent(Main_menu.this,Player_Name.class);
            i1.putExtra("game_mode",game_mode);
            startActivity(i1);
            finish();
        }
    }

    private long doubleBackToExitPressed;
    private Toast backToast;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressed + 2000 > System.currentTimeMillis() ) {
            backToast.cancel();
            super.onBackPressed();
            System.exit(0);
        }
        else {

            doubleBackToExitPressed = System.currentTimeMillis();
            backToast = Toast.makeText(this, "Please click Back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }


    }
}
