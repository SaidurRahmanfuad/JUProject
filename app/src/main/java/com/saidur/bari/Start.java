package com.saidur.bari;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.saidur.bari.databinding.ActivityStartBinding;
import com.saidur.bari.databinding.PopCreatebariBinding;
import com.saidur.bari.databinding.PopEnterhomeBinding;
import com.saidur.bari.databinding.PopEnterhomevaratiaBinding;

public class Start extends AppCompatActivity {
    ActivityStartBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_start);
        //setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view_vara);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home_varatia /*R.id.navigation_dashboard, R.id.navigation_notifications*/)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_start);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
       // NavigationUI.setupWithNavController(binding.navViewVara, navController);
        NavigationUI.setupWithNavController(navView, navController);
    }


}