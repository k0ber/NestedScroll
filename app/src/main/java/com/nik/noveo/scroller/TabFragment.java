package com.nik.noveo.scroller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TabFragment extends Fragment {

    public static final String ARG_NUMBER = "number";


    public static TabFragment newInstance(int number) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(TabFragment.ARG_NUMBER, number + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        Bundle args = getArguments();
        String text = "Tab Fragment  #" + Integer.toString(args.getInt(ARG_NUMBER));
        ((TextView) rootView.findViewById(R.id.text1)).setText(text);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("ITEM 0");
        strings.add("ITEM 1");
        strings.add("ITEM 2");
        strings.add("ITEM 3");
        strings.add("ITEM 4");
        strings.add("ITEM 5");
        strings.add("ITEM 6");
        strings.add("ITEM 7");
        strings.add("ITEM 8");
        strings.add("ITEM 9");
        ((MyScrollView) rootView.findViewById(R.id.scroller)).setItems(strings);

        return rootView;
    }

}
