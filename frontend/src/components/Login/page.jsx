import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    try {
      const response = await axios.post("http://localhost:8080/api/auth/login", {
        email,
        password,
      });
      if (response.data.status === "success") {
        navigate("/Home"); // NAVIGATE TO HOME PAGE
      }
    } catch (error) {
      console.error("Login Error:", error);
      setMessage("An error occurred. Please try again.");
    }
  };
  

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
    <div className="max-w-md relative flex flex-col p-4 rounded-md text-black bg-white">
      <div className="text-2xl font-bold mb-2 text-[#1e0e4b] text-center">
        Welcome back to <span className="text-[#7747ff]">test</span>
      </div>
      <div className="text-sm font-normal mb-4 text-center text-[#1e0e4b]">
        Log in to your account
      </div>
      <form onSubmit={handleSubmit} className="flex flex-col gap-3">
        <div className="block relative">
          <label htmlFor="email" className="block text-gray-600 text-sm mb-2">
            Email
          </label>
          <input
            type="text"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="rounded border border-gray-200 text-sm w-full h-11 p-[11px] focus:ring-2 ring-offset-2 ring-gray-900 outline-0"
          />
        </div>
        <div className="block relative">
          <label htmlFor="password" className="block text-gray-600 text-sm mb-2">
            Password
          </label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="rounded border border-gray-200 text-sm w-full h-11 p-[11px] focus:ring-2 ring-offset-2 ring-gray-900 outline-0"
          />
        </div>
        <div>
          <a className="text-sm text-[#7747ff]" href="#">
            Forgot your password?
          </a>
        </div>
        <button
          type="submit"
          className="bg-[#7747ff] w-max m-auto px-6 py-2 rounded text-white text-sm"
        >
          Submit
        </button>
      </form>
      {message && (
        <div className="text-center mt-4 text-sm text-red-500">{message}</div>
      )}
      <div className="text-sm text-center mt-[1.6rem]">
        Don’t have an account yet?{" "}
        <a className="text-sm text-[#7747ff]" href="/Register">
          Sign up!
        </a>
      </div>
    </div>
    </div>
  );
};

export default Login;
