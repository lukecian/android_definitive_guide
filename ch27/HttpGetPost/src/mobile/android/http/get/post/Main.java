package mobile.android.http.get.post;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener
{

	@Override
	public void onClick(View view)
	{
		// ������Ҫ�������е�IP�����Լ�������IP
		String url = "http://192.168.17.156:8080/querybooks/QueryServlet";
		TextView tvQueryResult = (TextView) findViewById(R.id.tvQueryResult);
		EditText etBookName = (EditText) findViewById(R.id.etBookName);
		HttpResponse httpResponse = null;
		try
		{
			switch (view.getId())
			{
			// �ύHTTP GET����
				case R.id.btnGetQuery:
					// ��url����������
					url += "?bookname=" + etBookName.getText().toString();
					// ��1��������HttpGet����
					HttpGet httpGet = new HttpGet(url);
					// ��2����ʹ��execute��������HTTP GET���󣬲�����HttpResponse����
					httpResponse = new DefaultHttpClient().execute(httpGet);
					// �ж�������Ӧ״̬�룬״̬��Ϊ200��ʾ����˳ɹ���Ӧ�˿ͻ��˵�����
					if (httpResponse.getStatusLine().getStatusCode() == 200)
					{
						// ��3����ʹ��getEntity������÷��ؽ��
						String result = EntityUtils.toString(httpResponse
								.getEntity());
						// ȥ�����ؽ���еġ�\r���ַ���������ڽ���ַ���������ʾһ��С����
						tvQueryResult.setText(result.replaceAll("\r", ""));
					}
					break;
				// �ύHTTP POST����
				case R.id.btnPostQuery:
					// ��1��������HttpPost����
					HttpPost httpPost = new HttpPost(url);
					// ����HTTP POST�������������NameValuePair����
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("bookname", etBookName
							.getText().toString()));
					// ����HTTP POST�������
					httpPost.setEntity(new UrlEncodedFormEntity(params,
							HTTP.UTF_8));
					// ��2����ʹ��execute��������HTTP POST���󣬲�����HttpResponse����
					httpResponse = new DefaultHttpClient().execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200)
					{
						// ��3����ʹ��getEntity������÷��ؽ��
						String result = EntityUtils.toString(httpResponse
								.getEntity());
						// ȥ�����ؽ���еġ�\r���ַ���������ڽ���ַ���������ʾһ��С����
						tvQueryResult.setText(result.replaceAll("\r", ""));
					}
					break;
			}
		}
		catch (Exception e)
		{
			tvQueryResult.setText(e.getMessage());
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btnGetQuery = (Button) findViewById(R.id.btnGetQuery);
		Button btnPostQuery = (Button) findViewById(R.id.btnPostQuery);
		btnGetQuery.setOnClickListener(this);
		btnPostQuery.setOnClickListener(this);

	}
}