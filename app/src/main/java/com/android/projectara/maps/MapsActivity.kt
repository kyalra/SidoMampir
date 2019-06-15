package com.android.projectara.maps

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.android.projectara.R
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style;
import android.support.annotation.NonNull;
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import android.R.style
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.geojson.Feature
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.layers.PropertyFactory




class MapsActivity : AppCompatActivity(){
    private var mapView: MapView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, "pk.eyJ1IjoiYWZpYXJ5YXVkeSIsImEiOiJjand3eG5mdTEwcDI1NDNuNTAxdTduNzZnIn0.M3c3szim6OsH-p1vibrGPA")
        setContentView(R.layout.maps)
        mapView = findViewById(R.id.mapView)
        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync(object : OnMapReadyCallback{
            override fun onMapReady(mapboxMap: MapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS)
            }

        })
    }
}