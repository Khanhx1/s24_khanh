import "../../statics/css/Home.css"
import {Link} from "react-router-dom";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import Slider from "react-slick";


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


    return(
        <>
            <div className="section-1">
                <div className="row">
                    <div className="col-12 text-center w-color">
                        <p>Get now</p>
                        <h1>Become MP</h1>
                        <Link to={"/"} className="btn btn-warning mt-4 custom-btn-home-s1">Join now</Link>
                    </div>

                </div>

            </div>

            <div className="se-home">
                <p className="mx-5 text-center">Welcome to K Academy - where the passion for music transforms into an
                    exciting
                    and promising career!
                    Here, we are committed to providing a professional and creative learning environment for those who
                    aspire to become outstanding music producers.</p>
            </div>

            <div className="third-home">
                <div className="d-flex">
                    <p className="third-card color-card-1">Why is it necessary to learn?</p>
                    <p className="third-card-ans">The music industry is booming and growing rapidly, with an increasing
                        demand
                        for high-quality
                        music producers. Having in-depth knowledge and skills not only helps you bring your creative
                        ideas
                        to
                        life but also opens up opportunities for you to engage in a competitive and evolving field.</p>
                </div>

                <div className="d-flex">
                    <p className="third-card color-card-2">Diverse Career Paths</p>
                    <p className="third-card-ans">Besides traditional music production, mastering these skills can lead
                        to
                        various career paths such as sound engineering, composing for film and TV, audio editing, and
                        even
                        video game music production.</p>
                </div>

                <div className="d-flex">
                    <p className="third-card color-card-3">Creative Fulfillment</p>
                    <p className="third-card-ans">Music production is a highly creative process that
                        allows you to express yourself artistically. It provides a sense of fulfillment and satisfaction
                        as
                        you see your ideas come to life and impact others emotionally.</p>
                </div>

                <div className="d-flex">
                    <p className="third-card color-card-4">Adaptability and Innovation</p>
                    <p className="third-card-ans">The music industry is constantly evolving, with
                        new technologies and trends emerging regularly. By staying updated and continuously honing your
                        skills, you can remain adaptable and innovative, ensuring longevity and relevance in your
                        career.
                    </p>
                </div>


            </div>

            <div className="custom-slider-home">
                <div className="mx-3">
                <Slider {...settings}>
                    <div className="d-flex justify-content-center">
                        <h3>1</h3>
                    </div>
                    <div>
                        <h3>2</h3>
                    </div>
                    <div>
                        <h3>3</h3>
                    </div>
                    <div>
                        <h3>4</h3>
                    </div>
                    <div>
                        <h3>5</h3>
                    </div>
                    <div>
                        <h3>6</h3>
                    </div>
                </Slider>
                </div>
            </div>


        </>
    )
}