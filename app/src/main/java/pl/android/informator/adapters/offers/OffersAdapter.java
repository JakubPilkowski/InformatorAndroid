package pl.android.informator.adapters.offers;

import android.view.View;
import android.view.ViewGroup;

import com.android.informator.R;
import pl.android.informator.base.BaseRecyclerViewAdapter;
import pl.android.informator.base.BaseViewHolder;
import com.android.informator.databinding.SingleOfferBinding;
import pl.android.informator.models.Offer;
import pl.android.informator.navigation.Navigator;

import java.util.ArrayList;
import java.util.List;

public class OffersAdapter extends BaseRecyclerViewAdapter<Offer, BaseViewHolder> {

    private List<OffersAdapterViewModel> viewModels = new ArrayList<>();
    private Navigator navigator;

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public int getItemLayoutRes() {
        return R.layout.single_offer;
    }

    @Override
    public BaseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType, View itemView) {
        SingleOfferBinding binding = SingleOfferBinding.bind(itemView);
        return new BaseViewHolder(itemView,binding);
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        if(viewModels.size()<=position){
            OffersAdapterViewModel viewModel = new OffersAdapterViewModel();
            holder.setViewModel(viewModel);
            ((SingleOfferBinding)holder.getBinding()).setViewModel(viewModel);
            viewModels.add(viewModel);
            holder.setElement(items.get(position),navigator);
        }
        else {
            OffersAdapterViewModel viewModel = viewModels.get(position);
            ((SingleOfferBinding)holder.getBinding()).setViewModel(viewModel);
        }
    }
}
