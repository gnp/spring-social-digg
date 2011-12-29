package org.springframework.social.digg.api;

public class Topic {

	private final String name;
	private final String cleanName;
	
	public Topic(final String name, final String cleanName) {
		super();
		
		this.name = name;
		this.cleanName = cleanName;
	}
	
	public String getName() {
		return name;
	}
	public String getCleanName() {
		return cleanName;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("Topic:\n");
		sb.append("  name: " + name + "\n");
		sb.append("  cleanName: " + cleanName + "\n");
		
		return sb.toString();
	}
	
}
