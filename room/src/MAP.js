import * as React from 'react';
import { useState ,useEffect } from 'react';
import './App.css';

const MAP=()=> {
    const {naver} = window;

    // const [myLocation, setMyLocation] = useState<{ latitude: Number, longitude: number}>("");

    // useEffect(()=> {
    //     if(navigator.geolocation) {
    //         navigator.geolocation.getCurrentPosition((position) => {
    //             setMyLocation({
    //                 latitude: position.coords.latitude,
    //                 longitude: position.coords.longitude,
    //             });
    //         });
    //     } else {
    //         window.alert("Current Location unknown");
    //     }
    // }, []);

    useEffect(() => {
        let map = null
        let marker = null

        const initMap = () => {
            map = new naver.maps.Map('map', {
                //지도 추가, 좌표를 기점으로 주변 지도가 추가된다.
                center: new naver.maps.LatLng(35.250565, 128.902063),
                minZoom:16,
                zoom: 17,
                zoomControl: true
            })

            marker = new naver.maps.Marker({
                position: new naver.maps.LatLng(35.24999, 128.902416), //Marker 추가, 좌표에 마커가 찍힌다.
                map: map,
                // icon: {
                //     content: `
                //         <img alt="marker" src={RoomIcon} />
                //             `
                // }
            })
        }
        initMap()
    }, [])
    const mapstyle = {
        // width: '80%',
        // height: '500px'
        height: '100vh',
        width: '100vw'
    }
    return (
        <div>
            <div id='map' style={mapstyle}></div>
        </div>
    );
}
export default MAP;