package xyz.marstonconnell.engine.asset_manager;

import java.io.File;

public class Resource {
	
	File path;
	
	public Resource(AssetManager assetMan, String filePath) {
		path = new File(assetMan.assetPath + filePath);
	}
}
