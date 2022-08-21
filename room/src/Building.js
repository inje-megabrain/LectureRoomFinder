import * as React from 'react';
import { useChain, useSpring, animated, useTransition, config } from 'react-spring';
import './App.css';
// import { useState, useRef } from 'react';
// import data from './data';

const Building=()=> {
    const styles = useSpring({
        loop:true,
        to : [
            {opacity: 1, color: 'blue'},
            {opacity: 0, color:'rgb(14,26,19)'},
        ],
        from: {opacity: 0, color:'yellow'}
    })
    // useSpring example

    return (
        <div>
            <animated.div style={styles} className="middle-big">
                Working!
            </animated.div>
         </div>
    );
}
export default Building;