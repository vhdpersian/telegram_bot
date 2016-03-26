/*     */ package io.github.nixtabyte.telegram.jtelebot.server.impl;
/*     */ 
/*     */ import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Builder;

/*     */ import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
/*     */ import io.github.nixtabyte.telegram.jtelebot.client.impl.DefaultRequestHandler;
/*     */ import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
/*     */ import io.github.nixtabyte.telegram.jtelebot.exception.TelegramServerException;
/*     */ import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
/*     */ import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
/*     */ import io.github.nixtabyte.telegram.jtelebot.response.json.TelegramResponse;
/*     */ import io.github.nixtabyte.telegram.jtelebot.response.json.Update;
/*     */ import io.github.nixtabyte.telegram.jtelebot.response.json.User;
/*     */ import io.github.nixtabyte.telegram.jtelebot.server.Command;
/*     */ import io.github.nixtabyte.telegram.jtelebot.server.CommandDispatcher;
/*     */ import io.github.nixtabyte.telegram.jtelebot.server.CommandFactory;

/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentMap;

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
/*     */ 
/*     */ 
/*     */ public class DefaultCommandWatcher
/*     */   extends AbstractCommandWatcher
/*     */ {
/*  53 */   private static final Logger LOG = Logger.getLogger(DefaultCommandWatcher.class);
/*     */   
/*     */   private static final long MAX_CACHE_CAPACITY = 1000L;
/*     */   
/*     */   private CommandDispatcher commandDispatcher;
/*     */   
/*     */   private CommandFactory commandFactory;
/*     */   
/*     */   private RequestHandler requestHandler;
/*     */   
/*     */   private long offset;
/*     */   
/*     */   private long limit;
/*     */   private long timeout;
/*     */   private ConcurrentMap<String, Update> cache;
/*     */   
/*     */   public DefaultCommandWatcher()
/*     */   {
/*  71 */     this(0L, 1000L, null, null, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public DefaultCommandWatcher(String telegramToken, CommandDispatcher commandDispatcher, CommandFactory commandFactory)
/*     */   {
/*  77 */     this(0L, 1000L, telegramToken, commandDispatcher, commandFactory);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DefaultCommandWatcher(long delayInMillis, long cacheCapacity, String telegramToken, CommandDispatcher commandDispatcher, CommandFactory commandFactory)
/*     */   {
/*  87 */     super(delayInMillis);
/*  88 */     this.commandDispatcher = commandDispatcher;
/*  89 */     this.commandFactory = commandFactory;
/*  90 */     requestHandler = new DefaultRequestHandler(telegramToken);
/*     */     
/*     */ 
/*     */ 
/*  94 */     offset = 0L;
/*  95 */     limit = 100L;
/*  96 */     timeout = 0L;
/*     */     
/*  98 */     cache = new ConcurrentLinkedHashMap.Builder().maximumWeightedCapacity(cacheCapacity).build();
/*     */   }
/*     */   
/*     */ 
/*     */   public void retrieveCommands()
/*     */   {
/* 104 */     LOG.debug("\tPolling Telegram updates (offset:" + offset + ", limit:" + limit + ", timeout=" + timeout + ")...");
/*     */     
/*     */     try
/*     */     {
/* 108 */       TelegramResponse<?> response = requestHandler.sendRequest(TelegramRequestFactory.createGetUpdatesRequest(Long.valueOf(offset), Long.valueOf(limit), Long.valueOf(timeout)));
/*     */       
/*     */ 
/* 111 */       if (response.isSuccessful().booleanValue()) {
/* 112 */         handleUpdates(response);
/*     */       }
/*     */       else {
/* 115 */         LOG.error("Telegram response was unsuccessful: [" + response.getErrorCode() + "] " + response.getDescription());
/*     */       }
/*     */     }
/*     */     catch (JsonParsingException e)
/*     */     {
/* 120 */       LOG.error("JSON parsing failed");
/* 121 */       LOG.error(e);
/*     */     } catch (TelegramServerException e) {
/* 123 */       LOG.error("Fail at retrieving response from telegram");
/* 124 */       LOG.error(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void handleUpdates(TelegramResponse<?> response)
/*     */   {
/* 131 */     int newUpdatesCounter = 0;
/*     */     
              
              //   System.out.println(response.getResult());
                 
             // if ((response.getResult().size()>0) && !response.getResult().get(0).equals(true))
            //   {

/* 133 */     for (Object updateObj : response.getResult()) {
/* 134 */       Update update = (Update)updateObj;
/*     */       
/* 136 */       
/*     */    // LOG.info("Watching... UpdateId:" + update.getUpdateId() + " - Query:" + update.getInline_query().getQuery());
/*     */       

              //   if (update.getMessage()!=null)
                // {
                	// LOG.info("Watching... UpdateId:" + update.getUpdateId() + " - MessageID:" + update.getMessage().getId() + " - " + update.getMessage().getFromUser().getId() + ":" + update.getMessage().getFromUser().getUsername());
                	 /*     */       
		/* 144 */       if (!cache.containsKey(update.getUpdateId().toString())) {
		/* 145 */         cache.put(update.getUpdateId().toString(), update);
		/* 146 */         newUpdatesCounter++;
		/*     */         
		/*     */         try
		/*     */         {
		/* 150 */          Command command = commandFactory.createCommand(update, requestHandler);
		/*     */     	              	
		/* 152 */           commandDispatcher.enqueueCommand(command);
		
		
		/*     */         }
		/*     */         catch (Exception e) {
		/* 155 */           LOG.error(e);
		/*     */         }
		/*     */         
		/* 158 */         offset = (Long.parseLong(update.getUpdateId()) + 1L);
		/*     */       }
               //  }
                /* else if (update.getInline_query()!=null)
                 {
                	
                	  LOG.info("Watching... UpdateId:" + update.getUpdateId() + " - Query:" + update.getInline_query().getQuery());
                	  
                	  if (!cache.containsKey(update.getUpdateId().toString())) {
                			 145          cache.put(update.getUpdateId().toString(), update);
                			 146          newUpdatesCounter++;
                			              
                			              try
                			              {
                			 150           Command command = commandFactory.createCommand(update, requestHandler);
                			                
                			 152            commandDispatcher.enqueueCommand(command);
                			              }
                			              catch (Exception e) {
                			 155            LOG.error(e);
                			              }
                			              
                			 158          offset = (update.getUpdateId().longValue() + 1L);
                			            }
                 
                 }*/
                 
/*     */    // }
/*     */     
/* 162 */     if ((LOG.isInfoEnabled()) && (response.getResult().size() > 0)) {
/* 163 */       LOG.info("\tFound " + response.getResult().size() + " updates, " + newUpdatesCounter + " new updates added - History cache size: " + cache.size());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 169 */       LOG.trace("\tFound " + response.getResult().size() + " updates, " + newUpdatesCounter + " new updates added - History cache size: " + cache.size());
/*     */     }
               }
              // }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CommandDispatcher getCommandDispatcher()
/*     */   {
/* 177 */     return commandDispatcher;
/*     */   }
/*     */   
/*     */   public void setCommandDispatcher(CommandDispatcher commandDispatcher) {
/* 181 */     this.commandDispatcher = commandDispatcher;
/*     */   }
/*     */   
/*     */   public RequestHandler getRequestHandler() {
/* 185 */     return requestHandler;
/*     */   }
/*     */   
/*     */   public void setRequestHandler(RequestHandler requestHandler) {
/* 189 */     this.requestHandler = requestHandler;
/*     */   }
/*     */   
/*     */   public long getOffset() {
/* 193 */     return offset;
/*     */   }
/*     */   
/*     */   public void setOffset(long offset) {
/* 197 */     this.offset = offset;
/*     */   }
/*     */   
/*     */   public long getLimit() {
/* 201 */     return limit;
/*     */   }
/*     */   
/*     */   public void setLimit(long limit) {
/* 205 */     this.limit = limit;
/*     */   }
/*     */   
/*     */   public long getTimeout() {
/* 209 */     return timeout;
/*     */   }
/*     */   
/*     */   public void setTimeout(long timeout) {
/* 213 */     this.timeout = timeout;
/*     */   }
/*     */ }

/* Location:           D:\eclipse luna\workspace\bot_lib\jtelebot-core-0.1.0(4).jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandWatcher
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */