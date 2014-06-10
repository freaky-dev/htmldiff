package main;

import java.util.List;

import org.jsoup.nodes.Node;

public class Diff {

	
//	private Node root = new Document("");	
//	private Tree<Node> tree = new Tree<Node>(root);
	
	public void diff(Node n1, Node n2, Tree<NodeWraper> tree){
		if(equals(n1, n2)){
			return;
		}
		//Tree<Node> leaf = tree.addLeaf(n1);

		printNode(n1);
		
		List<Node> childNodes1 = n1.childNodes();
		List<Node> childNodes2 = n2.childNodes();
		
		int size1 = childNodes1.size();
		int size2 = childNodes2.size();
		
		if(size1 == size2){
			for(int i=0;i<size1;i++){
				if(!equals(childNodes1.get(i), childNodes2.get(i))){
					Tree<NodeWraper> leaf;
					if(equalAttributes(childNodes1.get(i), childNodes2.get(i))){
						leaf = tree.addLeaf(new NodeWraper(childNodes1.get(i), i, ""));
					} else {
						leaf = tree.addLeaf(new NodeWraper(childNodes1.get(i), i, "attributes"));
					}
					diff(childNodes1.get(i), childNodes2.get(i), leaf);
				}
				
			}
		} else if(size1 > size2){
			int nodesDiff = size1 - size2;
			int offset = 0;
			for(int i=0;i<size1;i++){
				if(!equals(childNodes1.get(i), childNodes2.get(i-offset))){
					tree.addLeaf(new NodeWraper(childNodes1.get(i), i, "deleted"));
					offset++;
				}
			}
		} else {
			int nodesDiff = size2 - size1;
			int offset = 0;
			for(int i=0;i<size1;i++){
				if(!equals(childNodes1.get(i), childNodes2.get(i+offset))){
					tree.addLeaf(new NodeWraper(childNodes2.get(i), i, "added"));
					offset++;
				}
			}
		}
		
		
	}
	
	private boolean equalAttributes(Node n1, Node n2){
		return n1.attributes().toString().equals(n2.attributes().toString());
	}
	
	private boolean equals(Node n1, Node n2){
		return n1.toString().equals(n2.toString());
	}
	
	private void printNode(Node n){
		System.out.println(n.nodeName() + " " + n.toString().substring(0, Math.min(7, n.toString().length())));
	}
	
}
