package com.yongchul.suitdagenealogy.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yongchul.suitdagenealogy.R;
import com.yongchul.suitdagenealogy.databinding.SutdachoiceFragmentBinding;

public class SutdaChoiceFragment extends Fragment {

    SutdachoiceFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.binding = DataBindingUtil.inflate(inflater, R.layout.sutdachoice_fragment,container,false);
        //new AgendaViewModel(binding,getContext(),this.titleDTO);

        return this.binding.getRoot();
    }
}
