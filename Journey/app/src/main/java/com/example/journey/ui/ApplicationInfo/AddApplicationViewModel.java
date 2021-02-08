package com.example.journey.ui.ApplicationInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddApplicationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddApplicationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}