import { Navbar, Nav, Container } from "react-bootstrap";
import Dropdown from "react-bootstrap/Dropdown";
import { GiHamburgerMenu } from "react-icons/gi";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

export const NavbarBootstrap = () => {
  return (
    <>
      <Navbar bg="light" extend="lg">
      <Container>
        <Dropdown>
          <Dropdown.Toggle variant="light" id="dropdown-basic">
            <GiHamburgerMenu className="NavIcon" />
          </Dropdown.Toggle>

          <Dropdown.Menu>
            <Dropdown.Item href="#/Questions">Questions</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        <Navbar.Brand href="/">
          <img
            src="img/stack-overflow.png"
            style={{ height: "25px", padding: "0 0.3rem" }}
          ></img>
          StackOverflow
        </Navbar.Brand>

        <Nav className="me-auto">
          <Nav.Link href="#abouts">About</Nav.Link>
          <Nav.Link href="#products">Product</Nav.Link>
          <Nav.Link href="#forTeams">For Teams</Nav.Link>
        </Nav>

        <Form className="d-flex">
          <Form.Control
            type="search"
            placeholder="Search"
            className="me-2"
            aria-label="Search"
          />
          <Button variant="outline-success">Search</Button>

          <Button variant="secondary">Login</Button>{" "}
            <Button href="#">SignUp</Button>
        </Form>
        </Container>
      </Navbar>
    </>
  );
};
