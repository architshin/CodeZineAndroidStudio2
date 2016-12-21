package com.websarva.wings.android.coordinatorlayoutsample;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * スクロール連動ンプル
 *
 * アクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class ScrollArticleActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_article);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setLogo(R.mipmap.ic_launcher);
		setSupportActionBar(toolbar);

		CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbarLayout);
		toolbarLayout.setTitle(getString(R.string.toolbar_title));
		toolbarLayout.setExpandedTitleColor(Color.WHITE);
		toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY);
	}
}
