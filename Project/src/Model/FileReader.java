package Model;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.PopupMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {
	    ArrayList<String> FirstLine = new ArrayList<>();
	    ArrayList<String> SecondLine = new ArrayList<>();
	    ArrayList<String> products = new ArrayList<>();
	    DefaultMutableTreeNode node_1;
	    JTree tree = new JTree();

	    public FileReader() {

	    }

	    public void getResource() {
	        try {
	            File file = new File("D:\\Програми\\Java\\OOP Java\\задачи\\Project\\src\\Categories.file");
	            Scanner reader = new Scanner(file);
	            while (reader.hasNextLine()) {
	                String data = reader.nextLine();
	                if (data.contains("</")) {
	                	
	                    data = data.replace("</", "");
	                    
	                    data = data.replace(">", "");
	                    FirstLine.add(data);
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }

	    }
	    public void JTree() throws FileNotFoundException {
	    	
	        File file = new File("D:\\Програми\\\\Java\\\\OOP Java\\\\задачи\\\\Project\\\\src\\\\Categories.file");
	        Scanner reader = new Scanner(file);
	        
	        tree.setModel(new DefaultTreeModel(
	        		
	                new DefaultMutableTreeNode("JTree") {
	                    {
	                        int Categ = 0;
	                        String data;
	                        String previousLine = null;
	                        for (int i = 0; i < FirstLine.size(); i++) {
	                            node_1 = new DefaultMutableTreeNode(FirstLine.get(i));
	                            add(node_1);
	                            while (reader.hasNextLine()) {
	                                if (previousLine!=null){
	                                    data = previousLine;
	                                } else {
	                                    data = reader.nextLine();
	                                }
	                                if (data.contains("<" + FirstLine.get(i) + ">")){
	                                    data = reader.nextLine();
	                                    while(!data.contains("</" + FirstLine.get(i) + ">")){
	                                        if (data.contains("_")){
	                                            data = data.replace("_", "");
	                                            SecondLine.add(data);
	                                            node_1.add(new DefaultMutableTreeNode(SecondLine.get(Categ)));
	                                            add(node_1);
	                                            Categ++;
	                                        }
	                                        data = reader.nextLine();
	                                        previousLine = null;
	                                    }
	                                } else{
	                                    previousLine = data;
	                                    break;
	                                }
	                            }
	                            System.out.println(i);
	                        }

	                    }
	                }
	        ));
	        reader.close();
	    }


	    public void getProducts(Object selected) {
	        try {
	            products.clear();
	            File file = new File("D:\\Програми\\Java\\OOP Java\\задачи\\Project\\src\\Categories.file");
	            Scanner reader = new Scanner(file);
	            String cat = selected.toString().trim();
	            while (reader.hasNextLine()) {
	                String data = reader.nextLine();
	                if (data.contains("_" + cat)) {
	                    data = reader.nextLine();
	                    while (data.isEmpty()) {
	                        data = reader.nextLine();
	                    }
	                    while (data.contains("*")) {
	                        data.trim();
	                        data = data.replace("*", "");
	                        products.add(data);
	                        data = reader.nextLine();
	                    }
	                }
	            }

	        } catch (FileNotFoundException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    }

	    public void getList(){
	        System.out.println(FirstLine);
	    }

	    public void getProductList(){
	        for (int i = 0; i<products.size(); i++) {
	            System.out.println(products.get(i).trim());
	        }
	    }

	}