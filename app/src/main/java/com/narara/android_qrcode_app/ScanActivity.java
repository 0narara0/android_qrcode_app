package com.narara.android_qrcode_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.webkit.WebViewClient;

import com.narara.android_qrcode_app.databinding.ActivityScanBinding;

public class ScanActivity extends AppCompatActivity {

    private ActivityScanBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_scan);

        QrViewModel viewModel = ViewModelProviders.of(this).get(QrViewModel.class);

        String url = getIntent().getStringExtra("contents");
        viewModel.url.setValue(url);

        viewModel.url.observe(this, qrCodeUrl -> {
            mBinding.webView.setWebViewClient(new WebViewClient()); // 이걸 안해주면 새창이 뜸
            mBinding.webView.getSettings().setJavaScriptEnabled(true);
            mBinding.webView.loadUrl(qrCodeUrl);
        });

    }


}
