package com.example.rock_papper_scissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Options extends AppCompatActivity {

    Button r,p,s, n_g, S;
    TextView p1,p2,w,pl,t,p1_s,p2_s;
    int selected_opt = 0, rounds, game_mode, w1, w2;
    List<Integer> winner_set = new ArrayList<>();
    List<Integer> options = new ArrayList<>();
    List<Integer> comp_opt = new ArrayList<>();
    Random rand = new Random();



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

        comp_opt.add(r.getId());
        comp_opt.add(p.getId());
        comp_opt.add(p.getId());

        Intent intent = getIntent();
        p1.setText(intent.getStringExtra("player1"));
        p2.setText(intent.getStringExtra("player2"));
        rounds = intent.getIntExtra("rounds",0);
        game_mode = intent.getIntExtra("game_mode",0);

        selected_option(r,p,s);

        n_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Options.this,Main_menu.class);
                startActivity(i);
            }
        });



    }



    public void selected_option(final Button b1, final Button b2, final Button b3)
    {
        final int[] button_clicked = new int[1];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_clicked[0] += 1;
                selected_opt = b1.getId();
                game(button_clicked[0]);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_clicked[0] += 1;
                selected_opt = b2.getId();
                game(button_clicked[0]);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_clicked[0] += 1;
                selected_opt = b3.getId();
                game(button_clicked[0]);
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
        pl.setVisibility(View.INVISIBLE);
        w.setVisibility(View.VISIBLE);
        n_g.setVisibility(View.VISIBLE);

//        for(int i=0;i<f_w.size();i++)
//        {
//            if(winner_set.get(i) == 1)
//                p1_w++;
//            else if(winner_set.get(i) == 2)
//                p2_w++;
//        }

        if(p1_w>p2_w)
        {
            w.setText("PLAYER 1 WINS !!");
        }
        else if(p1_w<p2_w)
        {
            if(game_mode == 2)
                w.setText("PLAYER 2 WINS !!");
            else if(game_mode == 1)
                w.setText("COMPUTER WINS !!");

        }
        else if(p1_w == p2_w)
        {
            w.setText("DRAW !!");
        }

    }

    public void s_opt(int s_o)
    {
        if(s_o == r.getId())
        {
            p.setVisibility(View.GONE);
            s.setVisibility(View.GONE);
        }
        else if(s_o == p.getId())
        {
            r.setVisibility(View.GONE);
            s.setVisibility(View.GONE);
        }
        if(s_o == s.getId())
        {
            p.setVisibility(View.GONE);
            r.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("r_v",r.getVisibility());
        outState.putInt("p_v",p.getVisibility());
        outState.putInt("s_v",s.getVisibility());
        outState.putInt("n_g_v",n_g.getVisibility());
        outState.putInt("pl_v",pl.getVisibility());
    }

    public void game(int button_clicked)
    {
        if(game_mode == 2) {

            options.add(selected_opt);
            if (button_clicked % 2 != 0) {
                pl.setText(String.valueOf(2));
            } else {
                pl.setText(String.valueOf(1));
                winner_set.add(winner(options.get(0), options.get(1)));
                w1 = Collections.frequency(winner_set, 1);
                w2 = Collections.frequency(winner_set, 2);
                p1_s.setText(String.valueOf(w1));
                p2_s.setText(String.valueOf(w2));
                options.clear();
                if(button_clicked/2 == rounds)
                {
                    final_winner(w1,w2);
                }
            }
        }

        else if(game_mode == 1) {

            options.add(selected_opt);

            pl.setVisibility(View.INVISIBLE);
            t.setText("C O M P U T E R");

            selected_opt = comp_opt.get(rand.nextInt(comp_opt.size()));
            options.add(selected_opt);
            s_opt(selected_opt);

            winner_set.add(winner(options.get(0), options.get(1)));
            w1 = Collections.frequency(winner_set, 1);
            w2 = Collections.frequency(winner_set, 2);
            p1_s.setText(String.valueOf(w1));
            p2_s.setText(String.valueOf(w2));
            options.clear();



//
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            pl.setVisibility(View.VISIBLE);
//                            t.setText("P L A Y E R");
//                            b1.setVisibility(View.VISIBLE);
//                            b2.setVisibility(View.VISIBLE);
//                            b3.setVisibility(View.VISIBLE);
//                        }
//                    }, 500);

            if(button_clicked == rounds)
                final_winner(w1,w2);


//                b2.setVisibility(View.GONE);
//                b3.setVisibility(View.GONE);
        }
    }
}
