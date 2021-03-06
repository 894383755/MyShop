package cn.it.shop.model;

import java.io.File;

/**
 * 文件类别
 * @author 王
 */
public class FileImage {
	/** 文件 **/
	private File file;
	/** 内容类型 **/
    private String contentType;  
    /** 名字 **/
    private String filename;  
      
    public File getFile() {  
        return file;  
    }  
  
    public String getContentType() {  
        return contentType;  
    }  
  
    public String getFilename() {  
        return filename;  
    }  
  
    public void setUpload(File file) { //set方法可以不用和属性名一样，但是前台传进来时的参数得和set方法名相同。即前台传的参数为fileImage.upload  
        this.file = file;  
    }  
      
    public void setUploadContentType(String contentType) {  
        this.contentType = contentType;  
    }  
      
    public void setUploadFileName(String filename) {  
        this.filename = filename;  
    }
}
