package mobile.android.auto.open.uri;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.widget.Toast;

public class AutoOpenUriActivity extends Activity
{
	private NfcAdapter nfcAdapter;
	private PendingIntent pendingIntent;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_auto_open_uri);
		nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
				getClass()), 0);

	}

	@Override
	public void onResume()
	{
		super.onResume();
		if (nfcAdapter != null)
			nfcAdapter
					.enableForegroundDispatch(this, pendingIntent, null, null);
	}

	@Override
	public void onNewIntent(Intent intent)
	{
		Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		writeNFCTag(detectedTag);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		if (nfcAdapter != null)
			nfcAdapter.disableForegroundDispatch(this);

	}

	public void writeNFCTag(Tag tag)
	{
		if (tag == null)
		{
			Toast.makeText(this, "NFC Tagδ��������", Toast.LENGTH_LONG).show();
			return;
		}

		// NdefMessage ndefMessage = new NdefMessage(new NdefRecord[]
		// { NdefRecord.createUri("http://blog.csdn.net/nokiaguy")});

		NdefMessage ndefMessage = new NdefMessage(new NdefRecord[]
		{ NdefRecord.createUri(Uri.parse("http://blog.csdn.net/nokiaguy")) });

		int size = ndefMessage.toByteArray().length;

		try
		{

			Ndef ndef = Ndef.get(tag);
			if (ndef != null)
			{
				ndef.connect();

				if (!ndef.isWritable())
				{
					Toast.makeText(this, "NFC Tag��ֻ���ģ�", Toast.LENGTH_LONG)
							.show();
					return;
				}
				if (ndef.getMaxSize() < size)
				{
					Toast.makeText(this, "NFC Tag�Ŀռ䲻�㣡", Toast.LENGTH_LONG)
							.show();
					return;
				}

				ndef.writeNdefMessage(ndefMessage);
				Toast.makeText(this, "�ѳɹ�д�����ݣ�", Toast.LENGTH_LONG).show();
			}
			else
			{
				NdefFormatable format = NdefFormatable.get(tag);
				if (format != null)
				{
					try
					{
						format.connect();
						format.format(ndefMessage);
						Toast.makeText(this, "�ѳɹ�д�����ݣ�", Toast.LENGTH_LONG)
								.show();
					}
					catch (Exception e)
					{
						Toast.makeText(this, "д��NDEF��ʽ����ʧ�ܣ�", Toast.LENGTH_LONG)
								.show();

					}
				}
				else
				{
					Toast.makeText(this, "NFC��ǩ��֧��NDEF��ʽ��", Toast.LENGTH_LONG)
							.show();
				}
			}
		}
		catch (Exception e)
		{
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}

	}

}
