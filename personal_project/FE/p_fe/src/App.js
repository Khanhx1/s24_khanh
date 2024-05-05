import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Header} from "./components/header/Header";
import {Footer} from "./components/footer/Footer";
import {Home} from "./components/home/Home";
import "bootstrap/dist/css/bootstrap.css";
import {Course} from "./components/course/Course";
import {Detail} from "./components/detail/Detail";
import "../src/statics/css/CommonStyle.css"
import {Login} from "./components/login/Login";
import {useState} from "react";
import {Cart} from "./components/cart/Cart";
function App() {
    const [isShowLogin, setIsShowLogin] = useState(false);

    const closeModalLogin = () => {
        setIsShowLogin(false);
    }

    const openModalLogin = () => {
        setIsShowLogin(true);
    }
  return (
   <>
   <BrowserRouter>
       <Header openModalLogin={openModalLogin}/>
     <Routes>
       <Route path={"/"} element={<Home/>}></Route>
         <Route path={"/course"} element={<Course/>}></Route>
         <Route path={"/course/:id"} element={<Detail/>}></Route>
         <Route path={"/cart"} element={<Cart/>}></Route>
     </Routes>
       <Footer/>
   </BrowserRouter>
       {isShowLogin && (<Login closeModalLogin={closeModalLogin}/>)}
   </>
  );
}

export default App;
