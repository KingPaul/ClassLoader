package pual.example.classloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import paul.example.dynamic.IDynamic;

import dalvik.system.DexClassLoader;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements
		View.OnClickListener {

	private Button button1, button2, button3;
	private String SECONDARY_DEX_NAME = "test.jar";
	static final int BUF_SIZE = 8 * 1024;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.button1:
			testDexClassLoader();
			break;
		case R.id.button2:
			testPathClassLoader();
			break;
		case R.id.button3:
			break;

		default:
			break;
		}

	}

	@SuppressLint("NewApi")
	private void testDexClassLoader() {

		File dexInternalStoragePath = new File(getDir("dex",
				Context.MODE_PRIVATE), SECONDARY_DEX_NAME);
		BufferedInputStream bis = null;
		OutputStream dexWriter = null;

		try {
			bis = new BufferedInputStream(getAssets().open(SECONDARY_DEX_NAME));
			dexWriter = new BufferedOutputStream(new FileOutputStream(
					dexInternalStoragePath));
			byte[] buf = new byte[BUF_SIZE];
			int len;
			while ((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
				dexWriter.write(buf, 0, len);
			}
			dexWriter.close();
			bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final File optimizedDexOutputPath = getDir("outdex",
				Context.MODE_PRIVATE);

		MyDexClassLoader cl = new MyDexClassLoader(
				dexInternalStoragePath.getAbsolutePath(),
				optimizedDexOutputPath.getAbsolutePath(), null,
				getClassLoader());
		Class libProviderClazz = null;
		// Load the library.
		try {
			libProviderClazz = cl.loadClass("pual.example.dynamic.DynamicTest");
			System.out.println(cl.toString());
			
			System.out.println(libProviderClazz.getClassLoader().toString());
			
			// Cast the return object to the library interface so that the
			// caller can directly invoke methods in the interface.
			// Alternatively, the caller can invoke methods through
			// reflection,
			// which is more verbose.
			IDynamic lib = (IDynamic) libProviderClazz.newInstance();
//			System.out.println(lib.getClass().getClassLoader().toString());
//			System.out.println(lib.helloworld());
//
//			System.out.println("------------------------");
//			lib.sayHello();
//			System.out.println("------------------------");
			lib.printIMEI(this);
			System.out.println("------------------------");
			String url = "http://fabowang.sinaapp.com/";
			lib.printWeb(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testPathClassLoader() {

	}
}
