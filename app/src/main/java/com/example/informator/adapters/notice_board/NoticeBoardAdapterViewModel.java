package com.example.informator.adapters.notice_board;

import androidx.databinding.ObservableField;

import com.example.informator.base.BaseAdapterViewModel;
import com.example.informator.models.Notice;
import com.example.informator.navigation.Navigator;

public class NoticeBoardAdapterViewModel extends BaseAdapterViewModel {


    private Navigator navigator;
    private Notice notice;
    public ObservableField<String>imgUrl = new ObservableField<>();
    public ObservableField<String>title = new ObservableField<>();
    public ObservableField<String>price = new ObservableField<>();
    @Override
    public void init(Object[] values) {
        navigator = (Navigator) values[0];
        notice = (Notice) values[1];
        imgUrl.set(notice.getMainImgUrl());
        title.set(notice.getTitle());
        price.set(notice.getPrice());
    }

    public void onDetailsClick(){

    }

}
