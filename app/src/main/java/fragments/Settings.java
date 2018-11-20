package fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import example.com.industrialautomation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    Switch mSwitch;


    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        mSwitch = (Switch) view.findViewById(R.id.switchbutton2);
     //   final MediaPlayer mp = MediaPlayer.create(this,R.raw.soho);


        return view;
    }

}
