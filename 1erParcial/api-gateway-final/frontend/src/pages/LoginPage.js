import React, { useState, useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';
import './LoginPage.css'; // Estilo opcional para la pantalla de inicio

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const { login } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        if (login(username, password)) {
            navigate('/books'); // Redirigir a la página principal después del login
        } else {
            alert('Credenciales incorrectas');
        }
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Biblioteca</h2>
                <img src="/path-to-your-icon.png" alt="Institución" className="logo" />
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Usuario</label>
                        <input
                            type="text"
                            className="form-control"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Contraseña</label>
                        <input
                            type="password"
                            className="form-control"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit" className="btn btn-primary mt-3">Iniciar Sesión</button>
                </form>
            </div>
        </div>
    );
};

export default LoginPage;
