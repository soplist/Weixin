package com.shengxin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.shengxin.po.News;
import com.shengxin.po.NewsMessage;
import com.shengxin.po.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
    	Map<String,String> map = new HashMap<String,String>();
    	SAXReader reader = new SAXReader();
    	
    	InputStream ins = request.getInputStream();
	    Document doc = reader.read(ins);
			
		Element root = doc.getRootElement();
			
		List<Element> list = root.elements();
			
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
    	
    }
    
    public static String textMessageToXml(TextMessage textMessage){
    	XStream xstream = new XStream();
    	xstream.alias("xml", textMessage.getClass());
    	return xstream.toXML(textMessage);
    }
    
    public static String initText(String toUserName,String fromUserName,String content){
    	TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(""+new Date().getTime());
		//text.setContent("the message you send is:"+content);
		text.setContent(content);
		return textMessageToXml(text);
    }
    
    public static String menuText(){
    	StringBuffer sb = new StringBuffer();
    	sb.append("welcome,please operate follow prompt:\n\n");
    	sb.append("1.course introduction\n");
    	sb.append("2.other introduction\n\n");
    	sb.append("reply '?' call this menu");
    	return sb.toString();
    }
    
    public static String firstText(){
    	StringBuffer sb = new StringBuffer();
    	sb.append("first");
    	return sb.toString();
    }
    
    public static String secondText(){
    	StringBuffer sb = new StringBuffer();
    	sb.append("second");
    	return sb.toString();
    }
    
    public static String newsMessageToXml(NewsMessage newsMessage){
    	XStream xstream = new XStream();
    	xstream.alias("xml", newsMessage.getClass());
    	xstream.alias("item", new News().getClass());
    	return xstream.toXML(newsMessage);
    }
    
    public static String initNewsMessage(String toUserName,String fromUserName){
    	String message = null;
    	List<News> newsList = new ArrayList<News>();
    	NewsMessage newsMessage = new NewsMessage();
    	
    	News news = new News();
    	news.setTitle("title_1");
    	news.setDescription("description_1");
    	news.setPicUrl("http://mytest.tunnel.echomod.cn/Weixin/image/1.png");
    	news.setUrl("www.baidu.com");
    	
    	newsList.add(news);
    	
    	newsMessage.setFromUserName(toUserName);
    	newsMessage.setToUserName(fromUserName);
    	newsMessage.setCreateTime(""+new Date().getTime());
    	newsMessage.setMsgType(MESSAGE_NEWS);
    	newsMessage.setArticles(newsList);
    	newsMessage.setArticleCount(newsList.size());
    	
    	message = newsMessageToXml(newsMessage);
    	return message;
    }
}
