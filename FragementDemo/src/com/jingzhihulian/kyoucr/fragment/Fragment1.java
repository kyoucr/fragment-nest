package com.jingzhihulian.kyoucr.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.jingzhihulian.kyoucr.activity.R;

/**
 * 
 */
public class Fragment1 extends Fragment implements View.OnClickListener{
    private FragmentTransaction ft;
    private List<Fragment> list = new ArrayList<Fragment>();
    private int gapWidth;
    private int bmWidth;
    int beforeItem = 0;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment1, null);
        init(view);
        initViewPage(view);
        return view;
    }
    private void init(View view) {
        TextView textview1 = (TextView) view.findViewById(R.id.textview1);
        TextView textview2 = (TextView) view.findViewById(R.id.textview2);
        TextView textview3 = (TextView) view.findViewById(R.id.textview3);
        textview1.setOnClickListener(this);
        textview2.setOnClickListener(this);
        textview3.setOnClickListener(this);
        initImage(view);
    }
    private void initImage(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        setImageStartMove(imageView);
    }
    private void initViewPage(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        list.add(new Fragment4());
        list.add(new Fragment5());
        list.add(new Fragment6());
        viewPager.setAdapter(new FragmentAdapter(getActivity().getSupportFragmentManager()));
        MoveImage(view);
    }
    /**
     * 让图片移动到起始位置
     */
    private void setImageStartMove(ImageView imageView) {
        bmWidth = BitmapFactory.decodeResource(getResources(), R.drawable.line_below).getWidth();
       /*获取屏幕宽度*/
        int screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
       /*计算间隙宽度*/
        gapWidth = (screenWidth / 3 - bmWidth) / 2;
        System.out.println("--->"+gapWidth);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(gapWidth, 0, 0, 0);
        imageView.setLayoutParams(params);
    }
    private void MoveImage(  View view) {

        final ImageView imageView=(ImageView)view.findViewById(R.id.image);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int one = gapWidth * 2 + bmWidth;
                int two = one * 2;
                Animation animation = null;
                switch (position) {
                    case 0:
                        if (beforeItem == 1) {
                            animation = new TranslateAnimation(one, 0, 0, 0);
                        } else {
                            animation = new TranslateAnimation(two, 0, 0, 0);
                        }
                        break;
                    case 1:
                        if (beforeItem == 0) {
                            animation = new TranslateAnimation(gapWidth, one, 0, 0);
                        } else {
                            animation = new TranslateAnimation(two, one, 0, 0);
                        }
                        break;
                    case 2:
                        if (beforeItem == 0) {
                            animation = new TranslateAnimation(gapWidth, two, 0, 0);
                        } else {
                            animation = new TranslateAnimation(one, two, 0, 0);
                        }
                        break;
                }
                animation.setDuration(200);//设置动画的持续时间
                animation.setFillAfter(true);//让动画停止在结束位置
                imageView.startAnimation(animation);
                beforeItem=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textview1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.textview2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.textview3:
                viewPager.setCurrentItem(2);
                break;
        }

    }
    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        // 当某子项被摧毁时
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        // 判断该view是否来自对象
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return super.isViewFromObject(view, object);
        }
    }
}
