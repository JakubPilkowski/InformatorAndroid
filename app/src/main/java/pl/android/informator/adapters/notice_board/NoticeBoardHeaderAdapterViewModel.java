package pl.android.informator.adapters.notice_board;

import pl.android.informator.base.BaseAdapterViewModel;
import pl.android.informator.navigation.Navigator;

public class NoticeBoardHeaderAdapterViewModel extends BaseAdapterViewModel {

    private Navigator navigator;
    @Override
    public void init(Object[] values) {
        navigator = (Navigator)values[0];
    }
    public void onSortClick(){

    }
    public void onAddClick(){
        navigator.addNotice();
    }
}
