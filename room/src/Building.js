import * as React from "react";
import {
  useChain,
  useSpring,
  animated,
  useTransition,
  config,
} from "react-spring";
import "./App.css";
// import { useState, useRef } from 'react';
// import data from './data';
import { useState, useEffect } from "react";
import axios from "axios";
import UserList from "./UserList";
import { Button } from "@mui/material";
import Modal from "@mui/material/Modal";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

const Building = () => {
  // const styles = useSpring({
  //     loop:true,
  //     to : [
  //         {opacity: 1, color: 'blue'},
  //         {opacity: 0, color:'rgb(14,26,19)'},
  //     ],
  //     from: {opacity: 0, color:'yellow'}
  // })
  // useSpring example
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get("https://jsonplaceholder.typicode.com/users").then((response) => {
      setUsers(response.data);
    });
  }, []);

  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 400,
    bgcolor: "background.paper",
    border: "2px solid #000",
    boxShadow: 24,
    p: 4,
  };

  return (
    <div>
      {/* <animated.div style={styles} className="middle-big">
                Working!
            </animated.div> */}
      <h1>Users</h1>
      <UserList users={users} />
      <div>
        <Button onClick={handleOpen}>Modal test</Button>
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              Text in a modal
            </Typography>
            <Typography id="modal-modal-description" sx={{ mt: 2 }}>
              Good Test!!!
            </Typography>
          </Box>
        </Modal>
      </div>
    </div>
  );
};
export default Building;
