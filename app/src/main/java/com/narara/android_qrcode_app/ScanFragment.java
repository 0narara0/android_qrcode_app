package com.narara.android_qrcode_app;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;
import com.narara.android_qrcode_app.databinding.FragmentScanBinding;


public class ScanFragment extends Fragment {

    private FragmentScanBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        mBinding = DataBindingUtil.bind(view);

        IntentIntegrator integrator = new IntentIntegrator(requireActivity());
        integrator.initiateScan();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.scanButton.setOnClickListener(view1 -> {
            IntentIntegrator integrator = new IntentIntegrator(requireActivity());
            integrator.initiateScan();
        });
    }
}
