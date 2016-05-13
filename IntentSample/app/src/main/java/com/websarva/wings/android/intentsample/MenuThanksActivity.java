package com.websarva.wings.android.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * 画面遷移サンプル
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
	}
}
