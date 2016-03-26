package io.github.nixtabyte.telegram.jtelebot.server.impl;

import io.github.nixtabyte.telegram.jtelebot.server.Command;
/*     */ import io.github.nixtabyte.telegram.jtelebot.server.CommandDispatcher;
/*     */ import io.github.nixtabyte.telegram.jtelebot.server.CommandQueue;
/*     */ import io.github.nixtabyte.telegram.jtelebot.server.Service;
/*     */ import java.util.Observable;
/*     */ import java.util.Observer;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractCommandDispatcher
/*     */   implements CommandDispatcher, Observer, Service, Runnable
/*     */ {
/*  44 */   private static final Logger LOG = Logger.getLogger(AbstractCommandDispatcher.class);
/*     */   
/*     */   protected ExecutorService executor;
/*     */   
/*     */   protected CommandQueue commandQueue;
/*     */   
/*     */   protected boolean alive;
/*     */   protected int threadPoolSize;
/*     */   protected long delay;
/*     */   private Thread thread;
/*     */   
/*     */   public AbstractCommandDispatcher()
/*     */   {
/*  57 */     this(5, 1000L, new DefaultCommandQueue());
/*     */   }
/*     */   
/*     */   public AbstractCommandDispatcher(int threadPoolSize, long delay, CommandQueue commandQueue)
/*     */   {
/*  62 */     this.threadPoolSize = threadPoolSize;
/*  63 */     this.delay = delay;
/*  64 */     this.commandQueue = commandQueue;
/*     */   }
/*     */   
/*     */   public void startUp()
/*     */   {
/*  69 */     LOG.info("*************************************");
/*  70 */     LOG.info("** Starting up command dispatcher...");
/*  71 */     LOG.info("*************************************");
/*  72 */     alive = true;
/*  73 */     executor = Executors.newFixedThreadPool(threadPoolSize);
/*     */     
/*  75 */     thread = new Thread(this);
/*  76 */     thread.start();
/*     */   }
/*     */   
/*     */   public void shutdown()
/*     */   {
/*  81 */     LOG.info("***************************************");
/*  82 */     LOG.info("** Shutting down command dispatcher...");
/*  83 */     LOG.info("***************************************");
/*  84 */     alive = false;
/*  85 */     executor.shutdown();
/*     */   }
/*     */   
/*     */   public boolean isAlive()
/*     */   {
/*  90 */     LOG.debug("Command dispatcher " + (alive ? "is" : "is not") + " alive...");
/*     */     
/*  92 */     return alive;
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*  97 */     while (alive) {
/*     */       try {
/*  99 */         Thread.sleep(delay);
/*     */       } catch (InterruptedException e) {
/* 101 */         LOG.error(e);
/*     */       }
/*     */       try {
/* 104 */         dispatchCommands();
/*     */       }
/*     */       catch (Exception e) {
/* 107 */         LOG.error(e);
/*     */       }
/*     */     }
/*     */     
/* 111 */     thread = null;
/*     */   }
/*     */   
/*     */   public void enqueueCommand(Command command)
/*     */   {
/* 116 */     commandQueue.add(command);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public abstract void dispatchCommands();
/*     */   
/*     */ 
/*     */ 
/*     */   public abstract void update(Observable paramObservable, Object paramObject);
/*     */   
/*     */ 
/*     */   public CommandQueue getCommandQueue()
/*     */   {
/* 130 */     return commandQueue;
/*     */   }
/*     */   
/*     */   public void setCommandQueue(CommandQueue commandQueue) {
/* 134 */     this.commandQueue = commandQueue;
/*     */   }
/*     */   
/*     */   public int getThreadPoolSize() {
/* 138 */     return threadPoolSize;
/*     */   }
/*     */   
/*     */   public void setThreadPoolSize(int threadPoolSize) {
/* 142 */     this.threadPoolSize = threadPoolSize;
/*     */   }
/*     */   
/*     */   public long getDelay() {
/* 146 */     return delay;
/*     */   }
/*     */   
/*     */   public void setDelay(long delay) {
/* 150 */     this.delay = delay;
/*     */   }
/*     */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
* Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommandDispatcher
* Java Class Version: 7 (51.0)
* JD-Core Version:    0.7.1
*/