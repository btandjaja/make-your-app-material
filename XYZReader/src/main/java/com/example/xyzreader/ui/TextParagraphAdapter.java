package com.example.xyzreader.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

public class TextParagraphAdapter extends RecyclerView.Adapter<TextParagraphAdapter.TextParagraphViewHolder> {
    private String[] mTextBody;
    private Context mContext;

    public TextParagraphAdapter(Context context) {
        mContext = context;
        mTextBody = new String[]{};
    }

    public void setTextBody(String[] bodyText) {
        mTextBody = bodyText;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TextParagraphViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_body_for_recyclerview, viewGroup, false);
        return new TextParagraphViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextParagraphViewHolder textParagraphViewHolder, int i) {
        if(mTextBody[i] == null) return;
        textParagraphViewHolder.mTextView.setTypeface(Typeface.createFromAsset(mContext.getResources().getAssets(),
                "Rosario-Regular.ttf"));
        textParagraphViewHolder.mTextView.setText(mTextBody[i]);
    }

    @Override
    public int getItemCount() {
        return mTextBody == null ? 0 : mTextBody.length;
    }

    public class TextParagraphViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public TextParagraphViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.article_body);
        }
    }
}
