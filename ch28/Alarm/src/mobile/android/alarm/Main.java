package mobile.android.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener
{
	private AlarmManager alarmManager;

	@Override
	public void onClick(View view)
	{
		Intent intent = null;
		PendingIntent pendingActivityIntent;

		switch (view.getId()) 
		{
			case R.id.btnShowActivity:
				intent = new Intent(this, MyActivity.class);
				pendingActivityIntent = PendingIntent.getActivity(this, 0,
						intent, 0);				
				alarmManager.setRepeating(AlarmManager.RTC, 0, 5000,
						pendingActivityIntent);
				break;
			case R.id.btnStopActivity:
				intent = new Intent(this, MyActivity.class);
				pendingActivityIntent = PendingIntent.getActivity(this, 0, 
						intent, 0);
				alarmManager.cancel(pendingActivityIntent);
				break;

			default:
				break;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		Button btnShowActivity = (Button) findViewById(R.id.btnShowActivity);
		Button btnStopActivity = (Button)findViewById(R.id.btnStopActivity);
		btnShowActivity.setOnClickListener(this);
		btnStopActivity.setOnClickListener(this);
		

	}
}