import React, { useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import AuthContext from "../context/AuthContext";

const Navbar = () => {
  const { token, logout } = useContext(AuthContext); // ⬅️ using token instead of authenticated
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <nav className="navbar">
      <h2 className="logo">Employee Portal</h2>

      <ul>
        {token ? ( // ⬅️ show menu only when token exists
          <>
            <li>
              <Link to="/">Home</Link>
            </li>

            <li>
              <Link to="/add">Add Employee</Link>
            </li>

            <li>
              <button
                onClick={handleLogout}
                style={{
                  background: "transparent",
                  color: "white",
                  border: "none",
                  cursor: "pointer",
                  fontSize: "16px",
                  fontWeight: "bold",
                }}
              >
                Logout
              </button>
            </li>
          </>
        ) : (
          <>
            <li>
              <Link to="/login">Login</Link>
            </li>
          </>
        )}
      </ul>
    </nav>
  );
};

export default Navbar;
