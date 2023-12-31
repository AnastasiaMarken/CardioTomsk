package com.example.cardiotomsk.mainFragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cardiotomsk.LoginActivity;
import com.example.cardiotomsk.ProfileActivity;
import com.example.cardiotomsk.R;
import com.example.cardiotomsk.StartActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//	private static final String ARG_PARAM1 = "param1";
//	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
//	private String mParam1;
//	private String mParam2;

	public HomeFragment() {
		// Required empty public constructor
	}

//	/**
//	 * Use this factory method to create a new instance of
//	 * this fragment using the provided parameters.
//	 *
//	 * @param param1 Parameter 1.
//	 * @param param2 Parameter 2.
//	 * @return A new instance of fragment HomeFragment.
//	 */
	// TODO: Rename and change types and number of parameters
	public static HomeFragment newInstance() {
		HomeFragment fragment = new HomeFragment();
//		Bundle args = new Bundle();
//		args.putString(ARG_PARAM1, param1);
//		args.putString(ARG_PARAM2, param2);
//		fragment.setArguments(args);
		return fragment;
	}

	HomeFragment homeFragment;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		if (getArguments() != null) {
//			mParam1 = getArguments().getString(ARG_PARAM1);
//			mParam2 = getArguments().getString(ARG_PARAM2);
//		}

		homeFragment = this;


	}

	View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		v = inflater.inflate(R.layout.fragment_home, null);
		ImageView btn_notes = (ImageView) v.findViewById(R.id.user_profile1);

		ImageView.OnClickListener oclBtnOk = (new ImageView.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ProfileActivity.class);
				startActivity(intent);

			}
		});

		btn_notes.setOnClickListener(oclBtnOk);
		return v;
//		return inflater.inflate(R.layout.fragment_home, container, false);

	}

//	public void callProfileScreen(View view) {
//		Intent intent = new Intent(getActivity(), ProfileActivity.class);
//
//		Pair[] pairs = new Pair[1];
//		pairs[0] = new Pair<View, String>(v.findViewById(R.id.user_profile), "icon_profile");
//
//		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//			ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeFragment.this, pairs);
//			startActivity(intent, options.toBundle());
//		} else {
//			startActivity(intent);
//		}
//	}
}