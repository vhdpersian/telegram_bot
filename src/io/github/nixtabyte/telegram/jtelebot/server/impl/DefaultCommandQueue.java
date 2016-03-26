package io.github.nixtabyte.telegram.jtelebot.server.impl;

/*    */ import io.github.nixtabyte.telegram.jtelebot.server.Command;
/*    */ import io.github.nixtabyte.telegram.jtelebot.server.CommandQueue;
/*    */ import java.util.Queue;
/*    */ import java.util.concurrent.ConcurrentLinkedQueue;
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
/*    */ public class DefaultCommandQueue
/*    */   implements CommandQueue
/*    */ {
/* 21 */   private static final Logger LOG = Logger.getLogger(DefaultCommandQueue.class);
/*    */   private Queue<Command> commandQueue;
/*    */   
/*    */   public DefaultCommandQueue()
/*    */   {
/* 26 */     commandQueue = new ConcurrentLinkedQueue();
/*    */   }
/*    */   
/*    */   public void add(Command command)
/*    */   {
/* 31 */     commandQueue.add(command);
/*    */   }
/*    */   
/*    */   public Command poll()
/*    */   {
/* 36 */     return (Command)commandQueue.poll();
/*    */   }
/*    */   
/*    */   public boolean isEmpty()
/*    */   {
/* 41 */     return commandQueue.isEmpty();
/*    */   }
/*    */   
/*    */   public int size()
/*    */   {
/* 46 */     return commandQueue.size();
/*    */   }
/*    */   
/*    */   public boolean contains(Command command)
/*    */   {
/* 51 */     return commandQueue.contains(command);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 56 */     return commandQueue.toString();
/*    */   }
/*    */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandQueue
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */