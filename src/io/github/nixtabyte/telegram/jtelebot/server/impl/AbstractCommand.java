package io.github.nixtabyte.telegram.jtelebot.server.impl;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
/*    */ import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.response.json.Update;
/*    */ import io.github.nixtabyte.telegram.jtelebot.server.Command;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractCommand
/*    */   implements Command
/*    */ {
/*    */   protected Update update;
/*    */   protected RequestHandler requestHandler;
/*    */   
/*    */   public AbstractCommand(Update message, RequestHandler requestHandler)
/*    */   {
/* 32 */     this.update = message;
/* 33 */     this.requestHandler = requestHandler;
/*    */   }
/*    */   
/*    */   public Update getUpdate() {
/* 37 */     return update;
/*    */   }
/*    */   
/*    */   public void setUpdate(Update update) {
/* 41 */     this.update = update;
/*    */   }
/*    */   
/*    */   public RequestHandler getRequestHandler() {
/* 45 */     return requestHandler;
/*    */   }
/*    */   
/*    */   public void setRequestHandler(RequestHandler requestHandler) {
/* 49 */     this.requestHandler = requestHandler;
/*    */   }
/*    */   
/*    */   public abstract void execute();
/*    */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommand
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */