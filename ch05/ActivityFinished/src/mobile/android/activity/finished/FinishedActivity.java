package mobile.android.activity.finished;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class FinishedActivity extends Activity
{
	private int count = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finished);
	}

	@Override
	public void finish()
	{
		if (count == 2)
		{
			super.finish();
			
		}
		else
		{
			Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_LONG).show();
			count++;
		}
	}

}
