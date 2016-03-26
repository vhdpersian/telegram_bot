package io.github.nixtabyte.telegram.jtelebot.server;

public abstract interface CommandDispatcher
{
  public abstract void enqueueCommand(Command paramCommand);
  
  public abstract void dispatchCommands();
}