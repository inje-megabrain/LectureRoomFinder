import { REGISTER_USER, LOGIN_USER } from "./types";
import { request } from "../axios";
import Axios from 'axios';

const USER_URL = "http://localhost:3000"; //"/api/user";

export function loginUser(dataTosubmit) {
  const request = Axios.post('http://localhost:3000/Join',dataTosubmit)//('/api/users/login', dataTosubmit) //서버에 리퀘스트 날리고 
    .then(response => response.data)      //받은 데이터를 request에 저장

  return {             //Action 했으니까 이제 Reducer로 보냄
    type: LOGIN_USER,
    payload: request,
  };
}

export function registerUser(dataToSubmit) {
  const data = request("post", USER_URL + "/Signup", dataToSubmit);

  return {
    type: REGISTER_USER,
    payload: data,
  };
}