
package mobile.android.proximity.alert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;


public class ProximityAlertReciever extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{

		// ��ȡ�Ƿ�Ϊ����ָ������
		boolean isEnter = intent.getBooleanExtra(
			LocationManager.KEY_PROXIMITY_ENTERING, false);
		if(isEnter)
		{
			// ��ʾ��ʾ��Ϣ
			Toast.makeText(context
				, "���Ѿ��ӽ��������Ի�" 
				, Toast.LENGTH_LONG)
				.show();
		}
		else
		{
			// ��ʾ��ʾ��Ϣ
			Toast.makeText(context
				, "���Ѿ��뿪�������Ի�"
				, Toast.LENGTH_LONG)
				.show();		
		}
	}
}
