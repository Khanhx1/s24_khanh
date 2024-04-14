import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Header} from "./components/header/Header";
import {Footer} from "./components/footer/Footer";
import {Home} from "./components/home/Home";
import "bootstrap/dist/css/bootstrap.css";
function App() {
  return (
   <>
<Header/>
   <BrowserRouter>
     <Routes>

       <Route path={"/"} element={<Home/>}></Route>

     </Routes>
   </BrowserRouter>
<Footer/>

   </>
  );
}

export default App;
