package mobile.android.service.test;


import mobile.android.service.lifecycle.MyService;
import android.content.Intent;
import android.test.ServiceTestCase;

public class ServiceTest extends ServiceTestCase<MyService>
{
	private MyService service;

	
	public ServiceTest()
	{
		super(MyService.class);

	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		Intent intent = new Intent(mContext, MyService.class);

		startService(intent);
		service = getService();

	}

	public void testService()
	{
		assertNotNull(service);
	}

	public void testResource()
	{
		
		assertEquals("�������������", service.getString(R.string.app_name));
	}
}
