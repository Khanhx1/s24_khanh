import {useState} from "react";
import "../../statics/css/Cart.css"
import {Helmet} from "react-helmet";


export function Cart() {

    const [cart, setCart] = useState([]);


    return (

        <>
            <Helmet>
                <link rel="stylesheet"
                      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
            </Helmet>


            <div className="container-cart">
                {/*<div className="head-cart">*/}
                {/*</div>*/}
                <div className="d-flex justify-content-center align-items-center ct-content-cart">
                    <div className="col-10">
                        <div className="content-cart pt-4 mb-5">
                            <div className="col-8 left-cart px-4">
                                <div>
                                    <p className="w-color-2 title-cart mx-3">Cart (2 Courses)</p>
                                    <div>
                                        <div className="item-cart mx-3 mb-4">
                                            <div className="d-flex justify-content-center ct-img-cart col-4 my-4">
                                                <img
                                                    src="https://store-images.s-microsoft.com/image/apps.54355.14047496556148589.c22f253d-c9b9-4f11-aee9-75e0ca6ecf73.b40d5201-dd16-4abb-bc50-bd538df83c03"
                                                    className="img-cart-item"
                                                />
                                            </div>
                                            <div className="d-flex col-8 my-4 ct-right">
                                                <div className="ps-3 col-8">
                                                    <p className="w-color-2 w-bold p-content-cart mb-2">Ori and b</p>
                                                    <p className="w-color-2 p-content-cart mb-2">Instructor: khanh</p>
                                                    <p className="w-color-2 p-content-cart mb-2">Tags: Course</p>

                                                </div>
                                                <div className="col-3 d-flex justify-content-end">
                                                    <p className="w-color-2 p-content-cart mb-2">Price: <span>100$</span>
                                                    </p>
                                                </div>

                                                <div className="col-11 d-flex justify-content-end pt-2 ct-remove-cart">
                                                    <span className="w-color-2 pe-2">Remove: </span> <span
                                                    className="material-symbols-outlined cus-delete-cart">delete</span>
                                                </div>
                                            </div>

                                        </div>


                                        <div className="item-cart mx-3 mb-4">
                                            <div className="d-flex justify-content-center ct-img-cart col-4 my-4">
                                                <img
                                                    src="https://store-images.s-microsoft.com/image/apps.54355.14047496556148589.c22f253d-c9b9-4f11-aee9-75e0ca6ecf73.b40d5201-dd16-4abb-bc50-bd538df83c03"
                                                    className="img-cart-item"
                                                />
                                            </div>
                                            <div className="d-flex col-8 my-4 ct-right">
                                                <div className="ps-3 col-8">
                                                    <p className="w-color-2 w-bold p-content-cart mb-2">Ori and b</p>
                                                    <p className="w-color-2 p-content-cart mb-2">Instructor: khanh</p>
                                                    <p className="w-color-2 p-content-cart mb-2">Tags: Course</p>

                                                </div>
                                                <div className="col-3 d-flex justify-content-end">
                                                    <p className="w-color-2 p-content-cart mb-2">Price: <span>100$</span>
                                                    </p>
                                                </div>

                                                <div className="col-11 d-flex justify-content-end pt-2 ct-remove-cart">
                                                    <span className="w-color-2 pe-2">Remove: </span> <span
                                                    className="material-symbols-outlined cus-delete-cart">delete</span>
                                                </div>
                                            </div>

                                        </div>


                                    </div>
                                </div>
                            </div>
                            <div className="col-4 right-cart">
                                <div>
                                    <p className="w-color-2 title-total-cart">Payment Summary</p>
                                    <div className="payment-content me-4">
                                        <div className="ins-payment-content col-12 px-5 pt-4">
                                            <div className="col-12 d-flex">
                                                <span className="w-color-2 col-6">Order Summary</span>
                                                <span className="w-color-2 col-6 d-flex justify-content-end">12$</span>
                                            </div>
                                            <div className="col-12 d-flex total-a mt-3 pt-2">
                                                <span className="w-color-2 col-6">Total Amount</span>
                                                <span className="w-color-2 col-6 d-flex justify-content-end">12$</span>
                                            </div>

                                            <div
                                                className="col-12 btn-pay mt-4 d-flex justify-content-center align-items-center">
                                                Check out
                                            </div>
                                            <div
                                                className="col-12 btn-paypal mt-3 d-flex justify-content-center align-items-center">
                                                PayPal
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </>

    )
}