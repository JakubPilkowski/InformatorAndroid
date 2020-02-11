package pl.android.informator.ui.notice_board;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.databinding.ObservableField;

import pl.android.informator.adapters.notice_board.NoticeBoardAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.Notice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoticeBoardViewModel extends BaseViewModel {

    public ObservableField<NoticeBoardAdapter> adapter = new ObservableField<>();
    private NoticeBoardAdapter noticeBoardAdapter = new NoticeBoardAdapter();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void init() {
        adapter.set(noticeBoardAdapter);
        List<Notice>notices = new ArrayList<>();
//        LocalDate date = LocalDate.now();
        notices.add(new Notice("Placki","5500 zł","https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2019/03/412525-v-1000x1000.jpg",new ArrayList<String>(),"Takie tam placki na sprzedaż"));
        notices.add(new Notice("GTR Sashy!!!","Za darmo!!!","https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg",new ArrayList<String>(),"GTR do oddania, nie chce tego ścierwa"));
        notices.add(new Notice("GTR Sashy!!!","Za darmo!!!","https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg",new ArrayList<String>(),"GTR do oddania, nie chce tego ścierwa"));
        notices.add(new Notice("GTR Sashy!!!","Za darmo!!!","https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg",new ArrayList<String>(),"GTR do oddania, nie chce tego ścierwa"));
        notices.add(new Notice("GTR Sashy!!!","Za darmo!!!","https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg",new ArrayList<String>(),"GTR do oddania, nie chce tego ścierwa"));
        noticeBoardAdapter.setNavigator(getNavigator());
        noticeBoardAdapter.setItems(notices);
    }
    // TODO: Implement the ViewModel
}
