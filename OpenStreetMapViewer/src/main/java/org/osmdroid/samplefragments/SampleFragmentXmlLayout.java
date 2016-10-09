package org.osmdroid.samplefragments;


import org.osmdroid.views.MapView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SampleFragmentXmlLayout extends BaseSampleFragment {

	// ===========================================================
	// Fields
	// ===========================================================

	public static final String TITLE = "MapView in XML layout";

	@Override
	public String getSampleTitle() {
		return TITLE;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(org.osmdroid.R.layout.activity_starter_mapview, null);
		mMapView = (MapView) v.findViewById(org.osmdroid.R.id.mapview);
		return v;
		// mResourceProxy = new ResourceProxyImpl(inflater.getContext().getApplicationContext());
		// mMapView = new MapView(inflater.getContext(), 256, mResourceProxy);
		// mMapView.setUseSafeCanvas(true);
		// return mMapView;
	}

}
