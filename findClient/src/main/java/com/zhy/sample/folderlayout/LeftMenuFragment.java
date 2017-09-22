package com.zhy.sample.folderlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.adapter.LeftAdapter;
import com.http.response.bean.SignInBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhy http://blog.csdn.net/lmj623565791/
 */
public class LeftMenuFragment extends Fragment {

    private ListView mMenus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignInBean  signInBean = (SignInBean)getArguments().getSerializable("SignInBean");
        View view = inflater.inflate(R.layout.fragment_left_menu, container,
                false);
        mMenus = (ListView) view.findViewById(R.id.id_left_menu_lv);
        mMenus.setAdapter(new LeftAdapter(getContext(), signInBean.getBuild_list()));

        return view;
    }
}
