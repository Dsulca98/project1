package com.example.project1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ConfirmationFragment extends Fragment {
    View view;
    private TextView mFragmentMessage;
    String fragmentMessage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_confirmation, container, false);
        mFragmentMessage=(TextView) view.findViewById(R.id.fragment_textview);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //setText();
    }
     /*public void setText(){
       // fragmentMessage=QuizActivity.getFragmentMessage();
        mFragmentMessage.setText(fragmentMessage);
        //getFragmentManager().popBackStack();
         //getActivity().onBackPressed();
        /*if(fragmentMessage=="Choose an option")
        {
            getActivity().onBackPressed();
        }
    }*/


}