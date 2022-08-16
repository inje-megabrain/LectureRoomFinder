import axios from "axios";

axios.defaults.withCredentials = true;

export const request = (method, url, data) => {
    return axios({
        method,
        url: "http://localhost:3000"+url,
        data,
    })
    .then((res)=>res.data)
    .catch((err)=>console.log(err));
};