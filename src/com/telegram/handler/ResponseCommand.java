package com.telegram.handler;



import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
import io.github.nixtabyte.telegram.jtelebot.exception.TelegramServerException;
import io.github.nixtabyte.telegram.jtelebot.request.TelegramRequest;
import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import io.github.nixtabyte.telegram.jtelebot.response.json.Update;
import io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommand;

public class ResponseCommand extends AbstractCommand {
	
	 public ResponseCommand(Update update,  RequestHandler requestHandler) {
		 
	        super(update, requestHandler);
	           
	    }
	 
	@Override
	public void execute() {
		// TODO Auto-generated method stub

		 System.out.println(update.getMessage().getChat().getId());
		 System.out.println(update.getMessage().getId());
		 
		 try {
		TelegramRequest telegramRequest=TelegramRequestFactory
					 .createSendMessageRequest(update.getMessage().getChat().getId()
							 ,"”·«„ «“ »« "
							 , true
							 , update.getMessage().getId()
							 , null);
			
			//TelegramRequest telegramRequest=TelegramRequestFactory
			//		 .createSendMessageRequest("@vhdchannel"
			//				 ,"”·«„ «“ »« "
				//			 , false
					//		 , null
						//	 , null);
			requestHandler.sendRequest(telegramRequest);
			
						
		} catch (JsonParsingException | TelegramServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		           
	}

	

}
