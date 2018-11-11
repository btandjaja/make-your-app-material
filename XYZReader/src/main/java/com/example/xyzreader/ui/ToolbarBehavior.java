package com.example.xyzreader.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toolbar;

import com.example.xyzreader.R;

public class ToolbarBehavior extends CoordinatorLayout.Behavior<HeaderView> {
    private Context mContext;
    private int mStartMarginLeft;
    private int mEndMargintLeft;
    private int mStartMarginBottom;
    private int mMarginRight;

    public ToolbarBehavior(Context context) {
        mContext = context;
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull HeaderView child, @NonNull View dependency) {
        // TODO remove
        // return super.layoutDependsOn(parent, child, dependency);
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull HeaderView child, @NonNull View dependency) {
        // TODO remove
        // return super.onDependentViewChanged(parent, child, dependency);
        shouldInitProperties(child, dependency);
        int maxScroll = ((AppBarLayout)dependency).getTotalScrollRange();
        float percent = Math.abs(dependency.getY()) / (float) maxScroll;

        float childPosition = dependency.getHeight()
                + dependency.getY()
                - child.getHeight()
                - (getToolbarHeight() - child.getHeight()) * percent / 2;
        // TODO not finish
        return false;
    }

    private void shouldInitProperties(HeaderView child, View dependency) {
        if (mStartMarginLeft == 0) {
            mStartMarginLeft = mContext.getResources().getDimensionPixelOffset(R.dimen.header_view_start_margin_left);
        }

        if (mEndMargintLeft == 0) {
            mEndMargintLeft = mContext.getResources().getDimensionPixelOffset(R.dimen.header_view_end_margin_left);
        }

        if (mStartMarginBottom == 0) {
            mStartMarginBottom = mContext.getResources().getDimensionPixelOffset(R.dimen.header_view_start_margin_bottom);
        }

        if (mMarginRight == 0) {
            mMarginRight = mContext.getResources().getDimensionPixelOffset(R.dimen.header_view_end_margin_right);
        }
    }

    private int getToolbarHeight() {
        int result = 0;
        TypedValue tv = new TypedValue();
        // TODO not finish
//        if (mContext.getTheme().resolveAttribute())
        return 0;
    }
}
