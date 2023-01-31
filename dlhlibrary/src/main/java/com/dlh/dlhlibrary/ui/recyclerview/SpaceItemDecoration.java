package com.dlh.dlhlibrary.ui.recyclerview;

/**
 * @author: dlh
 * @date:     /6/23
 * @description
 */

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerViews support the concept of ItemDecoration: special offsets and drawing around each element.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration{

    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(space,space,space,space);
    }
}