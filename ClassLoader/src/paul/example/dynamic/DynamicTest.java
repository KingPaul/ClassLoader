package paul.example.dynamic;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DynamicTest{

	public String helloworld() {
		// TODO Auto-generated method stub
		return "Hello classloader!";
	}

	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("say hello!");
	}

	public void printIMEI(Context context) {
		// TODO Auto-generated method stub

		String Imei = ((TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
		System.out.println("IMEI: " + Imei);

	}

	public void printWeb(final String strurl) {
		// TODO Auto-generated method stub

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				URL url = null;
				try {
					url = new URL(strurl);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					// 建立连接
					URLConnection conn = url.openConnection();

					// 设置参数，如要Post的内容
					// conn.addRequestProperty(key, value);

					BufferedReader rd = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					DataInputStream dis = new DataInputStream(
							conn.getInputStream());
					// PrintWriter writer = new
					// PrintWriter(conn.getOutputStream());
					String str = "";
					String line = "";
					// while (str != null) {
					// str = dis.re();
					// System.out.println(str);
					// }

					while ((line = rd.readLine()) != null) {
						str += line;
					}
					System.out.println(str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

}
