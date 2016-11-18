package com.websarva.wings.android.cameraintentsample;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * カメラアプリ連携サンプル
 *
 * アクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class UseCameraActivity extends AppCompatActivity {
	/**
	 * 保存された画像のURI。
	 */
	private Uri _imageUri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_use_camera);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == 200 && resultCode == RESULT_OK) {
			ImageView ivCamera = (ImageView) findViewById(R.id.ivCamera);
			ivCamera.setImageURI(_imageUri);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		if(requestCode == 2000 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
			ImageView ivCamera = (ImageView) findViewById(R.id.ivCamera);
			onCameraImageClick(ivCamera);
		}
	}

	/**
	 * 画像部分がタップされたときの処理メソッド。
	 *
	 * @param view 画面部品
	 */
	public void onCameraImageClick(View view) {
		if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
			String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
			ActivityCompat.requestPermissions(this, permissions, 2000);
			return;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date(System.currentTimeMillis());
		String nowStr = dateFormat.format(now);
		String fileName = "UseCameraActivityPhoto_" + nowStr +".jpg";

		ContentValues values = new ContentValues();
		values.put(MediaStore.Images.Media.TITLE, fileName);
		values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");

		ContentResolver resolver = getContentResolver();
		_imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, _imageUri);
		startActivityForResult(intent, 200);
	}
}
