package com.brainstormer.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AFragment extends Fragment {
private static final String ARG1 = "argument1";
    private static final String ARG2 = "argument2";
    public AFragment() {
        // Required empty public constructor
    }

    public static AFragment getInstance(String value1, int value2){
        AFragment aFragment = new AFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG1,value1);
        bundle.putInt(ARG2,value2);

        aFragment.setArguments(bundle);

        return aFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(getArguments()!=null){
            String name = getArguments().getString(ARG1);
           int num =  getArguments().getInt(ARG2);

            Log.d("Values from Act.","Name is: "+name+", RollNo is: "+num);
            ((MainActivity)getActivity()).CallFromFragment();
        }
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        TextView textView = view.findViewById(R.id.txtFrag);

        return  view;
    }
}