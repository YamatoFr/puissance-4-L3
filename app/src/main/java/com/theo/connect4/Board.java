package com.theo.connect4;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class Board extends AppCompatActivity {
    int time;
    int boardsize;
    String mode;
    int status;
    Button restart, checkboard;
    TextView info;
    Dialog dialogbox;
    playbg bggame;
    BoardButton[][] arr;
    CountDownTimer countdownTimer = null;
    int[] UndoArray;
    public Board(){
        time=0;
        boardsize=0;
        status=1;
    }

    public void DialogAlert(){
        Intent activity = getIntent();
        String name_1 = activity.getStringExtra("Name_1");
        String name_2 = activity.getStringExtra("Name_2");

        if(time!=0) {
            countdownTimer.cancel();
            countdownTimer = null;
        }

        dialogbox = new Dialog(this);
        dialogbox.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbox.setContentView(R.layout.finish);
        info = (TextView) dialogbox.findViewById(R.id.info);
        for(int i=0; i<boardsize*boardsize; i++){
            UndoArray[i]=-1;
        }
        for(int i=0; i<boardsize; i++){
            for(int j=0; j<boardsize; j++){
                if(bggame.getFour(i,j)==1){
                    arr[boardsize-i-1][j].setBackgroundResource(R.drawable.boardb4);
                    info.setText(name_1 + " won !");
                }
                if(bggame.getFour(i,j)==2){
                    arr[boardsize-i-1][j].setBackgroundResource(R.drawable.boardr4);
                    info.setText(name_2 + " won !");

                }
            }
        }

        restart  = (Button) dialogbox.findViewById(R.id.restart);
        checkboard = (Button) dialogbox.findViewById(R.id.checkboard);
        restart.setOnClickListener(v -> {
            Intent i = new Intent(Board.this, MainActivity.class);
            finish();
            startActivity(i);
        });
        checkboard.setOnClickListener(v -> dialogbox.cancel());
        dialogbox.setTitle("Game Finished!");
        dialogbox.show();
    }
    public void timerfunc() {
        if(time!=0) {
            final TextView timetext = (TextView) findViewById(R.id.timetext);
            countdownTimer = new CountDownTimer(time * 1000L, 1000) {
                @Override
                public void onTick(long millis) {
                    timetext.setText("Time : " + (int) (millis / 1000));
                }

                @Override
                public void onFinish() {
                    int statustimer = 1;
                    while(statustimer==1){
                        Random rand = new Random();
                        int n = rand.nextInt(boardsize);
                        int temp = bggame.timerRandom(n);
                        if (temp != -1) {
                            if (bggame.getTurn() == 1) {
                                arr[temp][n].setBackgroundResource(R.drawable.boardr);
                                for (int a = 0; a < boardsize * boardsize; a++) {
                                    if (UndoArray[a] == -1) {
                                        UndoArray[a] = n;
                                        break;
                                    }
                                }
                            } else if (bggame.getTurn() == 2) {
                                arr[temp][n].setBackgroundResource(R.drawable.boardb);
                                for (int a = 0; a < boardsize * boardsize; a++) {
                                    if (UndoArray[a] == -1) {
                                        UndoArray[a] = n;
                                        break;
                                    }
                                }
                            }
                            statustimer=0;
                        }
                    }
                    if (bggame.is_game_finished() != 0) {
                        DialogAlert();
                        status=0;
                        return;
                    } else if (bggame.is_game_draw() == 1) {
                        DialogAlert();
                        status=0;
                        return;
                    }
                    if (mode.equals("single")) {
                        if (status == 1) {
                            int tempmove = bggame.computer_move(arr);
                            for (int a = 0; a < boardsize * boardsize; a++) {
                                if (UndoArray[a] == -1) {
                                    UndoArray[a] = tempmove;
                                    break;
                                }
                            }
                            bggame.setTurn(1);
                        }
                        if (bggame.is_game_finished() != 0) {
                            DialogAlert();
                            status=0;
                            return;
                        } else if (bggame.is_game_draw() == 1) {
                            DialogAlert();
                            status=0;
                            return;
                        }
                    }
                    countdownTimer.cancel();
                    countdownTimer.start();
                }
            };
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_board);
        Intent i = getIntent();

        time = Integer.parseInt(i.getStringExtra("Time: "));
        boardsize = Integer.parseInt(i.getStringExtra("Boardsize: "));
        mode = i.getStringExtra("Mode: ");

        findViewById(R.id.ConstraintLayout);
        GridLayout gl = (GridLayout) findViewById(R.id.gridlayout);
        gl.setRowCount(boardsize);
        gl.setColumnCount(boardsize);

        arr = new BoardButton[boardsize][boardsize];
        UndoArray = new int[boardsize*boardsize];

        for(int a=0; a<boardsize*boardsize; a++){
            UndoArray[a]=-1;
        }

        bggame = new playbg(boardsize);
        bggame.init_table();
        Button undobutton = findViewById(R.id.undobutton);
        undobutton.setOnClickListener(v -> {
            if(UndoArray[0]!=-1){
                for(int a=boardsize*boardsize-1; a>-1; a--) {
                    if (UndoArray[a] != -1) {
                        int temp = bggame.setTableElement(UndoArray[a]);
                        arr[temp][UndoArray[a]].setBackgroundResource(R.drawable.board);
                        UndoArray[a] = -1;
                        break;
                    }
                }
                if(mode.equals("single")) {
                    for (int a = boardsize * boardsize - 1; a > -1; a--) {
                        if (UndoArray[a] != -1) {
                            int temp = bggame.setTableElement(UndoArray[a]);
                            arr[temp][UndoArray[a]].setBackgroundResource(R.drawable.board);
                            UndoArray[a] = -1;
                            break;
                        }
                    }
                }
                if(mode.equals("multi")){
                    if(bggame.getTurn()==1){
                        bggame.setTurn(2);
                    }
                    if(bggame.getTurn()==2){
                        bggame.setTurn(1);
                    }
                }
                if(time!=0) {
                    countdownTimer.cancel();
                    countdownTimer.start();
                }
            }
        });

        for(int r=0; r<boardsize; r++){
            for(int c=0; c<boardsize; c++){
                arr[r][c] = new BoardButton(this,r,c);
                arr[r][c].setOnClickListener(v -> {
                    BoardButton btn = (BoardButton) v;
                    int temp = bggame.playOnTable(btn.getColumn());
                    if(temp!=-1 && status==1) {
                        if(bggame.getTurn()==1) {
                            arr[temp][btn.getColumn()].setBackgroundResource(R.drawable.boardb);
                            bggame.setTurn(2);
                            if(time!=0) {
                                countdownTimer.cancel();
                                countdownTimer.start();
                            }
                        }
                        else if(bggame.getTurn()==2){
                            arr[temp][btn.getColumn()].setBackgroundResource(R.drawable.boardr);
                            bggame.setTurn(1);
                            if(time!=0) {
                                countdownTimer.cancel();
                                countdownTimer.start();
                            }                            }
                        for(int a=0; a<boardsize*boardsize; a++){
                            if(UndoArray[a]==-1) {
                                UndoArray[a] = btn.getColumn();
                                break;
                            }
                        }
                        if(bggame.is_game_finished()!=0){
                            status=0;
                            DialogAlert();
                        }
                        else if(bggame.is_game_draw()==1){
                            status=0;
                            DialogAlert();
                        }
                        if(mode.equals("single")) {
                            if (status == 1) {
                                int tempmove=bggame.computer_move(arr);
                                for(int a=0; a<boardsize*boardsize; a++){
                                    if(UndoArray[a]==-1) {
                                        UndoArray[a] = tempmove;
                                        break;
                                    }
                                }
                                bggame.setTurn(1);
                            }
                            if (bggame.is_game_finished() != 0) {
                                DialogAlert();
                                status = 0;
                            } else if (bggame.is_game_draw() == 1) {
                                DialogAlert();
                                status = 0;
                            }
                        }
                    }
                });
                gl.addView(arr[r][c]);
            }
        }

        if(time!=0) {
            timerfunc();
            countdownTimer.start();
        }

    }
}