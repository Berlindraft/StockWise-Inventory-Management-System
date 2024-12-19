import React, { useState } from "react";
import axios from "axios";

const SignUp = () => {
const [email, setEmail] = useState("");
const [password, setPassword] = useState("");
const [confirmPassword, setConfirmPassword] = useState("");
const [acceptTerms, setAcceptTerms] = useState(false);
const [message, setMessage] = useState("");


const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
    setMessage("Passwords do not match.");
    return;
    }

    try {
    const response = await axios.post("http://localhost:8080/api/auth/register", {
        email,
        password,
    });
    if (response.data.status === "success") {
        setMessage("Registration successful!");
    } else {
        setMessage(response.data.message || "An error occurred. Please try again.");
    }
    } catch (error) {
    setMessage("An error occurred. Please try again.");
    }
};


return (
    <div className="w-full flex justify-center items-center min-h-screen bg-gray-100">
    <div className="w-80 rounded-2xl bg-slate-900">
        <div className="flex flex-col gap-2 p-8">
        <p className="text-center text-3xl text-gray-300 mb-4">Register</p>
        
        <form onSubmit={handleSubmit}>
            <input
            className="bg-slate-900 w-full rounded-lg border border-gray-300 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-gray-700 focus:ring-offset-2 focus:ring-offset-gray-800 mb-4"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            />
            
            <input
            className="bg-slate-900 w-full rounded-lg border border-gray-300 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-gray-700 focus:ring-offset-2 focus:ring-offset-gray-800 mb-4"
            placeholder="Password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            />
            
            <input
            className="bg-slate-900 w-full rounded-lg border border-gray-300 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-gray-700 focus:ring-offset-2 focus:ring-offset-gray-800 mb-4"
            placeholder="Confirm password"
            type="password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            />
            
            <label className="flex cursor-pointer items-center justify-between p-1 text-slate-400 mb-4">
            Accept terms of use
            <div className="relative inline-block">
                <input
                className="peer h-6 w-12 cursor-pointer appearance-none rounded-full border border-gray-300 bg-gray-400 checked:border-green-300 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-gray-900 focus-visible:ring-offset-2"
                type="checkbox"
                checked={acceptTerms}
                onChange={() => setAcceptTerms(!acceptTerms)}
                />
                <span className="pointer-events-none absolute left-1 top-1 block h-4 w-4 rounded-full bg-slate-600 transition-all duration-200 peer-checked:left-7 peer-checked:bg-green-300"></span>
            </div>
            </label>
            
            <button
            className="inline-block cursor-pointer rounded-md bg-gray-700 px-4 py-3.5 text-center text-sm font-semibold uppercase text-white transition duration-200 ease-in-out hover:bg-gray-800 focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-gray-700 focus-visible:ring-offset-2 active:scale-95 w-full"
            type="submit"
            >
            Register
            </button>
            <div className="text-sm text-white text-center mt-[1.6rem]">
        Don’t have an account yet?{" "}
        <a className="text-sm text-[#7747ff]" href="/Login">
        Login!
        </a>
        </div>
        </form>
        
        {message && (
            <div className="text-center mt-4 text-sm text-red-500">{message}</div>
        )}
        </div>
    </div>
    </div>
);
};

export default SignUp;
