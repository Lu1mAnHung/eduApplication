package com.edu.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.jfinal.plugin.activerecord.Record;

import cn.hutool.json.JSONObject;
/**
 * 公用工具类
 * @author 咸鱼OvO
 *
 */
public class JwUtil {

	/**
	 * xml解析实现方法
	 * @param xmlFile
	 * @return
	 * @throws Exception
	 */
	public static Document readXML(File xmlFile) throws Exception{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(xmlFile);
		return doc;
	}
	
	/**
	 * 将recrod解析为Json
	 * @param rec
	 * @return
	 */
	public static JSONObject RecrodToJson(Record rec) {
		// TODO Auto-generated method stub
		if(rec == null) {
			return null;
		}
		JSONObject json = new JSONObject();
		json.putAll(rec.getColumns());
		return json;
	}
}
