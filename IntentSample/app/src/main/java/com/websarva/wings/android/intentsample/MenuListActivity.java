package com.websarva.wings.android.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * 画面遷移サンプル
 *
 * メニューリスト画面のアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class MenuListActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_list);

		ListView lvMenu = (ListView) findViewById(R.id.lvMenu);

		List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();
		
		Map<String, String> menu = new HashMap<String, String>();
		menu.put("name", "から揚げ定食");
		menu.put("price", "800円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "ハンバーグ定食");
		menu.put("price", "850円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "生姜焼き定食");
		menu.put("price", "850円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "ステーキ定食");
		menu.put("price", "1000円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "野菜炒め定食");
		menu.put("price", "750円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "とんかつ定食");
		menu.put("price", "900円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "ミンチかつ定食");
		menu.put("price", "850円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "チキンカツ定食");
		menu.put("price", "900円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "コロッケ定食");
		menu.put("price", "850円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "焼き魚定食");
		menu.put("price", "850円");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "焼肉定食");
		menu.put("price", "950円");
		menuList.add(menu);

		String[] from = {"name", "price"};
		int[] to = {android.R.id.text1, android.R.id.text2};
		SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, menuList, android.R.layout.simple_list_item_2, from, to);
		lvMenu.setAdapter(adapter);

		lvMenu.setOnItemClickListener(new ListItemClickListener());
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
			Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
			String menuName = item.get("name");
			String menuPrice = item.get("price");

			Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);
			intent.putExtra("menuName", menuName);
			intent.putExtra("menuPrice", menuPrice);
			startActivity(intent);
		}
	}
}
