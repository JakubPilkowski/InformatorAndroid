package pl.android.informator.adapters.notice_board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.R;
import com.android.informator.databinding.SingleViewpagerViewBinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pl.android.informator.ui.notice_board.notice_details.NoticeDetailsViewModel;

public class ViewPagerAdapter extends PagerAdapter {
    private List<String> imgUrls;
    private Context context;
    private NoticeDetailsViewModel viewModel;
    @Override
    public int getCount() {
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
        View view = layoutInflater.inflate(R.layout.single_viewpager_view,container,false);
        SingleViewpagerViewBinding binding = SingleViewpagerViewBinding.bind(view);
        binding.setViewModel(viewModel);
        viewModel.setImage(imgUrls.get(position));
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
