/*    */ package io.github.nixtabyte.telegram.jtelebot.server.impl;
/*    */ 
/*    */ import io.github.nixtabyte.telegram.jtelebot.server.CommandWatcher;
/*    */ import io.github.nixtabyte.telegram.jtelebot.server.Service;
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
/*    */ public abstract class AbstractCommandWatcher
/*    */   implements CommandWatcher, Service, Runnable
/*    */ {
/* 32 */   private static final Logger LOG = Logger.getLogger(AbstractCommandWatcher.class);
/*    */   
/*    */   protected boolean alive;
/*    */   
/*    */   protected long delay;
/*    */   private Thread thread;
/*    */   
/*    */   public AbstractCommandWatcher()
/*    */   {
/* 41 */     this(0L);
/*    */   }
/*    */   
/*    */   public AbstractCommandWatcher(long delayInMillis) {
/* 45 */     delay = delayInMillis;
/*    */   }
/*    */   
/*    */   public void startUp()
/*    */   {
/* 50 */     LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
/* 51 */     LOG.info(">> Starting up command watcher...");
/* 52 */     LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
/* 53 */     alive = true;
/*    */     
/* 55 */     thread = new Thread(this);
/* 56 */     thread.start();
/*    */   }
/*    */   
/*    */   public void shutdown()
/*    */   {
/* 61 */     LOG.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
/* 62 */     LOG.info("<< Shutting down command watcher...");
/* 63 */     LOG.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
/* 64 */     alive = false;
/*    */   }
/*    */   
/*    */   public boolean isAlive()
/*    */   {
/* 69 */     LOG.debug("Command watcher " + (alive ? "is" : "is not") + " alive...");
/* 70 */     return alive;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 75 */     while (alive) {
/*    */       try {
/* 77 */         Thread.sleep(delay);
/*    */       } catch (InterruptedException e) {
/* 79 */         LOG.error(e);
/*    */       }
/* 81 */       retrieveCommands();
/*    */     }
/*    */     
/* 84 */     thread = null;
/*    */   }
/*    */   
/*    */   public abstract void retrieveCommands();
/*    */ }

/* Location:           D:\eclipse luna\workspace\bot_lib\jtelebot-core-0.1.0(4).jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommandWatcher
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */