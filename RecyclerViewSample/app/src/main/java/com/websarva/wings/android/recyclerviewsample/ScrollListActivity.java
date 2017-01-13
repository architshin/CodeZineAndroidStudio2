package com.websarva.wings.android.recyclerviewsample;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * リサイクラービューサンプル
 *
 * アクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class ScrollListActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_list);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setLogo(R.mipmap.ic_launcher);
		setSupportActionBar(toolbar);

		CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbarLayout);
		toolbarLayout.setTitle(getString(R.string.toolbar_title));
		toolbarLayout.setExpandedTitleColor(Color.WHITE);
		toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY);

		RecyclerView lvMenu = (RecyclerView) findViewById(R.id.lv_menu);

		LinearLayoutManager layout = new LinearLayoutManager(ScrollListActivity.this);
		lvMenu.setLayoutManager(layout);

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
		menuList.add("カキフライ定食");
		menuList.add("アジのフライ定食");
		menuList.add("ジンギスカン定食");
		menuList.add("エビフライ定食");
		menuList.add("回鍋肉定食");
		menuList.add("青椒肉絲定食");
		menuList.add("麻婆豆腐定食");
		menuList.add("餃子定食");

		RecyclerListAdapter adapter = new RecyclerListAdapter(menuList);
		lvMenu.setAdapter(adapter);

		DividerItemDecoration decorator = new DividerItemDecoration(ScrollListActivity.this, layout.getOrientation());
		lvMenu.addItemDecoration(decorator);
	}

	/**
	 * RecyclerViewのビューホルダクラス。
	 */
	private class RecyclerListViewHolder extends RecyclerView.ViewHolder {
		public TextView _tvItem;

		public RecyclerListViewHolder(View itemView) {
			super(itemView);
			_tvItem = (TextView) itemView.findViewById(android.R.id.text1);
		}
	}

	/**
	 * RecyclerViewのアダプタクラス。
	 */
	private class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListViewHolder> {

		private List<String> _listData;

		public RecyclerListAdapter(List<String> listData) {
			_listData = listData;
		}

		@Override
		public RecyclerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater inflater = LayoutInflater.from(ScrollListActivity.this);
			View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
			view.setOnClickListener(new ItemClickListener());
			RecyclerListViewHolder holder = new RecyclerListViewHolder(view);
			return holder;
		}

		@Override
		public void onBindViewHolder(RecyclerListViewHolder holder, int position) {
			String item = _listData.get(position);
			holder._tvItem.setText(item);
		}

		@Override
		public int getItemCount() {
			return _listData.size();
		}
	}

	/**
	 * リストをタップした時のリスナクラス。
	 */
	private class ItemClickListener implements View.OnClickListener {

		@Override
		public void onClick(View view) {
			TextView tvItem = (TextView) view.findViewById(android.R.id.text1);
			String menu = tvItem.getText().toString();
			String msg = getString(R.string.msg_header) + menu;
			Toast.makeText(ScrollListActivity.this, msg, Toast.LENGTH_SHORT).show();
		}
	}
}
