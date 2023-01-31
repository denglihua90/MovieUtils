package com.dlh.dlhlibrary.utils;
import android.graphics.drawable.Drawable;

import androidx.annotation.ArrayRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.blankj.utilcode.util.Utils;

/**
 * @author: dlh
 * @date:     /6/9
 * @description
 */
public class ResourceDLHUtils  {

    public static int getColor(@ColorRes int id) {
        return Utils.getApp().getResources().getColor(id);
    }

    public static String getString(@StringRes int id) {
        return Utils.getApp().getResources().getString(id);
    }

    public static String[] getStringArray(@ArrayRes int id) {
        return Utils.getApp().getResources().getStringArray(id);
    }
    public static float getDimension(@DimenRes int id) {
        return Utils.getApp().getResources().getDimension(id);
    }

    public static Drawable DrawableRes(@DrawableRes int id) {
        return Utils.getApp().getResources().getDrawable(id);
    }

}
