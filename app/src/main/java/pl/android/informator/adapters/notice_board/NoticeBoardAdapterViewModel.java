package pl.android.informator.adapters.notice_board;

import androidx.databinding.ObservableField;

import pl.android.informator.base.BaseAdapterViewModel;
import pl.android.informator.models.Notice;
import pl.android.informator.navigation.Navigator;

public class NoticeBoardAdapterViewModel extends BaseAdapterViewModel{


    private Navigator navigator;
    private Notice notice;
    public ObservableField<String> imgUrl = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    @Override
    public void init(Object[] values) {
        navigator = (Navigator) values[0];
        notice = (Notice) values[1];
        imgUrl.set(notice.getMainImgUrl());
        title.set(notice.getTitle());
        price.set(notice.getPrice());
    }

    public void onDetailsClick() {
        navigator.showNoticeDetails(notice);
    }

}
