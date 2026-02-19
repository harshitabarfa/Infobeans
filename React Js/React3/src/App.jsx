import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Link, Routes, Route } from 'react-router-dom'
import User from './Component/User'

function App() {

  { /* const linkstyle = {
    marginRight : '15px',
    textDecoration : 'none',
    color : 'red',
  }; */ }

  return (
    <>
      <h1>This is my website</h1>

      <nav>
        <Link to="/user/101">User 101</Link>|
        <Link to="/user/102">User 102</Link>|
        <Link to="/user/103">User 103</Link>
      </nav>

      <Routes>
        <Route path="/user/:id" element={<User />}></Route>
      </Routes>
    </>
  )
}

export default App
