package pl.android.informator.ui.notice_board.add_notice;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.databinding.AddNoticeFragmentBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.adapters.notice_board.AddImagesViewPagerAdapter;
import pl.android.informator.adapters.notice_board.ViewPagerAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.ImageHelper;

public class AddNoticeViewModel extends BaseViewModel {

    AddImagesViewPagerAdapter viewPagerAdapter;
    public void init() {
        ViewPager viewPager = ((AddNoticeFragmentBinding)getBinding()).noticeDetailsViewpager;
        viewPagerAdapter = new AddImagesViewPagerAdapter(viewPager.getContext());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPageMargin(0);
    }

    public void onAddPhoto(){
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(),Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MainActivity.RESULT_LOAD_IMAGE);
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

    public void addPhoto(final Uri data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream image = null;
                try{
                    image = getActivity().getContentResolver().openInputStream(ImageHelper.compressBitmap(getActivity().getContentResolver(),data,90,256));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Bitmap compressedImage = BitmapFactory.decodeStream(image);
                viewPagerAdapter.addItem(compressedImage);
            }
        }).start();
        }
    // TODO: Implement the ViewModel
}
