package mobile.android.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity
{
	private NotificationManager mNotificationManager;

	public void onClick_ShowCommonNotification(View view)
	{
		Notification.Builder builder = new Notification.Builder(this)
				.setSmallIcon(R.drawable.smile).setContentTitle("Ц��֪ͨ")
				.setContentText("ͼ����ʾ�����!");
		mNotificationManager.notify(1, builder.build());
	}

	public void onClick_ShowBigIconNotification(View view)
	{
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.smile);
		Notification.Builder builder = new Notification.Builder(this)
				.setSmallIcon(R.drawable.why).setLargeIcon(bitmap)
				.setContentTitle("��ͼ��Ц��").setContentText("��ͼ�������࣬Сͼ��������½�!");

		mNotificationManager.notify(2, builder.build());

	}

	public void onClick_ShowBigPictureNotification(View view)
	{
		// �����������ͼNotification�������ٴ���ʾʱ�׳��쳣
		mNotificationManager.cancel(3);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.big);

		Notification notification = new Notification.BigPictureStyle(
				new Notification.Builder(this).setContentTitle("Big Picture")
						.setContentText("��ͼ").setSmallIcon(R.drawable.wrath))
				.bigPicture(bitmap).build();

		mNotificationManager.notify(3, notification);

	}

	public void onClick_ShowInfoNotification(View view)
	{
		Notification.Builder builder1 = new Notification.Builder(this)
				.setSmallIcon(R.drawable.why).setContentTitle("Info")
				.setContentText("�ı���Ϣ��ʾ�����½�!").setContentInfo("��Ϣ");

		mNotificationManager.notify(4, builder1.build());

		// setContentInfo���ȣ���setContentInfo��setNumber��������
		Notification.Builder builder2 = new Notification.Builder(this)
				.setSmallIcon(R.drawable.wrath).setContentTitle("Number")
				.setContentText("������ʾ�����½�!").setNumber(25);
		mNotificationManager.notify(5, builder2.build());

	}

	public void onClick_ShowProgressNotification(View view)
	{
		Notification.Builder builder1 = new Notification.Builder(this)
				.setSmallIcon(R.drawable.smile).setContentTitle("Determinate Progress")
				.setContentText("��ʾ���ȵĽ�����!").setProgress(100, 25, false);
		mNotificationManager.notify(6, builder1.build());
		Notification.Builder builder2 = new Notification.Builder(this)
		.setSmallIcon(R.drawable.why).setContentTitle("Indeterminate Progress")
		.setContentText("δ��ʾ���ȵĽ�����!").setProgress(100, 25, true);
		mNotificationManager.notify(7, builder2.build());
	}
    public void onClick_ClearAllNotification(View view)
    {
    	mNotificationManager.cancelAll();
    }
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}
}
