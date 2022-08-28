import axios from "axios";
import {LOGIN_USER, REGISTER_USER} from '../types';

export function loginUser(dataTosubmit) {

    const request = axios.post('/api/users/login_check', dataTosubmit)//서버에 리퀘스트 날리고 
        .then(response => response.data)//받은 데이터를 request에 저장

        return {    //Action 했으니까 이제 Reducer로 보냄
            type: LOGIN_USER,
            payload: request
        }
}


export function registerUser(dataTosubmit) {

    const request = axios.post('/api/users/new', dataTosubmit)//서버에 리퀘스트 날리고 
        .then(response => response.data)//받은 데이터를 request에 저장

        return {   //Action 했으니까 이제 Reducer로 보냄
            type: REGISTER_USER,
            payload: request
        }
}