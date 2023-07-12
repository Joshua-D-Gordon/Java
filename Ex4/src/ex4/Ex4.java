package ex4;
import java.awt.Color;


import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	
	private Shape_Collection _gsc;
	private String f;
	private Shape_Comp flg;
	
	public Ex4() {
		this._gsc = new Shape_Collection();
		_gsc.load(f);
		_gsc.sort(flg);
	
	}
	
	
	@Override
	public void init(GUI_Shape_Collection g) {
		
		_gsc = (Shape_Collection) g;
	}
	
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		
		return _gsc;
	}

	@Override
	public void show() {
		double min =-10, max=10;
		StdDraw.setScale(min,max);
		StdDraw.clear();
		
		for(int i = 0; i< _gsc.size(); i++){
			StdDraw.show();
		}
	}

	@Override
	public String getInfo() {
		return _gsc.toString();
	}
}