import * as React from 'react';
import './App.css';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import { useState } from 'react';
import { useNavigate } from "react-router-dom";
import { Button } from '@mui/material';
import { useDispatch } from 'react-redux';
import { loginUser } from './actions/userAction';

const Join=(props)=> {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const [id, setId] = useState("");
    const [password, setPassword] = useState("");
    
    const SignupClick=()=> {
        navigate("/Signup");
    }
    const LoginClick=()=> {
        navigate("/LoginHome");
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
    const onSubmitHandler = (event) => {
        event.preventDefault();
        let body={
            id:id,
            password:password
        }
        dispatch(loginUser(body))
        .then(response => {
            if(response.payload.loginSuccess) {
                props.history.push('/Home')   //리액트에서 페이지 이동하기 위해서는 props.history.push() 이용.
	            // 로그인 완료된 후 처음 화면(루트 페이지-landingpage로)으로 돌악가게 하기 
            } else{
                alert('Error')
            }
        })
    };

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
                        onChange={onIdHandler}
                        />
                        <TextField
                        id="password"
                        label="Password"
                        type="password"
                        value={password}
                        onChange={onPasswordHandler}
                        autoComplete="current-password"
                        />
                        <Button
                            type="submit"
                            variant="contained"
                            onSubmit={onSubmitHandler}
                            color="primary"
                            onClick={LoginClick}
                        >로그인</Button>
                    </Stack>
                </div>
            </div>
        </div>
    );
}
export default Join;