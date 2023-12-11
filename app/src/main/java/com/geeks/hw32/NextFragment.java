package com.geeks.hw32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class NextFragment extends Fragment {

    private TextView textViewResult;
    private Button setPictureButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_next, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();

        if (getArguments() != null) {
            if (getArguments().getString(MainActivity.KEY_FOR_ARG1) != null){
                textViewResult.setText(getArguments().getString(MainActivity.KEY_FOR_ARG1));
            }
        }
    }

    private void initListener() {
        setPictureButton.setOnClickListener(v -> {

        });
    }

    private void initView() {
        textViewResult = requireView().findViewById(R.id.text_view_result);
        setPictureButton = requireView().findViewById(R.id.set_picture_button);
    }
}