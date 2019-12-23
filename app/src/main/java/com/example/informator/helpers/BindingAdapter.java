package com.example.informator.helpers;


import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("recyclerViewAdapter")
    public static void setRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
    @androidx.databinding.BindingAdapter("layout_manager")
    public static void setLayoutManager(RecyclerView recyclerView, Context context){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}
