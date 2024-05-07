import axios from "axios";
import {axiosCof} from "../config/axios-config";

export const getAll = async (page, nameSearch, sort, searchCategory) => {
    try {
        const category = searchCategory.sort().join(',');
        console.log(category)
        console.log(nameSearch)
        const res = await axiosCof.get(`http://localhost:8080/api/course?page=${page}&name=${nameSearch}&sort=${sort}&category=${category}`);
        return res.data;
    }catch (e) {
        console.log(e);
    }
}

export const getCourseDetail = async (id) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/course/detail/${id}`);
        console.log("service");
        console.log(res.data)
        return res.data;
    }catch (e) {
        console.log(e);
    }
}

export const getCategories = async () => {
    try {
        const res = await axios.get(`http://localhost:8080/api/category`);
        console.log(res.data)
        return res.data;
    }catch (e) {
        console.log(e);
    }
}

export const addToCart = async (id) => {
    try {
        const res = await axiosCof.get(`http://localhost:8080/api/cart/save?id=${id}`);
        console.log(res.data)
        return res.data;
    }catch (e) {
        console.log(e);
    }
}

export const checkDetailStatus = async (id) => {
    try {
        const res = await axiosCof.get(`http://localhost:8080/api/cart/checkCourseStatus?id=${id}`);
        console.log(res.data)
        return res.data;
    }catch (e) {
        console.log(e);
    }
}