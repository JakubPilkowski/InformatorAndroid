package pl.android.informator.ui.notice_board.notice_details;

import androidx.databinding.ObservableField;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.Notice;

public class NoticeDetailsViewModel extends BaseViewModel {
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> imgUrl = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<String> desc = new ObservableField<>();

    public void init(Notice notice) {
        title.set(notice.getTitle());
        imgUrl.set(notice.getMainImgUrl());
        price.set(notice.getPrice());
        desc.set(notice.getDescription());
    }

    public void onClick() {

    }
    // TODO: Implement the ViewModel
}
