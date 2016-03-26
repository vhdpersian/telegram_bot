/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * This object represents an incoming update.
 *
 * @since 0.0.1
 */
public class Update {
	/**
	 * The update?????????s unique identifier. Update identifiers start from a certain
	 * positive number and increase sequentially. This ID becomes especially
	 * handy if you?????????re using Webhooks, since it allows you to ignore repeated
	 * updates or to restore the correct update sequence, should they get out of
	 * order.
	 */
	@JsonProperty("update_id")
	private String updateId;
	/**
	 * Optional. New incoming message of any kind ????????? text, photo, sticker, etc.
	 */
	@JsonProperty("message")
	private Message message;
	
	@JsonProperty("inline_query")
	private InlineQuery inline_query;
	
	@JsonProperty("chosen_inline_result")
	private ChosenInlineResult chosen_inline_result;

	public InlineQuery getInline_query() {
		return inline_query;
	}

	public void setInline_query(InlineQuery inline_query) {
		this.inline_query = inline_query;
	}

	public ChosenInlineResult getChosen_inline_result() {
		return chosen_inline_result;
	}

	public void setChosen_inline_result(ChosenInlineResult chosen_inline_result) {
		this.chosen_inline_result = chosen_inline_result;
	}

	/**
	 * <p>Getter for the field <code>updateId</code>.</p>
	 *
	 * @return a {@link java.lang.Long} object.
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * <p>Setter for the field <code>updateId</code>.</p>
	 *
	 * @param updateId a {@link java.lang.Long} object.
	 */
	public void setUpdateId(final String updateId) {
		this.updateId = updateId;
	}

	/**
	 * <p>Getter for the field <code>message</code>.</p>
	 *
	 * @return a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Message} object.
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * <p>Setter for the field <code>message</code>.</p>
	 *
	 * @param message a {@link io.github.nixtabyte.telegram.jtelebot.response.json.Message} object.
	 */
	public void setMessage(final Message message) {
		this.message = message;
	}

	/** {@inheritDoc} */
	  @Override
	    public int hashCode() {
	        return updateId.hashCode();
	    }
	  

	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Update update = (Update) o;

	        if (updateId != null ? !updateId.equals(update.updateId) : update.updateId != null) return false;
	        if (message != null ? !message.equals(update.message) : update.message != null) return false;
	        if (inline_query != null ? !inline_query.equals(update.inline_query) : update.inline_query != null)
	            return false;
	        return chosen_inline_result != null ? chosen_inline_result.equals(update.chosen_inline_result) : update.chosen_inline_result == null;
	    }

	/** {@inheritDoc} */
	@Override
    public String toString() {
        return "Update{" +
                "update_id=" + updateId +
                ", message=" + message +
                ", inline_query=" + inline_query +
                ", chosen_inline_result=" + chosen_inline_result +
                '}';
    }

}
