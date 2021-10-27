package com.saidur.bari.ui.bariwala;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BariwalaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BariwalaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}