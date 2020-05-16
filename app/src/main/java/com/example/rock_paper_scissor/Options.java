package com.example.rock_paper_scissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Options extends AppCompatActivity {

    Button r,p,s, n_g, S;
    ImageView i1, i2, i3;
    ConstraintLayout l1;
    TextView p1,p2,w,pl,t,p1_s,p2_s,t6,t2;
    int selected_opt = 0, rounds, game_mode, w1, w2, flag = 0;
    List<Integer> winner_set = new ArrayList<>();
    List<Integer> options = new ArrayList<>();
    List<Integer> comp_opt = new ArrayList<>();
    Random rand = new Random();
    final int[] button_clicked = new int[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        r = findViewById(R.id.rock);
        p = findViewById(R.id.paper);
        s = findViewById(R.id.scissor);
        p1 = findViewById(R.id.player_1);
        p2 = findViewById(R.id.player_2);
        w = findViewById(R.id.winner);
        pl = findViewById(R.id.player);
        t = findViewById(R.id.textView);
        n_g = findViewById(R.id.new_game);
        p1_s = findViewById(R.id.player1_score);
        p2_s = findViewById(R.id.player2_score);
        S = findViewById(selected_opt);
        t2 = findViewById(R.id.textView2);
        t6 = findViewById(R.id.textView6);
        i1 = findViewById(R.id.imageView);
        i2 = findViewById(R.id.imageView2);
        l1 = findViewById(R.id.layout_options);
        i3 = findViewById(R.id.imageView3);

        comp_opt.add(r.getId());
        comp_opt.add(p.getId());
        comp_opt.add(p.getId());

        Intent intent = getIntent();
        p1.setText(intent.getStringExtra("player1"));
        p2.setText(intent.getStringExtra("player2"));
        rounds = intent.getIntExtra("rounds",0);
        game_mode = intent.getIntExtra("game_mode",0);

        t.setText(p1.getText().toString().toUpperCase() + "'S TURN");

        button_clicked[0] = 0;
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = 1;

                button_clicked[0] += 1;
                selected_opt = r.getId();
                game(button_clicked[0]);
            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = 2;

                button_clicked[0] += 1;
                selected_opt = p.getId();
                game(button_clicked[0]);
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = 3;

                button_clicked[0] += 1;
                selected_opt = s.getId();
                game(button_clicked[0]);
            }
        });

        n_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Options.this,Main_menu.class);
                startActivity(i);
                finish();
            }
        });

    }


    public int winner(int p1,int p2)
    {
        if(p1==r.getId())
        {
            if(p2==p.getId())
            {
                return 2;
            }
            else if(p2==s.getId())
            {
                return 1;
            }
        }
        else if(p1==p.getId())
        {
            if(p2==r.getId())
            {
                return 1;
            }
            else if(p2==s.getId())
            {
                return 2;
            }
        }
        else if(p1==s.getId())
        {
            if(p2==r.getId())
            {
                return 2;
            }
            else if(p2==p.getId())
            {
                return 1;
            }
        }
        else
            return 0;
        return 0;

    }

    public void final_winner(int p1_w,int p2_w)
    {
        r.setVisibility(View.INVISIBLE);
        p.setVisibility(View.INVISIBLE);
        s.setVisibility(View.INVISIBLE);
        t.setVisibility(View.INVISIBLE);
        w.setVisibility(View.VISIBLE);
        n_g.setVisibility(View.VISIBLE);

        if(p1_w>p2_w)
        {
            if(game_mode == 2)
                w.setText(p1.getText().toString().toUpperCase() + " WINS !!");
            else {
                l1.setBackgroundResource(R.drawable.win_back);
                w.setText("YOU WIN !!");

            }
        }
        else if(p1_w<p2_w)
        {
            if(game_mode == 2)
                w.setText(p2.getText().toString().toUpperCase() + " WINS !!");
            else {
                l1.setBackgroundResource(R.drawable.loose_back);
                w.setText("YOU LOOSE !!");
            }

        }
        else if(p1_w == p2_w)
        {
            w.setText("DRAW !!");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("game_mode",game_mode);
        outState.putString("p1_s_text",p1_s.getText().toString());
        outState.putString("p2_s_text",p2_s.getText().toString());
        outState.putString("w_text",w.getText().toString());
        outState.putString("t_text",t.getText().toString());
        outState.putInt("player1_score",w1);
        outState.putInt("player2_score",w2);
        outState.putInt("flag",flag);
        outState.putInt("button_clicked",button_clicked[0]);
        outState.putIntegerArrayList("options", (ArrayList<Integer>) options);
        outState.putIntegerArrayList("winner_set", (ArrayList<Integer>) winner_set);
        outState.putIntegerArrayList("comp_opt", (ArrayList<Integer>) comp_opt);
        outState.putInt("r_v",r.getVisibility());
        outState.putInt("p_v",p.getVisibility());
        outState.putInt("s_v",s.getVisibility());
        outState.putInt("t_v",t.getVisibility());
        outState.putInt("w_v",w.getVisibility());
        outState.putInt("i1_v",i1.getVisibility());
        outState.putInt("i2_v",i2.getVisibility());
        outState.putInt("i3_v",i3.getVisibility());
        outState.putInt("t2_v",t2.getVisibility());
        outState.putInt("t6_v",t6.getVisibility());
        outState.putInt("n_g_v",n_g.getVisibility());


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        game_mode = savedInstanceState.getInt("game_mode");
        w1 = savedInstanceState.getInt("player1_score");
        t.setText(savedInstanceState.getString("t_text"));
        p1_s.setText(savedInstanceState.getString("p1_s_text"));
        p2_s.setText(savedInstanceState.getString("p2_s_text"));
        w.setText(savedInstanceState.getString("w_text"));
        r.setVisibility(savedInstanceState.getInt("r_v"));
        p.setVisibility(savedInstanceState.getInt("p_v"));
        s.setVisibility(savedInstanceState.getInt("s_v"));
        t.setVisibility(savedInstanceState.getInt("t_v"));
        w.setVisibility(savedInstanceState.getInt("w_v"));
        i1.setVisibility(savedInstanceState.getInt("i1_v"));
        i2.setVisibility(savedInstanceState.getInt("i2_v"));
        i3.setVisibility(savedInstanceState.getInt("i3_v"));
        n_g.setVisibility(savedInstanceState.getInt("n_g_v"));
        t2.setVisibility(savedInstanceState.getInt("t2_v"));
        t6.setVisibility(savedInstanceState.getInt("t6_v"));
        w2 = savedInstanceState.getInt("player2_score");
        button_clicked[0] = savedInstanceState.getInt("button_clicked");
        options.addAll(savedInstanceState.getIntegerArrayList("options"));
        winner_set.addAll(savedInstanceState.getIntegerArrayList("winner_set"));
        comp_opt.addAll(savedInstanceState.getIntegerArrayList("comp_opt"));
        flag = savedInstanceState.getInt("flag");

//        if( flag == 1)
//        {
//            button_clicked[0] += 1;
//            selected_opt = r.getId();
//            game(button_clicked[0]);
//        }
//        else if( flag == 2)
//        {
//            button_clicked[0] += 1;
//            selected_opt = p.getId();
//            game(button_clicked[0]);
//        }
//        else if( flag == 3)
//        {
//            button_clicked[0] += 1;
//            selected_opt = s.getId();
//            game(button_clicked[0]);
//        }

    }

    public void game(final int button_clicked)
    {
        int win;
        if(game_mode == 2) {

            options.add(selected_opt);
            if (button_clicked % 2 != 0) {
                t.setText(p2.getText().toString().toUpperCase() + "'S TURN");
            } else {
                if(button_clicked/2 != rounds) {
                    r.setVisibility(View.INVISIBLE);
                    p.setVisibility(View.INVISIBLE);
                    s.setVisibility(View.INVISIBLE);
                    t2.setText(p1.getText().toString().toUpperCase() + "'S CHOICE");
                    t6.setText(p2.getText().toString().toUpperCase() + "'S CHOICE");
                    t2.setVisibility(View.VISIBLE);
                    t6.setVisibility(View.VISIBLE);
                    show_choice(options.get(0), i1);
                    show_choice(options.get(1), i2);
                    i1.setVisibility(View.VISIBLE);
                    i2.setVisibility(View.VISIBLE);
                }

                win = winner(options.get(0), options.get(1));
                if( win == 1)
                    t.setText(p1.getText().toString().toUpperCase() + " WINS THE ROUND!!");
                else if( win == 2)
                    t.setText(p2.getText().toString().toUpperCase() + " WINS THE ROUND!!");
                else
                    t.setText("ROUND DRAW !!");
                winner_set.add(win);
                w1 = Collections.frequency(winner_set, 1);
                w2 = Collections.frequency(winner_set, 2);
                p1_s.setText(String.valueOf(w1));
                p2_s.setText(String.valueOf(w2));

                if(button_clicked/2 != rounds) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            t.setText(p1.getText().toString().toUpperCase() + "'S TURN");
                            t.setVisibility(View.VISIBLE);
                            r.setVisibility(View.VISIBLE);
                            p.setVisibility(View.VISIBLE);
                            s.setVisibility(View.VISIBLE);
                            t2.setVisibility(View.INVISIBLE);
                            t6.setVisibility(View.INVISIBLE);
                            i1.setVisibility(View.INVISIBLE);
                            i2.setVisibility(View.INVISIBLE);
                        }
                    }, 4000);
                }


                options.clear();
                if(button_clicked/2 == rounds)
                {
                    final_winner(w1,w2);
                }
            }
        }

        else {

            options.add(selected_opt);

            pl.setVisibility(View.INVISIBLE);
            t.setText("Computer's turn");

            r.setVisibility(View.INVISIBLE);
            p.setVisibility(View.INVISIBLE);
            s.setVisibility(View.INVISIBLE);

            selected_opt = comp_opt.get(rand.nextInt(comp_opt.size()));
            options.add(selected_opt);
            show_choice(selected_opt,i3);
            i3.setVisibility(View.VISIBLE);


            winner_set.add(winner(options.get(0), options.get(1)));
            w1 = Collections.frequency(winner_set, 1);
            w2 = Collections.frequency(winner_set, 2);
            p1_s.setText(String.valueOf(w1));
            p2_s.setText(String.valueOf(w2));
            options.clear();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    i3.setVisibility(View.GONE);
                    t.setText(p1.getText().toString().toUpperCase() + "'S TURN");
                    r.setVisibility(View.VISIBLE);
                    p.setVisibility(View.VISIBLE);
                    s.setVisibility(View.VISIBLE);

                    if(button_clicked == rounds)
                        final_winner(w1,w2);

                }
            }, 2000);

        }
    }

    public void show_choice(int id, ImageView i)
    {
        if(id == r.getId())
        {
            i.setImageResource(R.drawable.rock);
        }
        else if(id == p.getId())
        {
            i.setImageResource(R.drawable.paper);
        }
        else if(id == s.getId())
        {
            i.setImageResource(R.drawable.scissor);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyDialogBoxTheme);
        builder.setTitle("QUIT?");
        builder.setMessage("Do you want to go to Main menu?");
        builder.setPositiveButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent intent = new Intent(Options.this,Main_menu.class);
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
