package org.osmdroid.tileprovider.tilesource;

import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.util.ManifestUtil;

import android.content.Context;

/**
 * MapBox tile source, revised in 5.1 to not use static map ids or tokens
 * @author Brad Leege <bleege@gmail.com>
 * Created on 10/15/13 at 7:57 PM
 */
public class MapBoxTileSource extends OnlineTileSourceBase
{
    /** the meta data key in the manifest */
    //<meta-data android:name="MAPBOX_MAPID" android:value="YOUR KEY" />

    private static final String MAPBOX_MAPID = "MAPBOX_MAPID";
    //<meta-data android:name="ACCESS_TOKEN" android:value="YOUR TOKEN" />
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";

	private static final String[] mapBoxBaseUrl = new String[]{
			"http://api.tiles.mapbox.com/v4/"};

	private String mapBoxMapId = "";
     private String accessToken;

	/**
     * Creates a MapBox TileSource. You won't be able to use it until you set the access token and map id.
     * 
     */
    public MapBoxTileSource()
    {
		super("mapbox", 1, 18, 256, ".png", mapBoxBaseUrl);
    }
    
    /**
     * creates a new mapbox tile source, loading the access token and mapid from the manifest
     * @param ctx
     * @since 5.1
     */
    public MapBoxTileSource(final Context ctx)
    {
		super("mapbox", 1, 18, 256, ".png", mapBoxBaseUrl);
          retrieveAccessToken(ctx);
          retrieveMapBoxMapId(ctx);
    }
    
    /**
     * creates a new mapbox tile source, using the specified access token and mapbox id
     * @param mapboxid
     * @param accesstoken 
     * @since 5.1
     */
    public MapBoxTileSource(final String mapboxid, final String accesstoken)
    {
		super("mapbox", 1, 18, 256, ".png", mapBoxBaseUrl);
          this.accessToken=accesstoken;
          this.mapBoxMapId=mapboxid;
    }

    /**
     * TileSource allowing majority of options (sans url) to be user selected.
     * <br> <b>Warning, the static method {@link #retrieveMapBoxMapId(android.content.Context)} should have been invoked once before constructor invocation</b>
	 * @param name Name
	 * @param zoomMinLevel Minimum Zoom Level
	 * @param zoomMaxLevel Maximum Zoom Level
	 * @param tileSizePixels Size of Tile Pixels
	 * @param imageFilenameEnding Image File Extension
	 */
    public MapBoxTileSource(String name, int zoomMinLevel, int zoomMaxLevel, int tileSizePixels, String imageFilenameEnding)
    {
		super(name, zoomMinLevel, zoomMaxLevel, tileSizePixels, imageFilenameEnding, mapBoxBaseUrl);
    }

    /**
     * TileSource allowing all options to be user selected.
     * <br> <b>Warning, the static method {@link #retrieveMapBoxMapId(android.content.Context)} should have been invoked once before constructor invocation</b>
     * @param name Name
     * @param zoomMinLevel Minimum Zoom Level
     * @param zoomMaxLevel Maximum Zoom Level
     * @param tileSizePixels Size of Tile Pixels
     * @param imageFilenameEnding Image File Extension
     * @param mapBoxVersionBaseUrl MapBox Version Base Url @see https://www.mapbox.com/developers/api/#Versions
     */
    public MapBoxTileSource(String name, int zoomMinLevel, int zoomMaxLevel, int tileSizePixels, String imageFilenameEnding, String mapBoxMapId, String mapBoxVersionBaseUrl)
    {
		super(name, zoomMinLevel, zoomMaxLevel, tileSizePixels, imageFilenameEnding,
				new String[] { mapBoxVersionBaseUrl });
    }

    /**
     * Reads the mapbox map id from the manifest.<br>
     */
    public final void retrieveMapBoxMapId(final Context aContext)
    {
        // Retrieve the MapId from the Manifest
        mapBoxMapId = ManifestUtil.retrieveKey(aContext, MAPBOX_MAPID);
    }
    
    /**
     * Reads the access token from the manifest.
     */
    public final void retrieveAccessToken(final Context aContext)
    {
        // Retrieve the MapId from the Manifest
        accessToken = ManifestUtil.retrieveKey(aContext, ACCESS_TOKEN);
    }

    public void setMapboxMapid(String key){
        mapBoxMapId=key;
    }

    public String getMapBoxMapId()
    {
        return mapBoxMapId;
    }

    @Override
    public String getTileURLString(final MapTile aMapTile)
    {
        StringBuilder url = new StringBuilder(getBaseUrl());
        url.append(getMapBoxMapId());
        url.append("/");
        url.append(aMapTile.getZoomLevel());
        url.append("/");
        url.append(aMapTile.getX());
        url.append("/");
        url.append(aMapTile.getY());
        url.append(".png");
        url.append("?access_token=").append(getAccessToken());
        String res = url.toString();

        return res;
    }
    
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessTokeninput) {
        accessToken = accessTokeninput;
    }
}