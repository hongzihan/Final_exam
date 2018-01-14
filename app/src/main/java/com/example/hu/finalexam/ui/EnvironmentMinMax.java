package com.example.hu.finalexam.ui;

import android.os.Bundle;


import com.example.hu.finalexam.R;


/**
 * Created by a1398 on 2018/1/13.
 */

public class EnvironmentMinMax extends TitleActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.environment_minmax);
        setTitle("CO2曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);



    }
}