package com.websarva.wings.android.asyncsample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * クラウド連携サンプル
 *
 * お天気詳細情報画面のアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class WeatherInfoActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather_info);

		Intent intent = getIntent();
		String cityName = intent.getStringExtra("cityName");
		String cityId = intent.getStringExtra("cityId");

		TextView tvCityName = (TextView) findViewById(R.id.tvCityName);
		TextView tvWeatherTelop = (TextView) findViewById(R.id.tvWeatherTelop);
		TextView tvWeatherDesc = (TextView) findViewById(R.id.tvWeatherDesc);

		WeatherInfoReceiver receiver = new WeatherInfoReceiver(cityName, tvCityName, tvWeatherTelop, tvWeatherDesc);
		receiver.execute(cityId);
	}

	/**
	 * 非同期でお天気データを取得するクラス。
	 *
	 * @author Shinzo SAITO
	 */
	private class WeatherInfoReceiver extends AsyncTask<String, String, String> {
		/**
		 * 都市名文字列フィールド。
		 */
		private String _cityName;
		/**
		 * 都市名を表示する画面部品フィールド。
		 */
		private TextView _tvCityName;
		/**
		 * 現在の天気を表示する画面部品フィールド。
		 */
		private TextView _tvWeatherTelop;
		/**
		 * 天気の詳細を表示する画面部品フィールド。
		 */
		private TextView _tvWeatherDesc;

		/**
		 * コンストラクタ。
		 * 都市名とお天気情報を表示する画面部品をあらかじめ取得してフィールドに格納している。
		 *
		 * @param cityName 都市名。
		 * @param tvCityName 都市名を表示する画面部品。
		 * @param tvWeatherTelop 現在の天気を表示する画面部品。
		 * @param tvWeatherDesc 天気の詳細を表示する画面部品。
		 */
		public WeatherInfoReceiver(String cityName, TextView tvCityName, TextView tvWeatherTelop, TextView tvWeatherDesc) {
			_cityName = cityName;
			_tvCityName = tvCityName;
			_tvWeatherTelop = tvWeatherTelop;
			_tvWeatherDesc = tvWeatherDesc;
		}

		@Override
		public String doInBackground(String... params) {
			String id = params[0];
			String urlStr = "http://weather.livedoor.com/forecast/webservice/json/v1?city=" + id;

			HttpURLConnection con = null;
			InputStream is = null;
			String result = "";

			try {
				URL url = new URL(urlStr);
				con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.connect();
				is = con.getInputStream();

				result = is2String(is);
			}
			catch(MalformedURLException ex) {
			}
			catch(IOException ex) {
			}
			finally {
				if(con != null) {
					con.disconnect();
				}

				if(is != null) {
					try {
						is.close();
					}
					catch(IOException ex) {
					}
				}
			}

			return result;
		}

		@Override
		public void onPostExecute(String result) {
			String desc = "";
			String dateLabel = "";
			String telop = "";
			try {
				JSONObject rootJSON = new JSONObject(result);
				JSONObject descriptionJSON = rootJSON.getJSONObject("description");
				desc = descriptionJSON.getString("text");
				JSONArray forecasts = rootJSON.getJSONArray("forecasts");
				JSONObject forecastNow = forecasts.getJSONObject(0);
				dateLabel = forecastNow.getString("dateLabel");
				telop = forecastNow.getString("telop");
			}
			catch(JSONException ex) {
			}

			_tvCityName.setText(_cityName + "の" + dateLabel + "の天気: ");
			_tvWeatherTelop.setText(telop);
			_tvWeatherDesc.setText(desc);
		}

		/**
		 * InputStreamオブジェクトを文字列に変換するメソッド。変換文字コードはUTF-8。
		 *
		 * @param is 変換対象のInputStreamオブジェクト。
		 * @return 変換された文字列。
		 * @throws IOException 変換に失敗した時に発生。
		 */
		private String is2String(InputStream is) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuffer sb = new StringBuffer();
			char[] b = new char[1024];
			int line;
			while(0 <= (line = reader.read(b))) {
				sb.append(b, 0, line);
			}
			return sb.toString();
		}
	}
}
