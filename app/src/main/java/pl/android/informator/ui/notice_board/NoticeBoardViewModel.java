package pl.android.informator.ui.notice_board;

import android.app.ProgressDialog;
import android.os.Handler;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import java.util.ArrayList;
import java.util.List;

import pl.android.informator.adapters.notice_board.NoticeBoardAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.ProgressDialogManager;
import pl.android.informator.models.Notice;

public class NoticeBoardViewModel extends BaseViewModel{
    public ObservableField<NoticeBoardAdapter> adapter = new ObservableField<>();
    private NoticeBoardAdapter noticeBoardAdapter = new NoticeBoardAdapter();
    public ObservableInt show = new ObservableInt();
    public void init() {
        List<String> imgUrls = new ArrayList<>();
        imgUrls.add("https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2019/03/412525-v-1000x1000.jpg");
        imgUrls.add("https://extradania.pl/wp-content/uploads/2018/08/placki-z-twarogu.jpg");
        imgUrls.add("https://ilovebake.pl/wp-content/uploads/2019/09/Placki-z-jab%C5%82kiem-na-jogurcie-greckim-7.jpg");
        final List<Notice> notices = new ArrayList<>();
        notices.add(new Notice("Placki", "5500 zł", "https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2019/03/412525-v-1000x1000.jpg", imgUrls, "Takie tam placki na sprzedaż" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "asddddddddddddddddddddddddddddddddddddddddd" +
                "dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 698390390));
        notices.add(new Notice("GTR Sashy!!!", "Za darmo!!!", "https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg", imgUrls, "GTR do oddania, nie chce tego ścierwa", 600113200));
        notices.add(new Notice("GTR Sashy!!!", "Za darmo!!!", "https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg", imgUrls, "GTR do oddania, nie chce tego ścierwa", 123456789));
        notices.add(new Notice("GTR Sashy!!!", "Za darmo!!!", "https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg", imgUrls, "GTR do oddania, nie chce tego ścierwa", 456789123));
        notices.add(new Notice("GTR Sashy!!!", "Za darmo!!!", "https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg", imgUrls, "GTR do oddania, nie chce tego ścierwa", 123123123));
        notices.add(new Notice("Placki", "5500 zł", "https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2019/03/412525-v-1000x1000.jpg", imgUrls, "Takie tam placki na sprzedaż", 698390390));
        notices.add(new Notice("Placki", "5500 zł", "https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2019/03/412525-v-1000x1000.jpg", imgUrls, "Takie tam placki na sprzedaż", 698390390));
        notices.add(new Notice("GTR Sashy!!!", "Za darmo!!!", "https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg", imgUrls, "GTR do oddania, nie chce tego ścierwa", 456789123));
        notices.add(new Notice("Placki", "5500 zł", "https://d3iamf8ydd24h9.cloudfront.net/pictures/articles/2019/03/412525-v-1000x1000.jpg", imgUrls, "Takie tam placki na sprzedaż", 456456456));
        notices.add(new Notice("GTR Sashy!!!", "Za darmo!!!", "https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq_nCA/image;s=1080x720;cars_;/857660195_;slot=4;filename=eyJmbiI6InVwMWNieDc5dWc3NS1PVE9NT1RPUEwifQ.NDfu13FCMsXLxaMwAsdNQfmUHnBSHx7hy2ocvAq+nCA_rev001.jpg", imgUrls, "GTR do oddania, nie chce tego ścierwa", 789123456));
        adapter.set(noticeBoardAdapter);
        noticeBoardAdapter.setNavigator(getNavigator());
        ProgressDialogManager.get().show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                noticeBoardAdapter.setItems(notices);
                ProgressDialogManager.get().dismiss();
            }
        },1000);
    }

    public void onClick() {
        getNavigator().addNotice();
    }

    // TODO: Implement the ViewModel
}
