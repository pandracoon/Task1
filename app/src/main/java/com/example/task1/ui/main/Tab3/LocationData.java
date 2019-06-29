package com.example.task1.ui.main.Tab3;

import com.naver.maps.geometry.LatLng;
import java.util.ArrayList;


public class LocationData {


  public ArrayList<LatLng> StationLocList = new ArrayList<LatLng>();

  public static final LatLng[] PathLocList = {};

  public LocationData() {

  }

  public void setData() {
    StationLocList.add(new LatLng(36.3733734, 127.3592182));   //학사식당
    StationLocList.add(new LatLng(36.372921, 127.3616884));    //Sport Complex
    StationLocList.add(new LatLng(36.3707786, 127.3625589));   //창의학습관
    StationLocList.add(new LatLng(36.3703879, 127.3658091));   //의과학센터
    StationLocList.add(new LatLng(36.3693934, 127.3693892));   //Medical Center
    StationLocList.add(new LatLng(36.368708, 127.3671386));   //나노종합기술원
    StationLocList.add(new LatLng(36.3664233, 127.3637844));   //정문
    StationLocList.add(new LatLng(36.3681931, 127.3622346));   //오리연못
    StationLocList.add(new LatLng(36.370393, 127.3604109));   //교육지원동 건너편
    StationLocList.add(new LatLng(36.3715681, 127.355487));   //나눔관
    StationLocList.add(new LatLng(36.368301, 127.3562427));  //희망-다솜관


  }

  public int getStationLocSize() {
    return StationLocList.size();
  }


}


