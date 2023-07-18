package com.example.cardiotomsk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cardiotomsk.mainFragments.HeartBeatFragment;
import com.example.cardiotomsk.mainFragments.HomeFragment;
import com.example.cardiotomsk.mainFragments.PillsFragment;
import com.example.cardiotomsk.mainFragments.ScheduleFragment;
import com.example.cardiotomsk.objectModels.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

	public MainActivity mainActivity;
	public BottomNavigationView menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainActivity = this;

		menu = (BottomNavigationView) mainActivity.findViewById(R.id.bottom_nav_menu);
		loadFragment(HomeFragment.newInstance());
		menu.setSelectedItemId(R.id.navigation_home);
		menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
	}

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_home:
					loadFragment(HomeFragment.newInstance());
					return true;
				case R.id.navigation_pills:
					loadFragment(PillsFragment.newInstance());
					return true;
				case R.id.navigation_doctor:
					loadFragment(ScheduleFragment.newInstance());
					return true;
				case R.id.navigation_heartbeat:
					loadFragment(HeartBeatFragment.newInstance());
					return true;
				case R.id.navigation_chat:
					Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
					startActivity(intent);
					return true;
			}
			return false;
		}
	};

	private void loadFragment(Fragment fragment) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.frame, fragment);
		ft.commit();
	}
}