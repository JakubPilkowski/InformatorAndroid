package pl.android.informator.ui.notice_board.add_notice;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.R;
import com.android.informator.databinding.AddNoticeFragmentBinding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.adapters.notice_board.AddImagesViewPagerAdapter;
import pl.android.informator.adapters.notice_board.ViewPagerAdapter;
import pl.android.informator.base.BaseViewModel;
import pl.android.informator.helpers.ImageHelper;
import pl.android.informator.models.Image;

public class AddNoticeViewModel extends BaseViewModel {
    private List<Image> images = new ArrayList<>();
    private LinearLayout imageContainer;
    public AddImagesViewPagerAdapter adapter;
    private int imageWidth;

    public void init() {
        imageContainer = ((AddNoticeFragmentBinding) getBinding()).addNoticeImageContainer;
        LinearLayout placeholder = (LinearLayout) LayoutInflater.from(imageContainer.getContext()).inflate(R.layout.image_placeholder, imageContainer, false);
        imageContainer.addView(placeholder);
        imageContainer.requestLayout();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        imageWidth = size.x;
    }

    public void onAddPhoto() {
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MainActivity.RESULT_LOAD_IMAGE);
        } else {
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
        Log.d("viewpager", "5");
        if (images.size() <= 5) {
            Bitmap compressedImage = null;
            try {
                compressedImage = ImageHelper.decodeSampledBitmap(imageContainer.getContext(), data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            images.add(new Image(compressedImage, data));
            imageContainer.removeAllViews();
            GridView imagesView = (GridView) LayoutInflater.from(imageContainer.getContext()).inflate(R.layout.add_images_grid_view, imageContainer, false);
            adapter = new AddImagesViewPagerAdapter(imageContainer.getContext(), images, imageWidth / 3);
            imagesView.setAdapter(adapter);
            imagesView.getLayoutParams().height = imageWidth / 3 * 2 + 50;
            imageContainer.addView(imagesView);
            imageContainer.requestLayout();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Nie można dodać więcej zdjęć!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
