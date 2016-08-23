package com.zhj.rebook;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.button_income)
    Button button_income;
    @ViewInject(R.id.button_outcome)
    Button button_outcome;
    @ViewInject(R.id.button_final)
    Button button_sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Event({R.id.button_income,R.id.button_final,R.id.button_outcome})
    private void Income(View view){
        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.button_income:
                button_income.setTextColor(Color.RED);
                EasyFragment fragment = new EasyFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                break;
            case R.id.button_outcome:
                button_outcome.setTextColor(Color.BLACK);
                IncomeFragment incomeFragment = new IncomeFragment();
                fragmentTransaction.replace(R.id.fragment_container,incomeFragment);
                break;
            case R.id.button_final:
                button_sum.setTextColor(Color.BLUE);
                OutComeFragment outcomeFragment = new OutComeFragment();
                fragmentTransaction.replace(R.id.fragment_container,outcomeFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
        int x = view.getId();
        Log.d("aa"+x,"bb");
        Toast.makeText(getApplicationContext(),"aaa",Toast.LENGTH_SHORT);
    }
}
