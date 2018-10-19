package com.example.budakgigibesi.ibeacon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_main extends Fragment {
    

    //public fragment_main() {
        // Required empty public constructor
    //}

    // TODO: Rename and change types and number of parameters
    public static fragment_main newInstance() {
        fragment_main fragment = new fragment_main();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.f_fragment_main, container, false);
    }
	

    
}
