import * as React from 'react';
import './App.css';
import { Button } from '@mui/material';
import { useNavigate } from "react-router-dom";

const Campus=()=> {
    const navigate = useNavigate();
    const MAPClick=()=> {
        navigate("/MAP");
    }
    const homeClick=()=> {
        navigate("/");
    }

    return (
        <div className='campusback'>
            <div className='megalogo' onClick={homeClick}>MegaBrain</div>
            <div className='campusmainframe'>
                <div className='campusimg'></div>
            </div>
             <div className='campusbutton'>
                <Button variant="contained" color="primary" size='large' 
                        onClick={MAPClick}>Map</Button>
            </div>
        </div>
    );
}
export default Campus;