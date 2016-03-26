package io.github.nixtabyte.telegram.jtelebot.server;

public abstract interface CommandQueue
{
  public abstract void add(Command paramCommand);
  
  public abstract Command poll();
  
  public abstract int size();
  
  public abstract boolean isEmpty();
  
  public abstract boolean contains(Command paramCommand);
}