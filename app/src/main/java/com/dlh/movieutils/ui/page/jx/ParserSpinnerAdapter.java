package com.dlh.movieutils.ui.page.jx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.dlh.movieutils.R;
import com.dlh.movieutils.databinding.ItemParserSpinnerAdapterItemLayoutBinding;

import java.util.ArrayList;

/**
 * @author: dlh
 * @date:     /5/15
 * @description
 */
public class ParserSpinnerAdapter extends BaseAdapter  {
    private ArrayList<ParserBean> mList;

    public ParserSpinnerAdapter(ArrayList<ParserBean> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ParserBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemParserSpinnerAdapterItemLayoutBinding itemBinding;
        if (convertView == null) {
            itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_parser_spinner_adapter_item_layout, parent, false);
            convertView = itemBinding.getRoot();
            convertView.setTag(itemBinding);
        }
        else {
            itemBinding = (ItemParserSpinnerAdapterItemLayoutBinding) convertView.getTag();

        }
         itemBinding.setMParserBean(mList.get(position));

        return convertView;
    }

}
