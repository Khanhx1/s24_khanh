import "../../statics/css/Home.css"
import {Link} from "react-router-dom";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";
import {Avatar} from "@mui/material";
import {Header} from "../header/Header";


export function Home() {
    var settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        // autoplay: true,
        // autoplaySpeed: 2000
    };


    return (
        <>
            <div>

                <div className="section-1">
                    <div className="row">
                        <div className="col-12 text-center w-color">
                            <p>Get now</p>
                            <h1>Become MP</h1>
                            <Link to={"/course"} className="btn btn-warning mt-4 custom-btn-home-s1">Join now</Link>
                        </div>

                    </div>

                </div>

                <div className="se-home">
                    <p className="mx-5 text-center">Welcome to K Academy - where the passion for music transforms into
                        an
                        exciting
                        and promising career!
                        Here, we are committed to providing a professional and creative learning environment for those
                        who
                        aspire to become outstanding music producers.</p>
                </div>

                <div className="third-home">
                    <div className="d-flex">
                        <p className="third-card color-card-1">Why is it necessary to learn?</p>
                        <p className="third-card-ans">The music industry is booming and growing rapidly, with an
                            increasing
                            demand
                            for high-quality
                            music producers. Having in-depth knowledge and skills not only helps you bring your creative
                            ideas
                            to
                            life but also opens up opportunities for you to engage in a competitive and evolving
                            field.</p>
                    </div>

                    <div className="d-flex">
                        <p className="third-card color-card-2">Diverse Career Paths</p>
                        <p className="third-card-ans">Besides traditional music production, mastering these skills can
                            lead
                            to
                            various career paths such as sound engineering, composing for film and TV, audio editing,
                            and
                            even
                            video game music production.</p>
                    </div>

                    <div className="d-flex">
                        <p className="third-card color-card-3">Creative Fulfillment</p>
                        <p className="third-card-ans">Music production is a highly creative process that
                            allows you to express yourself artistically. It provides a sense of fulfillment and
                            satisfaction
                            as
                            you see your ideas come to life and impact others emotionally.</p>
                    </div>

                    <div className="d-flex">
                        <p className="third-card color-card-4">Adaptability and Innovation</p>
                        <p className="third-card-ans">The music industry is constantly evolving, with
                            new technologies and trends emerging regularly. By staying updated and continuously honing
                            your
                            skills, you can remain adaptable and innovative, ensuring longevity and relevance in your
                            career.
                        </p>
                    </div>


                </div>


                <div className="container-custom-slider">
                    <div className="custom-slider-home">
                        <div className="mx-3 custom-slider-home-ins">
                            <Slider {...settings}>
                                <div className="d-flex justify-content-center">
                                    <div>
                                        <div className="d-flex justify-content-center custom-avatar">
                                            <Avatar alt="Remy Sharp"
                                                    src="https://i.scdn.co/image/ab677762000056b802d0547a179c672721e0ab61"/>
                                        </div>
                                        <p>The music industry is constantly evolving, with new technologies and trends
                                            emerging
                                            regularly. By staying Music production is a highly creative process that
                                            allows
                                            you
                                            to express yourself artistically. It provides a sense of fulfillment and
                                            satisfaction as you see your ideas come to life and impact others
                                            emotionally.</p>
                                    </div>
                                </div>

                                <div className="d-flex justify-content-center">
                                    <div>
                                        <div className="d-flex justify-content-center custom-avatar">
                                            <Avatar alt="Remy Sharp"
                                                    src="https://i.scdn.co/image/ab67616100005174371632043a8c12bb7eeeaf9d"/>
                                        </div>
                                        <p>The music industry is constantly evolving, with new technologies and trends
                                            emerging
                                            regularly. By staying Music production is a highly creative process that
                                            allows
                                            you
                                            to express yourself artistically. It provides a sense of fulfillment and
                                            satisfaction as you see your ideas come to life and impact others
                                            emotionally.</p>
                                    </div>
                                </div>

                                <div className="d-flex justify-content-center">
                                    <div>
                                        <div className="d-flex justify-content-center custom-avatar">
                                            <Avatar alt="Remy Sharp"
                                                    src="https://i.scdn.co/image/ab6761610000e5eb5328c468cef8019bc41b63a8"/>
                                        </div>
                                        <p>The music industry is constantly evolving, with new technologies and trends
                                            emerging
                                            regularly. By staying Music production is a highly creative process that
                                            allows
                                            you
                                            to express yourself artistically. It provides a sense of fulfillment and
                                            satisfaction as you see your ideas come to life and impact others
                                            emotionally.</p>
                                    </div>
                                </div>

                                <div className="d-flex justify-content-center">
                                    <div>
                                        <div className="d-flex justify-content-center custom-avatar">
                                            <Avatar alt="Remy Sharp"
                                                    src="https://i.scdn.co/image/ab6775700000ee859a17b114db2b4d879901ed53"/>
                                        </div>
                                        <p>The music industry is constantly evolving, with new technologies and trends
                                            emerging
                                            regularly. By staying Music production is a highly creative process that
                                            allows
                                            you
                                            to express yourself artistically. It provides a sense of fulfillment and
                                            satisfaction as you see your ideas come to life and impact others
                                            emotionally.</p>
                                    </div>
                                </div>

                                <div className="d-flex justify-content-center">
                                    <div>
                                        <div className="d-flex justify-content-center custom-avatar">
                                            <Avatar alt="Remy Sharp"
                                                    src="https://media.socastsrm.com/wordpress/wp-content/blogs.dir/2212/files/2021/08/calvin-harris-1.jpg"/>
                                        </div>
                                        <p>The music industry is constantly evolving, with new technologies and trends
                                            emerging
                                            regularly. By staying Music production is a highly creative process that
                                            allows
                                            you
                                            to express yourself artistically. It provides a sense of fulfillment and
                                            satisfaction as you see your ideas come to life and impact others
                                            emotionally.</p>
                                    </div>
                                </div>
                            </Slider>
                        </div>
                    </div>
                </div>



            </div>
        </>
    )
}