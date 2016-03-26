package com.telegram.handler;

import java.util.ArrayList;

import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
import io.github.nixtabyte.telegram.jtelebot.request.TelegramRequest;
import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.response.json.ReplyKeyboardMarkup;

public class ForwardRequestFactory {
	
//	public static TelegramRequest getSend(Message  msg)
//	{
//		//String target="@greenarrowapi";
//		//msg.getChat().getId()
//		
//		String target=String.valueOf(msg.getChat().getId());
//		
//		String txt=msg.getText();
//		
//		if (txt.equals("/start"))
//		{
//		   	ArrayList<String[]> al=new ArrayList<>();
//			 al.add(new String[]{"ساندویچ","پیتزا"});
//			 al.add(new String[]{"مرغ","نوشیدنی"});
//			 
//			 ReplyKeyboardMarkup rkm=new  ReplyKeyboardMarkup();
//			 rkm.setKeyboard(al);
//			 rkm.setOneTimeKeyboard(false);
//			 rkm.setResizeKeyboard(true);
//			 rkm.setSelective(true);
//			 
//			 try
//			 {
//				 return TelegramRequestFactory.
//						 createSendMessageRequest(target, "لیست غذاهای گرین اررو", true, msg.getId(), rkm);
//			
//			 }
//			catch (JsonParsingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//				 
//		}
//		
//		if (txt.equalsIgnoreCase("پیتزا"))
//		{
//			
//			ArrayList<String[]> al=new ArrayList<>();
//			 al.add(new String[]{"سیرواستیک","پپرونی","سبزیجات","گوشت"});
//					 
//			 ReplyKeyboardMarkup rkm=new  ReplyKeyboardMarkup();
//			 rkm.setKeyboard(al);
//			 rkm.setOneTimeKeyboard(false);
//			 rkm.setResizeKeyboard(true);
//			 rkm.setSelective(true);
//			 
//			 try
//			 {
//				// return TelegramRequestFactory.
//				//		 createSendMessageRequest(target, "لیست پیتزا های موجود در گرین اررو", true, msg.getId(), rkm);
//			
//			 }
//			catch (JsonParsingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//				 
//		 return null;
//		
//	}
	
	private void getMarkupKeyboardText(String txt)
	{
		
		
	}

}
