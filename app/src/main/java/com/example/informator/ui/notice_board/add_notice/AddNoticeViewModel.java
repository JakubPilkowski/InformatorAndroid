package com.example.informator.ui.notice_board.add_notice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.example.informator.activities.MainActivity;
import com.example.informator.base.BaseViewModel;
import com.example.informator.databinding.AddNoticeFragmentBinding;

public class AddNoticeViewModel extends BaseViewModel {


    public void init() {
    }

    public void onAddPhoto(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            getActivity().requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MainActivity.REQUEST_ACCEPTED);
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
