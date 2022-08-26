import { Button } from '@mui/material';
import * as React from 'react';
import { useNavigate } from "react-router-dom";
import './App.css';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { registerUser } from './actions/user_action';
import axios from 'axios';

const Signup=(props)=> {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const JoinClick=()=> {
        navigate("/Join");
    }
    const homeClick=()=> {
        navigate("/");
    }

    const [pw, setPassword] = useState("");
    const [username,setNickname] = useState("");
    const [identity, setId] = useState("");
    const [confirmPassword, setconfirmPassword] = useState("");

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value)
    }
    const onNickHandler = (e) => {
        setNickname(e.currentTarget.value);
      };
    
      const onIdHandler = (e) => {
        setId(e.currentTarget.value);
      };
    const onconfirmPasswordHandler = (event) => {
        setconfirmPassword(event.currentTarget.value)
    }
    const hasNotSameError = passwordEntered => 
        pw !== confirmPassword ? true : false;    
    
    const onSubmitHandler = (event) => {
        event.preventDefault();

        if (pw !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
        } 

        let body = {
            username : username,
            identity : identity,
            pw : pw,
        }
        dispatch(registerUser(body))
        .then(response => {
            if(response.payload.success) {
                props.history.push("/Join");
            }
          });
        };
        async function postData() {
            try {
                const response = await axios.post('/api/users/new',{
                    username : username,
                    identity : identity,
                    pw: pw,
                });
                console.log(response);
            } catch(error) {
                console.error(error);
            }
        }
    
    return (
        <div className='signupback'>
            <div className='megalogo' onClick={homeClick}>MegaBrain</div>
            <div className='signupmainframe'>
                <div className='signupmain'>
                    Create account
                </div>
                <div className='signupmainunder'>
                    Already have an account? 
                    <Button onClick={JoinClick}>Login</Button>
                </div>
                <div className='underframe'>
                    <Stack spacing={4}>
                        <TextField
                            required
                            id="nickname"
                            label="NickName"
                            value={username}
                            onChange={onNickHandler}
                            />
                        <TextField
                        required
                        id="userid"
                        value={identity}
                        label="ID"
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
                        <TextField
                        id="outlined-password-input"
                        label="Re-Password"
                        type="password"
                        value={confirmPassword}
                        onChange={onconfirmPasswordHandler}
                        error={hasNotSameError('confirmPassword')}
                        helperText={hasNotSameError('confirmPassword') ? 
                        "비밀번호가 일치하지 않습니다." : null}
                        autoComplete="current-password"
                        />
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            onSubmit={onSubmitHandler}
                            color="primary"
                            onClick={postData}
                        >회원가입</Button>
                    </Stack>
                </div>
            </div>
        </div>
    );
}
export default Signup;