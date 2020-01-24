package pl.android.informator.ui.notice_board.add_notice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.base.BaseViewModel;

public class AddNoticeViewModel extends BaseViewModel {


    public void init() {
    }

    public void onAddPhoto(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            getActivity().requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MainActivity.REQUEST_ACCEPTED);
        }
        else {
            Intent i = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            getActivity().startActivityForResult(i, MainActivity.RESULT_LOAD_IMAGE);
        }
    }
    public void onCancel() {
        getActivity().onBackPressed();
    }

    public void onPublishOffer() {
        getActivity().onBackPressed();
    }
    // TODO: Implement the ViewModel
}
