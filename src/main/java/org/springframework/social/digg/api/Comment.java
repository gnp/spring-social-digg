package org.springframework.social.digg.api;

public class Comment {

	private final String id;
	
	private final String text;
	
	private final String parentId;
	
	private final int diggs;
	
	private final int buries;
	
	private final int dateCreated;

	public Comment(final String id, final String text, final String parentId, final int diggs, final int buries, final int dateCreated) {
		super();
		
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.diggs = diggs;
		this.buries = buries;
		this.dateCreated = dateCreated;
	}
	
	public int getBuries() {
		return buries;
	}

	public int getDateCreated() {
		return dateCreated;
	}

	public int getDiggs() {
		return diggs;
	}

	public String getId() {
		return id;
	}

	public String getParentId() {
		return parentId;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("Comment:\n");
		sb.append("  id: " + id + "\n");
		sb.append("  text: " + text + "\n");
		sb.append("  parentId: " + parentId + "\n");
		sb.append("  diggs: " + diggs + "\n");
		sb.append("  buries: " + buries + "\n");
		sb.append("  dateCreated: " + dateCreated + "\n");
		
		return sb.toString();
	}

}
