package com.example.cardiotomsk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

	public static RegistrationActivity registrationActivity;
	private TextInputLayout name, second_name, patronymic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		registrationActivity = this;
//		ImageView backBtn =  findViewById(R.id.registration1_img_back);
//		ImageView logoImg =  findViewById(R.id.reg1_logo);
//		TextView titleText =  findViewById(R.id.reg1_title);
//		Button next =  findViewById(R.id.registration1_btn_next);
//		Button login =  findViewById(R.id.registration1_btn_login);

		name = registrationActivity.findViewById(R.id.name);
		second_name = registrationActivity.findViewById(R.id.second_name);
		patronymic = registrationActivity.findViewById(R.id.patronymic);
	}

	public void callNextSigupScreen(View view) {
		if (!validateName() | !validateSecondName() | !validatePatronymic()) {
			return;
		}

		Intent intent = new Intent(getApplicationContext(), RegistratioinStep2Activity.class);

		//Add Shared Animation
		Pair[] pairs = new Pair[5];
		pairs[0] = new Pair<View, String>(registrationActivity.findViewById(R.id.registration1_img_back), "transition_back_arrow_btn");
		pairs[1] = new Pair<View, String>(registrationActivity.findViewById(R.id.registration1_btn_next), "transition_registration");
		pairs[2] = new Pair<View, String>(registrationActivity.findViewById(R.id.registration1_btn_login), "transition_reg_btn_login");
		pairs[3] = new Pair<View, String>(registrationActivity.findViewById(R.id.reg1_title), "transition_title_text");
		pairs[4] = new Pair<View, String>(registrationActivity.findViewById(R.id.reg1_logo), "transition_logo");
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
			ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RegistrationActivity.this, pairs);
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

	// для фамилии добавить тире и для имени
	private boolean validateName() {
		String val = name.getEditText().getText().toString().trim();
		String checkspaces = "\\A\\w{1,20}\\z";

		if (val.isEmpty()) {
			name.setError("Обязательно для заполнения");
			return false;
		} else if (!val.matches(checkspaces)) {
			name.setError("Пробелы не допустимы");
			return false;
		} else {
			name.setError(null);
			name.setErrorEnabled(false);
			return true;
		}
	}

	private boolean validateSecondName() {
		String val = second_name.getEditText().getText().toString().trim();
		String checkspaces = "\\A\\w{1,20}\\z";

		if (val.isEmpty()) {
			second_name.setError("Обязательно для заполнения");
			return false;
		} else if (!val.matches(checkspaces)) {
			second_name.setError("Пробелы не допустимы");
			return false;
		} else {
			second_name.setError(null);
			second_name.setErrorEnabled(false);
			return true;
		}
	}

	private boolean validatePatronymic() {
		String val = patronymic.getEditText().getText().toString().trim();
		String checkspaces = "\\A\\w{1,20}\\z";

		if (val.isEmpty()) {
			patronymic.setError("Обязательно для заполнения");
			return false;
		} else if (!val.matches(checkspaces)) {
			patronymic.setError("Пробелы не допустимы");
			return false;
		} else {
			patronymic.setError(null);
			patronymic.setErrorEnabled(false);
			return true;
		}
	}
}