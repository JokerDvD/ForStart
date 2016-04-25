package com.example.startup.startuptaskmanager.FragmentViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.startup.startuptaskmanager.R;


/**
 * Created by David on 24.04.2016.
 */
public class NotificationFrag extends Fragment
{
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static NotificationFrag newInstance(int page, String title)
    {
        NotificationFrag fragmentNotif = new NotificationFrag();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentNotif.setArguments(args);
        return fragmentNotif;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
       page = getArguments().getInt("someInt", 0);
       title = getArguments().getString("someTitle");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        TextView tvText = (TextView) view.findViewById(R.id.tvText);
        tvText.setText(page+"--"+title);
        return view;
    }


}
