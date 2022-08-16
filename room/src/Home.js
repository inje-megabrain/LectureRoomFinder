import * as React from 'react';
import './App.css';
import { useNavigate } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import FlightTakeoffIcon from '@mui/icons-material/FlightTakeoff';
import FlightLandIcon from '@mui/icons-material/FlightLand';

const Home=()=> {
    const navigate = useNavigate();

    const MAPClick = ()=> {
        navigate("/MAP");
    }
    const campusClick=()=> {
        navigate("/Campus");
    }
    const signupClick=()=> {
        navigate("/Signup");
    }
    const joinClick=()=> {
        navigate("/Join");
    }
    const searchClick=()=> {
        navigate("/Search");
    }
    return (
        <div className='home'>
            <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar>
                <Typography variant="h3" component="div"  sx={{ flexGrow: 1 }}>
                    MegaBrain
                </Typography>
                <Stack direction="row" spacing={2}>
                    <Button variant="text" color="inherit" size='large' 
                        onClick={MAPClick}>Map</Button>
                    <Button variant="text" color="inherit" size='large'
                        onClick={campusClick}>Campus</Button>
                    <Button variant="text" color="inherit" size='large'
                        onClick={signupClick}>Sign Up</Button>
                    <Button variant="outlined" color="inherit" size='large'
                        onClick={joinClick}>Join</Button>
                </Stack>
                </Toolbar>
            </AppBar>
            </Box>
            <div className='App'>
                <div className='middle-big'>
                    INJE Lecture Room Map
                </div>
                <div className='middle-small'>
                    It was made by Megabrain for the first time
                </div>
                <div className='centerfram'>
                    <div className='center-main'>
                        <Stack direction="row" spacing={4}>
                            <FlightTakeoffIcon sx={{fontSize:50}} />
                            <TextField id="outlined-basic" label="Depart" variant="outlined" />
                            <FlightLandIcon sx={{fontSize:50}} />
                            <TextField id="outlined-basic" label="Arrive" variant="outlined" />
                            <Button variant="contained" onClick={searchClick}>Search</Button>
                        </Stack>
                    </div>
                </div>
            </div>
        </div>
      );
}
export default Home;