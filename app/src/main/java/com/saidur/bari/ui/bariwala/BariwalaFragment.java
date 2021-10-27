package com.saidur.bari.ui.bariwala;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saidur.Welcome;
import com.saidur.bari.MainActivity;
import com.saidur.bari.databinding.FragmentBariwalaBinding;
import com.saidur.bari.model.HomeModel;


public class BariwalaFragment extends Fragment {

    private BariwalaViewModel bariwalaViewModel;
    private FragmentBariwalaBinding binding;
    FirebaseDatabase fdb;
    DatabaseReference dbr;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bariwalaViewModel =
                new ViewModelProvider(this).get(BariwalaViewModel.class);

        binding = FragmentBariwalaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bariwalaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        dbr.child(ownerLHphn).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HomeModel hm = dataSnapshot.getValue(HomeModel.class);
                // pdeh.dismiss();
                assert hm != null;
                if (hm.getH_owphn().equals(ownerLHphn) && hm.getH_pin().equals(s_ownerLHp)) {
                    pdeh.dismiss();
                    //MainActivity hobe
                    Intent gotobariwal=new Intent(Welcome.this, MainActivity.class);
                    startActivity(gotobariwal);
                    finish();
                }
                else {
                    pdeh.dismiss();
                    Toast.makeText(Welcome.this, "Entering Home Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                pdeh.dismiss();
                Toast.makeText(Welcome.this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}