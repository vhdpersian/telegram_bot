package io.github.nixtabyte.telegram.jtelebot.server.impl;

/*    */ import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Builder;

/*    */ import io.github.nixtabyte.telegram.jtelebot.server.CommandQueue;

/*    */ import java.util.Observable;
/*    */ import java.util.concurrent.ConcurrentMap;
/*    */ import java.util.concurrent.ExecutorService;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultCommandDispatcher
/*    */   extends AbstractCommandDispatcher
/*    */ {
/*    */   private ConcurrentMap<String, DefaultCommandTask> taskList;
/* 44 */   private static final Logger LOG = Logger.getLogger(DefaultCommandDispatcher.class);
/*    */   
/*    */   public DefaultCommandDispatcher()
/*    */   {
/* 48 */     this(5, 1000L, new DefaultCommandQueue());
/*    */   }
/*    */   
/*    */   public DefaultCommandDispatcher(CommandQueue commandQueue) {
/* 52 */     this(5, 1000L, 1000L, commandQueue);
/*    */   }
/*    */   
/*    */   public DefaultCommandDispatcher(int threadPoolSize, long delay, CommandQueue commandQueue)
/*    */   {
/* 57 */     this(threadPoolSize, 1000L, delay, commandQueue);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public DefaultCommandDispatcher(int threadPoolSize, long taskListCapacity, long delay, CommandQueue commandQueue)
/*    */   {
/* 64 */     super(threadPoolSize, delay, commandQueue);
/* 65 */     taskList = new ConcurrentLinkedHashMap.Builder().maximumWeightedCapacity(taskListCapacity).build();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void dispatchCommands()
/*    */   {
/* 72 */     while (!commandQueue.isEmpty()) {
/* 73 */       LOG.trace("About to dispatch " + commandQueue.size() + " commands enqueued...");
/*    */       
/* 75 */       DefaultCommandTask task = new DefaultCommandTask(commandQueue.poll(), delay);
/*    */       
/* 77 */       task.addObserver(this);
/* 78 */       taskList.put(String.valueOf(task.getCommand().hashCode()), task);
/*    */       
/*    */ 
/* 81 */       executor.execute(task);
/*    */     }
/*    */   }
/*    */   
/*    */   public void update(Observable observableTask, Object arg)
/*    */   {
/* 87 */     DefaultCommandTask task = (DefaultCommandTask)observableTask;
/* 88 */     String observableKey = String.valueOf(task.getCommand().hashCode());
/*    */     
/* 90 */     if (taskList.containsKey(observableKey)) {
/* 91 */       taskList.remove(observableKey);
/* 92 */       LOG.debug("Pending tasks: " + taskList.size() + "...");
/*    */     } else {
/* 94 */       LOG.error("Could not find {Task:" + observableKey + "} in taskList");
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandDispatcher
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */