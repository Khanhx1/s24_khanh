import {Link} from "react-router-dom";
import {useEffect} from "react";

export function PurchasedSuccessfully({changeFlagApp}) {

    useEffect(() => {
        changeFlagApp();
    }, []);

    return (
        <>
            <div className="d-flex justify-content-center align-items-center kpp">
                <p className="col-12 d-flex justify-content-center align-items-center">Payment successfull</p>
                <div className="col-12 d-flex justify-content-center align-items-center">
                    <Link to={"/course"}>Continue to
                        our
                        courses</Link>
                </div>
                <div className="col-12 d-flex justify-content-center align-items-center">
                    <Link to={"/"}>Back to home
                        page</Link>
                </div>

            </div>


        </>
    )
}