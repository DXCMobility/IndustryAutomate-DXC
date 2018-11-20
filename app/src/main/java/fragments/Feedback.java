package fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.industrialautomation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feedback extends Fragment  {

    Button mButton,sButton;
    EditText mEditText;



    public Feedback() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view = inflater.inflate(R.layout.fragment_feedback, container, false);

        mButton = (Button) view.findViewById(R.id.send_comment);
        mEditText = (EditText) view.findViewById(R.id.multilineEdittext);
        sButton = (Button) view.findViewById(R.id.reset_button);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Your Comment has successfully send ", Toast.LENGTH_LONG).show();
                mEditText.setText("");
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEditText.setText("");
            }
        });


        return view;
    }

}
