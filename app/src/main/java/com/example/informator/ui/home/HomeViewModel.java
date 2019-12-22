package com.example.informator.ui.home;

import androidx.core.view.GravityCompat;

import com.example.informator.base.BaseViewModel;
import com.example.informator.databinding.ActivityMainBinding;

public class HomeViewModel extends BaseViewModel {
    // TODO: Implement the ViewModel
    public void init(){

    }
    public void onBurgerClick(){
        ((ActivityMainBinding)getBinding()).drawerLayout.openDrawer(GravityCompat.START);
    }
}
