package pl.android.informator.ui.notice_board.notice_details;

import androidx.databinding.ViewDataBinding;

import com.android.informator.R;
import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseFragment;
import com.android.informator.databinding.NoticeDetailsFragmentBinding;
import pl.android.informator.interfaces.Providers;
import pl.android.informator.models.Notice;
import pl.android.informator.navigation.Navigator;

public class NoticeDetailsFragment extends BaseFragment<NoticeDetailsFragmentBinding, NoticeDetailsViewModel> implements Providers {

    public static final String TAG = "NoticeDetailsFragment";

    public static NoticeDetailsFragment newInstance(Notice notice) {
        NoticeDetailsFragment fragment = new NoticeDetailsFragment();
        fragment.setNotice(notice);
        return fragment;
    }

    private Notice notice;

    private void setNotice(Notice notice){
        this.notice = notice;
    }

    private Notice getNotice() {
        return notice;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.notice_details_fragment;
    }

    @Override
    public Class<NoticeDetailsViewModel> getViewModelClass() {
        return NoticeDetailsViewModel.class;
    }

    @Override
    public void bindData(NoticeDetailsFragmentBinding binding) {
        binding.setViewModel(viewModel);
        viewModel.setProviders(this);
        viewModel.init(getNotice());
    }

    @Override
    public int getToolbarType() {
        return 2;
    }

    @Override
    public int getBackPressType() {
        return 0;
    }

    @Override
    public String getToolbarName() {
        return getContext().getString(R.string.notice);
    }

    @Override
    public float getToolbarFontSize() {
        return 24;
    }

    @Override
    public Navigator getNavigator() {
        return ((MainActivity)getActivity()).navigator;
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }

    @Override
    public ViewDataBinding getActivityOrFragmentBinding() {
        return ((MainActivity)getActivity()).binding;
    }

    @Override
    public BaseFragment getFragment() {
        return this;
    }
}
