import {useState} from "react";
import "../../statics/css/Cart.css"


export function Cart() {

    const [cart, setCart] = useState([]);


    return (

        <>
            <div className="container-cart">
                {/*<div className="head-cart">*/}
                {/*</div>*/}
                <div className="d-flex justify-content-center align-items-center ct-content-cart">
                    <div className="col-10">
                        <div className="content-cart pt-4 mb-5">
                            <div className="col-8 left-cart px-4">
                                <div>
                                    <p className="w-color-2 title-cart mx-3">Cart</p>
                                    <div>
                                        <div className="item-cart mx-3">
                                            <div className="d-flex justify-content-center align-items-center">
                                                <img
                                                    src="https://store-images.s-microsoft.com/image/apps.54355.14047496556148589.c22f253d-c9b9-4f11-aee9-75e0ca6ecf73.b40d5201-dd16-4abb-bc50-bd538df83c03"
                                                    className="img-cart-item"
                                                />
                                            </div>
                                            <div className="ps-3 pt-3">
                                                <p className="w-color-2 w-bold p-content-cart mb-2">Ori and b</p>
                                                <p className="w-color-2 p-content-cart mb-2">Instructor: khanh</p>
                                                <p className="w-color-2 p-content-cart mb-2">Tags: Course</p>
                                                <p className="w-color-2 p-content-cart mb-2">Price: 100</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-4 right-cart">
                                <div>
                                    <p className="w-color-2 title-total-cart">Payment Summary</p>
                                    <div className="payment-content me-4">

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