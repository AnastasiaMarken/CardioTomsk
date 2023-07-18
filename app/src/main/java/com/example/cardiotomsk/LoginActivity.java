package com.example.cardiotomsk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

	public LoginActivity loginActivity;
	private TextInputLayout login, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_login);
		loginActivity = this;

		login = loginActivity.findViewById(R.id.login);
		password = loginActivity.findViewById(R.id.password);
	}

	public void completeLogin(View view) {
		if (!validateLogin() | !validatePassword()) {
			return;
		}

		startActivity(new Intent(getApplicationContext(), MainActivity.class));
		finish();
	}

	//добавить потом анимацию для лого, кнопки назад, заголовка и самой кнопки
	public void callRegistrationFromLogin(View view) {
		startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
		finish();
	}

	private boolean validateLogin() {
		String val = login.getEditText().getText().toString().trim();
		String checkspaces = "\\A\\w{1,20}\\z";

		if (val.isEmpty()) {
			login.setError("Обязательно для заполнения");
			return false;
		} else if (val.length() > 20) {
			login.setError("Максимальная длина 20 символов");
			return false;
		} else if (val.length() < 4) {
			login.setError("Минимальная длина 4 символа");
			return false;
		} else if (!val.matches(checkspaces)) {
			login.setError("Пробелы не допустимы");
			return false;
		} else {
			login.setError(null);
			login.setErrorEnabled(false);
			return true;
		}
	}

	private boolean validatePassword() {
		String val = password.getEditText().getText().toString().trim();
		//String checkPassword = "^" +
				//"(?=.*[0-9])" +         //at least 1 digit
				//"(?=.*[a-z])" +         //at least 1 lower case letter
				//"(?=.*[A-Z])" +         //at least 1 upper case letter
				//"(?=.*[a-zA-Z])" +      //any letter
				//"(?=.*[@#$%^&+=])" +    //at least 1 special character
				//"(?=S+$)" +           //no white spaces
				//".{5,}" +               //at least 5 characters
				//"$";

		if (val.isEmpty()) {
			password.setError("Обязательно для заполнения");
			return false;
		} else if (val.length() < 5) { //if (!val.matches(checkPassword)) {
			password.setError("Минимум 5 символов");
			return false;
		} else {
			password.setError(null);
			password.setErrorEnabled(false);
			return true;
		}
	}
}