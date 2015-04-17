package com.me.catquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Block {
	
	
	//splits the map texture into regions and sets blockTexture[0][1] as the placeable block's tile
	TextureRegion blockTexture = (TextureRegion.split((new 
				Texture(Gdx.files.internal("data/mylevel1_stage/mylevel1_stage/mylevel1_tiles.png"))), 32, 32))[0][2];
	StaticTiledMapTile blockTile = new StaticTiledMapTile(blockTexture);
	
	
	//method for preparing map by adding all placeable blocks to it
	public TiledMap prepareMap(TiledMap map, int maxPosX, int maxPosY){
		//gets layer 2 from map 
		TiledMapTileLayer layer2 = (TiledMapTileLayer) map.getLayers().get(2); 
		
		//creates cell for block
		TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
		cell.setTile(blockTile);
		
		//iterates across start/end y and start/end x
		//then sets cell object equal to cell located at x and y on map
		for (int y = 0; y <= maxPosY; y++)  
		{
			for (int x = 0; x <= maxPosX; x++)
			{
				//if cell isn't null, it adds the cell to the spot and clears the one off the overlay
				if (layer2.getCell(x,y) != null) 
				{
					placeBlocks(map, x,y);
					layer2.setCell(x, y, null);
					}
				}
			}
		return map;
	}
	
	public TiledMap placeBlocks(TiledMap map, int xCoord, int yCoord){
		//Obtains the layer from the TiledMap and sets blockTexture[0][1] as the block's tile
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
		
		//creates the cell to be added to the map, sets the cell as the block tile from above, then adds cell to map.
		TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
		cell.setTile(blockTile);
		layer.setCell(xCoord, yCoord, cell);
		
		return map;
	}

	public boolean placeableBlockCheck(TiledMap map, int xCoord, int yCoord, float playerx, float playery){
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
		TiledMapTileLayer.Cell cell = layer.getCell(xCoord, yCoord);
		if(cell != null && (Math.abs(playerx-xCoord)<2) && (Math.abs(playery-yCoord)<2)){
			TiledMapTile tile = cell.getTile();
			TextureRegion texture = tile.getTextureRegion();
			if(texture == blockTexture)
				return true;
			else
				return false;  
		}
		return false;
	}
	
	public TiledMap removeBlocks(TiledMap map, int xCoord, int yCoord){
		//Obtains the layer from the TiledMap and sets blockTexture[0][1] as the block's tile
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
		layer.setCell(xCoord, yCoord, null);
		return map;
	}
	
	//xy coordinates of current overlay block to compare against new ones in renderMouse to see if it 
	//changed since last time renderMouse was run
	int oldxcoord;
	int oldycoord;
	public TiledMap renderOverlayBlock(TiledMap map, int playerBlocks, float deltaTime, int xcoord, int ycoord)
	{	
		//loads the overlay layer of the map
		TiledMapTileLayer overlayLayer = (TiledMapTileLayer) map.getLayers().get(2);
		//creates the cell to be added to the map, sets the cell as the block tile from above, then adds cell to map.
		TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
		cell.setTile(blockTile);	
		
		if(canPlaceCheck(map, xcoord, ycoord) && playerBlocks> 0){		
			if(oldxcoord != xcoord || oldycoord != ycoord){
				overlayLayer.setCell(oldxcoord, oldycoord, null);
				overlayLayer.setCell(xcoord, ycoord, cell);
				oldxcoord=xcoord;
				oldycoord=ycoord;
			}
		}
		else{
			overlayLayer.setCell(oldxcoord, oldycoord, null);
			oldxcoord = 0;
			oldycoord = 0;
			
		}
		
		return map;
	}
	
	public boolean canPlaceCheck(TiledMap map, int xCoord, int yCoord){
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1); 
		TiledMapTileLayer.Cell cell = layer.getCell(xCoord, yCoord);
		if(cell == null)
			return true;
		else
			return false;
	}

}
