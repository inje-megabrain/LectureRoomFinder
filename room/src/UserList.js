import React from "react";

const UserList = ({ users }) => {
  return (
    <div>
      {users.map((user) => {
        return <li key={user.id}>{user.name}</li>;
      })}
    </div>
  );
};

export default UserList;
