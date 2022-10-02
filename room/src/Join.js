import * as React from 'react';
import './App.css';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import { Button } from '@mui/material';
import { useDispatch } from 'react-redux';
//import { loginUser } from './actions/user_action';
import axios from 'axios';


const Join=(props)=> {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [identity, setId] = useState("");
    const [pw, setPassword] = useState("");

    
    const SignupClick=()=> {
        navigate("/Signup");
    }
    const homeClick=()=> {
        navigate("/");
    }

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value)
    }
    const onIdHandler = (event) => {
        setId(event.currentTarget.value)
    }

    let body={
        identity:identity,
        pw:pw,
    }
    // const onSubmitHandler = (event) => {
    //     event.preventDefault();

    //     dispatch(loginUser(body))
    //     .then(response => {
    //         if(response.payload.loginSuccess) {
    //             props.history.push('/LoginHome')
    //         } else{
    //             alert('Error')
    //         }
    //     })
    // };

    function logincheck(){
        return (
            axios.post('api/users/login',null,{params : {
                identity:identity,
                pw:pw,
            }})
            .then((response)=> {
                if(response.status == 200) {
                    console.log(response);
                    window.confirm('로그인이 완료되었습니다!');
                    navigate("/LoginHome");
                }
            }).catch(error=>{
                console.log(error);
                window.confirm('로그인 실패!');
            })
        )
    }

    return (
        <div className='loginback'>
            <div className='megalogo' onClick={homeClick}>MegaBrain</div>
            <div className='signupmainframe'>
                <div className='signupmain'>
                    Login
                </div>
                <div className='signupmainunder'>
                    Aren't you a member?
                    <Button onClick={SignupClick}>Sign up</Button>
                </div>
                <div className='underframe'>
                    <Stack spacing={4}>
                        <TextField
                        required
                        id="userid"
                        label="ID"
                        value={identity}
                        onChange={onIdHandler}
                        />
                        <TextField
                        id="password"
                        label="Password"
                        type="password"
                        value={pw}
                        onChange={onPasswordHandler}
                        autoComplete="current-password"
                        />
                        <Button
                            type="submit"
                            variant="contained"
                            //onSubmit={onSubmitHandler}
                            color="primary"
                            onClick={logincheck}
                        >로그인</Button>
                    </Stack>
                </div>
            </div>
        </div>
    );
}
export default Join;