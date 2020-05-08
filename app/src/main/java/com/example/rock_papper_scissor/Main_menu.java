package com.example.rock_papper_scissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class Main_menu extends AppCompatActivity {

    Button p,s,d;

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

                p.setVisibility(View.GONE);
                s.setVisibility(View.VISIBLE);
                d.setVisibility(View.VISIBLE);
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                game_mode = 1;
                pass_game_mode(game_mode);

            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                game_mode = 2;
                pass_game_mode(game_mode);

            }
        });


    }

    public void pass_game_mode(int gm)
    {
        //Intent i = new Intent(Main_menu.this,Options.class);
        Intent i1 = new Intent(Main_menu.this,Player_Name.class);
        i1.putExtra("game_mode",gm);
        //i.putExtra("game_mode",gm);
        startActivity(i1);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);

        outState.putInt("v_p",p.getVisibility());
        outState.putInt("v_s",s.getVisibility());
        outState.putInt("v_d",d.getVisibility());
        outState.putInt("game_mode",game_mode);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        game_mode = savedInstanceState.getInt("game_mode");
        p.setVisibility(savedInstanceState.getInt("v_p"));
        s.setVisibility(savedInstanceState.getInt("v_s"));
        d.setVisibility(savedInstanceState.getInt("v_d"));
    }
}
