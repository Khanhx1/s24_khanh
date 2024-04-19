import "../../statics/css/Detail.css"
import {useParams} from "react-router-dom";
import * as CourseService from "../../services/CourseService";
import {useEffect, useState} from "react";

export function Detail() {

    const [course, setCourse] = useState();
    const {id} = useParams();

    useEffect(() => {
        getCourse();
    }, []);

    const getCourse = async () => {
        try {
            const res = await CourseService.getCourseDetail(id);
            setCourse(res);
        }catch (e){
            console.log(e);
        }
    }
    if(!course) {return (<div>Loading</div>)}
    return (
        <>

            <div className="container-course-detail">
                <div className="bg-content-detail" style={{backgroundImage: `url("${course.img}")`}}>
                </div>

                <div className="content-detail">
                    <div className="content-detail-1">
                        <div className="col-7 mx-4">
                            <h2>{course.name}</h2>
                            <p className="description-content-detail">{course.description}</p>
                            <div className="mb-2">
                                <p className="custom-category-detail">{course.category.name}</p>
                            </div>
                            <div className="mb-2">
                            <p className="custom-price-detail">${course.price}</p>
                            </div>
                            <div>
                                <button className="custom-add-to-cart">Add to cart</button>
                            </div>
                        </div>
                        <div className="col-5 mx-4">
                        <img src={course.img} className="custom-img-detail"/>
                        </div>
                    </div>

                </div>
            </div>
        </>
    )
}