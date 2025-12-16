import React, { useState, useContext } from "react";
import API from "../api";
import AuthContext from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const { login } = useContext(AuthContext);
  const navigate = useNavigate();

  const [form, setForm] = useState({ username: "", password: "" });

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await API.post("/login", form); // backend returns token
      login(res.data.data.token); // save token to localStorage
      navigate("/"); // go to home
    } catch (err) {
      if (!err.response) {
        alert("Network error. Please try again later.");
      } else {
        alert("Invalid Username or Password");
      }
    }
  };

  return (
    <div className="form-container">
      <h2>Login</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="username"
          placeholder="Username"
          value={form.username}
          onChange={handleChange}
          required
        />

        <input
          name="password"
          type="password"
          placeholder="Password"
          value={form.password}
          onChange={handleChange}
          required
        />

        <button type="submit" className="submit-btn">
          Login
        </button>

        <a href="/register">Don't have an account?</a>
      </form>
    </div>
  );
};

export default Login;
