package com.example.tp4exo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment {

    private EditText mEditText;
    private Button btn;

    public SimpleDialogFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static SimpleDialogFragment newInstance(int layoutID) {
        SimpleDialogFragment SDFR = new SimpleDialogFragment();
        Bundle args = new Bundle();
        args.putInt("layoutID", layoutID);
        SDFR.setArguments(args);
        return SDFR;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int layoutID = getArguments().getInt("layoutID", R.layout.paypal);
        return inflater.inflate(layoutID, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

}
