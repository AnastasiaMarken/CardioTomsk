package com.example.cardiotomsk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class RegistratioinStep3Activity extends AppCompatActivity {

	public RegistratioinStep3Activity registratioinStep3Activity;
	private TextInputLayout login, email, password, repeat_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registratioin_step3);
		registratioinStep3Activity = this;

		login = registratioinStep3Activity.findViewById(R.id.login);
		email = registratioinStep3Activity.findViewById(R.id.email);
		repeat_password = registratioinStep3Activity.findViewById(R.id.repeat_password);
		password = registratioinStep3Activity.findViewById(R.id.password);
	}

	public void completeRegistration(View view) {
		if (!validateLogin() | !validatePassword() | !validateRepeatPassword() | !validateEmail()) {
			return;
		}

		startActivity(new Intent(getApplicationContext(), MainActivity.class));
		finish();
	}


	//добавить потом анимацию для лого, кнопки назад, заголовка и самой кнопки
	public void callLoginFromSignUp(View view) {
		startActivity(new Intent(getApplicationContext(), LoginActivity.class));
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

	private boolean validateEmail() {
		String val = email.getEditText().getText().toString().trim();
		String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

		if (val.isEmpty()) {
			email.setError("Обязательно для заполнения");
			return false;
		} else if (!val.matches(checkEmail)) {
			email.setError("Неверный email");
			return false;
		} else {
			email.setError(null);
			email.setErrorEnabled(false);
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

	private boolean validateRepeatPassword() {
		String val = repeat_password.getEditText().getText().toString().trim();
		String val2 = password.getEditText().getText().toString().trim();
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
			repeat_password.setError("Обязательно для заполнения");
			return false;
		} else if (val.length() < 5) { //if (!val.matches(checkPassword)) {
			repeat_password.setError("Минимум 5 символов");
			return false;
		} else if (!val.equals(val2)) { //if (!val.matches(checkPassword)) {
			repeat_password.setError("Пароли не совпадают");
			return false;
		} else {
			repeat_password.setError(null);
			repeat_password.setErrorEnabled(false);
			return true;
		}
	}
}