package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class Main {

	private static final String fileName1 = "sample.html";
	private static final String fileName2 = "sample2.html";
	
	
	public static void main(String[] args) throws Exception {
		File file1 = new File(fileName1);
		File file2 = new File(fileName2);
		
		Document doc1 = Jsoup.parse(file1, "UTF-8");
		Document doc2 = Jsoup.parse(file2, "UTF-8");
		
		Tree<NodeWraper> tree = new Tree<NodeWraper>(new NodeWraper(doc1,0,"root"));
		
		Diff diff = new Diff();
		
		diff.diff(doc1, doc2, tree);
		
		System.out.println("----------");
		System.out.println(tree.toString());
		
		
		//System.out.println(doc1.childNode(0).childNode(2).childNode(1).childNode(0).);
		
	}

	

}
