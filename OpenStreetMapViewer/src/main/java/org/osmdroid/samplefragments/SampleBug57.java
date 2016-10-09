package org.osmdroid.samplefragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.osmdroid.ExtraSamplesActivity;
import org.osmdroid.R;
import org.osmdroid.views.MapView;


/**
 * https://github.com/osmdroid/osmdroid/issues/57
 *
 * load the map, then navigate to a different fragment, then hit the back button
 * Created by alex on 7/5/16.
 */

public class SampleBug57 extends BaseSampleFragment implements View.OnClickListener {
    @Override
    public String getSampleTitle() {
        return "Recovery from backstack";
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.sample_cachemgr, container, false);

        mMapView = (MapView) root.findViewById(R.id.mapview);
        Button btn = (Button) root.findViewById(R.id.btnCache);
        btn.setOnClickListener(this);
        btn.setText("To Step 2");
        return root;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(org.osmdroid.R.id.samples_container, new SampleBug57Step2(), ExtraSamplesActivity.SAMPLES_FRAGMENT_TAG)
                .addToBackStack(null).commit();
    }
}
