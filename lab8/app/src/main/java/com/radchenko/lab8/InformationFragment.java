package com.radchenko.lab8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InformationFragment extends Fragment
{
    public static final class Companion
    {
        public static InformationFragment newInstance() {
            InformationFragment informationFragment = new InformationFragment();
            informationFragment.setArguments(new Bundle());
            return informationFragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        TextView textView = view.findViewById(R.id.textView);
        TextView textView2 = view.findViewById(R.id.textView2);
        return view;
    }
}
