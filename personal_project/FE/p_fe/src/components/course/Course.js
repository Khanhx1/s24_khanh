import "../../statics/css/Course.css";
import {Link, useLocation, useNavigate} from "react-router-dom";
import * as CourseService from "../../services/CourseService";
import {useEffect, useState} from "react";
import {grey} from '@mui/material/colors';
import Checkbox from '@mui/material/Checkbox';
import ReactPaginate from "react-paginate";
import {Helmet} from "react-helmet";


export function Course() {
    const [courses, setCourses] = useState([]);
    const [searchCategory, setSearchCategory] = useState([]);
    const [categories, setCategories] = useState([]);
    const [nameSearch, setNameSearch] = useState("");
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState();
    const labelMui = {inputProps: {'aria-label': 'Checkbox demo'}};

    const [doS, setDoS] = useState(false);
    const [sort, setSort] = useState("");

    const navigate = useNavigate();
    const location = useLocation();



    useEffect(() => {
        getList(page, nameSearch, sort, searchCategory);

    }, [page, doS]);

    useEffect(() => {
        getCategories();
    }, []);
    const handleSearchName = () => {
        // Cập nhat URL với các bộ lọc mới
        // const queryParams = new URLSearchParams();
        // queryParams.append('name', nameSearch);
        // navigate({ search: queryParams.toString() });


        setDoS(!doS);
    }

    const getCategories = async () => {
        try {
            const list = await CourseService.getCategories();
            setCategories(list);
        }catch (e) {
            console.log(e);
        }
    }

    const handleChangeSort = (event) => {
        setSort(event.target.value);
        setPage(0);
    }

    const handleChangeNameSearch = (event) => {
        setNameSearch(event.target.value);
        setPage(0);
    }

    const handleCheckBoxFilter = (event) => {

        const value = event.target.value;
        const isChecked = event.target.checked;

        let list = [...searchCategory];
        if (list.includes(value) && !isChecked) {
            console.log("remove")
            list = list.filter(item => item !== value);
        } else if (!list.includes(value) && isChecked) {
            console.log("add")
            list.push(event.target.value);
        }
        setSearchCategory(list);
        setPage(0);
    }

    useEffect(() => {
        console.log(`cate ${searchCategory}`);
        console.log(`name ${nameSearch}`);
        console.log(`sort ${sort}`);
    }, [searchCategory, nameSearch, sort]);
    const getList = async (page, nameSearch, sort, searchCategory) => {
        try {
            console.log(nameSearch);
            const res = await CourseService.getAll(page, nameSearch, sort, searchCategory);
            setCourses(res.content);
            setTotalPages(res.totalPages);
        } catch (e) {
            console.log(e);
        }
    }

    const handlePageClick = (event) => {
        const currentPage = event.selected;
        setPage(currentPage);
    }

    return (
        <>
            <Helmet>
                <link rel="stylesheet"
                      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0"/>
            </Helmet>
            <div>


                <div className="head-course">
                    <div>
                        <div className="cus-head-content d-flex justify-content-center col-12">

                            <div className="col-12 d-flex justify-content-end align-items-center c-b-1">
                                <div className="cus-ban-1 col-lg-10 col-md-12 col-sm-12 col-12 mt-5">

                                </div>
                                <div className="col-lg-1 col-md-12 col-sm-12 col-12">

                                </div>
                            </div>

                            <div className="side-bar col-3 d-flex justify-content-start justify-content-lg-end">
                                <div className="col-lg-8 col-md-10 col-sm-12 content-filter">
                                    <div>
                                        <h4 className="w-color-2 d-flex justify-content-center align-items-center title-filter-course pb-3">Course
                                            filter</h4>
                                    </div>
                                    <div className="pt-2">
                                        <div>
                                            <p className="w-color-2 w-bold">Tags:</p>
                                        </div>



                                        {
                                            categories.map((item) => (
                                                <label className="d-flex align-items-center" key={item.id}>
                                                    <Checkbox
                                                        {...labelMui}
                                                        sx={{
                                                            color: grey[100],
                                                            '&.Mui-checked': {
                                                                color: grey[100],
                                                            },
                                                        }}
                                                        value={item.name}
                                                        onClick={(event) => {
                                                            handleCheckBoxFilter(event)
                                                        }}
                                                    />
                                                    <span className="w-color-2 w-filter-c">{item.name}</span>
                                                </label>
                                            ))
                                        }

                                    </div>
                                </div>
                            </div>
                            <div className="primary-content-course col-8">
                                <div className="filter-p">
                                    <div className="container-filter-2 justify-content-lg-end justify-content-sm-start">

                                        <div
                                            className="d-flex justify-content-center align-items-center block-filter mb-3">
                                            <span className="d-flex align-items-center">Sort by</span>
                                            <select name="category" className="custom-select-search"
                                                    onChange={(event) => {
                                                        handleChangeSort(event)
                                                    }}>
                                                <option value="">---</option>
                                                <option value="popular">Popular</option>
                                                <option value="newest">Newest</option>
                                                <option value="lowestPrice">Lowest price</option>
                                                <option value="highestPrice">Highest price</option>
                                            </select>
                                        </div>

                                        <div
                                            className="d-flex justify-content-center align-items-center block-filter mb-3">
                                            <input type="text" className="custom-text-search" spellCheck="false"
                                                   placeholder="Type to search" onChange={(event) => {handleChangeNameSearch(event)}}/>
                                            <button className="custom-btn-search-light" onClick={() => {handleSearchName()}}>Search</button>

                                        </div>


                                    </div>

                                </div>

                                <div className="d-flex align-items-center k-row k-product-course container">


                                    {
                                        courses.map((item) => (
                                            <div className="col-md-4 col-lg-4 px-3 mb-3 custom-card-course"
                                                 key={item.id}>
                                                <div className="container-img-p">
                                                    <Link to={`/course/${item.id}`}><img
                                                        src={item.img}
                                                        className="img-fluid custom-img" alt="..."/></Link>

                                                    <div className="overlay-card"></div>
                                                </div>

                                                <div>
                                                    <Link to={`/course/${item.id}`}
                                                          className="cus-title-card">{item.name}</Link>
                                                    <div className="d-flex align-items-center">
                                                        <span className="material-symbols-outlined c-user-i">person</span>
                                                        <p className="cus-t-user">{item.totalUser} Students</p>
                                                    </div>

                                                    <p className="custom-price-p"><span>${item.price}</span></p>

                                                </div>
                                            </div>
                                        ))
                                    }


                                </div>
                            </div>

                            <div className="col-1"></div>
                            <div className="col-12 d-flex align-items-center">
                                <div className="col-3"></div>
                                <div className="col-8 d-flex justify-content-center align-items-center">
                                    <ReactPaginate
                                        nextLabel=">"
                                        onPageChange={handlePageClick}
                                        pageRangeDisplayed={3}
                                        marginPagesDisplayed={2}
                                        pageCount={totalPages}
                                        previousLabel="<"
                                        pageClassName="page-item"
                                        pageLinkClassName="page-link"
                                        previousClassName="page-item"
                                        previousLinkClassName="page-link"
                                        nextClassName="page-item"
                                        nextLinkClassName="page-link"
                                        breakLabel="..."
                                        breakClassName="page-item"
                                        breakLinkClassName="page-link"
                                        containerClassName="pagination"
                                        activeClassName="active"
                                        renderOnZeroPageCount={null}
                                    />
                                </div>
                                <div className="col-1"></div>


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