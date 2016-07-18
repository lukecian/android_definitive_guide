package galaxy.geek.nfc.util;

import galaxy.geek.nfc.service.Data;
import galaxy.geek.nfc.widget.NFCTag;
import mobile.android.galaxy.geek.nfc.data.NFCData;
import mobile.android.galaxy.geek.nfc.data.NFCSimulationData;
import mobile.android.galaxy.geek.nfc.exceptions.MaxSizeException;

//  ���ڴ����ڿͻ��˺ͷ����֮�䴫�ݵ��ַ���
public class StringWorker
{
	public static String buildNfcTagString(NFCData data)
	{
		NFCSimulationData simulationData = data.simulation;

		if (simulationData != null)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(simulationData.command);
			sb.append(":");
			sb.append(simulationData.type);
			sb.append(":");
			sb.append(simulationData.deviceName);

			sb.append(":");
			sb.append(simulationData.targetName);
			if (data.text != null)
			{
				sb.append("$");
				sb.append(data.maxSize);
				sb.append(",");
				sb.append(data.text);
				sb.append(",");
				sb.append(data.contentSize);
			}
			return sb.toString();
		}
		return null;
	}

	// clientText��ʾ�ͻ��˴��������ַ������÷��������clientText�����ý�����ĵ�������װ��data�Ĳ�������
	public static void writeDataToTag(String clientText)
			throws MaxSizeException
	{
		String[] array = clientText.split(":");
		if (array.length < 5)
			return;
		String command = array[0]; // writetag��readtag��
		String type = array[1]; // text��url��
		String deviceName = array[2]; // �ṩ����Դ���豸���ƣ���������ʱû�и�ֵ
		String targetName = array[3]; // �������ݵ��豸��Tag���ƣ���Ҫ���ݸ������ҵ�NFCTag
		String value = array[4]; // ����command��target������ֵ������
		NFCTag tag = null;
		if (command.contains("tag"))
		{
			if (targetName.contains("$"))
				tag = Data.getTag(targetName.substring(0,
						targetName.indexOf("$")));
			else
				tag = Data.getTag(targetName);
			if (tag == null)
				return;
		}
		if ("writetag".equals(command))
		{
			if ("text".equals(type))
			{

				int contentSize = 0;
				try
				{
					contentSize = value.getBytes("utf-8").length;
				}
				catch (Exception e) {
					// TODO: handle exception
				}

				if (contentSize > tag.maxSize)
				{
					throw new MaxSizeException("д������ݳ���NFC��ǩ���������");
				}

				tag.contentSize = contentSize;
			}

			tag.setText(value);

		}
		Storage.saveNFCTag(tag);
	}

}
