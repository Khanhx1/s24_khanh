import "../../statics/css/Detail.css"
import {Link, useParams} from "react-router-dom";
import * as CourseService from "../../services/CourseService";
import {useEffect, useRef, useState} from "react";
import {Helmet} from "react-helmet";
import lockVideo from "../../statics/assets/detail_course/bg-video-lock.png"
import {Bounce, toast} from "react-toastify";

export function Detail({changeFlagApp, flagApp}) {

    const [course, setCourse] = useState();
    const [chapters, setChapters] = useState([]);
    const [categories, setCategories] = useState([]);
    const [currentChapter, setCurrentChapter] = useState("");
    const [isLockCourse, setIsLockCourse] = useState(false);
    const {id} = useParams();
    const videoSectionRef = useRef(null);

    const [statusDetail, setStatusDetail] = useState("original");


    useEffect(() => {
        getCourse();
    }, []);

    useEffect(() => {
        let token = localStorage.getItem("token");
        if (token) {
            checkCourseStatus();
        } else {
            setStatusDetail("original");
        }
    }, [flagApp]);

    const checkCourseStatus = async () => {
        try {
            const status = await CourseService.checkDetailStatus(id);
            setStatusDetail(status);
        } catch (e) {
            console.log(e);
        }
    }

    useEffect(() => {
        console.log(statusDetail);
    }, [statusDetail]);


    const handleAddToCart = async () => {
        try {
            let id = course.id;
            const res = await CourseService.addToCart(id);
            if (res) {
                changeFlagApp();
                toast.success('Added to cart', {
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

    const getCourse = async () => {
        try {
            const res = await CourseService.getCourseDetail(id);
            setCourse(res);
            let chapters = res.titleChapter.split(";");
            setChapters(chapters);
            setCurrentChapter(chapters[0]);
            let categories = res.categories.split(",");
            setCategories(categories);

        } catch (e) {
            console.log(e);
        }
    }

    const handleChangeChapter = (index) => {
        setCurrentChapter(chapters[index]);
        scrollToVideoSection();
        if (index == 0) {
            setIsLockCourse(false);
        } else {
            setIsLockCourse(true);
        }
    }

    const scrollToVideoSection = () => {
        if (videoSectionRef.current) {
            videoSectionRef.current.scrollIntoView({behavior: 'smooth'});
        }
    };


    let buttonCart;
    let exButtonCart;
    switch (statusDetail) {
        case "original":
            buttonCart = <button className="custom-add-to-cart" onClick={() => {
                handleAddToCart()
            }}>Add to cart
            </button>;
            exButtonCart = <></>;
            break;
        case "purchased":
            buttonCart = <button disabled={true} className="custom-add-to-cart-purchased">Purchased</button>;
            exButtonCart =
                <Link to={"/myCourse"} className="w-color-1 ex-btn-cart mx-3 d-flex align-items-center">go to your
                    course <span className="material-symbols-outlined"> navigate_next </span></Link>;
            break;
        case "cart":
            buttonCart = <button disabled={true} className="custom-add-to-cart-iyc">Added to cart</button>;
            exButtonCart = <div className="d-flex justify-content-center align-items-center"><Link to={"/cart"}
                                                                                                   className="w-color-1 ex-btn-cart mx-3 d-flex align-items-center">go
                to your cart <span className="material-symbols-outlined"> navigate_next </span> </Link></div>;
            break;
    }


    if (!course) {
        return (<div>Loading</div>)
    }
    return (
        <>
            <Helmet>
                <link rel="stylesheet"
                      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0"/>
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
                                <p className="custom-title-category">Instructor: {course.instructor}</p>
                            </div>

                            <div className="d-flex">
                                <p className="custom-title-category">Tags:</p>
                                <div>
                                    {
                                        categories.map((item, index) => (
                                            <p className="custom-category-detail" key={index}>{item}</p>
                                        ))
                                    }
                                </div>
                            </div>
                            <div className="mb-2">
                                <p className="custom-title-price">Price:</p>
                                <p className="custom-price-detail">${course.price}</p>
                            </div>

                            <div className="d-flex c-r-wrap">
                                {
                                    buttonCart
                                }
                                {
                                    exButtonCart
                                }

                            </div>

                            <div ref={videoSectionRef}></div>

                        </div>
                        <div className="col-lg-5 col-md-12 col-sm-12 px-4 item-2">
                            <img src={course.img} className="custom-img-detail"/>
                        </div>


                    </div>

                </div>

                <div className="se-detail">
                    <div className="se-detail-container col-7">
                        <div className="d-flex justify-content-center align-items-center col-12 mb-3">
                            <h3 className="w-color-1 w-wrap cus-title-video-detail">
                                {currentChapter}
                            </h3>
                        </div>
                        <div className="d-flex justify-content-center align-items-center mb-5">
                            {
                                isLockCourse ? (
                                    <div
                                        className="d-flex justify-content-center align-items-center position-relative ct-lock-video">
                                        <img
                                            src={lockVideo}
                                            className="cus-lock-video-detail position-relative"
                                        />
                                        <div className="position-absolute ct-content-lock-d">
                                            <div className="d-flex justify-content-center align-items-center">
                                                <span className="material-symbols-outlined w-color-1 c-l-i">lock</span>
                                            </div>
                                            <p className="title-lock-video-de">Please buy this course to unlock all
                                                lessons</p>
                                            <div className="d-flex justify-content-center align-items-center mt-3">
                                                <button className="unlock-btn">Unlock now</button>
                                            </div>
                                        </div>
                                    </div>
                                ) : (
                                    <video className="custom-video-detail" controls>
                                        <source src={course.videoDemo} type="video/mp4"/>
                                        Your browser does not support the video tag.
                                    </video>
                                )
                            }


                        </div>
                        <h4 className="d-flex justify-content-center">Lessons in this course</h4>
                        <h5>{chapters.length} lessons</h5>
                        {
                            course.titleChapter && (
                                chapters.map((item, index) => (
                                    <div className="d-flex block-title-chapter" key={index} onClick={() => {
                                        handleChangeChapter(index)
                                    }}>
                                        <p className="col-10">{index + 1 + ". " + item}</p>
                                        <div
                                            className="d-flex justify-content-end align-items-center px-2 custom-lock-detail col-2">
                                            {index == 0 ? (<></>) : (
                                                <span className="material-symbols-outlined">lock</span>
                                            )
                                            }
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