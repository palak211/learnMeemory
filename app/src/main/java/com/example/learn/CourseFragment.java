package com.example.learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import androidx.cardview.widget.CardView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseFragment extends Fragment {
    GridView simpleListView;
    String[] courseNames =
            {"Djanjo", " Photoshop", " Learn PHP", "Shooter Game","Java","Java Script","Kivy","Python"};
    int[] courseImages =
            {R.drawable.django, R.drawable.photoshop, R.drawable.phpp,
                    R.drawable.scartch,R.drawable.javaj,R.drawable.js,
                    R.drawable.kc,R.drawable.python};
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View myFragmentView= inflater.inflate(R.layout.fragment_course,container,false);
        simpleListView = (GridView)myFragmentView. findViewById(R.id.home_grid);


        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < courseNames.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", courseNames[i]);
            hashMap.put("image", courseImages[i] + "");
            arrayList.add(hashMap);
        }
        String[] from = {"name", "image"};
        int[] to = {R.id.tv1, R.id.imageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.layout, from, to);
        simpleListView.setAdapter(simpleAdapter);
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                coursedetails ldf = new coursedetails ();
                Bundle args = new Bundle();
                args.putInt("course",i);
                ldf.setArguments(args);
                getActivity().getSupportFragmentManager().
                        beginTransaction().replace(R.id.fragment_container, ldf).commit();
            }
        });
           return myFragmentView;
    }
}


