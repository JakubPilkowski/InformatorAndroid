package com.example.informator.adapters.notice_board;

import com.example.informator.base.BaseAdapterViewModel;
import com.example.informator.navigation.Navigator;

public class NoticeBoardHeaderAdapterViewModel extends BaseAdapterViewModel {

    private Navigator navigator;
    @Override
    public void init(Object[] values) {
        navigator = (Navigator)values[0];
    }
    public void onSortClick(){

    }
    public void onAddClick(){

    }
}
