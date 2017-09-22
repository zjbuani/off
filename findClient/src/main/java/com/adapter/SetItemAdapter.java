package com.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhy.sample.folderlayout.R;

import java.util.ArrayList;

/**
 * 设置界面的List 适配器
 */

public class SetItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> list;

    public SetItemAdapter(Context context, ArrayList<String> list) {
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
        ViewHodler mHodler;
        if (convertView == null) {
            mHodler = new ViewHodler();
            convertView.inflate(context, R.layout.left_menu, null);
            mHodler.setItem = (TextView) convertView.findViewById(R.id.left_tv);
            convertView.setTag(mHodler);
        } else {
            mHodler = (ViewHodler) convertView.getTag();
        }
        mHodler.setItem.setText(list.get(position));
        return convertView;
    }

    class ViewHodler {
        TextView setItem;
    }
}
