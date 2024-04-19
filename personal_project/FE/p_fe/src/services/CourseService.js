import axios from "axios";

export const getAll = async () => {
    try {
        const res = await axios.get("http://localhost:8080/api/course");
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