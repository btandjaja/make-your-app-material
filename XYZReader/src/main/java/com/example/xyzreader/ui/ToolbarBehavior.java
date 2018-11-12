package com.example.xyzreader.ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.TypedValue;
import android.view.View;

import com.example.xyzreader.R;

public class ToolbarBehavior extends CoordinatorLayout.Behavior<HeaderView> {
    private Context mContext;
    private int mStartMarginLeft;
    private int mEndMargintLeft;
    private int mStartMarginBottom;
    private int mMarginRight;
    private boolean isHide;

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
        shouldInitProperties();
        int maxScroll = ((AppBarLayout)dependency).getTotalScrollRange();
        float percentage = Math.abs(dependency.getY()) / (float) maxScroll;

        float childPosition = dependency.getHeight()
                + dependency.getY()
                - child.getHeight()
                - (getToolbarHeight() - child.getHeight()) * percentage / 2;

        childPosition = childPosition - mStartMarginBottom * (1f - percentage);

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.leftMargin = (int) (percentage * mEndMargintLeft) + mStartMarginLeft;
        lp.rightMargin = mMarginRight;

        child.setLayoutParams(lp);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if (isHide && percentage < 1) {
                child.setVisibility(View.VISIBLE);
            } else if (!isHide && percentage == 1) {
                child.setVisibility(View.GONE);
            }
            isHide = !isHide;
        }

        return true;
    }

    private void shouldInitProperties() {
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
        TypedValue tv = new TypedValue();
        return mContext.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true) ?
                0 : TypedValue.complexToDimensionPixelOffset(tv.data, mContext.getResources().getDisplayMetrics());
    }
}
