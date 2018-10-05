package com.ibrickedlabs.facebookshimmer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ShimmerFrameLayout mShimmerFrameLayout;
    private LinearLayout mLinearLayout;
    private String[] array = {"item 1",
            "item 2",
            "item 3",
            "item 4",
            "item 5",
            "item 6",
            "item 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        mShimmerFrameLayout = (ShimmerFrameLayout) findViewById(R.id.shimmer);
        mShimmerFrameLayout.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        mShimmerFrameLayout.startShimmer();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.row_items, R.id.itemText, array);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mShimmerFrameLayout.stopShimmer();
                listView.setAdapter(arrayAdapter);
                mShimmerFrameLayout.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);


            }
        }, 8000);

    }
}
