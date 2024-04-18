import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Header} from "./components/header/Header";
import {Footer} from "./components/footer/Footer";
import {Home} from "./components/home/Home";
import "bootstrap/dist/css/bootstrap.css";
import {Course} from "./components/Course/Course";
function App() {
  return (
   <>
   <BrowserRouter>
       <Header/>
     <Routes>
       <Route path={"/"} element={<Home/>}></Route>
         <Route path={"/course"} element={<Course/>}></Route>
     </Routes>
       <Footer/>
   </BrowserRouter>
   </>
  );
}

export default App;
