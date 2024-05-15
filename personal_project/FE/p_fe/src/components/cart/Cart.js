import {useEffect, useState} from "react";
import "../../statics/css/Cart.css"
import {Helmet} from "react-helmet";
import * as CartCourseService from "../../services/CartCourseService"
import {Link, useNavigate} from "react-router-dom";
import {Bounce, toast} from "react-toastify";

import {
    PayPalScriptProvider,
    PayPalButtons,
    usePayPalScriptReducer
} from "@paypal/react-paypal-js";
import {Checkout} from "../checkout/Checkout";
import {useUserData} from "../context/useUserData";



export function Cart({changeFlagApp}) {

    const [cart, setCart] = useState([]);
    const [totalCourse, setTotalCourse] = useState(0);
    const [isEmpty, setIsEmpty] = useState(false);
    const [totalPrice, setTotalPrice] = useState(0);
    const [flagCart, setFlagCart] = useState(false);
    const { userData, setUserData } = useUserData();
    const navigation = useNavigate();

//config paypal
    const initialOptions = {
        "client-id": "AQkVcfCC4gtSsWWfENoWhryiWDSJIi_6H8F4YHt5OGGLVjurFs8JkxyR4EgqNTItisPYgcZjrlMKJ0ie",
        currency: "USD",
        intent: "capture",
    };


    useEffect(() => {
        getCart();
    }, [flagCart]);


    const cleanAllCart = async () => {
        try {

            const res = await CartCourseService.cleanAllCart();
            if (res) {
                setFlagCart(!flagCart);
                navigation("/paymentSuccess");
            } else {
                console.log("loi r")
                toast.error('occur a error', {
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
            }

        } catch (e) {
            console.log(e);
        }
    }

    const getCart = async () => {
        try {
            const list = await CartCourseService.getCart();
            if (list) {
                if (list.length === 0) {
                    setIsEmpty(true);
                    setTotalCourse(0);
                    setTotalPrice(0);
                    changeFlagApp();
                } else {
                    setCart(list);
                    setTotalCourse(list.length);
                    setIsEmpty(false);
                    let total = 0;
                    for (let i = 0; i < list.length; i++) {
                        total += list[i].price;
                    }
                    setTotalPrice(total);
                    setUserData(total);
                    changeFlagApp();
                }
            } else {
                setIsEmpty(true);
            }

        } catch (e) {
            console.log(e);
        }
    }

    const handleRemoveCart = async (id) => {
        try {
            const res = await CartCourseService.deleteCartById(id);
            if (res) {
                changeFlagApp();
                setFlagCart(!flagCart);
                toast.success('Removed a course', {
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
            } else {
                toast.error('occur a error', {
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
            }
        } catch (e) {
            console.log(e);
        }
    }

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
                                    <p className="w-color-2 title-cart mx-3">Cart ({totalCourse} Courses)</p>
                                    <div>

                                        {
                                            isEmpty ?
                                                (
                                                    <p className="w-color-1 cus-empty-cart">Your cart is empty</p>
                                                ) : (
                                                    cart.map((item) => (
                                                        <div className="item-cart mx-3 mb-4" key={item.id}>
                                                            <div
                                                                className="d-flex justify-content-center ct-img-cart col-4 mt-4 mb-3">

                                                                <Link to={`/course/${item.id}`}>
                                                                    <img
                                                                        src={item.img}
                                                                        className="img-cart-item"
                                                                    />
                                                                </Link>

                                                            </div>
                                                            <div className="d-flex col-8 mt-4 mb-3 ct-right">
                                                                <div className="ps-3 col-8">
                                                                    <Link to={`/course/${item.id}`}
                                                                          className="w-color-2 w-bold p-content-cart mb-2 d-block">
                                                                        {item.name}
                                                                    </Link>

                                                                    <p className="w-color-2 p-content-cart mb-2">Instructor:
                                                                        {item.instructor}</p>
                                                                    <p className="w-color-2 p-content-cart mb-2">Tags:
                                                                        {item.categories}</p>

                                                                </div>
                                                                <div className="col-3 d-flex justify-content-end">
                                                                    <p className="w-color-2 p-content-cart mb-2">Price: <span>${item.price}</span>
                                                                    </p>
                                                                </div>

                                                                <div
                                                                    className="col-11 d-flex justify-content-end pt-2 ct-remove-cart">
                                                                    <span className="w-color-2 pe-2">Remove: </span>
                                                                    <span
                                                                        className="material-symbols-outlined cus-delete-cart"
                                                                        onClick={() => {
                                                                            handleRemoveCart(item.id)
                                                                        }}>delete</span>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    ))
                                                )
                                        }





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
                                                <span className="w-color-2 col-6 d-flex justify-content-end">${totalPrice}</span>
                                            </div>
                                            <div className="col-12 d-flex total-a mt-3 pt-2">
                                                <span className="w-color-2 col-6">Total Amount</span>
                                                <span className="w-color-2 col-6 d-flex justify-content-end">${totalPrice}</span>
                                            </div>

                                            <div
                                                className="col-12 btn-pay mt-4 d-flex justify-content-center align-items-center">
                                                Check out
                                            </div>
                                            {
                                                totalPrice != 0 ? (
                                                    <div className="mt-3">
                                                        <PayPalScriptProvider options={initialOptions}>
                                                            <Checkout cleanAllCart={cleanAllCart}/>
                                                        </PayPalScriptProvider>
                                                    </div>
                                                ):(<></>)
                                            }


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