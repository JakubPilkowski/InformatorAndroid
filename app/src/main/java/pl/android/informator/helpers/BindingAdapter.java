package pl.android.informator.helpers;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.informator.databinding.NoticeBoardFragmentBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.android.informator.R;
import com.android.informator.databinding.AddNoticeFragmentBinding;

import pl.android.informator.navigation.Navigator;
import pl.android.informator.views.ArrayView;
import pl.android.informator.views.CommunicationLineView;

import java.util.List;

public class BindingAdapter {

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
        if (show == 1) {
            view.setVisibility(View.VISIBLE);
            ToggleSlideAnim toggleSlideAnim = new ToggleSlideAnim(view, size, 0);
            toggleSlideAnim.setDuration(400);
            view.startAnimation(toggleSlideAnim);
        }
        if (show == 0) {
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
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .thumbnail(0.1f)
                .into(imageView);
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
//                String lettersAmount = String.valueOf(count);
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @androidx.databinding.BindingAdapter("setDrawable")
    public static void setImageDrawable(View view, String type) {
        if (view instanceof ImageView) {
            Drawable drawable = WeatherHelper.getWeatherDrawable(view.getContext(), type);
            ((ImageView) view).setImageDrawable(drawable);
        }
        if (view instanceof LinearLayout) {
            Drawable drawable = WeatherHelper.getWeatherToolbarBackground(view.getContext(), type);
            view.setBackground(drawable);
        }
    }

    @androidx.databinding.BindingAdapter("setArrayItems")
    public static <I> void setArrayItems(View view, List<I> items) {
        if (view instanceof ArrayView) {
            ((ArrayView) view).setItems(items);
        }
    }

    @androidx.databinding.BindingAdapter("setNavigator")
    public static void setNavigator(View view, Navigator navigator) {
        if (view instanceof ArrayView) {
            ((ArrayView) view).setNavigator(navigator);
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
        final Button button = ((NoticeBoardFragmentBinding) binding).noticeBoardAddButton;
        final Animation[] animation = new Animation[1];
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy < -12 && button.getVisibility()==View.GONE) {
                    animation[0] = AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.translate_up);
                    animation[0].setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            button.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            onAnimationEnd(animation);
                        }
                    });
                    button.startAnimation(animation[0]);
                } else if (dy > 12 && button.getVisibility()==View.VISIBLE) {
                    animation[0] = AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.translate_down);
                    animation[0].setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            button.setVisibility(View.GONE);
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
}

