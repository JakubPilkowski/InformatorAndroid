package pl.android.informator.adapters.search;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.android.informator.R;
import com.android.informator.databinding.SearchDefaultItemBinding;
import com.android.informator.databinding.SearchLocalizationItemBinding;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.base.BaseHeadAndItemRVAdapter;
import pl.android.informator.base.BaseViewHolder;
import pl.android.informator.models.SearchResult;
import pl.android.informator.navigation.Navigator;
import pl.android.informator.ui.timetable.set_route.set_route.SetRouteViewModel;

public class SearchAdapter extends BaseHeadAndItemRVAdapter<SearchResult, BaseViewHolder, BaseViewHolder> implements Filterable {
    private List<SearchAdapterViewModel>viewModels = new ArrayList<>();
    private SearchAdapterViewModel headerViewModel;
    private SetRouteViewModel routeViewModel;
    private List<SearchResult> fullItems;

    public void setRouteViewModel(SetRouteViewModel setRouteViewModel) {
        this.routeViewModel = setRouteViewModel;
    }

    public SearchAdapter(List<SearchResult>fullItems){
        setItems(fullItems);
        this.fullItems = fullItems;
    }



    @Override
    public BaseViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType, View itemView) {
        SearchLocalizationItemBinding binding = SearchLocalizationItemBinding.bind(itemView);
        return new BaseViewHolder(itemView, binding);
    }

    @Override
    public int getHeaderLayoutRes() {
        return R.layout.search_localization_item;
    }

    @Override
    public void onBindHeaderView(BaseViewHolder holder, int position) {
        if(headerViewModel==null)
        {
            headerViewModel = new SearchAdapterViewModel();
            ((SearchLocalizationItemBinding) holder.getBinding()).setViewModel(headerViewModel);
            holder.setViewModel(headerViewModel);
            holder.setElement(routeViewModel, items.get(position));
        }
        else{
            ((SearchLocalizationItemBinding) holder.getBinding()).setViewModel(headerViewModel);
            holder.setViewModel(headerViewModel);
        }
    }

    @Override
    public int getItemLayoutRes() {
        return R.layout.search_default_item;
    }

    @Override
    public BaseViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType, View itemView) {
        SearchDefaultItemBinding binding = SearchDefaultItemBinding.bind(itemView);
        return new BaseViewHolder(itemView, binding);
    }

    @Override
    public void onBindView(BaseViewHolder holder, int position) {
        SearchAdapterViewModel viewModel;
//        if (viewModels.size() <= position) {
            viewModel = new SearchAdapterViewModel();
//            viewModels.add(viewModel);
            ((SearchDefaultItemBinding) holder.getBinding()).setViewModel(viewModel);
            holder.setViewModel(viewModel);
            holder.setElement(routeViewModel, items.get(position));
//        } else {
//            viewModel = viewModels.get(position);
//            ((SearchDefaultItemBinding) holder.getBinding()).setViewModel(viewModel);
//            holder.setViewModel(viewModel);
//        }
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }
    private Filter searchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<SearchResult> filterResultList = new ArrayList<>();
            if(constraint == null || constraint.length()==0){
                filterResultList.addAll(fullItems);
            }
            else{
                String pattern = constraint.toString().toLowerCase().trim();
                Log.d("halo",pattern);
                for(SearchResult result : fullItems){
                    if(result.getBusStation().toLowerCase().startsWith(pattern)){
                        filterResultList.add(result);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterResultList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            setItems((List<SearchResult>) results.values);
        }
    };
}
