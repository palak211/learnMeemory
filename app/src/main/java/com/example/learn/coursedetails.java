package com.example.learn;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class coursedetails extends Fragment {
    String[] courseNames =
            {"Djanjo","Photoshop"  ,"Learn Php", "Shooter Game","Java","Java Script","Kivy","Python"};
    int vid =R.raw.msband;
    public coursedetails() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final int value = getArguments().getInt("course");
        if (value==0){
            vid=R.raw.djanjo0;
        }
        else if(value==1)
        {
            vid=R.raw.photoshop1;
        }
        else if(value==2)
        {
            vid=R.raw.php2;
        }
        else if(value==3)
        {
            vid=R.raw.shooter3;
        }
        else if(value==4)
        {
            vid=R.raw.java4;
        }
        else if(value==5)
        {
            vid=R.raw.javascript5;
        }
        else if(value==6)
        {
            vid=R.raw.kivy6;
        }
        else if(value==7)
        {
            vid=R.raw.python7;
        }
        View myFragmentView =inflater.inflate(R.layout.fragment_coursedetails, container, false);
        Toast.makeText(getActivity(),"course details "+value+"", Toast.LENGTH_LONG).show();
        VideoView videoView=(VideoView) myFragmentView.findViewById(R.id.videoView2);

        MediaController mediaController=new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        String path="android.resource://"+ getActivity().getPackageName() +"/"+vid;
        //  Toast.makeText(get,path,Toast.LENGTH_LONG).show();
        Log.d("videopath",path);
        Uri uri= Uri.parse(path);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        Button b1 = (Button)myFragmentView.findViewById(R.id.link);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Onclick","Onclick");
                Toast.makeText(getActivity(),"Hello", Toast.LENGTH_LONG).show();
                Startcourse ldf = new Startcourse ();
                Bundle args = new Bundle();
                args.putInt("course", value);
                ldf.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ldf).commit();

            }
        });
        return myFragmentView;

    }

}
