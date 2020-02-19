package pl.android.informator.adapters.notice_board;

import android.view.View;
import android.view.ViewGroup;

import com.android.informator.R;
import com.android.informator.databinding.SingleNoticeBoardBinding;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.base.BaseRecyclerViewAdapter;
import pl.android.informator.base.BaseViewHolder;
import pl.android.informator.models.Notice;
import pl.android.informator.navigation.Navigator;

public class NoticeBoardAdapter extends BaseRecyclerViewAdapter<Notice, BaseViewHolder> {


    private Navigator navigator;
    private List<NoticeBoardAdapterViewModel> viewModels = new ArrayList<>();

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public int getItemLayoutRes() {
        return R.layout.single_notice_board;
    }

    @Override
    public BaseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType, View itemView) {
        SingleNoticeBoardBinding binding = SingleNoticeBoardBinding.bind(itemView);
        return new BaseViewHolder(itemView, binding);
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        NoticeBoardAdapterViewModel viewModel;
        if (viewModels.size() <= position) {
            viewModel = new NoticeBoardAdapterViewModel();
            viewModels.add(viewModel);
            ((SingleNoticeBoardBinding) holder.getBinding()).setViewModel(viewModel);
            holder.setViewModel(viewModel);
            holder.setElement(navigator, items.get(position));
        } else {
            viewModel = viewModels.get(position);
            ((SingleNoticeBoardBinding) holder.getBinding()).setViewModel(viewModel);
        }
    }
}
