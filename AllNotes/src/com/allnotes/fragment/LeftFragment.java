package com.allnotes.fragment;

import com.allnotes.R;
import com.allnotes.activity.main.MainActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/*
 * @description 左边菜单
 */
public class LeftFragment extends Fragment implements OnClickListener {
	private View homeView;//首页
	private View readView;//阅读
	private View noteView;//笔记
	private View groupView;//群组
	private View findView;//发现
	private View draftView;//草稿
	private View settingView;//设置

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_menu, null);
		findViews(view);

		return view;
	}

	public void findViews(View view) {
		homeView = view.findViewById(R.id.menu_home);
		readView = view.findViewById(R.id.menu_read);
		noteView = view.findViewById(R.id.menu_note);
		groupView = view.findViewById(R.id.menu_group);
		findView = view.findViewById(R.id.menu_find);
		draftView = view.findViewById(R.id.menu_draft);
		settingView = view.findViewById(R.id.menu_setting);

		homeView.setOnClickListener(this);
		readView.setOnClickListener(this);
		noteView.setOnClickListener(this);
		groupView.setOnClickListener(this);
		findView.setOnClickListener(this);
		draftView.setOnClickListener(this);
		settingView.setOnClickListener(this);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		String title = null;
		switch (v.getId()) {
		case R.id.menu_home: // 首页
			newContent = new HomeFragment();
			title = getString(R.string.home);
			break;
		case R.id.menu_read:// 阅读
			newContent = new ReadFragment();
			title = getString(R.string.read);
			break;
		case R.id.menu_note: // 笔记
			newContent = new NoteFragment();
			title = getString(R.string.note);
			break;
		case R.id.menu_group: // 群组
			newContent = new GroupFragment();
			title = getString(R.string.group);
			break;
		case R.id.menu_find: // 发现
			newContent = new FindFragment();
			title = getString(R.string.find);
			break;
		case R.id.menu_draft: // 草稿
			newContent = new DraftFragment();
			title = getString(R.string.draft);
			break;
		case R.id.menu_setting: // 设置
			newContent = new SettingFragment();
			title = getString(R.string.setting);
			break;
		default:
			break;
		}
		if (newContent != null) {
			switchFragment(newContent, title);
		}
	}

	/**
	 * 更换fragment
	 * 
	 * @param fragment
	 */
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchConent(fragment, title);
		}
	}

}
