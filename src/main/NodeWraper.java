package main;

import org.jsoup.nodes.Node;

public class NodeWraper {

	private Node node;
	private int sequenceNumber;
	private String type;
	
	public NodeWraper(Node node, int sequenceNumber, String type) {
		this.node = node;
		this.sequenceNumber = sequenceNumber;
		this.type = type;
	}

	public Node getNode() {
		return node;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public String getType() {
		return type;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(sequenceNumber);
		builder.append(" ");
		builder.append(node.toString().substring(0, Math.min(7, node.toString().length())));
		builder.append(" ");
		builder.append(type);
		return builder.toString();
	}
	
	
	
}
