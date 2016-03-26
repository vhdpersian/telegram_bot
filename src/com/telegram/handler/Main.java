package com.telegram.handler;


import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandDispatcher;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandQueue;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandWatcher;

public class Main {

	public static void main(String[] args) {
 	
		 DefaultCommandDispatcher commandDispatcher = new DefaultCommandDispatcher(10,100, new DefaultCommandQueue());
	        commandDispatcher.startUp();
	         
	        DefaultCommandWatcher commandWatcher = new DefaultCommandWatcher(2000,100,"200890445:AAFMKVNg9hwkSvvj8dtkDK3uHDFaLNwL5ck",commandDispatcher,new ResponseCommandFactory());
	        commandWatcher.startUp();

	}

	

}
