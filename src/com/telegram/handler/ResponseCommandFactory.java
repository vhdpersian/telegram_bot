package com.telegram.handler;

import org.apache.log4j.Logger;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.response.json.Update;
import io.github.nixtabyte.telegram.jtelebot.server.Command;
import io.github.nixtabyte.telegram.jtelebot.server.CommandFactory;

public class ResponseCommandFactory implements CommandFactory {

	private static final Logger LOG = Logger.getLogger(ResponseCommandFactory.class);
    @Override
    public Command createCommand(Update update, RequestHandler requestHandler) {
      //  LOG.info("MESSAGE: "+message.getText());
        return new ResponseCommand(update,requestHandler);
    }
}
