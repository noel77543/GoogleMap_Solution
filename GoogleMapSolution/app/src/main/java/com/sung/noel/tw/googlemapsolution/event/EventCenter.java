package com.sung.noel.tw.googlemapsolution.event;


import com.google.android.gms.maps.model.LatLng;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sung.noel.tw.googlemapsolution.main.model.AddressInfo;
import com.sung.noel.tw.googlemapsolution.main.model.DirectionInfo;
import com.sung.noel.tw.googlemapsolution.main.model.DistanceInfo;
import com.sung.noel.tw.googlemapsolution.main.model.PlaceInfo;

/**
 * Created by noel on 2017/8/16.
 */

public class EventCenter {
    //連線失敗用
    public static int EVENT_CONNECT_FAIL = 111;

    public static final int TYPE_ADDRESS = 222;
    public static final int TYPE_LOCATION = 333;
    public static final int TYPE_DIRECTION = 444;
    public static final int TYPE_PLACE = 555;
    public static final int TYPE_DISTANCE = 666;
//    public static final int TYPE_PLACE_DETAIL = 777;


    //--------------------------------------------------
    private static EventCenter ourInstance = new EventCenter();

    //--------------------------------------------------
    public static EventCenter getInstance() {
        return ourInstance;
    }

    //--------------------------------------------------
    private EventCenter() {

    }

    //--------------------------------------------------
    private void sendListEvent(int type, List<?> dataList) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", type);
        data.put("data", dataList);
        EventBus.getDefault().post(data);
    }

    //--------------------------------------------------
    private void sendObjectEvent(int type, Object object) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", type);
        data.put("data", object);
        EventBus.getDefault().post(data);
    }
    //--------------------------------------------------

    /**
     * 發送 連線失敗
     */
    public void sendConnectErrorEvent(String errString) {
        sendObjectEvent(EVENT_CONNECT_FAIL, errString);
    }
    //-----------------

    /**
     * 經緯度轉地址
     * @param addressInfo 地址
     * */
    public void sendAddress(int type, AddressInfo addressInfo){
        sendObjectEvent(type, addressInfo);

    }

    //--------------------------------------------------

    /**
     * 地址轉經緯度
     * @param address 地址
     * */
    public void sendLocation(int type,LatLng address){
        sendObjectEvent(type,address);

    }

    //--------------------------------------------------

    /**
     * 最佳路線規劃
     *
     * */
    public void sendRoute(int type, DirectionInfo directionInfo){
        sendObjectEvent(type, directionInfo);
    }
    //--------------------------------------------------

    /**
     * 地方資訊
     * */
    public void sendPlace(int type, PlaceInfo placeInfo){
        sendObjectEvent(type, placeInfo);
    }
//    //--------------------------------------------------
//
//    /**
//     * 地方詳細資訊
//     * */
//    public void sendPlaceDetail(int type, PlaceDetail placeDetail){
//        sendObjectEvent(type, placeDetail);
//    }
    //---------

    /***
     * 距離 , 耗時
     * @param type
     * @param distanceInfo
     */
    public void sendDistance(int type, DistanceInfo distanceInfo){
        sendObjectEvent(type, distanceInfo);
    }
}