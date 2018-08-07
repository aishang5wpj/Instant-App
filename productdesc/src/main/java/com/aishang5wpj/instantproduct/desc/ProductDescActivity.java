package com.aishang5wpj.instantproduct.desc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class ProductDescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_desc);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
        String id = appLinkData.getQueryParameter("id");
        String name = getName(id);
        TextView textView = findViewById(R.id.productName);
        textView.setText(name);
    }

    private String getName(String id) {
        String[] ids = getResources().getStringArray(com.aishang5wpj.instantproduct.R.array.product_ids);
        int index = -1;
        for (int i = 0; i < ids.length; i++) {
            if (TextUtils.equals(id, ids[i])) {
                index = i;
                break;
            }
        }
        String[] names = getResources().getStringArray(com.aishang5wpj.instantproduct.R.array.product_names);
        if (0 <= index && index < names.length) {
            return names[index];
        }
        return "";
    }
}
