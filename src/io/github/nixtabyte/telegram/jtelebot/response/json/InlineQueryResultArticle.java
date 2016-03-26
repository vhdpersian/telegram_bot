package io.github.nixtabyte.telegram.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class InlineQueryResultArticle  extends InlineQueryResult

{

	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("id")
    private String id;
	
	@JsonProperty("title")
    private String title;
	
	@JsonProperty("message_text")
    private String message_text;
	
	@JsonProperty("parse_mode")
    private ParseMode parse_mode;
	
	@JsonProperty("disable_web_page_preview")
    private Boolean disable_web_page_preview;
	
	@JsonProperty("url")
    private String url="";
	
	@JsonProperty("hide_url")
    private Boolean hide_url=true;
	
	@JsonProperty("tdescriptionype")
    private String description="";
	
	@JsonProperty("thumb_url")
    private String thumb_url="";
	
	@JsonProperty("thumb_width")
    private Integer thumb_width=0;
	
	@JsonProperty("thumb_height")
    private Integer thumb_height=0;

    public InlineQueryResultArticle(String id, String title, String messageText) {
        this.type = "article";
        this.id = id;
        this.title = title;
        this.message_text = messageText;
    }

    public InlineQueryResultArticle parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode;
        return this;
    }

    public InlineQueryResultArticle disableWebPagePreview(Boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }

    public InlineQueryResultArticle url(String url) {
        this.url = url;
        return this;
    }

    public InlineQueryResultArticle hideUrl(Boolean hideUrl) {
        this.hide_url = hideUrl;
        return this;
    }

    public InlineQueryResultArticle description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultArticle thumbUrl(String thumbUrl) {
        this.thumb_url = thumbUrl;
        return this;
    }

    public InlineQueryResultArticle thumbWidth(Integer thumbWidth) {
        this.thumb_width = thumbWidth;
        return this;
    }

    public InlineQueryResultArticle thumbHeight(Integer thumbHeight) {
        this.thumb_height = thumbHeight;
        return this;
    }
}
