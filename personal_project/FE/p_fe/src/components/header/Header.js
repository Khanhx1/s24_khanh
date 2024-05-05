import {useEffect, useState} from "react";
import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import "../../statics/css/Header.css"

export function Header({openModalLogin, userLogin}) {
    const [isScrolled, setIsScrolled] = useState(false);
    const [nameCurrentUser, setNameCurrentUser] = useState(userLogin);
    const [dropDownNonLogin, setDropDownNonLogin] = useState(false);
    const [dropDownLogin, setDropDownLogin] = useState(false);

    useEffect(() => {
        setNameCurrentUser(userLogin);
    }, [userLogin]);


    const handleShowDropDown = () => {
        setDropDownLogin(!dropDownLogin);
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

                            <div className="position-relative ms-3 d-flex justify-content-center">

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
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>


        </>
    )
}