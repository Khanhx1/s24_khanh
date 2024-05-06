import {useEffect, useState} from "react";
import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import "../../statics/css/Header.css"
import {Helmet} from "react-helmet";
import {Link, useNavigate} from "react-router-dom";

export function Header({openModalLogin, userLogin, quantityCart}) {
    const [isScrolled, setIsScrolled] = useState(false);
    const [nameCurrentUser, setNameCurrentUser] = useState(userLogin);
    const [cartNumber, setCartNumber] = useState(quantityCart);
    const [dropDownNonLogin, setDropDownNonLogin] = useState(false);
    const [dropDownLogin, setDropDownLogin] = useState(false);


    const navigation = useNavigate();

    //cách load lại component
    useEffect(() => {
        setNameCurrentUser(userLogin);
        setCartNumber(quantityCart);
    }, [userLogin, quantityCart]);


    const handleShowDropDown = () => {
        setDropDownLogin(!dropDownLogin);
    }

    const redirectToCart = () => {
        navigation("/cart");
    }

    useEffect(() => {
        const handleScroll = () => {
            const scrollTop = window.pageYOffset;
            // Kiểm tra nếu người dùng đã cuộn xuống từ đầu trang, thì đặt isScrolled thành true
            setIsScrolled(scrollTop > 0);
        };

        window.addEventListener('scroll', handleScroll);
        // Xóa bỏ event listener khi component unmount
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);


    return (
        <>
            <Helmet>
                <link rel="stylesheet"
                      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,1,0"/>
            </Helmet>

            <Navbar expand="lg" className={isScrolled ? "fixed-top s2k pt-3 pb-3" : "fixed-top s1k pt-3 pb-3"}>
                <Container>
                    <Navbar.Brand href="#home" className="k-brand">K Academy</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="align-items-lg-center ms-auto me-lg-5 head-tag">
                            <Nav.Link href="#">Course</Nav.Link>
                            <Nav.Link href="#">Free</Nav.Link>
                            <Nav.Link href="#">Guide</Nav.Link>
                            <Nav.Link href="#">About us</Nav.Link>
                            <Nav.Link href="#">Contact</Nav.Link>

                            <div className="position-relative ms-3 d-flex ">

                                {nameCurrentUser ? (
                                        <p className="login-btn-head d-flex justify-content-center align-items-center"
                                        onClick={()=>{handleShowDropDown()}}>
                                            {nameCurrentUser}
                                        </p>)
                                    : (<p
                                        className="login-btn-head d-flex justify-content-center align-items-center"
                                        onClick={() => {
                                            openModalLogin()
                                        }}>Login</p>)}

                                {
                                    dropDownLogin? (
                                        <div className="ct-dropdown-login">
                                            <p>My Course</p>
                                            <p>Info</p>
                                            <p>Order</p>
                                            <p>Logout</p>
                                        </div>
                                    ) : (<></>)
                                }
                            </div>


                            {
                                nameCurrentUser ? (<div className="ms-3 position-relative d-flex">
                                    <div className="d-flex justify-content-center align-items-center position-relative">

                                            <span
                                                className="material-symbols-outlined icon-cart-head" onClick={()=>{redirectToCart()}}>shopping_bag</span>

                                    </div>
                                    <div
                                        className="circle-cart-quan position-relative d-flex justify-content-center align-items-center">
                                        <p>{cartNumber}</p>
                                    </div>
                                </div>) : (<></>)
                            }

                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>


        </>
    )
}