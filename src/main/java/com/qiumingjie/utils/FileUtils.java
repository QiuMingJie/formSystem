package com.qiumingjie.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class FileUtils extends org.apache.commons.io.FileUtils{
	

	public static final int BUFFER_SIZE = 1024 * 4;
	
	/**
	 * 将文件写入到输出流中
	 * author lijuntao
	 * date 2018年12月17日
	 */
	public static void write(File file, OutputStream out) throws Exception {
		InputStream in = null;
		try {
			in = new BufferedInputStream(
					new FileInputStream(file), BUFFER_SIZE);
			byte[] buffer = new byte[2048];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		} finally {
			closeQuietly(in);
			out.flush();
		} 
	}
	
	/**
	 * 将文件写入到输出流中
	 * author lijuntao
	 * date 2018年12月17日
	 */
	public static void write(String filePath, OutputStream out) throws Exception {
		InputStream in = null;
        try {
        	in = new BufferedInputStream(
        			new FileInputStream(filePath), BUFFER_SIZE);
        	byte[] buffer = new byte[2048];
            int count = 0;
            while ((count = in.read(buffer)) != -1) {
                out.write(buffer, 0, count);
            }
            out.flush();
        } finally {
        	closeQuietly(in);
			out.flush();
		} 
    }
	
	/**
	 * 
	 * author lijuntao
	 * date 2018年12月17日
	 */
	public static void write(byte[] bs, OutputStream out) throws Exception{
		if(CommonUtils.notEmpty(bs) && out != null){
			out.write(bs);
			out.flush();
		}
	}
	
	public static void closeQuietly(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (Exception ignore) {}
		}
    }
	
	
	public static void write(byte[] bs, HttpServletResponse response) throws Exception{
		if(CommonUtils.notEmpty(bs) && response != null){
			OutputStream os = null;
			os = response.getOutputStream();
			os.write(bs);
		}
	}
	
	public static void write(byte[] bs, String pathName) throws Exception{
		
		File file = new File(pathName);
		
		FileOutputStream out = new FileOutputStream(file);
		
		write(bs, out);
	}

	public static boolean exists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	/****
	 *@Author sugx
	 *@Description 拷贝文件夹
	 *@Date 2019年09月19日 12:20
	 **/
	public static void dirCopy(String srcPath, String destPath) {
		File src = new File(srcPath);
		if (!new File(destPath).exists()) {
			new File(destPath).mkdirs();
		}
		for (File s : src.listFiles()) {
			if (s.isFile()) {
				fileCopy(s.getPath(), destPath + File.separator + s.getName());
			} else {
				dirCopy(s.getPath(), destPath + File.separator + s.getName());
			}
		}
	}


	/***
	 *@Author sugx
	 *@Description 拷贝文件
	 *@Date 2019年09月19日 12:19
	 **/
	public static void fileCopy(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.exists()||!src.isFile()) {
			throw new RuntimeException("源文件不存在或类型不是文件");
		}
		if(destPath.endsWith("/")||destPath.endsWith(File.separator)){
			throw new RuntimeException("未指定目标文件文件名");
		}
		//使用jdk1.7 try-with-resource 释放资源，并添加了缓存流
		try(InputStream is = new BufferedInputStream(new FileInputStream(src));
			OutputStream out =new BufferedOutputStream(new FileOutputStream(dest))) {
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				out.write(flush, 0, len);
			}
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/****
	 *@Author sugx
	 *@Description //递归删除文件夹及其内容
	 *@Date 2019年09月19日 16:18
	 **/
	public static void deleteDir(File dir){
		if (dir == null || !dir.exists()||dir.isFile()){
			return;
		}

		String[] fileNames=dir.list();
		for (String fileName: fileNames){
			File file=new File(dir.getAbsolutePath()+File.separator+fileName);

			if (file.isDirectory()){
				deleteDir(file);
			}else {
				file.delete();
			}
		}
		//删除空文件夹
		dir.delete();
	}

    public static String getDirName(String path){
    	return getFileName(path);
    }
    
    public static String getFileName(String path){
    	int indexOf = path.lastIndexOf("/");
    	if(indexOf != -1){
    		return path.substring(indexOf + 1, path.length());
    	}
    	return "";
    }
    
    /**
     * 获取文件后缀
     * @author lijuntao
     * @date 2019年11月19日
     */
	public static String getSuffix(String name) {
		return StringUtils.substringAfterLast(name, ".");
	}
	
	/**
	 * 获取上一个目录
	 * @author lijuntao
	 * @date 2019年11月19日
	 */
    public static String getLastPath(String path){
    	path = StringUtils.removeEnd(path, "//");
    	path = StringUtils.removeEnd(path, "/");
    	int indexOf = path.lastIndexOf("/");
    	if(indexOf != -1){
    		return path.substring(0, indexOf);
    	}
    	return "";
    }
    
    public static Pattern pattern = Pattern.compile("(\\(\\d+\\))$");
    
    /**
     * 有相同文件名，则重命名文件
     * @author lijuntao
     * @date 2019年11月28日
     */
    public static String renameIfFileNameSame(Set<String> fileNames, String fileName){
    	if(CommonUtils.empty(fileNames) || StringUtils.isBlank(fileName)){
    		return fileName;
    	}
    	if(fileNames.contains(fileName)){
    		fileName = getNextFileName(fileName);
    		return renameIfFileNameSame(fileNames, fileName);
    	}
    	return fileName;
    }
    
    /**
     * 文件重名获取新的文件名，例如
     * jj.txt -> jj(1).txt
     * jj(1).txt -> jj(2).txt
     * @author lijuntao
     * @date 2019年11月28日
     */
    public static String getNextFileName(String fileName){

    	String suffix = CommonUtils.nullToEmpty(getSuffix(fileName));
    	String name = StringUtils.substringBeforeLast(fileName, ".");
    	
    	Matcher matcher = pattern.matcher(name);
    	if(matcher.find()){
    		String group = matcher.group(1);
    		String numStr = group.substring(1, group.length() - 1);
    		Integer num = NumberUtils.parseInteger(numStr);
    		String theNextStr = "(" + (num + 1) + ")";
    		name = name.substring(0, name.length() - group.length()) + theNextStr;
    	}else{
    		name += "(1)";
    	}
    	if(fileName.indexOf(".") > -1){
    		fileName = name + "." + suffix;
    	}else{
    		fileName = name + suffix;
    	}
    	return fileName;
    }
    
    public static void createDir(File dir){
   	    if(!dir.exists()){
   	        File parent = dir.getParentFile();
   	        createDir(parent);
   	        dir.mkdir();
   	    }
   	}


	public static void saveToDisk(String filePath, String fileName, InputStream fileStream) throws Exception {
		InputStream in = null;
		OutputStream out = null;
		try {
			File destDir = new File(filePath);
			if (!destDir.exists()) {
				destDir.mkdirs();
			}
			File destFile = new File(destDir, fileName);
			if (destFile.exists()) {
				throw new RuntimeException("文件[" + fileName + "]已存在！");
			}
			in = new BufferedInputStream(fileStream, BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(destFile), BUFFER_SIZE);
			byte[] buffer = new byte[2048];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
			out.flush();
		} finally {
			closeQuietly(in);
			closeQuietly(out);
		}
	}
   	

    
}
