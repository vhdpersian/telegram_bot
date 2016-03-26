package io.github.nixtabyte.telegram.jtelebot.response.json;

public enum ParseMode {

	Markdown, HTML;
	
	public  static String getValue(ParseMode val)
	{
		switch	(val)
		{
		case Markdown:
			return "Markdown";
		case HTML:
			return "HTML";
		default:
			return "HTML";
		}		
	}
}
