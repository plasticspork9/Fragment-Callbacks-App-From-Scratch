package com.example.fragmentcallbacksappfromscratch.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentcallbacksappfromscratch.R;

public class InputFragment extends Fragment {
    private View rootView;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private Button button;

    private OnInputFragmentInteractionListener mListener;

    public InputFragment() {
    }

    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_input, container, false);
        editText = rootView.findViewById(R.id.input_edit_text);
        editText2 = rootView.findViewById(R.id.input_edit_text2);
        editText3 = rootView.findViewById(R.id.input_edit_text3);
        button = rootView.findViewById(R.id.input_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                String input2 = editText2.getText().toString();
                String input3 = editText3.getText().toString();
                onButtonPressed(input, input2, input3);
            }
        });
        return rootView;
    }

    public void onButtonPressed(String input, String input2, String input3) {
        if (mListener != null) {
            mListener.onInputFragmentInteraction(input, input2, input3);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInputFragmentInteractionListener) {
            mListener = (OnInputFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnInputFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnInputFragmentInteractionListener {
        void onInputFragmentInteraction(String input, String input2, String input3);
    }
}
