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

public class MainFragment extends Fragment {
    private Button plusButton;
    private Button minusButton;
    private Button nextFragmentButton;
    private TextView textViewCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        textViewCount.setText(String.valueOf(MainActivity.count));
    }

    private void initListener() {
        plusButton.setOnClickListener(v -> {
            MainActivity.count++;
            textViewCount.setText(String.valueOf(MainActivity.count));
        });

        minusButton.setOnClickListener(v -> {
            MainActivity.count--;
            textViewCount.setText(String.valueOf(MainActivity.count));
        });
        nextFragmentButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString(MainActivity.KEY_FOR_ARG1, textViewCount.getText().toString());
            NextFragment nextFragment = new NextFragment();
            nextFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    nextFragment).addToBackStack(null).commit();
        });
    }

    private void initView() {
        plusButton = requireActivity().findViewById(R.id.button_plus);
        minusButton = requireActivity().findViewById(R.id.button_minus);
        textViewCount = requireActivity().findViewById(R.id.text_view_count);
        nextFragmentButton = requireActivity().findViewById(R.id.next_fragment_button);
    }
}