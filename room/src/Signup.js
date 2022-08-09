import { Button } from '@mui/material';
import * as React from 'react';
import { useNavigate } from "react-router-dom";
import './App.css';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import { useState } from 'react';

const Signup=()=> {
    const navigate = useNavigate();

    const JoinClick=()=> {
        navigate("/Join");
    }
    const [Password, setPassword] = useState("");
    const [confirmPassword, setconfirmPassword] = useState("");

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value)
    }
    const onconfirmPasswordHandler = (event) => {
        setconfirmPassword(event.currentTarget.value)
    }
    const hasNotSameError = passwordEntered =>
        Password != confirmPassword ? true : false;    

    const onSubmitHandler = (event) => {
        event.preventDefault(); // 아무 동작 안하고 버튼만 눌러도 리프레쉬 되는 것을 막는다

        if(Password !== confirmPassword){
            return alert('비밀번호와 비밀번호 확인은 같아야 합니다.')
        }
    }

    return (
        <div className='signupback'>
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
                            id="outlined-required"
                            label="NickName"
                            defaultValue="개장수"
                            />
                        <TextField
                        required
                        id="outlined-required"
                        label="ID"
                        />
                        <TextField
                        id="outlined-password-input"
                        label="Password"
                        type="password"
                        value={Password}
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
                        >회원가입</Button>
                    </Stack>
                </div>
            </div>
        </div>
    );
}
export default Signup;