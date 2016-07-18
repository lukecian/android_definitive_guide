package mobile.android.custom.camera;

import java.io.IOException;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;  
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CameraPreview extends Activity
{

	private Preview preview;
	private ImageView ivFocus;
    public static Bitmap cameraBitmap ;
	@Override
	public void onCreate(Bundle savedInstanceState)   
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		preview = new Preview(this);
		setContentView(preview);

		ivFocus = new ImageView(this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
			preview.takePicture();
		return super.onTouchEvent(event);
	}  

	class Preview extends SurfaceView implements SurfaceHolder.Callback
	{
		private SurfaceHolder holder;
		private Camera camera;
		// 创建一个PictureCallback对象，并实现其中的onPictureTaken方法
		private PictureCallback pictureCallback = new PictureCallback()
		{
			// 该方法用于处理拍摄后的照片数据
			@Override
			public void onPictureTaken(byte[] data, Camera camera)
			{
				
				// data参数值就是照片数据，将这些数据以key-value形式保存，以便其他调用该Activity的程序可
				// 以获得照片数据
				Log.d("aaaaaaa", String.valueOf(data.length));
				cameraBitmap = BitmapFactory.decodeByteArray(data, 0,
						data.length);
				setResult(20);
				// 停止照片拍摄
				camera.stopPreview();
				camera = null;
				// 关闭当前的Activity
				finish();
			}
		};

		// Preview类的构造方法
		public Preview(Context context)
		{
			super(context);
			// 获得SurfaceHolder对象
			holder = getHolder();
			// 指定用于捕捉拍照事件的SurfaceHolder.Callback对象
			holder.addCallback(this);
			// 设置SurfaceHolder对象的类型
			//holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	
		}

		// 开�拍照时调用该方法
		public void surfaceCreated(SurfaceHolder holder)
		{
			// 获得Camera对象
			camera = Camera.open();
			
			try
			{
				
				// 设置用于显示拍照摄像的SurfaceHolder对象
				camera.setPreviewDisplay(holder);
			}
			catch (IOException exception)
			{
				// 释放手机摄像头
				camera.release();
				camera = null;
			}
		}

		// 停止拍照时调用该方法
		public void surfaceDestroyed(SurfaceHolder holder)
		{
			// 释放手机摄像头
			camera.release();
		}

		// 拍照状态变化时调用该方法
		public void surfaceChanged(final SurfaceHolder holder, int format,
				int w, int h)
		{
			try
			{
				
	   
				// 开始拍照
				camera.startPreview();
				// 准备用于表示对焦状态的图像
				
				ivFocus.setImageResource(R.drawable.focus1);
				LayoutParams layoutParams = new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				ivFocus.setScaleType(ScaleType.CENTER);
				addContentView(ivFocus, layoutParams);
				ivFocus.setVisibility(VISIBLE);
				// 自动对焦
				camera.autoFocus(new AutoFocusCallback()
				{
					@Override
					public void onAutoFocus(boolean success, Camera camera)
					{
						if (success)
						{
							// success为true表示对焦成功，改变对焦状态图像（一个绿色的png图像）
							ivFocus.setImageResource(R.drawable.focus2);
						}
					}
				});
			}
			catch (Exception e)
			{
			}
		}

		// 停止拍照，并将拍摄的照片传入PictureCallback接口的onPictureTaken方法
		public void takePicture()
		{
			if (camera != null)
			{
				
				camera.takePicture(null, null, pictureCallback);
			}
		}  
	}

}