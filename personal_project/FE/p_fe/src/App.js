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
import {useEffect, useState} from "react";
import {Cart} from "./components/cart/Cart";
import {ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.min.css"
import * as LoginService from "./services/LoginService"
import {UserDataProvider} from "./components/context/useUserData";
import {PurchasedSuccessfully} from "./components/payment/PurchasedSuccessfully";
import {Order} from "./components/historyOrder/Order";
function App() {
    const [isShowLogin, setIsShowLogin] = useState(false);
    const [userLogin, setUserLogin] = useState("");
    const [flagApp, setFlagApp] = useState(false);
    const [quantityCart, setQuantityCart] = useState(0);
    const [isLogin, setIsLogin] = useState(false);


    useEffect(() => {
        const token = localStorage.getItem("token");
        if (token) {
            loadUserLogin();
        } else {
            console.log("set false")
            setIsLogin(false);
            setUserLogin("unknown");
            setQuantityCart("99");
        }
    }, [flagApp]);

    const changeFlagApp = () => {
        setFlagApp(!flagApp);
    }

    const loadUserLogin = async () => {
        try {

            const res = await LoginService.getInfo();
            if (res) {
                const info = res.split(",");
                const name = info[0];
                const quantity = info[1];
                setQuantityCart(quantity);
                setUserLogin(name);
                setIsLogin(true);
            }
        } catch (e) {
            console.log(e);
        }
    }
    const closeModalLogin = () => {
        setIsShowLogin(false);
    }

    const openModalLogin = () => {
        setIsShowLogin(true);
    }
  return (
   <>
       <UserDataProvider>
       <ToastContainer/>
   <BrowserRouter>
       <Header openModalLogin={openModalLogin} userLogin={userLogin} quantityCart={quantityCart} isLogin={isLogin} changeFlagApp={changeFlagApp} flagApp={flagApp}/>
     <Routes>
       <Route path={"/"} element={<Home/>}></Route>
         <Route path={"/course"} element={<Course changeFlagApp={changeFlagApp}/>}></Route>
         <Route path={"/course/:id"} element={<Detail changeFlagApp={changeFlagApp} flagApp={flagApp} openModalLogin={openModalLogin}/>}></Route>
         <Route path={"/cart"} element={<Cart changeFlagApp={changeFlagApp}/>}></Route>
         <Route path={"/paymentSuccess"} element={<PurchasedSuccessfully changeFlagApp={changeFlagApp}/>}></Route>
         <Route path={"/order"} element={<Order changeFlagApp={changeFlagApp}/>}></Route>
     </Routes>
       <Footer/>
   </BrowserRouter>
       {isShowLogin && (<Login closeModalLogin={closeModalLogin} changeFlagApp={changeFlagApp}/>)}
       </UserDataProvider>
   </>
  );
}

export default App;
