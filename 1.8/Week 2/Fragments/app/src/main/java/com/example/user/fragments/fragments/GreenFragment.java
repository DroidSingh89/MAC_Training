package com.example.user.fragments.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.fragments.R;

public class GreenFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TextView tvGreenFrag;
    private EditText etGreenFrag;
    private Button btnGreenFrag;

    public GreenFragment() {
        // Required empty public constructor
    }

    public static GreenFragment newInstance(String param1, String param2) {
        GreenFragment fragment = new GreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //bind the view in the fragment
        tvGreenFrag = view.findViewById(R.id.tvGreenFrag);
        etGreenFrag = view.findViewById(R.id.etGreenFrag);
        btnGreenFrag = view.findViewById(R.id.btnGreenFrag);
        btnGreenFrag.setOnClickListener(this);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvGreenFrag.setText(mParam1 + " " + mParam2);

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        String etData = etGreenFrag.getText().toString();

        if (mListener != null) {
            mListener.onButtonClick(etData);
        }


    }

    public void updateTextView(String data) {
        tvGreenFrag.setText(data);

    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);

        void onButtonClick(String s);

    }
}
