package mobile.android.proximity.alert;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

public class ProximityAlertActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);	

		// ��λ�������������
		LocationManager locationManager;
		// ͨ��getSystemService�������LocationManager����
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// �����������Ի�Ĵ��¾��ȡ�γ��
		double longitude =123.427109;
		double latitude = 41.764998;			
		// ����뾶��2000�ף� 
		float radius = 2000;
		
		// ����Intent
		Intent intent = new Intent(this, ProximityAlertReciever.class);
		// ��Intent��װ��PendingIntent
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

		// ����ٽ�����
		locationManager.addProximityAlert(latitude, longitude, radius, -1, pendingIntent);		
	}
}