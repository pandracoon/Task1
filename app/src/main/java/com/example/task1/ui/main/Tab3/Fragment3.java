package com.example.task1.ui.main.Tab3;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.task1.R;;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.geometry.LatLngBounds;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

public class Fragment3 extends Fragment implements OnMapReadyCallback {

  MapView mapView;
  FragmentManager fragmentManager;
  View view;
  LocationData locationData = new LocationData();


  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    try {
      view = inflater.inflate(R.layout.layout_fragment3, container, false);
    } catch (InflateException e) {
    }

    mapView = (MapView) view.findViewById(R.id.map_view);
    mapView.getMapAsync(this);

    return view;
  }

  @Override
  public void onMapReady(@NonNull NaverMap naverMap) {

    float symbolScaleValue = 1 / 2;

    LatLng basicLocation = new LatLng(36.3703641, 127.3626828);
    CameraPosition cameraPosition = new CameraPosition(basicLocation, 14);
    naverMap.setCameraPosition(cameraPosition);

    naverMap.setMinZoom(14);

    LatLng NELimitLocation = new LatLng(36.3763389, 127.3707596);
    LatLng SWLimitLocation = new LatLng(36.3631224, 127.354996);
    naverMap.setExtent(new LatLngBounds(SWLimitLocation, NELimitLocation));

    naverMap.setSymbolScale(symbolScaleValue);

    LocationData locationData = new LocationData();
    locationData.setData();
    Marker[] stationMarker = new Marker[locationData.getStationLocSize()];
    for (int i = 0; i < locationData.getStationLocSize(); i++) {
      stationMarker[i]=new Marker();
      stationMarker[i].setPosition(locationData.StationLocList.get(i));
      stationMarker[i].setMap(naverMap);
    }

  }

  @Override
  public void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }

  @Override
  public void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    if (view != null) {
      ViewGroup parent = (ViewGroup) view.getParent();
      if (parent != null) {
        parent.removeView(view);
      }
    }
    mapView.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }


}

