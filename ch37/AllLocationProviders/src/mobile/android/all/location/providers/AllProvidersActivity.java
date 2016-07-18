package mobile.android.all.location.providers;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllProvidersActivity extends Activity
{
	ListView mProviders;
	LocationManager mLocationManager;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mProviders = (ListView) findViewById(R.id.providers);
		// ��ȡLocationManager����
		mLocationManager = (LocationManager)getSystemService(
			Context.LOCATION_SERVICE);
		
		// ��ȡ���е�LocationProvider������
		List<String> providerNames = mLocationManager.getAllProviders();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
			this,
			android.R.layout.simple_list_item_1,
			providerNames);
		// ʹ��ListView����ʾ���п��õ�LocationProvider
		mProviders.setAdapter(adapter);
	}
}