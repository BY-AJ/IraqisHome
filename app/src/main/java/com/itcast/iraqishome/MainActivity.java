package com.itcast.iraqishome;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.itcast.iraqishome.activity.BaseActivity;
import com.itcast.iraqishome.adapter.MainAdapter;
import com.itcast.iraqishome.view.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.viewpager) NoScrollViewPager mViewPager;
    @BindView(R.id.rg_group) RadioGroup mRadioGroup;
    private int[] mRbIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化基本信息
        initBasic();
        //初始化数据
        initData();
    }

    private void initData() {
        //1.设置适配器
        mViewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        //2.设置Viewpager缓存页数
        mViewPager.setOffscreenPageLimit(4);
        //3.设置Radiogruop监听器
        mRadioGroup.setOnCheckedChangeListener(this);
        //4.设置默认第一个RadioButton选中
        mRadioGroup.check(mRbIds[0]);
    }

    private void initBasic() {
        ButterKnife.bind(this);
        mRbIds = new int[]{R.id.rb_home,R.id.rb_category,R.id.rb_stroll,R.id.rb_shopping,R.id.rb_center};
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        for (int i=0; i<mRbIds.length;i++) {
            if(checkedId == mRbIds[i]) {
                mViewPager.setCurrentItem(i,false);
                break;
            }
        }
    }
}
