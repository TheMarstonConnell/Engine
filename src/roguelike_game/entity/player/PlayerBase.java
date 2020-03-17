package roguelike_game.entity.player;

import roguelike_game.entity.EntityBase;
import xyz.marstonconnell.engine.asset_manager.AssetManager;

public class PlayerBase extends EntityBase{

	String path = "entity/characters/";
	public PlayerBase(String name, int x, int y, int width, int height, AssetManager assetMan, int layer) {
		super(name, x, y, width, height, assetMan, layer);
	}
	
	@Override
	protected String getPath() {
		return "entity/characters/";
	}

}
