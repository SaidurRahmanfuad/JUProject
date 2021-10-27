package com.saidur;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saidur.bari.MainActivity;
import com.saidur.bari.R;
import com.saidur.bari.Start;
import com.saidur.bari.databinding.ActivityWelcomeBinding;
import com.saidur.bari.model.HomeModel;

public class Welcome extends AppCompatActivity {
    ActivityWelcomeBinding binding;
    AlertDialog.Builder adb;
    Dialog popup_createhome, popup_enterehome,popup_enterevarahome;
    ProgressDialog pd;

    TextInputEditText tiet_hName, tiet_hAddress, tiet_hOwner, tiet_hOwnerPhn, tiet_hId, tiet_hPin;
    String s_hName, s_hAddress, s_hOwner, s_hOwnerPhn, s_hId, s_hPin;
    TextInputEditText tiet_ownerLHphn, tiet_ownerLHp;
    String ownerLHphn, s_ownerLHp;

    FirebaseDatabase fdb;
    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_welcome);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_start);
        setContentView(binding.getRoot());
        pd = new ProgressDialog(Welcome.this);

        fdb = FirebaseDatabase.getInstance("https://varatia-4786f-default-rtdb.firebaseio.com/");
        // Write a message to the database
        dbr = fdb.getReference("Home");


        binding.idBariwala.setOnClickListener(v -> {
            adb = new AlertDialog.Builder(Welcome.this);
            adb.setTitle("Choose Option");
            adb.setPositiveButton("I want to Create Home", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    init_popCreatHome();
                }
            });
            adb.setNegativeButton("I want to Enter Home", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    init_popEnterHome();
                }
            });

            AlertDialog alert = adb.create();
            alert.show();

        });
        binding.idVaratia.setOnClickListener(v -> {
            init_popEnterHomevaratia();

        });
    }

    private void init_popCreatHome() {
        popup_createhome = new Dialog(Welcome.this);
        popup_createhome.setContentView(R.layout.pop_createbari);

        popup_createhome.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popup_createhome.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popup_createhome.getWindow().getAttributes().gravity = Gravity.CENTER;


        tiet_hName = popup_createhome.findViewById(R.id.tiet_hName);
        tiet_hAddress = popup_createhome.findViewById(R.id.tiet_hAddress);
        tiet_hOwner = popup_createhome.findViewById(R.id.tiet_hOwner);
        tiet_hOwnerPhn = popup_createhome.findViewById(R.id.tiet_hOwnerPhn);
        tiet_hId = popup_createhome.findViewById(R.id.tiet_hId);
        tiet_hPin = popup_createhome.findViewById(R.id.tiet_hPin);
        RelativeLayout btn = popup_createhome.findViewById(R.id.rlcreatsubmitbtn);

        btn.setOnClickListener(v -> {
            popup_createhome.dismiss();
            checkValidation();
            HomeModel homeModel = new HomeModel();
            homeModel.setH_id(s_hOwnerPhn + s_hId);
            homeModel.setH_name(s_hName);
            homeModel.setH_add(s_hAddress);
            homeModel.setH_owner(s_hOwner);
            homeModel.setH_owphn(s_hOwnerPhn);
            homeModel.setH_pin(s_hPin);
            CreateHome(homeModel);


        });
        popup_createhome.show();
    }

    private void CreateHome(HomeModel homeModel) {
        pd.setMessage("Home Creating...");
        pd.show();
        dbr.child(s_hOwnerPhn).setValue(homeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                pd.dismiss();
                //login
                init_popEnterHome();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Welcome.this, "Failed To Create Home", Toast.LENGTH_SHORT).show();
            }
        });
        //dbr.setValue("Hello, World!");
    }

    private void checkValidation() {
        if (TextUtils.isEmpty(tiet_hName.getText().toString())) {
            tiet_hName.setError("Must have input");
        } else {
            s_hName = tiet_hName.getText().toString();
        }

        if (TextUtils.isEmpty(tiet_hAddress.getText().toString())) {
            tiet_hAddress.setError("Must have input");
        } else {
            s_hAddress = tiet_hAddress.getText().toString();
        }
        if (TextUtils.isEmpty(tiet_hOwner.getText().toString())) {
            tiet_hOwner.setError("Must have input");
        } else {
            s_hOwner = tiet_hOwner.getText().toString();
        }
        if (TextUtils.isEmpty(tiet_hOwnerPhn.getText().toString())) {
            tiet_hOwnerPhn.setError("Must have input");
        } else {
            s_hOwnerPhn = tiet_hOwnerPhn.getText().toString();
        }
        if (TextUtils.isEmpty(tiet_hId.getText().toString())) {
            tiet_hId.setError("Must have input");
        } else {
            s_hId = tiet_hId.getText().toString();
        }
        if (TextUtils.isEmpty(tiet_hPin.getText().toString())) {
            tiet_hPin.setError("Must have input");
        } else {
            s_hPin = tiet_hPin.getText().toString();
        }
    }

    private void init_popEnterHome() {
       ProgressDialog pdeh = new ProgressDialog(Welcome.this);
        pdeh.setMessage("Entaring Home...");
        popup_enterehome = new Dialog(Welcome.this);
        popup_enterehome.setContentView(R.layout.pop_enterhome);


        popup_enterehome.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popup_enterehome.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popup_enterehome.getWindow().getAttributes().gravity = Gravity.CENTER;

        RelativeLayout btn = popup_enterehome.findViewById(R.id.rlenterbaribtn);

        tiet_ownerLHphn = popup_enterehome.findViewById(R.id.tiet_ownerLHphn);
        tiet_ownerLHp = popup_enterehome.findViewById(R.id.tiet_ownerLHp);
//Bariwala/**/
        btn.setOnClickListener(v -> {
            pdeh.show();
            ownerLHphn = tiet_ownerLHphn.getText().toString();
            s_ownerLHp = tiet_ownerLHp.getText().toString();
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
                        gotobariwal.putExtra("hid",hm.getH_id());
                        gotobariwal.putExtra("hid",hm.getH_name());
                        gotobariwal.putExtra("h_add",hm.getH_add());
                        gotobariwal.putExtra("h_owner",hm.getH_owner());
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
           /* Intent gotovaratia = new Intent(Welcome.this, Start.class);
            startActivity(gotovaratia);
            finish();*/
        });
        popup_enterehome.show();
    }

    private void init_popEnterHomevaratia() {
        popup_enterevarahome = new Dialog(Welcome.this);
        popup_enterevarahome.setContentView(R.layout.pop_enterhomevaratia);

        popup_enterevarahome.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popup_enterevarahome.getWindow().setLayout(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        popup_enterevarahome.getWindow().getAttributes().gravity = Gravity.CENTER;

        RelativeLayout btn = popup_enterevarahome.findViewById(R.id.rlvhome);


        btn.setOnClickListener(v -> {


            Intent gotovaratia = new Intent(Welcome.this, Start.class);
            startActivity(gotovaratia);
            finish();
        });
        popup_enterevarahome.show();
    }
}