package com.example.informator.helpers;


import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.informator.R;
import com.example.informator.databinding.AddNoticeFragmentBinding;

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
        if (show==0){
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
        if (show==-1){
            view.setVisibility(View.GONE);
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
        Log.d("halo", "setImageUrl: ");
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    @androidx.databinding.BindingAdapter("setOnShowLabelDrawable")
    public static void setOnShowLabelDrawable(View view, int show) {
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
    public static void onTextChangedListener(final EditText editText, ViewDataBinding binding){
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
}
