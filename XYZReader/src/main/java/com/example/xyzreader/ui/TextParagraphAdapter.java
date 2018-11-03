package com.example.xyzreader.ui;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextParagraphAdapter extends RecyclerView.Adapter<TextParagraphAdapter.TextPararaphViewHolder> {

    @NonNull
    @Override
    public TextPararaphViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TextPararaphViewHolder textPararaphViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TextPararaphViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public TextPararaphViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
