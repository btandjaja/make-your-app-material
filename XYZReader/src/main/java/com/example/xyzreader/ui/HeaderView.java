package com.example.xyzreader.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xyzreader.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderView extends LinearLayout {

    @BindView(R.id.tv_header_view_title) TextView mHeaderTitle;

    // base constructor
    public HeaderView(Context context) {
        super(context);
    }

    // constructor with different attribute
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindTo(String title) { mHeaderTitle.setText(title); }

    public void hideOrSetText(TextView tv, String title) {
        if (TextUtils.isEmpty(title) || title == null) {
            tv.setVisibility(GONE);
        } else {
            tv.setText(title);
        }
    }
}