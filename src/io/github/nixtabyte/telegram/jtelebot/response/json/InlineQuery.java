package io.github.nixtabyte.telegram.jtelebot.response.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class InlineQuery {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("from")
	private User from;
	
	@JsonProperty("query")
	private String query;
	
	@JsonProperty("offset")
	private String offset;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        InlineQuery that = (InlineQuery) o;

	        if (id != null ? !id.equals(that.id) : that.id != null) return false;
	        if (from != null ? !from.equals(that.from) : that.from != null) return false;
	        if (query != null ? !query.equals(that.query) : that.query != null) return false;
	        return offset != null ? offset.equals(that.offset) : that.offset == null;
	    }

	    @Override
	    public int hashCode() {
	        return id.hashCode();
	    }

	    @Override
	    public String toString() {
	        return "InlineQuery{" +
	                "id='" + id + '\'' +
	                ", from=" + from +
	                ", query='" + query + '\'' +
	                ", offset='" + offset + '\'' +
	                '}';
	    }
	    	

}
