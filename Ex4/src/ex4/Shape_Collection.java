package ex4;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
	Vector<GUI_Shape> v;
	
	public Shape_Collection() {
		v = new Vector<GUI_Shape>();
	}
	
	@Override
	public GUI_Shape get(int i) {
		return v.elementAt(i);
	}

	@Override
	public int size() {
		return v.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		GUI_Shape temp = v.elementAt(i);
		v.remove(i);
		return temp;
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		v.add(i, s);
	}
	@Override
	public void add(GUI_Shape s) {
		v.add(s);
	}
	@Override
	public GUI_Shape_Collection copy() {
		for(int i = 0; i<this.size(); i++) {
			GUI_Shape s = v.get(i).copy();
		}
	
		
		return null;
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		v.sort(comp);
	}

	@Override
	public void removeAll() {
		v.removeAllElements();
	}

	@Override
	public void save(String file_name) {
		try {
			FileWriter fw = new FileWriter(file_name);
			for(GUI_Shape shape:v) {
				fw.write(shape.toString()+"\n");
			}
			fw.close();
		}
		catch(Exception e){
			System.err.println("failed");
			e.printStackTrace();
		}
		 
	}

	@Override
	public void load(String file_name) {
		try {
			File myfile = new File(file_name);
			Scanner scan = new Scanner(myfile);
			
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				GUIShape sh = new GUIShape(data);
				this.add(sh);
			}
			scan.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Rect2D getBoundingBox() {
		return null;
	}
	@Override
	public String toString() {
		return null;
	}
}