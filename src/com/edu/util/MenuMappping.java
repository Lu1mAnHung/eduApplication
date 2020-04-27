package com.edu.util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.jfinal.kit.PathKit;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

/**
 * 角色权限处理
 * @author 咸鱼OvO
 *
 */
public class MenuMappping {

	/**
	 * 通过系统权限读取相对应的xml来获得对应menu
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public static   Document readMenu(int role) throws Exception{
		String xml = "";
		if(role==1) {
			 xml= "adminmenu.xml";
		}if(role==2) {
			 xml = "studentmenu.xml";
		}if(role==3) {
			xml = "teachermenu.xml";
		}
		String menuFileStr= PathKit.getWebRootPath()+"/WEB-INF/"+xml;
		File menuFile = new File(menuFileStr);
		Document menuDoc = JwUtil.readXML(menuFile);
		return menuDoc;
	}
	
	/**
	 * 根据角色权限返回不同的系统菜单
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public static  JSONArray readMenuToJSON(int role) throws Exception{
		JSONArray menuArray = new JSONArray();
		Document menuDoc = readMenu(role);
		Element rootEle = menuDoc.getRootElement();
		List<Element> menuList = rootEle.elements();
		for(Element menuEle : menuList) {
			JSONObject menuJson = new JSONObject();
			menuJson.put("id", menuEle.attributeValue("id"));
			menuJson.put("name", menuEle.attributeValue("name"));
			menuJson.put("icon", menuEle.attributeValue("icon"));
			JSONArray subArray = new JSONArray();
			List<Element> subMenuList = menuEle.elements();
			for(Element subMenuEle : subMenuList) {
				JSONObject subMenuJson = new JSONObject();
				subMenuJson.put("id", subMenuEle.attributeValue("id"));
				subMenuJson.put("name", subMenuEle.attributeValue("name"));
				subMenuJson.put("icon", subMenuEle.attributeValue("icon"));
				subArray.add(subMenuJson);
			}
			menuJson.put("subMenus", subArray);
			menuArray.add(menuJson);
		}
		return menuArray;
	}

	

}
