package com.fragment;

import android.view.View;
import android.widget.ListView;

import com.adapter.LeftAdapter;
import com.http.response.bean.SignInBean;
import com.zhy.sample.folderlayout.R;

/**
 * @author zhy http://blog.csdn.net/lmj623565791/
 */
public class LightFragment extends BaseFragment {

    private ListView mMenus;
    private SignInBean signInBean;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.light_fragment_layout, null);

//        mMenus = (ListView) view.findViewById(R.id.id_left_menu_lv);
        return view;
    }


    /*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignInBean  signInBean = (SignInBean)getArguments().getSerializable("SignInBean");
        View view = inflater.inflate(R.layout.fragment_left_menu, container,false);

        mMenus = (ListView) view.findViewById(R.id.id_left_menu_lv);
        mMenus.setAdapter(new LeftAdapter(getContext(), signInBean.getBuild_list()));

        return view;
    }*/
}
