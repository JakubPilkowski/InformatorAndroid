package pl.android.informator.adapters.notice_board;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class AddImagesViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<Bitmap> images = new ArrayList<>();

    public AddImagesViewPagerAdapter(Context context){
        this.context = context;
    }

    public AddImagesViewPagerAdapter(Context context, List<Bitmap>images){
        this.context = context;
        this.images = images;
    }
    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageView view = (ImageView) layoutInflater.inflate(R.layout.single_viewpager_view,container,false);
        if(images.size()>0){
            Glide.with(context)
                    .load(images.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .thumbnail(0.1f)
                    .into(view);
        }
        else {
            //placeholder
        }
        ViewPager vp = (ViewPager) container;
        vp.addView(view);
        return view;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void addItem(Bitmap image) {
        images.add(image);
        notifyDataSetChanged();
    }

    public void removeItem(Bitmap image){
        images.remove(image);
        notifyDataSetChanged();
    }
}
