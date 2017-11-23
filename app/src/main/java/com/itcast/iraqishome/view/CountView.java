package com.itcast.iraqishome.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.itcast.iraqishome.R;

/**
 * Created by yb on 2017/11/23.
 */

public class CountView extends LinearLayout implements View.OnClickListener,TextWatcher{

    private Button btnDecrease;
    private Button btnIncrease;
    private EditText etAmount;
    private static final int GOODS_MAX = 299;
    private int mCount;

    public CountView(Context context) {
        this(context,null);
    }

    public CountView(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public CountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.goods_group_amount, this);
        btnDecrease = (Button)view.findViewById(R.id.btn_decrease);
        btnIncrease = (Button)view.findViewById(R.id.btn_increase);
        etAmount = (EditText)view.findViewById(R.id.et_amount);

        //设置监听事件
        btnDecrease.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        etAmount.addTextChangedListener(this);

        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);
        int btnWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnWidth, LayoutParams.WRAP_CONTENT);
        int tvWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvWidth, 80);
        int tvTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvTextSize, 0);
        int btnTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnTextSize, 0);
        obtainStyledAttributes.recycle();

        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);
        btnDecrease.setLayoutParams(btnParams);
        btnIncrease.setLayoutParams(btnParams);
        if (btnTextSize != 0) {
            btnDecrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
            btnIncrease.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
        }

        LayoutParams textParams = new LayoutParams(tvWidth, LayoutParams.MATCH_PARENT);
        etAmount.setLayoutParams(textParams);
        if (tvTextSize != 0) {
            etAmount.setTextSize(tvTextSize);
        }

        String content = etAmount.getText().toString();
        mCount = Integer.valueOf(content);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_decrease:
                if(mCount > 1) {
                    mCount--;
                    etAmount.setText(mCount+"");
                }
                break;
            case R.id.btn_increase:
                if(mCount < GOODS_MAX) {
                    mCount++;
                    etAmount.setText(mCount+"");
                }
                break;
            default:
                break;
        }
        etAmount.clearFocus();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(editable.toString().isEmpty()) {
            return;
        }
        mCount = Integer.valueOf(editable.toString());
        if(mCount > GOODS_MAX) {
            etAmount.setText(GOODS_MAX+"");
            return;
        }
    }

    public int getCount(){
        return mCount;
    }
}
