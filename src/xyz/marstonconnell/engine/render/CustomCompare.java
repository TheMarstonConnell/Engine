package xyz.marstonconnell.engine.render;

import java.util.Comparator;

public class CustomCompare implements Comparator<Sprite> {
    
	@Override
    public int compare(Sprite o1, Sprite o2) {
		return ((Integer)(o1.getLayer())).compareTo(o2.getLayer());
    }
}