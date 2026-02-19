import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  return (
    <>
      <img src="https://images.unsplash.com/photo-1530076886461-ce58ea8abe24?q=80&w=871&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" width="500px" alt="Image" />

      <table border="1">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Harshita</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Janvi</td>
          </tr>
          <tr>
            <td>3</td>
            <td>Deepak</td>
          </tr>
          <tr>
            <td>4</td>
            <td>Amit</td>
          </tr>
        </tbody>
      </table>

      <a href="https://www.youtube.com/">Open Youtube</a> <br /><br />

      <form>
        Name: <input type="text" placeholder='Enter your name'/> <br /> <br />
        Email <input type="text" placeholder='Enetr your email'/> <br />
        <button type='submit'>Submit</button>
      </form>
    </>
  );
}

export default App
