import { REGISTER_USER,LOGIN_USER } from "../actions/types";

export default function (state = {}, action) {
  switch (action.type) {
    case LOGIN_USER:
      return {...state, loginSuccess: action.payload}       //... : spread operator은 파라미터 state를 그대로 가져온 것으로 빈 상태를 의미 
    case REGISTER_USER:
      return { ...state, success: action.payload };
    default:
      return state;
  }
}