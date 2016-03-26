package io.github.nixtabyte.telegram.jtelebot.server;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.response.json.Update;

public abstract interface CommandFactory
{
  public abstract Command createCommand(Update update, RequestHandler paramRequestHandler);
}