package mobile.android.custom.title;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ChangeTitleLayoutActivity extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_change_title_layout);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.new_title_bar);

	}

}
