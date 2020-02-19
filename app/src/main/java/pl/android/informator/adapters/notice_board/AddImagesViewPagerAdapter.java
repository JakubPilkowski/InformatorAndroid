package pl.android.informator.adapters.notice_board;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.informator.R;

import java.util.List;

import pl.android.informator.models.Image;

public class AddImagesViewPagerAdapter extends ArrayAdapter {
    private Context context;
    private List<Image> images;
    private LayoutInflater mInflater;
    private int imageWidth;


    public AddImagesViewPagerAdapter(Context context, List<Image> images, int imageWidth) {
        super(context, R.layout.single_image_view);
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.images = images;
        this.imageWidth = imageWidth;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout view = (LinearLayout) convertView;
        if (view == null) {
            view = (LinearLayout) mInflater.inflate(R.layout.single_image_view, parent, false);
        }
        ImageView imageView = view.findViewById(R.id.single_image_image);
        imageView.getLayoutParams().width = imageWidth - 8;
        imageView.getLayoutParams().height = imageWidth - 8;
        Drawable d = new BitmapDrawable(parent.getResources(), images.get(position).getBitmap());
        RippleDrawable rippledImage = new
                RippleDrawable(ColorStateList.valueOf(view.getResources().getColor(R.color.colorWhite)), d, null);
        imageView.setImageDrawable(rippledImage);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "Długie naciśnięcie", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return view;
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public int getPosition(Object item) {
        return images.indexOf(item);
    }


    public void removeItem(Bitmap image) {
        images.remove(image);
        notifyDataSetChanged();
    }
}
