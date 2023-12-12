package com.geeks.hw32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_FOR_ARG1 = "text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) { // в манифесте указано не вызывать destoy(); при повороте экрана
            // только так состояние первого фрагмента сохраняется (либо если счетчик сохранять в статичню публичную переменную класса MainActivity)
            // но состояние второго фрагмета сохряняется и без этих настроек (ответа на этот вопрос не нашел)
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
        }
    }
}