package mobile.android.runtime.test;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main extends Activity
{
    private List<Integer> list1 = new ArrayList<Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    //  ��1�����Է���
    public void test1() 
    {
        //  ��List���������10000����
        for (int i = 0; i < 10000; i++)
        {
            list1.add(i);
        }
    }
    //  ��2�����Է���
    public void test2()
    {
        //  ���λ��List�����е�Ԫ��
        for (int i = 0; i < 10000; i++)
            list1.get(i);
    }
    public void onClick_Test(View view)
    {
        try
        {
            //  ��ȡִ��test1����ǰ��ʱ��㣨��λ�����룩
            long start1 = System.currentTimeMillis();
            //  ִ��test1����
            test1();
            //  ��ȡִ��test1�������ʱ��㣨��λ�����룩
            long end1 = System.currentTimeMillis();
            //  ��ȡִ��test2����ǰ��ʱ��㣨��λ�����룩
            long start2 = System.currentTimeMillis();
            //  ִ��test2����
            test2();
            //  ��ȡִ��test2�������ʱ��㣨��λ�����룩
            long end2 = System.currentTimeMillis();
            //  ��ʾ���Խ��
            Toast.makeText(
                    this,
                    "test1������ִ��ʱ�䣺" + (end1 - start1) + "����\ntest2������ִ��ʱ�䣺" + (end2 - start2) + "����", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
        }
    }
}
