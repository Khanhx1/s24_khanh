import "../../statics/css/Login.css"

export function Login() {


    return (
        <>
            <div className="modal-login">
                <div className="modal-login-content col-7">
                    <div className="col-6">
                        <div className="background-login">

                        </div>
                    </div>
                    <div className="col-6">
                        <h3 className="d-flex justify-content-center align-items-center custom-brand-login">K Academy</h3>
                        <div className="login-input-container">
                            <div className="custom-login-input-cover">
                                <input type="text" placeholder="Username" className="custom-login-input"/>
                            </div>

                            <div className="custom-login-input-cover">
                                <input type="password" placeholder="Password" className="custom-login-input"/>
                            </div>

                        </div>
                        <div className="d-flex justify-content-center align-items-center custom-btn-login-container">
                            <button className="custom-btn-login">Login</button>
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