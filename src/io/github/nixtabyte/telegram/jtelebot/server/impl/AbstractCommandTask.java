package io.github.nixtabyte.telegram.jtelebot.server.impl;

import io.github.nixtabyte.telegram.jtelebot.server.Command;
/*    */ import io.github.nixtabyte.telegram.jtelebot.server.CommandTask;
/*    */ import java.util.Observable;
/*    */ import org.apache.log4j.Logger;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractCommandTask
/*    */   extends Observable
/*    */   implements CommandTask, Runnable
/*    */ {
/* 34 */   private static final Logger LOG = Logger.getLogger(AbstractCommandTask.class);
/*    */   
/*    */   protected Command command;
/*    */   protected long delay;
/*    */   
/*    */   public AbstractCommandTask(Command command)
/*    */   {
/* 41 */     this(command, 0L);
/*    */   }
/*    */   
/*    */   public AbstractCommandTask(Command command, long delayInMillis) {
/* 45 */     this.command = command;
/* 46 */     delay = delayInMillis;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 51 */     processCommand();
/* 52 */     notifyObserver();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public abstract void processCommand();
/*    */   
/*    */ 
/*    */   public abstract void notifyObserver();
/*    */   
/*    */ 
/*    */   public Command getCommand()
/*    */   {
/* 65 */     return command;
/*    */   }
/*    */   
/*    */   public void setCommand(Command command) {
/* 69 */     this.command = command;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 74 */     return "[" + command + ", delay: " + delay + " ms]";
/*    */   }
/*    */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommandTask
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */