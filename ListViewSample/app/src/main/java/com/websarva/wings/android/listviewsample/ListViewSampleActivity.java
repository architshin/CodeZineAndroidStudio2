package com.websarva.wings.android.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * リスト選択サンプル
 *
 * メインアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class ListViewSampleActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_sample);

		ListView listView = (ListView) findViewById(R.id.lv_menu);
		listView.setOnItemClickListener(new ListItemClickListener());
	}

	/**
	 * リストが選択されたときの処理が記述されたメンバクラス。
	 *
	 * @author Shinzo SAITO
	 *
	 */
	private class ListItemClickListener implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			ListView listView = (ListView) parent;
			String item = (String) listView.getItemAtPosition(position);

			String show = "あなたが選んだ定食: " + item;

			Toast.makeText(ListViewSampleActivity.this, show, Toast.LENGTH_SHORT).show();
		}
	}
}
