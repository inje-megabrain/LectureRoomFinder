import { StyleSheet, Text, View, Button } from 'react-native';
import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native';
import Locations from './Locations';

const Home = ({navigation}) => {
  return (
    <View style={styles.container}>
      <Text style={styles.bigtext}>Inje Home</Text>
      <Button
        title="Go to 인제대학교"
        onPress={()=>navigation.navigate('Locations')}
      />
    </View>
  )
}

const Stack = createNativeStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home}/>
        <Stack.Screen name="Locations" component={Locations}/>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  bigtext: {
    fontSize:45,
  },
});
export default App;

