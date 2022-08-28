import * as React from 'react';
import { useState ,useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import './App.css';

const MAP=()=> {
    const {naver} = window;
    const navigate = useNavigate();

    const homeClick=()=> {
        navigate("/");
    }
    const [myLocation, setMyLocation] = useState({ latitude: 35.250565, longitude: 128.902063});

    useEffect(() => {
        const currentPosition = [myLocation.latitude, myLocation.longitude];
        if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition((position) => {
                setMyLocation({
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude,
                });
            });
        } else {
            window.confirm("Current Location unknown");
        }

        let map = null
        let marker = null
        let marker1 = null
 
        const initMap = () => {
            map = new naver.maps.Map('map', {
                //지도 추가, 좌표를 기점으로 주변 지도가 추가된다.
                center: new naver.maps.LatLng(35.250565, 128.902063),
                minZoom:16,
                zoom: 17,
                zoomControl: true
            })

            marker = new naver.maps.Marker({
                position: new naver.maps.LatLng(currentPosition[0], currentPosition[1]), //Marker 추가, 좌표에 마커가 찍힌다.
                map: map,
            })
            marker1 = new naver.maps.Marker({ // test marker
                position: new naver.maps.LatLng(35.250565, 128.902063), //Marker 추가, 좌표에 마커가 찍힌다.
                map: map,
            })
        }
        initMap()
    }, [myLocation]);

    const mapstyle = {
        height: '100vh',
        width: '100vw'
    }
    return (
        <div>
            <div className='megalogo2' onClick={homeClick}>MegaBrain</div>
            <div id='map' style={mapstyle}></div>
        </div>
    );
}
export default MAP;