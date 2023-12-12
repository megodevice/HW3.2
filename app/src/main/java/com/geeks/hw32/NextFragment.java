package com.geeks.hw32;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NextFragment extends Fragment {

    private TextView textViewResult;
    private ImageView imageView;
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
            if (getArguments().getString(MainActivity.KEY_FOR_ARG1) != null) {
                textViewResult.setText(getArguments().getString(MainActivity.KEY_FOR_ARG1));
            }
        }
    }

    private void initListener() {
        setPictureButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            activityResultLaunch.launch(intent);
        });
    }

    private void initView() {
        textViewResult = requireActivity().findViewById(R.id.text_view_result);
        setPictureButton = requireActivity().findViewById(R.id.set_picture_button);
        imageView = requireActivity().findViewById(R.id.fragment_next_bg);
    }

    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    if (result.getData() != null) {
                        if (result.getData().getData() != null) {
                            imageView.setImageURI(result.getData().getData());
                        }
                    }
                }
            });
}