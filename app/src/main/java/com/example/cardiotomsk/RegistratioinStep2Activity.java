package com.example.cardiotomsk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Pair;
import android.view.View;
import android.widget.RadioButton;

public class RegistratioinStep2Activity extends AppCompatActivity {

	public RegistratioinStep2Activity registratioinStep2Activity;
	private RadioButton male, female, other;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registratioin_step2);
		registratioinStep2Activity = this;

		male = findViewById(R.id.male);
		female = findViewById(R.id.female);
		other = findViewById(R.id.others);
	}

	public void onRadioButtonClick (View view) {
		boolean isSelected = ((RadioButton) view).isChecked();
		switch (view.getId()) {
			case R.id.male:
				if (isSelected) {
					male.setTextColor(getResources().getColor(R.color.onPrimary));
					male.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_checked));
					female.setTextColor(getResources().getColor(R.color.primaryLite));
					female.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_unchecked));
					other.setTextColor(getResources().getColor(R.color.primaryLite));
					other.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_unchecked));
				}
				break;

			case R.id.female:
				if (isSelected) {
					male.setTextColor(getResources().getColor(R.color.primaryLite));
					male.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_unchecked));
					female.setTextColor(getResources().getColor(R.color.onPrimary));
					female.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_checked));
					other.setTextColor(getResources().getColor(R.color.primaryLite));
					other.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_unchecked));
				}
				break;

			case R.id.others:
				if (isSelected) {
					male.setTextColor(getResources().getColor(R.color.primaryLite));
					male.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_unchecked));
					female.setTextColor(getResources().getColor(R.color.primaryLite));
					female.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_unchecked));
					other.setTextColor(getResources().getColor(R.color.onPrimary));
					other.setBackground(getResources().getDrawable(R.drawable.shape_radio_btn_checked));
				}
				break;
		}
	}

	public void callNextSigupScreen(View view) {

		Intent intent = new Intent(getApplicationContext(), RegistratioinStep3Activity.class);

		//Add Shared Animation
		Pair[] pairs = new Pair[5];
		pairs[0] = new Pair<View, String>(registratioinStep2Activity.findViewById(R.id.registration1_img_back), "transition_back_arrow_btn");
		pairs[1] = new Pair<View, String>(registratioinStep2Activity.findViewById(R.id.registration1_btn_next), "transition_registration");
		pairs[2] = new Pair<View, String>(registratioinStep2Activity.findViewById(R.id.registration1_btn_login), "transition_reg_btn_login");
		pairs[3] = new Pair<View, String>(registratioinStep2Activity.findViewById(R.id.reg1_title), "transition_title_text");
		pairs[4] = new Pair<View, String>(registratioinStep2Activity.findViewById(R.id.reg1_logo), "transition_logo");
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
			ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RegistratioinStep2Activity.this, pairs);
			startActivity(intent, options.toBundle());
		} else {
			startActivity(intent);
		}
	}


	//добавить потом анимацию для лого, кнопки назад, заголовка и самой кнопки
	public void callLoginFromSignUp(View view) {
		startActivity(new Intent(getApplicationContext(), LoginActivity.class));
		finish();
	}
}