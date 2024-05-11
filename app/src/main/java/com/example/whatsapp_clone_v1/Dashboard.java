package com.example.whatsapp_clone_v1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Dashboard extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FloatingActionButton fabAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fabAdd = findViewById(R.id.fabAdd);
        viewPager2 = findViewById(R.id.viewpager2);
        tabLayout = findViewById(R.id.tablayout);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        TabLayoutMediator tlm = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                switch (i)
                {
                    case 0:
                        tab.setIcon(R.drawable.ic_chat);
                        break;
                    case 1:
                        tab.setText("Chats");
                        tab.setIcon(R.drawable.ic_chat);
                        BadgeDrawable bd = tab.getOrCreateBadge();
                        bd.setNumber(150);
                        bd.setMaxCharacterCount(3);
                        bd.setVisible(true);
                        break;
                    case 2:
                        tab.setText("Status");
                        tab.setIcon(R.drawable.ic_chat);
                        break;
                    default:
                        tab.setText("Calls");
                        tab.setIcon(R.drawable.ic_chat);
                        break;
                }
            }
        });

        tlm.attach();

    }
}