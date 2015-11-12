package pual.example.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;

import android.util.Log;

import dalvik.system.DexClassLoader;

public class MyDexClassLoader extends DexClassLoader {
	final private static String TAG = "DEXLOADER";

	// private final DexPathList pathList;

	public MyDexClassLoader(String dexPath, String optimizedDirectory,
			String libraryPath, ClassLoader parent) {

		// this.pathList = new DexPathList(this, dexPath, libraryPath,
		// optimizedDirectory);
		super(dexPath, optimizedDirectory, libraryPath, parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Log.i(TAG, "findCLass");
		return super.findClass(name);
	}

	@Override
	public String findLibrary(String name) {
		// TODO Auto-generated method stub
		Log.i(TAG, "findlibarary");
		return super.findLibrary(name);
	}

	@Override
	protected URL findResource(String name) {
		// TODO Auto-generated method stub
		Log.i(TAG, "findresource");
		return super.findResource(name);
	}

	@Override
	protected Enumeration<URL> findResources(String name) {
		// TODO Auto-generated method stub
		Log.i(TAG, "findresource");
		return super.findResources(name);
	}

	@Override
	protected synchronized Package getPackage(String name) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getpackage");
		return super.getPackage(name);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "wangfabo";
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
		Log.i(TAG, "getresource");
		return super.getResources(resName);
	}

	@Override
	public InputStream getResourceAsStream(String resName) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getresourceasstream");
		return super.getResourceAsStream(resName);
	}

	@Override
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Log.i(TAG, "loadclass: " + className);

		Class clz = super.findClass(className);
		// Field field;
		// try {
		// field = clz.getDeclaredField("classLoader");
		// Object obj = clz.newInstance();
		// field.setAccessible(true);
		// field.set(obj, this);
		// System.out.println(field.get(obj));
		// } catch (NoSuchFieldException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InstantiationException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		return clz;
	}

	@Override
	protected Class<?> loadClass(String className, boolean resolve)
			throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Log.i(TAG, "loadclass: " + className);
		return super.loadClass(className, resolve);
	}

	@Override
	protected Package[] getPackages() {
		// TODO Auto-generated method stub
		Log.i(TAG, "getpackage");
		return super.getPackages();
	}

	@Override
	protected Package definePackage(String name, String specTitle,
			String specVersion, String specVendor, String implTitle,
			String implVersion, String implVendor, URL sealBase)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Log.i(TAG, "defincepackage");
		return super.definePackage(name, specTitle, specVersion, specVendor,
				implTitle, implVersion, implVendor, sealBase);
	}

	@Override
	public void setClassAssertionStatus(String cname, boolean enable) {
		// TODO Auto-generated method stub
		Log.i(TAG, "setclassassertionstatus");
		super.setClassAssertionStatus(cname, enable);
	}

	@Override
	public void setPackageAssertionStatus(String pname, boolean enable) {
		// TODO Auto-generated method stub
		Log.i(TAG, "setpackageassertionstatus");
		super.setPackageAssertionStatus(pname, enable);
	}

	@Override
	public void setDefaultAssertionStatus(boolean enable) {
		// TODO Auto-generated method stub.
		Log.i(TAG, "setdefaultassertionstatus");
		super.setDefaultAssertionStatus(enable);
	}

	@Override
	public void clearAssertionStatus() {
		// TODO Auto-generated method stub
		Log.i(TAG, "clearassertionstatus");
		super.clearAssertionStatus();
	}

}
