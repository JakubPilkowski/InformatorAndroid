package pl.android.informator.helpers;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.informator.R;
import com.android.informator.databinding.AddNoticeFragmentBinding;
import com.android.informator.databinding.NoticeBoardFragmentBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import pl.android.informator.activities.MainActivity;
import pl.android.informator.adapters.notice_board.ViewPagerAdapter;
import pl.android.informator.views.ArrayView;
import pl.android.informator.views.CommunicationLineView;

public class BindingAdapter {

    private static boolean isAnimated = false;

    @androidx.databinding.BindingAdapter("showViewWithAnim")
    public static void setShowView(final View view, int show) {
        if (show == 1) {
            view.setVisibility(View.VISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,
                    0,
                    -view.getHeight(),
                    0);
            animate.setDuration(400);
            view.startAnimation(animate);
        }
        if (show == 0) {
            final TranslateAnimation animate = new TranslateAnimation(
                    0,
                    0, 0,
                    -view.getHeight());
            animate.setDuration(400);
            animate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    onAnimationEnd(animation);
                }
            });
            view.startAnimation(animate);
        }
        if (show == -1) {
            view.setVisibility(View.GONE);
        }
    }

    @androidx.databinding.BindingAdapter({"slideAnim", "size"})
    public static void setSlideAnim(final View view, int show, int size) {
        if (show == -1) {
            view.setVisibility(View.GONE);
        }
        if (show == 1 && size > 0) {
            view.setVisibility(View.VISIBLE);
            ToggleSlideAnim toggleSlideAnim = new ToggleSlideAnim(view, size, 0);
            toggleSlideAnim.setDuration(400);
            view.startAnimation(toggleSlideAnim);
        }
        if (show == 0 && size > 0) {
            ToggleSlideAnim toggleSlideAnim = new ToggleSlideAnim(view, 0, size);
            toggleSlideAnim.setDuration(400);
            toggleSlideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    onAnimationEnd(animation);
                }
            });
            view.startAnimation(toggleSlideAnim);
        }
    }

    @androidx.databinding.BindingAdapter("recyclerViewAdapter")
    public static void setRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @androidx.databinding.BindingAdapter("layout_manager")
    public static void setLayoutManager(RecyclerView recyclerView, Context context) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    @androidx.databinding.BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        GlideHelper.convertToImageView(imageView, url);
    }

    @androidx.databinding.BindingAdapter("setOnShowLabelDrawable")
    public static void setOnShowLabelDrawable(final View view, int show) {
        Animation animation;
        switch (show) {
            case 1:
                animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.rotate_0_180);
                view.startAnimation(animation);
                break;
            case 0:
                animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.rotate_180_360);
                view.startAnimation(animation);
                break;
            case -1:
                break;
        }
    }

    @androidx.databinding.BindingAdapter("onTextChanged")
    public static void onTextChangedListener(final EditText editText, ViewDataBinding binding) {
        final AddNoticeFragmentBinding viewBinding = (AddNoticeFragmentBinding) binding;
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String lettersAmount = String.valueOf(editText.getText().length());
                switch ((String) editText.getTag()) {
                    case "TitleTag":
                        lettersAmount += "/30";
                        viewBinding.titleLetterLength.setText(lettersAmount);
                        break;
                    case "PriceTag":
                        lettersAmount += "/30";
                        viewBinding.priceLetterLength.setText(lettersAmount);
                        break;
                    case "PhoneTag":
                        lettersAmount += "/9";
                        viewBinding.phoneLetterLength.setText(lettersAmount);
                        break;
                    case "DescriptionTag":
                        lettersAmount += "/1000";
                        viewBinding.descLetterLength.setText(lettersAmount);
                        break;

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @androidx.databinding.BindingAdapter("setImageById")
    public static void setImageById(View view, int drawableId) {
        ((ImageView) view).setImageResource(drawableId);
    }

    @androidx.databinding.BindingAdapter("setArrayItems")
    public static <I> void setArrayItems(View view, List<I> items) {
        if (view instanceof ArrayView) {
            ((ArrayView) view).setItems(items);
        }
    }

    @androidx.databinding.BindingAdapter("setArrayViewTitle")
    public static void setArrayViewTitle(CommunicationLineView view, String title) {
        view.setTitle(title);
    }

    @androidx.databinding.BindingAdapter("setArrayViewIcon")
    public static void setArrayViewIcon(CommunicationLineView view, int icon) {
        view.setIcon(icon);
    }

    @androidx.databinding.BindingAdapter("onScrollListener")
    public static void setOnScrollListener(RecyclerView recyclerView, ViewDataBinding binding) {
        final FloatingActionButton button = ((NoticeBoardFragmentBinding) binding).noticeBoardAddButton;
        final Animation[] animation = new Animation[1];
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy < -12 && !button.isShown() && !isAnimated) {
                    animation[0] = AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.translate_up);
                    animation[0].setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            button.setVisibility(View.VISIBLE);
                            isAnimated = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            isAnimated = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            onAnimationEnd(animation);
                        }
                    });
                    button.startAnimation(animation[0]);
                } else if (dy > 12 && button.isShown() && !isAnimated) {
                    animation[0] = AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.translate_down);
                    animation[0].setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            isAnimated = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            button.setVisibility(View.GONE);
                            isAnimated = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            onAnimationEnd(animation);
                        }
                    });
                    button.startAnimation(animation[0]);
                }
            }
        });
    }
    @androidx.databinding.BindingAdapter("scrollListener")
    public static void onScrollListener(RecyclerView recyclerView, RecyclerView.OnScrollListener listener){
        recyclerView.addOnScrollListener(listener);
    }
    @androidx.databinding.BindingAdapter("dots")
    public static void createDots(final LinearLayout layout, ViewPager viewPager) {
        ViewPagerAdapter adapter = (ViewPagerAdapter) viewPager.getAdapter();
        final int dotsCount = adapter.getCount();
        final ImageView[] dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(layout.getContext());
            dots[i].setImageDrawable(layout.getResources().getDrawable(R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            layout.addView(dots[i], params);
        }
        dots[0].setImageDrawable(layout.getResources().getDrawable(R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(layout.getResources().getDrawable(R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(layout.getResources().getDrawable(R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @androidx.databinding.BindingAdapter("imageSrc")
    public static void setImageSrc(final View view, final int drawableID) {
        final Context context = view.getContext();
        Drawable drawable = context.getResources().getDrawable(drawableID);
        GlideHelper.convertToOtherView(view, drawable);
    }

    @androidx.databinding.BindingAdapter("setImageUrlWithRipple")
    public static void setImageUrlWithRipple(final ImageView view, final String url) {
        Display display = MainActivity.getINSTANCE().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        Glide.with(view.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .thumbnail(0.1f)
                .override(size.x, TextHelper.getPixels(TypedValue.COMPLEX_UNIT_DIP, 200))
                .centerCrop()
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(
                                view.getResources().getColor(R.color.colorWhite)), resource, null);
                        view.setImageDrawable(rippleDrawable);

                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    @androidx.databinding.BindingAdapter("setOnClickListener")
    public static void setOnClickListener(View view, View.OnClickListener listener) {
        view.setOnClickListener(listener);
    }
}

