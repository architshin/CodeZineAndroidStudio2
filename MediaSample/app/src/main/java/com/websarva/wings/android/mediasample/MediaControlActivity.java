package com.websarva.wings.android.mediasample;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.io.IOException;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * メディアサンプル
 *
 * アクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class MediaControlActivity extends AppCompatActivity {

	/**
	 * メディアプレーヤーフィールド。
	 */
	private MediaPlayer _player;

	/**
	 * 再生・一時停止ボタンフィールド。
	 */
	private Button _btPlay;

	/**
	 * 戻るボタンフィールド。
	 */
	private Button _btBack;

	/**
	 * 進むボタンフィールド。
	 */
	private Button _btForward;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media_control);

		_btPlay = (Button) findViewById(R.id.btPlay);
		_btBack = (Button) findViewById(R.id.btBack);
		_btForward = (Button) findViewById(R.id.btForward);

		_player = new MediaPlayer();
		String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.mountain_stream;
		Uri mediaFileUri = Uri.parse(mediaFileUriStr);
		try {
			_player.setDataSource(MediaControlActivity.this, mediaFileUri);
			_player.setOnPreparedListener(new PlayerPreparedListener());
			_player.setOnCompletionListener(new PlayerCompletionListener());
			_player.prepareAsync();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		Switch loopSwitch = (Switch) findViewById(R.id.swLoop);
		loopSwitch.setOnCheckedChangeListener(new LoopSwitchChangedListener());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(_player.isPlaying()) {
			_player.stop();
		}
		_player.release();
		_player = null;
	}

	/**
	 * 再生ボタンタップ時の処理メソッド。
	 *
	 * @param view 画面部品
	 */
	public void onPlayButtonClick(View view) {
		if(!_player.isPlaying()) {
			_player.start();
			_btPlay.setText(R.string.bt_play_pause);
		}
		else {
			_player.pause();
			_btPlay.setText(R.string.bt_play_play);
		}
	}

	/**
	 * 戻るボタンタップ時の処理メソッド。
	 *
	 * @param view 画面部品
	 */
	public void onBackButtonClick(View view) {
		_player.seekTo(0);
	}

	/**
	 * 進むボタンタップ時の処理メソッド。
	 *
	 * @param view 画面部品
	 */
	public void onForwardButtonClick(View view) {
		int duration = _player.getDuration();
		_player.seekTo(duration);
		if(!_player.isPlaying()) {
			_player.start();
		}
	}

	/**
	 * プレーヤーの再生準備が整った時のリスナクラス。
	 */
	private class PlayerPreparedListener implements MediaPlayer.OnPreparedListener {

		@Override
		public void onPrepared(MediaPlayer mp) {
			_btPlay.setEnabled(true);
			_btBack.setEnabled(true);
			_btForward.setEnabled(true);
		}
	}

	/**
	 * 再生が終了したときのリスナクラス。
	 */
	private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener {

		@Override
		public void onCompletion(MediaPlayer mp) {
			if(!_player.isLooping()) {
				_btPlay.setText(R.string.bt_play_play);
			}
		}
	}

	/**
	 * リピート再生スイッチの切替時のリスナクラス。
	 */
	private class LoopSwitchChangedListener implements CompoundButton.OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			_player.setLooping(isChecked);
		}
	}
}
