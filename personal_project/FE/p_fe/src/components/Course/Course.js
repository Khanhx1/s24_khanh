import "../../statics/css/Course.css";
import {Link} from "react-router-dom";

export function Course() {



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

                                <div className="col-md-4 col-lg-3 px-3 mb-3 custom-card-course">
                                    <div className="container-img-p">
                                        <Link to={"/"}><img
                                            src="https://store-images.s-microsoft.com/image/apps.54355.14047496556148589.c22f253d-c9b9-4f11-aee9-75e0ca6ecf73.b40d5201-dd16-4abb-bc50-bd538df83c03"
                                            className="img-fluid custom-img" alt="..."/></Link>

                                        <div className="overlay-card"></div>
                                    </div>

                                    <div>
                                        <Link to={"/"} className="cus-title-card">Basic programming</Link>
                                        <p className="custom-price-p"><span>$45</span></p>
                                    </div>
                                </div>


                                <div className="col-md-4 col-lg-3 px-3 mb-3 custom-card-course">
                                    <div className="container-img-p">
                                        <Link to={"/"}><img
                                            src="https://i1.sndcdn.com/artworks-000112232009-4tdcw3-t500x500.jpg"
                                            className="img-fluid custom-img" alt="..."/></Link>

                                        <div className="overlay-card"></div>
                                    </div>

                                    <div>
                                        <Link to={"/"} className="cus-title-card">Basic programming</Link>
                                        <p className="custom-price-p"><span>$45</span></p>
                                    </div>
                                </div>
                                <div className="col-md-4 col-lg-3 px-3 mb-3 custom-card-course">
                                    <div className="container-img-p">
                                        <Link to={"/"}><img
                                            src="https://images.pexels.com/photos/4028878/pexels-photo-4028878.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                                            className="img-fluid custom-img" alt="..."/></Link>

                                        <div className="overlay-card"></div>
                                    </div>

                                    <div>
                                        <Link to={"/"} className="cus-title-card">Basic programming</Link>
                                        <p className="custom-price-p"><span>$45</span></p>
                                    </div>
                                </div>
                                <div className="col-md-4 col-lg-3 px-3 mb-3 custom-card-course">
                                    <div className="container-img-p">
                                        <Link to={"/"}><img
                                            src="https://images.pexels.com/photos/164879/pexels-photo-164879.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                                            className="img-fluid custom-img" alt="..."/></Link>

                                        <div className="overlay-card"></div>
                                    </div>

                                    <div>
                                        <Link to={"/"} className="cus-title-card">Basic programming</Link>
                                        <p className="custom-price-p"><span>$45</span></p>
                                    </div>
                                </div>
                                <div className="col-md-4 col-lg-3 px-3 mb-3 custom-card-course">
                                    <div className="container-img-p">
                                        <Link to={"/"}><img
                                            src="https://images.pexels.com/photos/164935/pexels-photo-164935.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                                            className="img-fluid custom-img" alt="..."/></Link>

                                        <div className="overlay-card"></div>
                                    </div>

                                    <div>
                                        <Link to={"/"} className="cus-title-card">Basic programming</Link>
                                        <p className="custom-price-p"><span>$45</span></p>
                                    </div>
                                </div>


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