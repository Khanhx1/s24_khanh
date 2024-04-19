import "../../statics/css/Course.css";
import {Link} from "react-router-dom";
import * as CourseService from "../../services/CourseService";
import {useEffect, useState} from "react";
export function Course() {
    const [courses, setCourses] = useState([]);

    useEffect(() => {
        getList();
    }, []);

    const getList = async () => {
        try {
            const res = await CourseService.getAll();
            setCourses(res.content);
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <>
            <div>


                <div className="head-course">
                    <div>
                        <div className="cus-head-content">
                            <div className="filter-p">
                                <div className="container">
                                    <input type="text" className="custom-text-search" spellCheck="false" placeholder="Type to search"/>
                                    <button className="custom-btn-search-light">Search</button>

                                    <select name="category" className="custom-select-search">
                                        <option>---category---</option>
                                        <option>film</option>
                                        <option>game</option>
                                    </select>
                                </div>

                            </div>

                            <div className="d-flex align-items-center k-row k-product-course container">


                                {
                                    courses.map((item) => (
                                        <div className="col-md-4 col-lg-3 px-3 mb-3 custom-card-course" key={item.id}>
                                            <div className="container-img-p">
                                                <Link to={`/course/${item.id}`}><img
                                                    src={item.img}
                                                    className="img-fluid custom-img" alt="..."/></Link>

                                                <div className="overlay-card"></div>
                                            </div>

                                            <div>
                                                <Link to={`/course/${item.id}`} className="cus-title-card">{item.name}</Link>
                                                <p className="custom-price-p"><span>${item.price}</span></p>
                                            </div>
                                        </div>
                                    ))
                                }


                            </div>


                        </div>
                    </div>
                </div>

                <div>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                    <p>k</p>
                </div>


            </div>
        </>
    )
}