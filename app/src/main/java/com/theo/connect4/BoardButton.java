package com.theo.connect4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;

@SuppressLint("ViewConstructor")
public class BoardButton extends android.support.v7.widget.AppCompatButton {
    int row;
    int column;
    @SuppressLint("NewApi")
    public BoardButton(Context context, int r, int c) {
        super(context);
        @SuppressLint("RestrictedApi") Drawable d = AppCompatDrawableManager.get().getDrawable(context,R.drawable.board);
        setBackground(d);
        setStateListAnimator(null);
        row = r;
        column = c;
    }

    public int getColumn(){
        return column;
    }
}