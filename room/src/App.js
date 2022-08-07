import * as React from 'react';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Home from "./Home";
import MAP from "./MAP";
import Campus from './Campus';
import Join from './Join';
import Signup from './Signup';
import Search from './Search';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/search" element={<Search/>} />
        <Route path="/map" element={<MAP/>} />
        <Route path="/campus" element={<Campus/>} />
        <Route path="/signup" element={<Signup/>} />
        <Route path="/join" element={<Join/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
