package com.zhj.rebook;

import android.app.Fragment;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
/**
 * Created by Administrator on 2016/8/1 0001.
 */
public class OutComeFragment extends Fragment{
    private Button button;
    private View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("aa","bbc");
            switch (view.getId()){
                case R.id.button_addMoney:
                    Toast.makeText(getActivity(),"aa",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income,container,false);
        button = (Button) view.findViewById(R.id.button_addMoney);
        button.setOnClickListener(onClickListener);
        return view;
    }

}
