package com.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.http.response.bean.SignInBean;
import com.zhy.sample.folderlayout.R;

import java.util.List;

/**
 * 左侧 Fragment 的 ListView 的 适配器
 * Created by fengx on 2017/9/20.
 */

public class LeftAdapter extends BaseAdapter {

    private final Context context;
    private final List<SignInBean.BuildListJavaBean> list;

    public LeftAdapter(Context context, List<SignInBean.BuildListJavaBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder = null;
        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.left_menu, null);
            mHolder.mLItem= (TextView) convertView.findViewById(R.id.left_tv);
            convertView.setTag(mHolder);
        }else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mHolder.mLItem.setText(list.get(position).getBuild_name());

        return convertView;
    }
    class ViewHolder{
        private TextView mLItem;

    }
}
