package com.example.startup.startuptaskmanager.PageFragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.startup.startuptaskmanager.R;

import java.util.Random;

/**
 * Created by David on 20.04.2016.
 */
public class PageFragment extends Fragment

{
    static final String ARGUMENT_PAGE_NUMBER="arg_page_number";
    static final String TAG = "myLogs";
    static final String SAVE_PAGE_NUMBER = "save_page_number";
    int pageNumber;
    int backColor;

    public static PageFragment newInstance(int page, String s)
    {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pageNumber=getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        int savedPageNumber = -1;
        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER);
        }
        Log.d(TAG, "savedPageNumber = " + savedPageNumber);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tabhost, null);
        TextView tvPage=(TextView) view.findViewById(R.id.tvPage);
        tvPage.setText("Page "+pageNumber);
        tvPage.setBackgroundColor(backColor);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + pageNumber);
    }
}
