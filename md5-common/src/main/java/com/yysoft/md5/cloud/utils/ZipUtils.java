package com.yysoft.md5.cloud.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	// 压缩
	public static byte[] zip(byte[] src) throws Exception {
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("1"));
			zout.write(src);
			zout.closeEntry();
			zout.flush();
			return out.toByteArray();
		} catch (Exception e) {
			throw e;
		} finally {
			closeQuietly(zout);
			closeQuietly(out);
		}
	}

	// 解压
	public static byte[] unzip(byte[] src) throws Exception {
		ZipInputStream zipin = null;
		ByteArrayOutputStream out = null;
		try {
			byte[] tst = Arrays.copyOf(src, 5);
			if ("<msg>".equals(new String(tst, "UTF-8"))) {
				return src;
			}
			zipin = new ZipInputStream(new ByteArrayInputStream(src));
			ZipEntry entry = zipin.getNextEntry();
			if (entry != null) {
				out = new ByteArrayOutputStream();
				byte[] buff = new byte[1024];
				int again = 0;
				while ((again = zipin.read(buff, 0, buff.length)) > 0) {
					out.write(buff, 0, again);
				}
				out.flush();
				return out.toByteArray();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			closeQuietly(zipin);
			closeQuietly(out);
		}

	}

	public static void closeQuietly(Closeable o) {
		if (o != null) {
			try {
				o.close();
			} catch (Exception e) {
			}
		}
	}

}
