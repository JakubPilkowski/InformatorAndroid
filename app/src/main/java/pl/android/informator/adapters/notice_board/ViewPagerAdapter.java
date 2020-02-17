package pl.android.informator.adapters.notice_board;

import android.content.Context;
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

import java.util.List;

import pl.android.informator.ui.notice_board.notice_details.NoticeDetailsViewModel;

public class ViewPagerAdapter extends PagerAdapter {
    private List<String> imgUrls;
    private Context context;
    private NoticeDetailsViewModel viewModel;
    @Override
    public int getCount() {
        if(imgUrls.size()==0)
            return 1;
        return imgUrls.size();
    }
    public ViewPagerAdapter(Context context, List<String>imgUrls, NoticeDetailsViewModel viewModel){
        this.context = context;
        this.imgUrls = imgUrls;
        this.viewModel = viewModel;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        if(imgUrls.size()>0) {
            view = layoutInflater.inflate(R.layout.single_viewpager_view, container, false);
            Glide.with(context)
                    .load(imgUrls.get(position))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.1f)
                    .into((ImageView) view);
        }
        if(imgUrls.size()==0){
            view = layoutInflater.inflate(R.layout.image_placeholder,container,false);
        }
        ViewPager vp = (ViewPager) container;
        vp.addView(view);
        return view;
    }
        @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ViewPager vp = (ViewPager) container;
            View view = (View) object;
            vp.removeView(view);
    }
}
