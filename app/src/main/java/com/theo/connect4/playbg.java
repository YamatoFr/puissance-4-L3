package com.theo.connect4;

public class playbg {
    private Cell[][] TABLE;
    private int turn;
    private int size;

    public playbg(int s){
        turn=1;
        size=s;
    }

    public void init_table() {
        int i, j;
        TABLE=new Cell[size][size];
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                Cell tmp = new Cell(0, i, j);
                TABLE[i][j] = tmp;
            }
        }
    }

    public int playOnTable(int x){
        if(turn==-1){
            return -1;
        }
        for(int i=0; i<size; i++){
            if(TABLE[i][x].getValue()==0){
                if(turn==1){
                    TABLE[i][x].setValue(1);
                    return size-i-1;
                }
                else if(turn==2){
                    TABLE[i][x].setValue(2);
                    return size-i-1;
                }
            }
        }
        return -1;
    }

    public int is_valid(int i, int j){
        if(i<0 || i>=size || j<0 || j>=size){
            return 0;
        }
        return 1;
    }

    public int is_game_finished(){
        int i, j;
        for(i=0; i<size; i++){
            for(j=0; j<size; j++){
                if(is_valid(i,j)==1 && is_valid(i+1,j)==1 && is_valid(i+2, j)==1 && is_valid(i+3, j)==1){
                    if(TABLE[i][j].getValue()==1 && TABLE[i+1][j].getValue()==1 && TABLE[i+2][j].getValue()==1 && TABLE[i+3][j].getValue()==1){
                        TABLE[i][j].setValue(3);
                        TABLE[i+1][j].setValue(3);
                        TABLE[i+2][j].setValue(3);
                        TABLE[i+3][j].setValue(3);
                        return 1;
                    }
                }
                if((is_valid(i,j)==1 && is_valid(i,j+1)==1 && is_valid(i, j+2)==1 && is_valid(i, j+3)==1)){
                    if(TABLE[i][j].getValue()==1 && TABLE[i][j+1].getValue()==1 && TABLE[i][j+2].getValue()==1 && TABLE[i][j+3].getValue()==1){
                        TABLE[i][j+1].setValue(3);
                        TABLE[i][j+2].setValue(3);
                        TABLE[i][j+3].setValue(3);
                        TABLE[i][j].setValue(3);
                        return 1;
                    }
                }
                if((is_valid(i,j)==1 && is_valid(i+1,j+1)==1 && is_valid(i+2, j+2)==1 && is_valid(i+3, j+3)==1)){
                    if(TABLE[i][j].getValue()==1 && TABLE[i+1][j+1].getValue()==1 && TABLE[i+2][j+2].getValue()==1 && TABLE[i+3][j+3].getValue()==1){
                        TABLE[i+1][j+1].setValue(3);
                        TABLE[i+2][j+2].setValue(3);
                        TABLE[i+3][j+3].setValue(3);
                        TABLE[i][j].setValue(3);
                        return 1;
                    }
                }
                if((is_valid(i,j)==1 && is_valid(i-1,j+1)==1 && is_valid(i-2, j+2)==1 && is_valid(i-3, j+3)==1)){
                    if(TABLE[i][j].getValue()==1 && TABLE[i-1][j+1].getValue()==1 && TABLE[i-2][j+2].getValue()==1 && TABLE[i-3][j+3].getValue()==1){
                        TABLE[i-1][j+1].setValue(3);
                        TABLE[i-2][j+2].setValue(3);
                        TABLE[i-3][j+3].setValue(3);
                        TABLE[i][j].setValue(3);
                        return 1;
                    }
                }
                if(is_valid(i,j)==1 && is_valid(i+1,j)==1 && is_valid(i+2, j)==1 && is_valid(i+3, j)==1){
                    if(TABLE[i][j].getValue()==2 && TABLE[i+1][j].getValue()==2 && TABLE[i+2][j].getValue()==2 && TABLE[i+3][j].getValue()==2){
                        TABLE[i][j].setValue(4);
                        TABLE[i+1][j].setValue(4);
                        TABLE[i+2][j].setValue(4);
                        TABLE[i+3][j].setValue(4);
                        return 2;
                    }
                }
                if((is_valid(i,j)==1 && is_valid(i,j+1)==1 && is_valid(i, j+2)==1 && is_valid(i, j+3)==1)){
                    if(TABLE[i][j].getValue()==2 && TABLE[i][j+1].getValue()==2 && TABLE[i][j+2].getValue()==2 && TABLE[i][j+3].getValue()==2){
                        TABLE[i][j+1].setValue(4);
                        TABLE[i][j+2].setValue(4);
                        TABLE[i][j+3].setValue(4);
                        TABLE[i][j].setValue(4);
                        return 2;
                    }
                }
                if((is_valid(i,j)==1 && is_valid(i+1,j+1)==1 && is_valid(i+2, j+2)==1 && is_valid(i+3, j+3)==1)){
                    if(TABLE[i][j].getValue()==2 && TABLE[i+1][j+1].getValue()==2 && TABLE[i+2][j+2].getValue()==2 && TABLE[i+3][j+3].getValue()==2){
                        TABLE[i+1][j+1].setValue(4);
                        TABLE[i+2][j+2].setValue(4);
                        TABLE[i+3][j+3].setValue(4);
                        TABLE[i][j].setValue(4);
                        return 2;
                    }
                }
                if((is_valid(i,j)==1 && is_valid(i-1,j+1)==1 && is_valid(i-2, j+2)==1 && is_valid(i-3, j+3)==1)){
                    if(TABLE[i][j].getValue()==2 && TABLE[i-1][j+1].getValue()==2 && TABLE[i-2][j+2].getValue()==2 && TABLE[i-3][j+3].getValue()==2){
                        TABLE[i-1][j+1].setValue(4);
                        TABLE[i-2][j+2].setValue(4);
                        TABLE[i-3][j+3].setValue(4);
                        TABLE[i][j].setValue(4);
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    public int is_game_draw(){
        int i, j;
        for(i=0; i<size; i++){
            for(j=0; j<size; j++){
                if(TABLE[i][j].getValue()==0){
                    return 0;
                }
            }
        }
        return 1;
    }

    public int getTurn(){
        return turn;
    }

    public void setTurn(int t){
        turn = t;
    }

    public int computer_4_in_a_row(int i, int j){
        if(is_valid(i-1,j)==1 && is_valid(i-2,j)==1 && is_valid(i-3, j)==1){
            if(TABLE[i-1][j].getValue()==2 && TABLE[i-2][j].getValue()==2 && TABLE[i-3][j].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j-2)==1 && is_valid(i, j-3)==1){
            if(TABLE[i][j-1].getValue()==2 && TABLE[i][j-2].getValue()==2 && TABLE[i][j-3].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i,j+1)==1 && is_valid(i,j+2)==1 && is_valid(i, j+3)==1){
            if(TABLE[i][j+1].getValue()==2 && TABLE[i][j+2].getValue()==2 && TABLE[i][j+3].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j+1)==1 && is_valid(i, j+2)==1){
            if(TABLE[i][j-1].getValue()==2 && TABLE[i][j+1].getValue()==2 && TABLE[i][j+2].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j-2)==1 && is_valid(i, j+1)==1){
            if(TABLE[i][j-1].getValue()==2 && TABLE[i][j-2].getValue()==2 && TABLE[i][j+1].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i+2,j+2)==1 && is_valid(i+3, j+3)==1){
            if(TABLE[i+1][j+1].getValue()==2 && TABLE[i+2][j+2].getValue()==2 && TABLE[i+3][j+3].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i+2,j+2)==1 && is_valid(i-1, j-1)==1){
            if(TABLE[i+1][j+1].getValue()==2 && TABLE[i+2][j+2].getValue()==2 && TABLE[i-1][j-1].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i-1,j-1)==1 && is_valid(i-2, j-2)==1){
            if(TABLE[i+1][j+1].getValue()==2 && TABLE[i-1][j-1].getValue()==2 && TABLE[i-2][j-2].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i-1,j-1)==1 && is_valid(i-2,j-2)==1 && is_valid(i-3, j-3)==1){
            if(TABLE[i-1][j-1].getValue()==2 && TABLE[i-2][j-2].getValue()==2 && TABLE[i-3][j-3].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i+2,j-2)==1 && is_valid(i+3, j-3)==1){
            if(TABLE[i+1][j-1].getValue()==2 && TABLE[i+2][j-2].getValue()==2 && TABLE[i+3][j-3].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i+2,j-2)==1 && is_valid(i-1, j+1)==1){
            if(TABLE[i+1][j-1].getValue()==2 && TABLE[i+2][j-2].getValue()==2 && TABLE[i-1][j+1].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i-1,j+1)==1 && is_valid(i-2, j+2)==1){
            if(TABLE[i+1][j-1].getValue()==2 && TABLE[i-1][j+1].getValue()==2 && TABLE[i-2][j+2].getValue()==2){
                return 6;
            }
        }
        if(is_valid(i-1,j+1)==1 && is_valid(i-2,j+2)==1 && is_valid(i-3, j+3)==1){
            if(TABLE[i-1][j+1].getValue()==2 && TABLE[i-2][j+2].getValue()==2 && TABLE[i-3][j+3].getValue()==2){
                return 6;
            }
        }
        return 0;
    }

    public int player_4_in_a_row(int i, int j){
        if(is_valid(i-1,j)==1 && is_valid(i-2,j)==1 && is_valid(i-3, j)==1){
            if(TABLE[i-1][j].getValue()==1 && TABLE[i-2][j].getValue()==1 && TABLE[i-3][j].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j-2)==1 && is_valid(i, j-3)==1){
            if(TABLE[i][j-1].getValue()==1 && TABLE[i][j-2].getValue()==1 && TABLE[i][j-3].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i,j+1)==1 && is_valid(i,j+2)==1 && is_valid(i, j+3)==1){
            if(TABLE[i][j+1].getValue()==1 && TABLE[i][j+2].getValue()==1 && TABLE[i][j+3].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j+1)==1 && is_valid(i, j+2)==1){
            if(TABLE[i][j-1].getValue()==1 && TABLE[i][j+1].getValue()==1 && TABLE[i][j+2].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j-2)==1 && is_valid(i, j+1)==1){
            if(TABLE[i][j-1].getValue()==1 && TABLE[i][j-2].getValue()==1 && TABLE[i][j+1].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i+2,j+2)==1 && is_valid(i+3, j+3)==1){
            if(TABLE[i+1][j+1].getValue()==1 && TABLE[i+2][j+2].getValue()==1 && TABLE[i+3][j+3].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i+2,j+2)==1 && is_valid(i-1, j-1)==1){
            if(TABLE[i+1][j+1].getValue()==1 && TABLE[i+2][j+2].getValue()==1 && TABLE[i-1][j-1].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i-1,j-1)==1 && is_valid(i-2, j-2)==1){
            if(TABLE[i+1][j+1].getValue()==1 && TABLE[i-1][j-1].getValue()==1 && TABLE[i-2][j-2].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i-1,j-1)==1 && is_valid(i-2,j-2)==1 && is_valid(i-3, j-3)==1){
            if(TABLE[i-1][j-1].getValue()==1 && TABLE[i-2][j-2].getValue()==1 && TABLE[i-3][j-3].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i+2,j-2)==1 && is_valid(i+3, j-3)==1){
            if(TABLE[i+1][j-1].getValue()==1 && TABLE[i+2][j-2].getValue()==1 && TABLE[i+3][j-3].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i+2,j-2)==1 && is_valid(i-1, j+1)==1){
            if(TABLE[i+1][j-1].getValue()==1 && TABLE[i+2][j-2].getValue()==1 && TABLE[i-1][j+1].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i-1,j+1)==1 && is_valid(i-2, j+2)==1){
            if(TABLE[i+1][j-1].getValue()==1 && TABLE[i-1][j+1].getValue()==1 && TABLE[i-2][j+2].getValue()==1){
                return 5;
            }
        }
        if(is_valid(i-1,j+1)==1 && is_valid(i-2,j+2)==1 && is_valid(i-3, j+3)==1){
            if(TABLE[i-1][j+1].getValue()==1 && TABLE[i-2][j+2].getValue()==1 && TABLE[i-3][j+3].getValue()==1){
                return 5;
            }
        }
        return 0;
    }

    public int computer_3_in_a_row(int i, int j){
        if(is_valid(i-1,j)==1 && is_valid(i-2,j)==1){
            if(TABLE[i-1][j].getValue()==2 && TABLE[i-2][j].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j-2)==1){
            if(TABLE[i][j-1].getValue()==2 && TABLE[i][j-2].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i,j+1)==1 && is_valid(i,j+2)==1){
            if(TABLE[i][j+1].getValue()==2 && TABLE[i][j+2].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j+1)==1){
            if(TABLE[i][j-1].getValue()==2 && TABLE[i][j+1].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i+2,j+2)==1){
            if(TABLE[i+1][j+1].getValue()==2 && TABLE[i+2][j+2].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i-1, j-1)==1){
            if(TABLE[i+1][j+1].getValue()==2  && TABLE[i-1][j-1].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i-1,j-1)==1 && is_valid(i-2,j-2)==1){
            if(TABLE[i-1][j-1].getValue()==2 && TABLE[i-2][j-2].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i+2,j-2)==1){
            if(TABLE[i+1][j-1].getValue()==2 && TABLE[i+2][j-2].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i-1,j+1)==1){
            if(TABLE[i+1][j-1].getValue()==2 && TABLE[i-1][j+1].getValue()==2){
                return 4;
            }
        }
        if(is_valid(i-1,j+1)==1 && is_valid(i-2,j+2)==1){
            if(TABLE[i-1][j+1].getValue()==2 && TABLE[i-2][j+2].getValue()==2){
                return 4;
            }
        }
        return 0;
    }

    public int player_3_in_a_row(int i, int j){
        if(is_valid(i-1,j)==1 && is_valid(i-2,j)==1){
            if(TABLE[i-1][j].getValue()==1 && TABLE[i-2][j].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j-2)==1){
            if(TABLE[i][j-1].getValue()==1 && TABLE[i][j-2].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i,j+1)==1 && is_valid(i,j+2)==1){
            if(TABLE[i][j+1].getValue()==1 && TABLE[i][j+2].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i,j-1)==1 && is_valid(i,j+1)==1){
            if(TABLE[i][j-1].getValue()==1 && TABLE[i][j+1].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i+2,j+2)==1){
            if(TABLE[i+1][j+1].getValue()==1 && TABLE[i+2][j+2].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i+1,j+1)==1 && is_valid(i-1, j-1)==1){
            if(TABLE[i+1][j+1].getValue()==1  && TABLE[i-1][j-1].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i-1,j-1)==1 && is_valid(i-2,j-2)==1){
            if(TABLE[i-1][j-1].getValue()==1 && TABLE[i-2][j-2].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i+2,j-2)==1){
            if(TABLE[i+1][j-1].getValue()==1 && TABLE[i+2][j-2].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i+1,j-1)==1 && is_valid(i-1,j+1)==1){
            if(TABLE[i+1][j-1].getValue()==1 && TABLE[i-1][j+1].getValue()==1){
                return 3;
            }
        }
        if(is_valid(i-1,j+1)==1 && is_valid(i-2,j+2)==1){
            if(TABLE[i-1][j+1].getValue()==1 && TABLE[i-2][j+2].getValue()==1){
                return 3;
            }
        }
        return 0;
    }

    public int computer_2_in_a_row(int i, int j){
        if(is_valid(i-1,j)==1){
            if(TABLE[i-1][j].getValue()==2){
                return 2;
            }
        }
        if(is_valid(i,j-1)==1){
            if(TABLE[i][j-1].getValue()==2){
                return 2;
            }
        }
        if(is_valid(i,j+1)==1){
            if(TABLE[i][j+1].getValue()==2){
                return 2;
            }
        }
        if(is_valid(i+1,j+1)==1){
            if(TABLE[i+1][j+1].getValue()==2){
                return 2;
            }
        }
        if(is_valid(i-1,j-1)==1){
            if(TABLE[i-1][j-1].getValue()==2){
                return 2;
            }
        }
        if(is_valid(i+1,j-1)==1){
            if(TABLE[i+1][j-1].getValue()==2){
                return 2;
            }
        }
        if(is_valid(i-1,j+1)==1){
            if(TABLE[i-1][j+1].getValue()==2){
                return 2;
            }
        }
        return 0;
    }

    public int computer_move(BoardButton[][] array){
        int i ,j, temp_i=0, temp_j=0, best_move=0;
        for(j=0; j<size; j++){
            for(i=0; i<size; i++){
                if(TABLE[i][j].getValue()==0){
                    if(computer_4_in_a_row(i,j) > best_move){
                        best_move = computer_4_in_a_row(i,j);
                        temp_i=i;
                        temp_j=j;
                    }
                    if(player_4_in_a_row(i, j)>best_move){
                        best_move = player_4_in_a_row(i, j);
                        temp_i=i;
                        temp_j=j;
                    }
                    if(computer_3_in_a_row(i, j)>best_move){
                        best_move = computer_3_in_a_row(i, j);
                        temp_i=i;
                        temp_j=j;
                    }
                    if(player_3_in_a_row(i, j)>best_move){
                        best_move = player_3_in_a_row(i, j);
                        temp_i=i;
                        temp_j=j;
                    }
                    if(computer_2_in_a_row(i, j)>best_move){
                        best_move = computer_2_in_a_row(i, j);
                        temp_i=i;
                        temp_j=j;
                    }
                    break;
                }
            }
        }

        if(best_move>0){
            TABLE[temp_i][temp_j].setValue(2);
            array[size-temp_i-1][temp_j].setBackgroundResource(R.drawable.boardr);
            return temp_j;
        }
        else if(TABLE[0][size/2].getValue()==0){
            TABLE[0][size/2].setValue(2);
            array[size-1][size/2].setBackgroundResource(R.drawable.boardr);
            return size/2;
        }
        else if(TABLE[0][size/2].getValue()==1){
            TABLE[0][size/2-1].setValue(2);
            array[size-1][size/2-1].setBackgroundResource(R.drawable.boardr);
            return size/2-1;
        }

        return -1;
    }

    public int setTableElement(int c){
        for(int i=size-1; i>-1; i--){
            if(TABLE[i][c].getValue()!=0){
                TABLE[i][c].setValue(0);
                return size-i-1;
            }
        }
        return -1;
    }

    public int timerRandom(int c){
        for(int i=0; i<size; i++){
            if(TABLE[i][c].getValue()==0){
                TABLE[i][c].setValue(turn);
                if(turn==1){
                    turn=2;
                }
                else if(turn==2){
                    turn=1;
                }
                return size-i-1;
            }
        }
        return -1;
    }

    public int getFour(int x, int y){
        if(TABLE[x][y].getValue()==3){
            return 1;
        }
        if(TABLE[x][y].getValue()==4){
            return 2;
        }
        return 0;
    }
}