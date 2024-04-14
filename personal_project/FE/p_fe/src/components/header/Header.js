import {useEffect, useState} from "react";
import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import "../../statics/css/Header.css"

export function Header() {
    const [isScrolled, setIsScrolled] = useState(false);

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
            <Navbar expand="lg" className={isScrolled ? "fixed-top s2k pt-3 pb-3": "fixed-top s1k pt-3 pb-3"} >
                <Container>
                    <Navbar.Brand href="#home" className="k-brand">K Academy</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="align-items-lg-center ms-auto me-lg-5 head-tag">
                            <Nav.Link href="#">Course</Nav.Link>
                            <Nav.Link href="#">Free</Nav.Link>
                            <Nav.Link href="#">Guide</Nav.Link>
                            <Nav.Link href="#">About us</Nav.Link>
                            <Nav.Link href="#">Contact</Nav.Link>
                            {/*<NavDropdown title="Dropdown" id="basic-nav-dropdown">*/}
                            {/*    <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>*/}
                            {/*    <NavDropdown.Item href="#action/3.2">*/}
                            {/*        Another action*/}
                            {/*    </NavDropdown.Item>*/}
                            {/*    <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>*/}
                            {/*    <NavDropdown.Divider />*/}
                            {/*    <NavDropdown.Item href="#action/3.4">*/}
                            {/*        Separated link*/}
                            {/*    </NavDropdown.Item>*/}
                            {/*</NavDropdown>*/}
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>




        </>
    )
}