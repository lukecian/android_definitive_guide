package mobile.android.activity.alias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityAliasMain extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_alias_main);
		if(".ActivityAliasMain".equals(getComponentName().getShortClassName()))
		{
			setTitle("ʹ����<activity>��ǩ");
		}
		else if(".AliasMain".equals(getComponentName().getShortClassName()))
		{
			setTitle("ʹ����<activity-alias>��ǩ");
		}
		
	}
	
	public void onClick_ShowTestActivity(View view)
	{
		Intent intent = new Intent("android.intent.action.TEST_ACTION");
		startActivity(intent);
	}
  
}
