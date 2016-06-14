package com.websarva.wings.android.menusample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * メニューサンプル
 *
 * メニューリスト画面のアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class MenuListActivity extends AppCompatActivity {

	private String[] _from = {"name", "price"};
	private int[] _to = {android.R.id.text1, android.R.id.text2};
	private ListView _lvMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_list);

		_lvMenu = (ListView) findViewById(R.id.lvMenu);

		List<Map<String, String>> menuList = createTeishokuList();
		SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, menuList, android.R.layout.simple_list_item_2, _from, _to);
		_lvMenu.setAdapter(adapter);

		_lvMenu.setOnItemClickListener(new ListItemClickListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_options_menu_list, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();
		int itemId = item.getItemId();
		switch(itemId) {
			case R.id.menuListOptionTeishoku:
				menuList = createTeishokuList();
				break;
			case R.id.menuListOptionCurry:
				menuList = createCurryList();
				break;
		}
		SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, menuList, android.R.layout.simple_list_item_2, _from, _to);
		_lvMenu.setAdapter(adapter);

		return super.onOptionsItemSelected(item);
	}

	/**
	 * リストビューに表示させる定食リストデータを生成するメソッド。
	 *
	 * @return 生成された定食リストデータ。
	 */
	private List<Map<String, String>> createTeishokuList() {
		List<Map<String, String>> menuList = new ArrayList<Map<String,String>>();

		Map<String, String> menu = new HashMap<String, String>();
		menu.put("name", "から揚げ定食");
		menu.put("price", "800円");
		menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "ハンバーグ定食");
		menu.put("price", "850円");
		menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "生姜焼き定食");
		menu.put("price", "850円");
		menu.put("desc", "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "ステーキ定食");
		menu.put("price", "1000円");
		menu.put("desc", "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "野菜炒め定食");
		menu.put("price", "750円");
		menu.put("desc", "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "とんかつ定食");
		menu.put("price", "900円");
		menu.put("desc", "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "ミンチかつ定食");
		menu.put("price", "850円");
		menu.put("desc", "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "チキンカツ定食");
		menu.put("price", "900円");
		menu.put("desc", "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "コロッケ定食");
		menu.put("price", "850円");
		menu.put("desc", "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "焼き魚定食");
		menu.put("price", "850円");
		menu.put("desc", "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		menu = new HashMap<String, String>();
		menu.put("name", "焼肉定食");
		menu.put("price", "950円");
		menu.put("desc", "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。");
		menuList.add(menu);

		return menuList;
	}

	/**
	 * リストビューに表示させるカレーリストデータを生成するメソッド。
	 *
	 * @return 生成されたカレーリストデータ。
	 */
	private List<Map<String, String>> createCurryList() {
		List<Map<String, String>> menuList = new ArrayList<Map<String,String>>();

		Map<String, String> menu = new HashMap<String, String>();
		menu.put("name", "ビーフカレー");
		menu.put("price", "520");
		menu.put("desc", "特選スパイスをきかせた国産ビーフ100%のカレーです。");
		menuList.add(menu);
		menu = new HashMap<String, String>();
		menu.put("name", "ポークカレー");
		menu.put("price", "420");
		menu.put("desc", "特選スパイスをきかせた国産ポーク100%のカレーです。");
		menuList.add(menu);
		menu = new HashMap<String, String>();
		menu.put("name", "ハンバーグカレー");
		menu.put("price", "620");
		menu.put("desc", "特選スパイスをきかせたカレーに手ごねハンバーグをトッピングです。");
		menuList.add(menu);
		menu = new HashMap<String, String>();
		menu.put("name", "チーズカレー");
		menu.put("price", "560");
		menu.put("desc", "特選スパイスをきかせたカレーにとろけるチーズをトッピングです。");
		menuList.add(menu);
		menu = new HashMap<String, String>();
		menu.put("name", "カツカレー");
		menu.put("price", "760");
		menu.put("desc", "特選スパイスをきかせたカレーに国産ロースカツをトッピングです。");
		menuList.add(menu);
		menu = new HashMap<String, String>();
		menu.put("name", "ビーフカツカレー");
		menu.put("price", "880");
		menu.put("desc", "特選スパイスをきかせたカレーに国産ビーフカツをトッピングです。");
		menuList.add(menu);
		menu = new HashMap<String, String>();
		menu.put("name", "からあげカレー");
		menu.put("price", "540");
		menu.put("desc", "特選スパイスをきかせたカレーに若鳥のから揚げをトッピングです。");
		menuList.add(menu);

		return menuList;
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
