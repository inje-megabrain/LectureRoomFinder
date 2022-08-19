import * as React from 'react';
import { useSpring, animated } from 'react-spring';
import './App.css';

function Building() {
    const styles = useSpring({
        loop:true,
        to : [
            {opacity: 1, color: 'blue'},
            {opacity: 0, color:'rgb(14,26,19)'},
        ],
        from: {opacity: 0, color:'yellow'}
    })
    return (
        <animated.div style={styles} className="middle-big">
            Working!
        </animated.div>
    );
}
export default Building;