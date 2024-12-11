import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav, Container, Button } from 'react-bootstrap';
import { AuthContext } from '../context/AuthContext';

const AppNavbar = () => {
    const { isAuthenticated, logout } = useContext(AuthContext);

    const handleLogout = () => {
        logout();
    };

    return (
        <Navbar bg="dark" variant="dark" expand="lg">
            <Container>
                <Navbar.Brand as={Link} to="/">Biblioteca</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    {isAuthenticated && (
                        <Nav className="me-auto">
                            <Nav.Link as={Link} to="/users">Usuarios</Nav.Link>
                            <Nav.Link as={Link} to="/books">Libros</Nav.Link>
                            <Nav.Link as={Link} to="/loans">Préstamos</Nav.Link>
                        </Nav>
                    )}
                    {isAuthenticated && (
                        <Button variant="outline-light" onClick={handleLogout}>
                            Cerrar Sesión
                        </Button>
                    )}
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default AppNavbar;
