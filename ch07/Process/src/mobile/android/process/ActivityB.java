package mobile.android.process;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ActivityB extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_activity_b);
		TextView textView = (TextView) findViewById(R.id.textview);
		String processId = String.valueOf(android.os.Process.myPid());

		textView.setText("��ǰ�������ڽ��̵�ID��" + processId + "\n");
		textView.append("ϵͳ�����е����н�������\n"
				+ ProcessActivity.getAllProcess(this));
	}

}
