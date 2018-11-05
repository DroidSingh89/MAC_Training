package com.example.user.fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.fragments.R;

public class YellowFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = YellowFragment.class.getSimpleName();

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String FIRST_NAME_PARAM = "param1";
    private static final String LAST_NAME_PARAM = "param2";

    private String firstName;
    private String lastName;

    private OnFragmentInteractionListener mListener;
    private TextView tvFirstName;
    private TextView tvLasttName;
    private Button btnSendData;

    public YellowFragment() {
        // Required empty public constructor
    }


    public static YellowFragment newInstance(String firstName, String lastName) {
        YellowFragment fragment = new YellowFragment();
        Bundle args = new Bundle();
        args.putString(FIRST_NAME_PARAM, firstName);
        args.putString(LAST_NAME_PARAM, lastName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");


        if (getArguments() != null) {
            firstName = getArguments().getString(FIRST_NAME_PARAM);
            lastName = getArguments().getString(LAST_NAME_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yellow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFirstName = view.findViewById(R.id.tvFirstName);
        tvLasttName = view.findViewById(R.id.tvLastName);
        btnSendData = view.findViewById(R.id.btnSendData);
        btnSendData.setOnClickListener(this);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvFirstName.setText(firstName);
        tvLasttName.setText(lastName);

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
        //set the textview in the main
        onButtonPressed("Some Data");

//        show toast
        mListener.showToast("From Yellow");

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);

        void showToast(String message);
    }
}
