package io.github.nixtabyte.telegram.jtelebot.server;

public abstract interface Service
{
  public abstract void startUp();
  
  public abstract void shutdown();
  
  public abstract boolean isAlive();
}