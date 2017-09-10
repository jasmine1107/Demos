package com.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.demo.presenter.activity.MainActivityPresenter;
import com.demo.ui.fragment.HomeFragment;
import com.demo.ui.fragment.MoreFragment;
import com.demo.ui.fragment.OrderFragment;
import com.demo.ui.fragment.PersonFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends FragmentActivity {

    @Inject
    MainActivityPresenter mainActivityPresenter;
    @InjectView(R.id.center)
    FrameLayout center;
    @InjectView(R.id.bottom)
    LinearLayout bottom;
    private int childCount;
    private ArrayList<Fragment> framents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setListener();
        init();
    }

    private void init() {
        framents.add(new HomeFragment());
        framents.add(new MoreFragment());
        framents.add(new PersonFragment());
        framents.add(new OrderFragment());
        onClick.onClick(bottom.getChildAt(0));

    }

    private void changefragment(int dex) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.center,framents.get(dex),""+dex)
                .commit();
    }

    private void setListener() {
        childCount = bottom.getChildCount();
        for (int i = 0; i < childCount; i++) {
            FrameLayout childAt = (FrameLayout) bottom.getChildAt(i);
            childAt.setOnClickListener(onClick);

        }
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int i = bottom.indexOfChild(view);
            changeUi(i);
            changefragment(i);
        }
    };

    private void changeUi(int dex) {
        Toast.makeText(this,""+dex,Toast.LENGTH_SHORT).show();
        for (int i = 0; i < childCount; i++) {
            if (i == dex) {
//                bottom.getChildAt(i).setEnabled(false);
                setEnables(bottom.getChildAt(i), false);

            } else {
//                bottom.getChildAt(i).setEnabled(true);
                setEnables(bottom.getChildAt(i), true);
            }
        }
    }

    /**
     * @param item
     * @param b    将所有item 中所有控件状态一同改变
     */

    private void setEnables(View item, boolean b) {
        item.setEnabled(b);
        if (item instanceof ViewGroup) {
            int count = ((ViewGroup) item).getChildCount();
            for (int i = 0 ;i<count;i++) {
                setEnables(((ViewGroup) item).getChildAt(i),b);
            }
        }
    }
}
