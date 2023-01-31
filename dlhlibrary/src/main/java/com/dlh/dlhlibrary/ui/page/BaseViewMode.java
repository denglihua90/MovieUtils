package com.dlh.dlhlibrary.ui.page;

import androidx.lifecycle.ViewModel;

/**
 * @author: dlh
 * @date:     /6/16
 * @description
 */
public abstract class BaseViewMode extends ViewModel {

    public enum LoadingState {
        FIRSTLOAD,REFRESH,LOADMORE
    }
}
