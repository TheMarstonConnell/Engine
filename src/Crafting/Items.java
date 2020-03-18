package Crafting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import javax.swing.Timer;
import roguelike_game.entity.EntityBase;
import roguelike_game.entity.player.PlayerBase;
import xyz.marstonconnell.engine.Engine;
import xyz.marstonconnell.engine.render.Camera;
import xyz.marstonconnell.engine.render.Sprite;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException; 

public class Items {
	{
	try {
		HashMap<String,Integer> allItems = new HashMap<String,Integer>();
		File itemsList = new File("items.txt");
		Scanner readFile = new Scanner(itemsList);
	} 	
	catch (FileNotFoundException fe){
		fe.printStackTrace();
	}
	/*FileReader fr = new FileReader("/Engine/assets/items.txt");
	BufferedReader br = new BufferedReader(fr);
    StringBuilder sb = new StringBuilder();
*/}
}
