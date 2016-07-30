package com.nik.noveo.scroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MyScrollView extends HorizontalScrollView {

    private LinearLayout linearLayout;


    public MyScrollView(Context context) {
        super(context);
        init(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(lParams);
        addView(linearLayout);

        setHorizontalScrollBarEnabled(false);
        OverScrollDecoratorHelper.setUpOverScroll(this);
    }

    public void setItems(List<String> itemNames) {
        for (final String itemName : itemNames) {
            Button button = new Button(getContext());
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            button.setLayoutParams(lParams);
            button.setText(itemName);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), itemName + " CLICKED", Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(button);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (getParent() != null) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
        }

        return super.onInterceptTouchEvent(ev);
    }

}
