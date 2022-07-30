import React, {useState, useEffect} from "react";
import MapView, {Marker} from "react-native-maps";
import { StyleSheet, View, ScrollView } from "react-native";
import * as Location from 'expo-location';

const Locations =() => {
    const [location, setLocatin] = useState(null);
    const [errorMsg, setErrorMsg] = useState(null);
    const [initialRegion, setInitialRegion] = useState({
        latitude: 35.91395373474155,
        longitude: 127.73829440215488,
        latitudeDelta: 5,
        longitudeDelta: 5,
    })

    useEffect(()=>{
        (async () => {
            let {status} = await Location.requestForegroundPermissionsAsync();
            if(status != 'granted') {
                setErrorMsg('Permission to access loaction was denied');
                return;
            }
            let location = await Location.getCurrentPositionAsync();
            setLocatin(location);
        })();
    },[]);

    let text = 'Waiting...';
    if(errorMsg) {
        text = errorMsg;
    } else if(location) {
        text = JSON.stringify(location);
    }

    return(
        <View style={styles.container}>
            <MapView
                onRegionChange={region => {
                    setLocatin({latitude: region.latitude, longitude : region.longitude})
                }}
                onRegionChangeComplete={region =>{
                    setLocatin({latitude:region.latitude,longitude:region.longitude})
                }}
                style={styles.map}
                zoo
            >
            <Marker coordinate={{latitude: 35.24971, longitude:128.90266}}></Marker>
            </MapView>
            {/* <Text>{text}</Text> */}
        </View>
    )
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    map: {
        ...StyleSheet.absoluteFillObject,
        width: "100%",
        height: "100%",
    },
})
export default Locations;
