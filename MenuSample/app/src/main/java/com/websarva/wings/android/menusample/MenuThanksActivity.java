package com.websarva.wings.android.menusample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * メニューサンプル
 *
 * 注文完了画面のアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class MenuThanksActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_thanks);

		Intent intent = getIntent();
		String menuName = intent.getStringExtra("menuName");
		String menuPrice = intent.getStringExtra("menuPrice");

		TextView tvMenuName = (TextView) findViewById(R.id.tvMenuName);
		TextView tvMenuPrice = (TextView) findViewById(R.id.tvMenuPrice);

		tvMenuName.setText(menuName);
		tvMenuPrice.setText(menuPrice);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		switch (itemId) {
			case android.R.id.home:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
