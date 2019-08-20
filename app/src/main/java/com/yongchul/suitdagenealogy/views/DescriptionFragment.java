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
import com.yongchul.suitdagenealogy.databinding.DescriptionFragmentBinding;
import com.yongchul.suitdagenealogy.viewmodels.ChoiceViewModel;
import com.yongchul.suitdagenealogy.viewmodels.DescriptViewModel;

public class DescriptionFragment extends Fragment {

    DescriptionFragmentBinding binding;
    DescriptViewModel dvm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.binding = DataBindingUtil.inflate(inflater, R.layout.description_fragment,container,false);
        this.binding.setDesc(this);
        this.dvm = new DescriptViewModel(this.binding,getContext());

        return this.binding.getRoot();
    }

}
