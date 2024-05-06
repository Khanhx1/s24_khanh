import "../../statics/css/Login.css"
import {useEffect, useState} from "react";
import {Helmet} from "react-helmet";
import * as LoginService from "../../services/LoginService"
import {Bounce, toast} from "react-toastify";
export function Login({closeModalLogin, changeFlagApp}) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const [errorMessage, setErrorMessage] = useState('');

    const handleChangeUsername = (e) => {
        setUsername(e.target.value);
    }

    const handleChangePassword = (e) => {
        setPassword(e.target.value);
    }

    const handleLogin = async () => {
        try {
            const user = {username: username, password: password}
            const res = await LoginService.login(user);

            if (res) {
                localStorage.setItem("token", res.token);
                toast.success('Login successfully', {
                    position: "bottom-right",
                    autoClose: 1500,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "light",
                    transition: Bounce,
                });
                changeFlagApp();
                closeModalLogin();

            } else {
                setErrorMessage("Username or password is wrong");
            }
        } catch (e) {
            console.log(e);
        }
    }

    useEffect(() => {
        console.log("user " + username);
        console.log("pass " + password);
    }, [username, password]);
    return (
        <>
            <Helmet>
                <link rel="stylesheet"
                      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
            </Helmet>
            <div className="modal-login">
                <div className="modal-login-content col-8">

                    <div className="col-6 position-relative d-flex justify-content-center align-items-center">
                        <div className="background-login">
                        </div>
                        <div className="position-relative custom-text-login-left">
                            <p className="d-flex justify-content-start align-items-center custom-t-1">Welcome to K Academy</p>

                            <div className="d-flex justify-content-start align-items-center">
                                <div className="custom-br-login"></div>
                            </div>
                            <p className="d-flex justify-content-start align-items-center custom-t-2">Log in to continue to your account.</p>
                        </div>
                    </div>
                    <div className="col-6">
                        <div className="custom-close-btn-login d-flex justify-content-end">
                            <span className="material-symbols-outlined" onClick={() => {
                                closeModalLogin()
                            }}>close</span>
                        </div>
                        <h3 className="d-flex justify-content-center align-items-center custom-brand-login">K
                            Academy</h3>
                        <div className="login-input-container">
                            <div className="custom-login-input-cover">
                                <input type="text" className="custom-login-input-1"
                                       onChange={(event) => {
                                           handleChangeUsername(event)
                                       }} spellCheck={false}/>
                                <label
                                    className={username ? 'custom-label-login-username input-has-content-user' : 'custom-label-login-username'}>Username</label>
                            </div>

                            <div className="custom-login-input-cover">
                                <input type="password" className="custom-login-input-2" onChange={(event) => {
                                    handleChangePassword(event)
                                }} spellCheck={false}/>
                                <label
                                    className={password ? 'custom-label-login-password input-has-content-pass' : 'custom-label-login-password'}>Password</label>
                            </div>

                        </div>
                        <div>
                            <p>{errorMessage}</p>
                        </div>
                        <div className="d-flex justify-content-center align-items-center custom-btn-login-container">
                            <button className="custom-btn-login" onClick={()=>{handleLogin()}}>Login</button>
                        </div>
                        <div className="d-flex justify-content-center align-items-center custom-small-login-m">
                            <p>Don't have an account yet? <span>Sign up</span></p>
                        </div>
                    </div>


                </div>
            </div>
        </>
    )
}