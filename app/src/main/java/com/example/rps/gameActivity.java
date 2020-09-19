package com.example.rps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class gameActivity extends AppCompatActivity {

    Button b_rock,b_paper,b_scissors,b_finish;
    ImageView iv_cpu,iv_player;

    String playerChoice,cpuChoice,result;
    Random r;

    int cpuPoints=0,playerPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_player = (ImageView) findViewById(R.id.iv_player);

        b_rock = (Button)findViewById(R.id.b_rock);
        b_paper = (Button)findViewById(R.id.b_paper);
        b_scissors = (Button)findViewById(R.id.b_scissor);
        b_finish = (Button)findViewById(R.id.b_finish);

        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = "rock";
                iv_player.setImageResource(R.drawable.rock);
                calculate();
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = "paper";
                iv_player.setImageResource(R.drawable.paper);
                calculate();
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = "scissors";
                iv_player.setImageResource(R.drawable.scissors);
                calculate();
            }
        });

        b_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDiaglogBuilder = new AlertDialog.Builder(gameActivity.this);
                alertDiaglogBuilder
                        .setMessage("YOUR SCORE : "+playerPoints+"\nROBOT SCORE : "+cpuPoints)
                        .setCancelable(false)
                        .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent =new Intent(getApplicationContext(),gameActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        })
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = alertDiaglogBuilder.create();
                alertDialog.show();
            }
        });




    }

    public void calculate(){
        int cpu = r.nextInt(3);
        if(cpu == 0){
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        } else if(cpu == 1){
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if(cpu == 2){
            cpuChoice = "scissors";
            iv_cpu.setImageResource(R.drawable.scissors);
        }

        if(playerChoice.equals("rock") && cpuChoice.equals("paper")){
            result = "YOU LOSE !!";
            cpuPoints++;
        } else if(playerChoice.equals("rock") && cpuChoice.equals("scissors")){
            result = "YOU WIN !!!!";
            playerPoints++;
        } else if(playerChoice.equals("rock") && cpuChoice.equals("rock")){
            result = "!!! DRAW !!!";
        } else if(playerChoice.equals("paper") && cpuChoice.equals("scissors")){
            result = "YOU LOSE !!";
            cpuPoints++;
        } else if(playerChoice.equals("paper") && cpuChoice.equals("rock")){
            result = "YOU WIN !!!!";
            playerPoints++;
        } else if(playerChoice.equals("paper") && cpuChoice.equals("paper")){
            result = "!!! DRAW !!!";
        } else if(playerChoice.equals("scissors") && cpuChoice.equals("rock")){
            result = "YOU LOSE !!";
            cpuPoints++;
        } else if(playerChoice.equals("scissors") && cpuChoice.equals("paper")){
            result = "YOU WIN !!!!";
            playerPoints++;
        } else if(playerChoice.equals("scissors") && cpuChoice.equals("scissors")){
            result = "!!! DRAW !!!";
        }

        Toast.makeText(gameActivity.this,result,Toast.LENGTH_SHORT).show();
    }
}
