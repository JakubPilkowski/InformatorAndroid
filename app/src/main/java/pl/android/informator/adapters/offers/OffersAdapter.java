package pl.android.informator.adapters.offers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.android.informator.R;
import com.android.informator.databinding.SingleOfferBinding;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.base.BaseRecyclerViewAdapter;
import pl.android.informator.base.BaseViewHolder;
import pl.android.informator.models.Offer;
import pl.android.informator.navigation.Navigator;

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
    public void onViewDetachedFromWindow(@NonNull BaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        LinearLayout offersDetails = ((SingleOfferBinding)holder.getBinding()).offerDetails;
        offersDetails.measure(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        int size = offersDetails.getMeasuredHeight();
        ((OffersAdapterViewModel)holder.getViewModel()).setSize(size);
        offersDetails.getLayoutParams().height = 0;
        offersDetails.requestLayout();
        ((OffersAdapterViewModel)holder.getViewModel()).refreshView();
    }


    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        OffersAdapterViewModel viewModel;
        if(viewModels.size()<=position){
            viewModel = new OffersAdapterViewModel();
            viewModels.add(viewModel);
            holder.setViewModel(viewModel);
            ((SingleOfferBinding)holder.getBinding()).setViewModel(viewModel);
            holder.setElement(items.get(position),navigator);
            LinearLayout offersDetails = ((SingleOfferBinding)holder.getBinding()).offerDetails;
            offersDetails.measure(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            int size = offersDetails.getMeasuredHeight();
            viewModel.setSize(size);
            offersDetails.getLayoutParams().height = 0;
            offersDetails.requestLayout();
            viewModel.refreshView();
        }
        else {
            viewModel = viewModels.get(position);
            ((SingleOfferBinding)holder.getBinding()).setViewModel(viewModel);
            holder.setViewModel(viewModel);
        }
    }
}
