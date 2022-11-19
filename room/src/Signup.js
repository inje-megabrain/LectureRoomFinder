import { Button } from "@mui/material";
import * as React from "react";
import { useNavigate } from "react-router-dom";
import "./App.css";
import TextField from "@mui/material/TextField";
import Stack from "@mui/material/Stack";
import { useState } from "react";
import axios from "axios";

const Signup = (props) => {
  const navigate = useNavigate();

  const JoinClick = () => {
    navigate("/Join");
  };
  const homeClick = () => {
    navigate("/");
  };

  const [pw, setPassword] = useState("");
  const [username, setNickname] = useState("");
  const [identity, setId] = useState("");
  const [confirmPassword, setconfirmPassword] = useState("");
  const [scheck, setcheck] = useState(0);

  const onPasswordHandler = (event) => {
    setPassword(event.currentTarget.value);
  };
  const onNickHandler = (e) => {
    setNickname(e.currentTarget.value);
  };

  const onIdHandler = (e) => {
    setId(e.currentTarget.value);
  };
  const onconfirmPasswordHandler = (event) => {
    setconfirmPassword(event.currentTarget.value);
  };
  const hasNotSameError = (passwordEntered) =>
    pw !== confirmPassword ? true : false;

  const postData = () => {
    // try {
    //     console.log(scheck);
    //     if(scheck === "1") {
    //         axios.post('/api/users/new',{
    //             username : username,
    //             identity : identity,
    //             pw: pw,
    //         }).then((response)=>{
    //             console.log(response);
    //         })
    //         if(scheck === "1") {
    //             window.confirm('회원가입 성공!!');
    //             console.log(scheck);
    //             navigate("/Join");
    //         }
    //     }
    //     if(scheck === "0") {
    //         window.confirm('다시 정보를 확인해주세요!');
    //     }
    // }
    // catch(error) {
    //      window.confirm('다시 정보를 확인해주세요!');
    //         console.error(error);
    // }
    if (scheck === 1) {
      axios
        .post("/api/users/new", {
          username: username,
          identity: identity,
          json: pw,
        })
        .then((response) => {
          console.log(response);
        });
    }
  };

  function check() {
    return axios
      .post("/api/users/id_check", null, {
        params: {
          identity: identity,
        },
      })
      .then((response) => {
        if (response.status === 200) {
          console.log("사용가능한 아이디입니다!");
          window.confirm("사용가능합니다!");
          setcheck(scheck + 1);
          console.log(scheck);
        }
      })
      .catch((error) => {
        console.log(error);
        if (error.response.status === 400) {
          window.confirm("중복된 아이디입니다!");
          setcheck(scheck + 0);
          console.log(scheck);
        }
        //setcheck = "false";
        console.log(scheck);
      });
  }

  return (
    <div className="signupback">
      <div className="megalogo" onClick={homeClick}>
        MegaBrain
      </div>
      <div className="signupmainframe">
        <div className="signupmain">Create account</div>
        <div className="signupmainunder">
          Already have an account?
          <Button onClick={JoinClick}>Login</Button>
        </div>
        <div className="underframe">
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
            <Button onClick={check}>중복확인</Button>
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
              error={hasNotSameError("confirmPassword")}
              helperText={
                hasNotSameError("confirmPassword")
                  ? "비밀번호가 일치하지 않습니다."
                  : null
              }
              autoComplete="current-password"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              //onSubmit={onSubmitHandler}
              color="primary"
              onClick={postData()}
            >
              회원가입
            </Button>
            {/* <Button onClick={url}>KEYCLOAK</Button> */}
          </Stack>
        </div>
      </div>
    </div>
  );
};
export default Signup;
