package mobile.android.criteria.location.providers;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CriteriaProvidersActivity extends Activity
{
	ListView mProviders;
	LocationManager mLocationManager;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mProviders = (ListView) findViewById(R.id.providers);
		// ��ȡϵͳ��LocationManager����
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// ����һ��LocationProvider�Ĺ�������
		Criteria cri = new Criteria();
		// ����Ҫ��LocationProvider��������ѵġ�
		cri.setCostAllowed(false);

		// ����Ҫ��LocationProvider���ṩ�߶���Ϣ
		cri.setAltitudeRequired(true);  
		// ����Ҫ��LocationProvider���ṩ������Ϣ
		cri.setBearingRequired(true);
		// ��ȡϵͳ���з���������LocationProvider������
		List<String> providerNames = mLocationManager.getProviders(cri, true);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, providerNames);
		// ʹ��ListView����ʾ���п��õ�LocationProvider
		mProviders.setAdapter(adapter);
	}
}