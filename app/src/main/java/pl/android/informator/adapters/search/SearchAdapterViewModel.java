package pl.android.informator.adapters.search;

import androidx.databinding.ObservableField;

import pl.android.informator.base.BaseAdapterViewModel;
import pl.android.informator.models.SearchResult;
import pl.android.informator.navigation.Navigator;
import pl.android.informator.ui.timetable.set_route.set_route.SetRouteViewModel;

public class SearchAdapterViewModel extends BaseAdapterViewModel {
    private SearchResult searchResult;
    public ObservableField<String>busStation = new ObservableField<>();
    public ObservableField<String>lines = new ObservableField<>();
    private SetRouteViewModel viewModel;


    @Override
    public void init(Object[] values) {
        viewModel = (SetRouteViewModel)values[0];
        searchResult = (SearchResult) values[1];
        busStation.set(searchResult.getBusStation());
        StringBuilder lines = new StringBuilder();
        for (int i = 0; i <searchResult.getLines().size() ; i++) {
            if(i<searchResult.getLines().size()-1){
                lines.append(searchResult.getLines().get(i));
                lines.append(", ");
            }
            else lines.append(searchResult.getLines().get(i));
        }
        this.lines.set(String.valueOf(lines));
    }

    public void onLocationClick(){

    }
    public void onBusStationClick(){
        if(viewModel.search1.hasFocus()){
            viewModel.search1.setText(searchResult.getBusStation());
            viewModel.hideKeyboard(viewModel.getActivity());
            viewModel.onDoneClick();
            return;
        }
        if(viewModel.search2.hasFocus()){
            viewModel.search2.setText(searchResult.getBusStation());
            viewModel.hideKeyboard(viewModel.getActivity());
            viewModel.onDoneClick();
        }
    }
}
