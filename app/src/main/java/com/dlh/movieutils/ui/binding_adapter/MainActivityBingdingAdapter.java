package com.dlh.movieutils.ui.binding_adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.dlh.movieutils.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

/**
 * @author: dlh
 * @date:
 * @description
 */
public class MainActivityBingdingAdapter {

    @BindingAdapter(value = {"initBottomNavigationView"}, requireAll = false)
    public static void initBottomNavigationView(BottomNavigationView navView, AppCompatActivity mAppCompatActivity) {
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//       ,R.id.navigation_me
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_jxpaly)
                .build();
        NavController navController = Navigation.findNavController(mAppCompatActivity, R.id.nav_host_fragment_activity_main);

        NavigationUI.setupActionBarWithNavController(mAppCompatActivity, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(navView, navController);
    }
}
