package pl.android.informator.adapters.notice_board;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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

    public List<Bitmap> getImages() {
        return images;
    }

    @Override
    public int getCount() {
        if(images.size()==0)
            return 1;
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("initItems","inicjacja itemów");
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if(images.size()>0){
            view = layoutInflater.inflate(R.layout.single_viewpager_view,container,false);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context,"Długie naciśnięcie",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            Glide.with(context)
                    .load(images.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .thumbnail(0.1f)
                    .into((ImageView) view);
        }
        if(images.size()==0) {
            view = layoutInflater.inflate(R.layout.image_placeholder,container,false);
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
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
