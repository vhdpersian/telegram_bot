package io.github.nixtabyte.telegram.jtelebot.server.impl;

/*    */ import io.github.nixtabyte.telegram.jtelebot.server.Command;
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
/*    */ public class DefaultCommandTask
/*    */   extends AbstractCommandTask
/*    */ {
/* 17 */   private static final Logger LOG = Logger.getLogger(DefaultCommandTask.class);
/*    */   
/*    */   public DefaultCommandTask(Command command)
/*    */   {
/* 21 */     super(command);
/*    */   }
/*    */   
/*    */   public DefaultCommandTask(Command command, long delayInMillis) {
/* 25 */     super(command, delayInMillis);
/*    */   }
/*    */   
/*    */   public void processCommand()
/*    */   {
/*    */     try {
/* 31 */       LOG.trace("\tSTART processing command {" + command + "}");
/* 32 */       Thread.sleep(delay);
/* 33 */       command.execute();
/* 34 */       LOG.trace("\tEND processing command {" + command + "}");
/*    */     } catch (InterruptedException e) {
/* 36 */       LOG.error(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public void notifyObserver()
/*    */   {
/* 42 */     setChanged();
/* 43 */     notifyObservers();
/*    */   }
/*    */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandTask
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */