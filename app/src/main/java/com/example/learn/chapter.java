package com.example.learn;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class chapter extends Fragment {

    public chapter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int[] Django =
                {R.raw.djanjo1};
        int[] Photoshop=
                {R.raw.photoshop3};
        int[] PHP=
                {R.raw.php1};
        int[] Shooter=
                {R.raw.shooter1};
        int[] Java=
                {R.raw.java1};
        int[] Kivy=
                {R.raw.kivy1};
        int[] Kivyc=
                {R.raw.djanjo0};
        int[] Python=
                {R.raw.python1};
        int [] java={R.raw.java4};
        String Djangoc[]={"Django Chapter 1 "};
        String Photoshopoc[]={"Photoshop Chapter 1"};
        String PHPoc[]={"PHP Chapter1"};


        View myFragmentView= inflater.inflate(R.layout.fragment_chapter, container, false);
        final int course = getArguments().getInt("course");
        final int chapter = getArguments().getInt("chapter");
        VideoView videoView=(VideoView) myFragmentView.findViewById(R.id.videoView3);
        TextView t1=(TextView) myFragmentView.findViewById(R.id.t1);

        MediaController mediaController=new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        String path="android.resource://"+ getActivity().getPackageName() +"/"+Django[chapter];
        //  Toast.makeText(get,path,Toast.LENGTH_LONG).show();

        if (course==0)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+Django[chapter];
            t1.setText(Djangoc[chapter]);

        }
        else if (course ==2)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+PHP[chapter];
        }
        else if (course ==3)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+Shooter[chapter];
        }
        else if (course ==4)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+Java[chapter];
        }
        else if (course ==6)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+Kivy[chapter];
        }
        else if (course ==1)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+Photoshop[chapter];
        }
        else if (course ==4)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+java[chapter];
        }
        else if (course ==7)
        {
            path="android.resource://"+ getActivity().getPackageName() +"/"+Python[chapter];
        }
        Log.d("videopath",path);
        Uri uri= Uri.parse(path);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        // Inflate the layout for this fragment
        return myFragmentView;
    }
}
