import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Header} from "./components/header/Header";
import {Footer} from "./components/footer/Footer";
import {Home} from "./components/home/Home";
import "bootstrap/dist/css/bootstrap.css";
import {Course} from "./components/course/Course";
import {Detail} from "./components/detail/Detail";
function App() {
  return (
   <>
   <BrowserRouter>
       <Header/>
     <Routes>
       <Route path={"/"} element={<Home/>}></Route>
         <Route path={"/course"} element={<Course/>}></Route>
         <Route path={"/course/:id"} element={<Detail/>}></Route>
     </Routes>
       <Footer/>
   </BrowserRouter>
   </>
  );
}

export default App;
