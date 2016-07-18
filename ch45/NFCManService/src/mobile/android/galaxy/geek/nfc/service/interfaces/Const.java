package mobile.android.galaxy.geek.nfc.service.interfaces;


public interface Const
{
    // �����ļ����ļ���
	public String NFC_MAN_SETTINGS_NAME = "nfc_man_service";
	
	//  ������IP��Key
	public String NFC_MAN_KEY_SERVER_IP = "server_ip";
	//  Android�豸���Ƶ�Key������������Ψһ��ʶAndroid�豸�������ظ�
	public String NFC_MAN_KEY_DEVICE_NAME = "device_name";
    
	//  ����˵Ķ˿ں�
	public int NFC_MAN_SERVER_PORT = 9119;
	
	//  broadcast action
	public String NFC_MAN_BROADCAST_ACTION = "android.intent.action.ACTION_NFC_MAN";
	public String NFC_MAN_SERVICE_BROADCAST_ACTION = "android.intent.action.ACTION_NFC_MAN_SERVICE";
	
	//  command
	public String NFC_MAN_COMMAND_CLOSE_SOCKET = "close_socket";

}
