package cn.simpleray.base.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileOperateUtil {
	/**
	 * 下载
	 * 
	 * @param request
	 * @param response
	 * @param storeName
	 * @param contentType
	 * @param realName
	 * @throws Exception
	 */
	public static void download(HttpServletRequest request,
			HttpServletResponse response, String storeName, String contentType,
			String realName) throws Exception {
		response.setContentType("application/x-compressed;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		String downLoadPath = getRoot() + storeName;

		long fileLength = new File(downLoadPath).length();

		response.setContentType(contentType);
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(zipName(realName).getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));

		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}

	public static void delete(String filePath) {
		filePath = getRoot() + filePath;

		File file = new File(filePath);

		if (file.exists()) {
			file.delete();
		}
	}

	public static String upload(MultipartFile file) throws Exception {
		String fileName = "";
		try {
			fileName = getFilePath(file.getOriginalFilename());

			File newFile = new File(getRoot() + fileName);

			newFile.setWritable(true, false);

			makeDirs(newFile);

			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(newFile));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}

	private static String getFilePath(String fileName) {
		String dir = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";

		String filePath = String.valueOf(new Random().nextInt(1000));

		if (fileName.indexOf(".") != -1) {
			filePath = dir + filePath
					+ fileName.substring(fileName.lastIndexOf("."));
		}

		return filePath;
	}

	public static void makeDirs(File file) {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}

	public static String uploadAsZip(MultipartFile file) throws Exception {
		String zipName = zipName(file.getOriginalFilename());

		File zipFile = new File(getRoot() + zipName);

		makeDirs(zipFile);

		// 上传成为压缩文件
		ZipOutputStream outputStream = new ZipOutputStream(
				new BufferedOutputStream(new FileOutputStream(zipFile)));
		outputStream.putNextEntry(new ZipEntry(file.getOriginalFilename()));
		outputStream.setEncoding(Constants.ENCODING);

		FileCopyUtils.copy(file.getInputStream(), outputStream);

		return zipName;
	}

	private static String getRoot() {
		if (root == null) {
			root = FileOperateUtil.class.getResource("/").getPath().replace(
				"WEB-INF/classes", "resources/upload");

			root = root.substring(1);

			if (!root.startsWith("/")) {
				root = "/" + root;
			}
		}

		return root;
	}

	private static String root = null;

	private static String zipName(String name) {
		name = getFilePath(name);

		String prefix = "";
		if (name.indexOf(".") != -1) {
			prefix = name.substring(0, name.lastIndexOf("."));
		} else {
			prefix = name;
		}
		return prefix + ".zip";
	}
}
