package io.github.nixtabyte.telegram.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class ChosenInlineResult {
	
	@JsonProperty("result_id")
	 private String result_id;
	 
	@JsonProperty("from")
     private User from;
	
	@JsonProperty("query")
     private String query;

	public String getResult_id() {
		return result_id;
	}

	public void setResult_id(String result_id) {
		this.result_id = result_id;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        ChosenInlineResult that = (ChosenInlineResult) o;

	        if (result_id != null ? !result_id.equals(that.result_id) : that.result_id != null) return false;
	        if (from != null ? !from.equals(that.from) : that.from != null) return false;
	        return query != null ? query.equals(that.query) : that.query == null;

	    }

	    @Override
	    public int hashCode() {
	        return result_id != null ? result_id.hashCode() : 0;
	    }

	    @Override
	    public String toString() {
	        return "ChosenInlineResult{" +
	                "result_id='" + result_id + '\'' +
	                ", from=" + from +
	                ", query='" + query + '\'' +
	                '}';
	    }

}
