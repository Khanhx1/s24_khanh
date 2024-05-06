import {axiosCof} from "../config/axios-config";

export const getCart = async () => {
    try {
        const res = await axiosCof.get(`http://localhost:8080/api/cart`);
        console.log(res.data)
        return res.data;
    }catch (e) {
        console.log(e);
    }
}