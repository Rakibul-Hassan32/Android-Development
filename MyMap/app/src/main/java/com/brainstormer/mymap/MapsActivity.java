package com.brainstormer.mymap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.brainstormer.mymap.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng char_syedpur = new LatLng(23.58308887776334, 90.50606919292359);
        mMap.addMarker(new MarkerOptions().position(char_syedpur).title("Marker in Char Syedpur"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(char_syedpur));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(char_syedpur));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(char_syedpur,16f));


        //circle

        mMap.addCircle(new CircleOptions()
                .center(char_syedpur)
                .radius(1000)
               // .fillColor(Color.BLUE)
                .strokeColor(Color.DKGRAY));

        //Polygon

     /*   mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(23.585016087053052, 90.50581170088832),
                        new LatLng(23.582695566268058, 90.51194859439609),
                        new LatLng(23.576205756447138, 90.51430893805293),
                        new LatLng(23.57537975763716, 90.50735665310006),
                        new LatLng(23.579431035370707, 90.50255013510794)).fillColor(Color.YELLOW).strokeColor(Color.GRAY));

        //overlay

        mMap.addGroundOverlay(new GroundOverlayOptions()
                .position(char_syedpur, 1000f,1000f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.thumb))
                .clickable(true));

*/

        //set Map type
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        //geocoder in click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Clicked here"));

                //geoCoder = location data

                Geocoder geocoder = new Geocoder(MapsActivity.this);
                try {
                    ArrayList<Address> arrOfAdd = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                        Log.d("Address: ",arrOfAdd.get(0).getAddressLine(0));


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}