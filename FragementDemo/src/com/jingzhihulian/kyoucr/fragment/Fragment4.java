package com.jingzhihulian.kyoucr.fragment;

import com.jingzhihulian.kyoucr.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/1/13.
 */
public class Fragment4 extends Fragment{
    /**
     * Fragment需要第一次绘制界面时，系统调用此方法。为了创建一个UI，必须返回一个View，这个View是从Fragment的Layout文件中得到的。如果你的Fragment不想提供UI的，就返回null
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment4, null);
    }

    /**
     *当创建Fragment的时候，系统调用这个方法。在你的方法实现中，你要初始化你必须的组件。
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    /**
     * 当系统调用此方法时，第一表明用户已经离开了此Fragment。通常要在这个方法内提交发生的变化。
     */
    @Override
    public void onPause() {
        super.onPause();
    }


    /**
     *当fragment被加入到activity时调用（在这个方法中可以获得所在的activity）
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
    }

    /**
     * 当fragment被从activity中删掉时被调用。
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }
    /**
     *当fragment的layout被销毁时被调用。
     */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
