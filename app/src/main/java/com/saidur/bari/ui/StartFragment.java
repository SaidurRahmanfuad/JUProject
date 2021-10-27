package com.saidur.bari.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saidur.bari.R;
import com.saidur.bari.Start;
import com.saidur.bari.databinding.ActivityStartBinding;
import com.saidur.bari.databinding.FragmentStartBinding;
import com.saidur.bari.databinding.PopCreatebariBinding;
import com.saidur.bari.databinding.PopEnterhomeBinding;
import com.saidur.bari.databinding.PopEnterhomevaratiaBinding;

public class StartFragment extends Fragment {

    FragmentStartBinding binding;
    FirebaseDatabase fdb;
    DatabaseReference dbr;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_start, container, false);

        binding = FragmentStartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

       /* fdb=FirebaseDatabase.getInstance();
        dbr=fdb.getReference().child("Mes");
// Read from the database
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });*/
        return view;

    }

}