package com.example.user.fragments.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedFragment extends Fragment {
    public static final String TAG = RedFragment.class.getSimpleName()+ "_TAG";

    private static final String ARG_TEXT_VALUE = "param1";

    private String textValue;

    private OnFragmentInteractionListener mListener;
    private TextView tvFragRed;

    public RedFragment() {
        // Required empty public constructor
    }

    public static RedFragment newInstance(String textValue) {
        RedFragment fragment = new RedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT_VALUE, textValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            textValue = getArguments().getString(ARG_TEXT_VALUE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_red, container, false);
        tvFragRed = view.findViewById(R.id.tvFragRed);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateTextView(textValue);

    }

    public void updateTextView(String textValue) {
        tvFragRed.setText(textValue);
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
    
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
