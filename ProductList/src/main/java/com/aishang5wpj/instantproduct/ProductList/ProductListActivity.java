package com.aishang5wpj.instantproduct.ProductList;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        mRecyclerView = findViewById(R.id.recyclerview);
        mProductAdapter = new ProductAdapter(getProductList());
        mProductAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onProductClick(Product product) {
                Intent intent = new Intent();
//                intent.setPackage(getPackageName());
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://aishang5wpj.github.io/desc?id=" + product.id));
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mProductAdapter);
    }

    private List<Product> getProductList() {
        String[] ids = getResources().getStringArray(com.aishang5wpj.instantproduct.R.array.product_ids);
        String[] names = getResources().getStringArray(com.aishang5wpj.instantproduct.R.array.product_names);
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < ids.length && i < names.length; i++) {
            list.add(new Product(ids[i], names[i]));
        }
        return list;
    }
}
