package com.example.learn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Startcourse extends Fragment {

    public Startcourse() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final int value = getArguments().getInt("course");
        Toast.makeText(getActivity(), "StartCourse" + value, Toast.LENGTH_LONG).show();
        View myFragmentView = inflater.inflate(R.layout.fragment_startcourse, container, false);

        Button b1 = (Button) myFragmentView.findViewById(R.id.s1);
        Button b2 = (Button) myFragmentView.findViewById(R.id.s2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Onclick", "Onclick");
                Toast.makeText(getActivity(), "Chapter", Toast.LENGTH_LONG).show();
                chapter ldf = new chapter();
                Bundle args = new Bundle();
                args.putInt("course", value);
                args.putInt("chapter", 0);
                ldf.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ldf).commit();

            }
        });


        return myFragmentView;
    }
}