package com.example.rock_paper_scissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    int game_mode, flag = 0;

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
        if (game_mode == 1)
        {
            p2.setText("Computer");
            t2.setVisibility(View.VISIBLE);
            p2.setVisibility(View.INVISIBLE);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (game_mode == 2) {

                    if (TextUtils.isEmpty(p1.getText()) && TextUtils.isEmpty(p2.getText())) {
                        p1.setError("Enter 1st Player Name !!");
                        p2.setError("Enter 2nd Player Name !!");
                    } else if (TextUtils.isEmpty(p2.getText())) {
                        p2.setError("Enter 2nd Player Name !!");
                    } else if (TextUtils.isEmpty(p1.getText())) {
                        p1.setError("Enter 1st Player Name !!");
                    } else {
                        t3.setVisibility(View.GONE);
                        p1.setVisibility(View.GONE);
                        t4.setVisibility(View.GONE);
                        p2.setVisibility(View.GONE);
                        t5.setVisibility(View.VISIBLE);
                        r.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.VISIBLE);

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                flag = 2;

                                if (TextUtils.isEmpty(r.getText())) {
                                    r.setError("Enter the number of rounds !!");
                                } else {
                                    Intent intent = new Intent(Player_Name.this, Options.class);
                                    intent.putExtra("rounds", Integer.parseInt(r.getText().toString()));
                                    intent.putExtra("player1", p1.getText().toString());
                                    intent.putExtra("player2", p2.getText().toString());
                                    intent.putExtra("game_mode",game_mode);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }
                } else if (game_mode == 1) {
                    flag = 1;

                    if (TextUtils.isEmpty(p1.getText())) {
                        p1.setError("Enter 1st Player Name !!");
                    } else {
                        t3.setVisibility(View.GONE);
                        p1.setVisibility(View.GONE);
                        t4.setVisibility(View.GONE);
                        t5.setVisibility(View.VISIBLE);
                        r.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.GONE);

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                flag = 2;

                                if (TextUtils.isEmpty(r.getText())) {
                                    r.setError("Enter the number of rounds !!");
                                } else {
                                    Intent intent = new Intent(Player_Name.this, Options.class);
                                    intent.putExtra("rounds", Integer.parseInt(r.getText().toString()));
                                    intent.putExtra("player1", p1.getText().toString());
                                    intent.putExtra("player2", p2.getText().toString());
                                    intent.putExtra("game_mode",game_mode);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

                    }
                }
            }
        });

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);

        outState.putInt("game_mode",game_mode);
        outState.putInt("flag",flag);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        game_mode = savedInstanceState.getInt("game_mode");
        flag = savedInstanceState.getInt("flag");

        if(flag == 0)
        {

        }

        else if(flag == 1)
        {
            if (TextUtils.isEmpty(p1.getText()) && TextUtils.isEmpty(p2.getText())) {
                p1.setError("Enter 1st Player Name !!");
                p2.setError("Enter 2nd Player Name !!");
            } else if (TextUtils.isEmpty(p2.getText())) {
                p2.setError("Enter 2nd Player Name !!");
            } else if (TextUtils.isEmpty(p1.getText())) {
                p1.setError("Enter 1st Player Name !!");
            } else {
                t3.setVisibility(View.GONE);
                p1.setVisibility(View.GONE);
                t4.setVisibility(View.GONE);
                p2.setVisibility(View.GONE);
                t5.setVisibility(View.VISIBLE);
                r.setVisibility(View.VISIBLE);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.VISIBLE);

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        flag = 2;

                        if (TextUtils.isEmpty(r.getText())) {
                            r.setError("Enter the number of rounds !!");
                        } else {
                            Intent intent = new Intent(Player_Name.this, Options.class);
                            intent.putExtra("rounds", Integer.parseInt(r.getText().toString()));
                            intent.putExtra("player1", p1.getText().toString());
                            intent.putExtra("player2", p2.getText().toString());
                            intent.putExtra("game_mode",game_mode);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
        } else if (game_mode == 1) {
            flag = 1;

            if (TextUtils.isEmpty(p1.getText())) {
                p1.setError("Enter 1st Player Name !!");
            } else {
                t3.setVisibility(View.GONE);
                p1.setVisibility(View.GONE);
                t4.setVisibility(View.GONE);
                t5.setVisibility(View.VISIBLE);
                r.setVisibility(View.VISIBLE);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.GONE);

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        flag = 2;

                        if (TextUtils.isEmpty(r.getText())) {
                            r.setError("Enter the number of rounds !!");
                        } else {
                            Intent intent = new Intent(Player_Name.this, Options.class);
                            intent.putExtra("rounds", Integer.parseInt(r.getText().toString()));
                            intent.putExtra("player1", p1.getText().toString());
                            intent.putExtra("player2", p2.getText().toString());
                            intent.putExtra("game_mode",game_mode);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyDialogBoxTheme);
        builder.setTitle("QUIT?");
        builder.setMessage("Do you want to go to Main menu?");
        builder.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent intent = new Intent(Player_Name.this,Main_menu.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Resume", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
