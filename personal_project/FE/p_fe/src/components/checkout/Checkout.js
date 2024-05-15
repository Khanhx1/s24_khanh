import { PayPalButtons, usePayPalScriptReducer } from "@paypal/react-paypal-js";
import {useEffect, useState} from "react";
import {useUserData} from "../context/useUserData";
import {Bounce, toast} from "react-toastify";
import {useNavigate} from "react-router-dom";

export const Checkout = ({cleanAllCart}) => {

    console.log("load trang")
    const [{ options, isPending }, dispatch] = usePayPalScriptReducer();
    const [currency, setCurrency] = useState(options.currency);
    const { userData } = useUserData();
    const navigation = useNavigate();



    // const onCurrencyChange = ({ target: { value } }) => {
    //     setCurrency(value);
    //     dispatch({
    //         type: "resetOptions",
    //         value: {
    //             ...options,
    //             currency: value,
    //         },
    //     });
    // }

    const onCreateOrder = (data,actions) => {
        console.log(userData);
        return actions.order.create({
            purchase_units: [
                {
                    amount: {
                        value: userData
                    },
                },
            ],
        });
    }

    const onApproveOrder = (data,actions) => {
        return actions.order.capture().then((details) => {
            const name = details.payer.name.given_name;
            cleanAllCart();

        });
    }

    return (
        <div className="checkout">
            {isPending ? <p>LOADING...</p> : (
                <>
                    {/*<select value={currency} onChange={onCurrencyChange}>*/}
                    {/*    <option value="USD">USD</option>*/}
                    {/*    <option value="EUR">Euro</option>*/}
                    {/*</select>*/}
                    <PayPalButtons
                        style={{ layout: "vertical" }}
                        createOrder={(data, actions) => onCreateOrder(data, actions)}
                        onApprove={(data, actions) => onApproveOrder(data, actions)}
                    />
                </>
            )}
        </div>
    );
}