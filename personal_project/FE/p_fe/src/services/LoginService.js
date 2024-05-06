import axios from "axios";
import {axiosCof} from "../config/axios-config";

export const login = async (user) => {
    try {
        const res = await axios.post(`http://localhost:8080/api/auth/login`, user);
        return res.data;
    } catch (e) {
        console.log(e);
    }
}

export const getInfo = async (token) => {
    try {
        const res = await axiosCof.get(`http://localhost:8080/api/auth/getInfoCart`, token);
        console.log(res.data)
        return res.data;
    } catch (e) {
        console.log(e);
    }
}