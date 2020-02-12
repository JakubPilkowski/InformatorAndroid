package pl.android.informator.ui.notice_board.notice_details;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.databinding.NoticeDetailsFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.Notice;

public class NoticeDetailsViewModel extends BaseViewModel {
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> imgUrl = new ObservableField<>();
    public ObservableField<List<String>> imgUrls = new ObservableField<>();
    public ObservableField<String> price = new ObservableField<>();
    public ObservableField<String> desc = new ObservableField<>();
    public ObservableField<ViewPager> viewPager = new ObservableField<>();
    public ObservableField<NoticeDetailsViewModel> viewModel = new ObservableField<>();

    public void init(Notice notice) {
        title.set(notice.getTitle());
        imgUrls.set(notice.getImgUrls());
        viewModel.set(this);
        price.set(notice.getPrice());
        desc.set(notice.getDescription());
        viewPager.set(((NoticeDetailsFragmentBinding) getBinding()).noticeDetailsViewpager);
    }

    public void onClick() {

    }

    public void setImage(String imgUrl) {
        this.imgUrl.set(imgUrl);
    }
    // TODO: Implement the ViewModel
}
