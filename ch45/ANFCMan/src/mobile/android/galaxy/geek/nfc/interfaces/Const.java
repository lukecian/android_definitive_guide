package mobile.android.galaxy.geek.nfc.interfaces;

public interface Const
{
    public String TAG_NFC_LOG = "ANFCMan"; 
    
	//  broadcast action
	public String NFC_MAN_BROADCAST_ACTION = "android.intent.action.ACTION_NFC_MAN";
	public String NFC_MAN_SERVICE_BROADCAST_ACTION = "android.intent.action.ACTION_NFC_MAN_SERVICE";
	
	//  ��������
	//  ��NFC��ǩд�ı�
	public int NFC_MAN_OPERATION_TYPE_WRITE_TEXT = 1;
	
	
	//  �쳣����
	//  д������ݳ���NFC��ǩ�����ߴ�
	public int NFC_MAN_EXCEPTION_MAX_SIZE = 1;
	//  ֻ����ǩ�޷�д��
	public int NFC_MAN_EXCEPTION_READONLY_NFC_TAG = 2;
	//  ��ʽ��NFC��ǩ�쳣
	public int NFC_MAN_EXCEPTION_FORMAT_NFC_TAG = 3;
	//  ��NFC��ǩд�������쳣
	public int NFC_MAN_EXCEPTION_WRITE_NFC_TAG = 4;
	  

	
	
	
}
   