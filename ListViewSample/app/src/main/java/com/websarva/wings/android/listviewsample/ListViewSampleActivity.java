package com.websarva.wings.android.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

		List<String> menuList = new ArrayList<String>();
		menuList.add("から揚げ定食");
		menuList.add("ハンバーグ定食");
		menuList.add("生姜焼き定食");
		menuList.add("ステーキ定食");
		menuList.add("野菜炒め定食");
		menuList.add("とんかつ定食");
		menuList.add("ミンチかつ定食");
		menuList.add("チキンカツ定食");
		menuList.add("コロッケ定食");
		menuList.add("焼き魚定食");
		menuList.add("焼肉定食");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewSampleActivity.this, android.R.layout.simple_list_item_1, menuList);
		listView.setAdapter(adapter);
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
			String item = (String) parent.getItemAtPosition(position);

//			TextView tvText = (TextView) view;
//			String item = tvText.getText().toString();

			String show = "あなたが選んだ定食: " + item;

			Toast.makeText(ListViewSampleActivity.this, show, Toast.LENGTH_LONG).show();
		}
	}
}
