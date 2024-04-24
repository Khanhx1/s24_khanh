import "../../statics/css/Detail.css"
import {useParams} from "react-router-dom";
import * as CourseService from "../../services/CourseService";
import {useEffect, useState} from "react";
import {Helmet} from "react-helmet";

export function Detail() {

    const [course, setCourse] = useState();
    const [chapters, setChapters] = useState([]);
    const {id} = useParams();

    useEffect(() => {
        getCourse();
    }, []);

    const getCourse = async () => {
        try {
            const res = await CourseService.getCourseDetail(id);
            setCourse(res);
            let chapters = res.titleChapter.split(";");
            setChapters(chapters);

        } catch (e) {
            console.log(e);
        }
    }
    if (!course) {
        return (<div>Loading</div>)
    }
    return (
        <>
            <Helmet>
                <link rel="stylesheet"
                      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
            </Helmet>

            <div className="container-course-detail">
                <div className="bg-content-detail" style={{backgroundImage: `url("${course.img}")`}}>
                </div>

                <div className="content-detail">
                    <div className="content-detail-1">
                        <div className="col-lg-7 col-md-12 col-sm-12 px-4 item-1">
                            <h2 className="custom-title-detail">{course.name}</h2>
                            <p className="description-content-detail">{course.description}</p>

                            <div>
                                <p>Instructor: {course.instructor}</p>
                            </div>

                            <div className="mb-2">
                                <p className="custom-title-category">Tags:</p>
                                <p className="custom-category-detail">{course.category.name}</p>
                            </div>
                            <div className="mb-2">
                                <p className="custom-title-price">Price:</p>
                                <p className="custom-price-detail">${course.price}</p>
                            </div>
                            <div>
                                <button className="custom-add-to-cart">Add to cart</button>
                            </div>

                        </div>
                        <div className="col-lg-5 col-md-12 col-sm-12 px-4 item-2">
                            <img src={course.img} className="custom-img-detail"/>
                        </div>


                    </div>

                </div>

                <div className="se-detail">
                    <div className="se-detail-container col-7">
                        <h4 className="d-flex justify-content-center">Lessons in this course</h4>
                        <h5>{chapters.length} lessons</h5>
                        {
                            course.titleChapter && (
                                chapters.map((item, index) => (
                                    <div className="d-flex block-title-chapter" key={index}>
                                        <p className="col-10">{index + 1 + ". " + item}</p>
                                        <div className="d-flex justify-content-end align-items-center px-2 custom-lock-detail col-2">
                                            <span className="material-symbols-outlined">lock</span>
                                        </div>
                                    </div>
                                ))
                            )
                        }
                    </div>

                </div>

                <div className="third-detail d-flex justify-content-center">
                    <div className="extra-description px-2 col-9">
                        <h2 className="mb-5">About this course</h2>
                        <div className="d-flex justify-content-center align-items-center mb-5">
                            <img src={course.img} className="custom-img-extra-description"/>
                        </div>
                        <p>{course.extraDescription}</p>
                        <p>{course.description}</p>
                        <p>Instructor: {course.instructor}</p>
                        <p>Target lesson: {course.targetLesson}</p>
                    </div>
                </div>

                <div className="four-detail d-flex justify-content-center">
                    <div className="recommendation-detail col-9 pb-4">
                        <h3>Recommend</h3>

                    </div>

                </div>

            </div>
        </>
    )
}