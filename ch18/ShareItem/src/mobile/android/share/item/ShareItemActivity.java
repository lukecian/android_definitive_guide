package mobile.android.share.item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class ShareItemActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_item);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		getMenuInflater().inflate(R.menu.activity_share_item, menu);
		MenuItem shareItem = (MenuItem) menu.findItem(R.id.menu_share);
		ShareActionProvider provider = (ShareActionProvider) shareItem
				.getActionProvider();
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "����");
		intent.putExtra(Intent.EXTRA_TEXT, "ʹ��ShareActionProvider");
		//provider.setShareHistoryFileName("share.xml");
		provider.setShareIntent(intent);

		return true;
	}

}
