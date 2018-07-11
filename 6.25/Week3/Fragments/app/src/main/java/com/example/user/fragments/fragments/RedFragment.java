package com.example.user.fragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedFragment extends Fragment {
    public static final String STRING_TAG = RedFragment.class.getSimpleName();

    public RedFragment() {
        // Required empty public constructor
    }

    onFragmentInteractor interactor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getActivity().findViewById(R.id.btnSendDataToRed);
        final EditText editText = getActivity().findViewById(R.id.etRed);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interactor.onDataFromRed(editText.getText().toString());
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentInteractor) {
            interactor = (onFragmentInteractor) context;
        } else throw new RuntimeException("must implement interface");
    }

    public interface onFragmentInteractor {
        void onDataFromRed(String data);

    }


}
