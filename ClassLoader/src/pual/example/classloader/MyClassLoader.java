package pual.example.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

import android.util.Log;

public class MyClassLoader extends ClassLoader {

	final private static String TAG = "CLASSLOADER";

	@Override
	protected Class<?> findClass(String className)
			throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Log.i(TAG, "findclass");
		return super.findClass(className);
	}

	@Override
	public URL getResource(String resName) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getresource");

		return super.getResource(resName);
	}

	@Override
	public Enumeration<URL> getResources(String resName) throws IOException {
		// TODO Auto-generated method stub
		Log.i(TAG, "getresources");

		return super.getResources(resName);
	}

	@Override
	public InputStream getResourceAsStream(String resName) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getResourceAsStream");

		return super.getResourceAsStream(resName);
	}

	@Override
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Log.i(TAG, "loadclass");
		return super.loadClass(className);
	}

	@Override
	protected Class<?> loadClass(String className, boolean resolve)
			throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Log.i(TAG, "loadclass");
		return super.loadClass(className, resolve);
	}

	@Override
	protected URL findResource(String resName) {
		// TODO Auto-generated method stub
		Log.i(TAG, "findresource");
		return super.findResource(resName);
	}

	@Override
	protected Enumeration<URL> findResources(String resName) throws IOException {
		// TODO Auto-generated method stub
		Log.i(TAG, "findresource");
		return super.findResources(resName);
	}

	@Override
	protected String findLibrary(String libName) {
		// TODO Auto-generated method stub
		Log.i(TAG, "findlibrary");
		return super.findLibrary(libName);
	}

	@Override
	protected Package getPackage(String name) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getpackage");
		return super.getPackage(name);
	}

	@Override
	protected Package[] getPackages() {
		Log.i(TAG, "getpackages");
		// TODO Auto-generated method stub
		return super.getPackages();
	}

	@Override
	protected Package definePackage(String name, String specTitle,
			String specVersion, String specVendor, String implTitle,
			String implVersion, String implVendor, URL sealBase)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Log.i(TAG, "definepackage");
		return super.definePackage(name, specTitle, specVersion, specVendor,
				implTitle, implVersion, implVendor, sealBase);
	}

	@Override
	public void setClassAssertionStatus(String cname, boolean enable) {
		// TODO Auto-generated method stub
		Log.i(TAG, "setClassAssertionStatus");
		super.setClassAssertionStatus(cname, enable);
	}

	@Override
	public void setPackageAssertionStatus(String pname, boolean enable) {
		// TODO Auto-generated method stub
		Log.i(TAG, "setClassAssertionStatus");
		super.setPackageAssertionStatus(pname, enable);
	}

	@Override
	public void setDefaultAssertionStatus(boolean enable) {
		// TODO Auto-generated method stub
		Log.i(TAG, "setClassAssertionStatus");
		super.setDefaultAssertionStatus(enable);
	}

	@Override
	public void clearAssertionStatus() {
		// TODO Auto-generated method stub
		Log.i(TAG, "clearAssertionStatus");
		super.clearAssertionStatus();
	}

}
