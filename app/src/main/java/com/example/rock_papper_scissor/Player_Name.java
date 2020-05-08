package com.example.rock_papper_scissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Player_Name extends AppCompatActivity {

    Button b1,b2;
    EditText p1, p2, r;
    TextView t5,t4,t3,t2;
    int game_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__name);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        p1 = findViewById(R.id.player_1);
        p2 = findViewById(R.id.player_2);
        r = findViewById(R.id.rounds);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t2 = findViewById(R.id.computer);

        Intent i1 = getIntent();
        game_mode = i1.getIntExtra("game_mode",0);

        if(game_mode == 2) {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(TextUtils.isEmpty(p1.getText()) && TextUtils.isEmpty(p2.getText())){
                        p1.setError("Enter 1st Player Name !!");
                        p2.setError("Enter 2nd Player Name !!");
                    } else if (TextUtils.isEmpty(p2.getText())) {
                        p2.setError("Enter 2nd Player Name !!");
                    }
                    else if(TextUtils.isEmpty(p1.getText())){
                        p1.setError("Enter 1st Player Name !!");
                    }
                    else {
                        t3.setVisibility(View.GONE);
                        p1.setVisibility(View.GONE);
                        t4.setVisibility(View.GONE);
                        p2.setVisibility(View.GONE);
                        t5.setVisibility(View.VISIBLE);
                        r.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.VISIBLE);

                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (TextUtils.isEmpty(r.getText())) {
                        r.setError("Enter the number of rounds !!");
                    } else {
                        Intent intent1 = new Intent(Player_Name.this, Options.class);
                        intent1.putExtra("rounds", Integer.parseInt(r.getText().toString()));
                        intent1.putExtra("player1", p1.getText().toString());
                        intent1.putExtra("player2", p2.getText().toString());
                        intent1.putExtra("game_mode",game_mode);
                        startActivity(intent1);
                    }
                }
            });
        }

        else if(game_mode == 1)
        {
            p2.setText("Computer");
            t2.setVisibility(View.VISIBLE);
            p2.setVisibility(View.INVISIBLE);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(TextUtils.isEmpty(p1.getText()))
                    {
                        p1.setError("Enter 1st Player Name !!");
                    }
                    else {
                        t3.setVisibility(View.GONE);
                        p1.setVisibility(View.GONE);
                        t4.setVisibility(View.GONE);
                        t5.setVisibility(View.VISIBLE);
                        r.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.GONE);

                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (TextUtils.isEmpty(r.getText())) {
                        r.setError("Enter the number of rounds !!");
                    } else {
                        Intent intent = new Intent(Player_Name.this, Options.class);
                        intent.putExtra("rounds", Integer.parseInt(r.getText().toString()));
                        intent.putExtra("player1", p1.getText().toString());
                        intent.putExtra("player2", p2.getText().toString());
                        startActivity(intent);
                    }
                }
            });

        }


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);

        outState.putString("player1",p1.getText().toString());
        outState.putString("player2",p2.getText().toString());
        outState.putString("rounds",r.getText().toString());

        outState.putInt("v_t3",t3.getVisibility());
        outState.putInt("v_t4",t4.getVisibility());
        outState.putInt("v_t5",t5.getVisibility());
        outState.putInt("v_p1",p1.getVisibility());
        outState.putInt("v_p2",p2.getVisibility());
        outState.putInt("v_r",r.getVisibility());
        outState.putInt("v_b2",b2.getVisibility());
        outState.putInt("v_b1",b1.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        p1.setText(savedInstanceState.getString("player1"));
        p2.setText(savedInstanceState.getString("player2"));
        r.setText(savedInstanceState.getString("rounds"));

        t3.setVisibility(savedInstanceState.getInt("v_t3"));
        t4.setVisibility(savedInstanceState.getInt("v_t4"));
        t5.setVisibility(savedInstanceState.getInt("v_t5"));
        p1.setVisibility(savedInstanceState.getInt("v_p1"));
        p2.setVisibility(savedInstanceState.getInt("v_p2"));
        r.setVisibility(savedInstanceState.getInt("v_r"));
        b2.setVisibility(savedInstanceState.getInt("v_b2"));
        b1.setVisibility(savedInstanceState.getInt("v_b1"));

    }
}
