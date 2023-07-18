package com.example.cardiotomsk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class StartActivity extends AppCompatActivity {
	public static StartActivity startActivity;


	private static final String url = "jdbc:mysql://127.0.0.1:3306/Db";
	private static final String user = "root";
	private static final String pass = "Lotos11122001";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		startActivity = this;

		Button btn_registration = findViewById(R.id.btn_registration);
		Button btn_login = findViewById(R.id.btn_login);


//		btn_registration.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Intent intent = new Intent(startActivity, RegistrationActivity.class);
//				startActivity.startActivity(intent);
//			}
//		});
//		btn_login.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Intent intent = new Intent(startActivity, LoginActivity.class);
//				startActivity.startActivity(intent);
//			}
//		});
	}

	public void callLoginScreen(View view) {
		Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

		Pair[] pairs = new Pair[2];
		pairs[0] = new Pair<View, String>(startActivity.findViewById(R.id.btn_login), "transition_login");
		pairs[1] = new Pair<View, String>(startActivity.findViewById(R.id.start_logo), "transition_logo");

		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
			ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartActivity.this, pairs);
			startActivity(intent, options.toBundle());
		} else {
			startActivity(intent);
		}
	}

	public void callRegistrationScreen(View view) {
		Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);

		Pair[] pairs = new Pair[2];
		pairs[0] = new Pair<View, String>(startActivity.findViewById(R.id.btn_registration), "transition_registration");
		pairs[1] = new Pair<View, String>(startActivity.findViewById(R.id.start_logo), "transition_logo");
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
			ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartActivity.this, pairs);
			startActivity(intent, options.toBundle());
		} else {
			startActivity(intent);
		}
	}
}

