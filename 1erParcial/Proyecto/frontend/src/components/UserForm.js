import React, { useState } from "react";

const UserForm = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    role: "",
  });

  const [responseMessage, setResponseMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/users", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        setResponseMessage("Usuario registrado con éxito.");
        setFormData({ name: "", email: "", role: "" });
      } else {
        const errorData = await response.json();
        setResponseMessage(`Error: ${errorData.message}`);
      }
    } catch (error) {
      setResponseMessage(`Error: ${error.message}`);
    }
  };

  return (
    <div style={{ padding: "20px", maxWidth: "500px", margin: "auto" }}>
      <h2>Registrar Usuario</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: "10px" }}>
          <label>Nombre:</label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
            style={{ width: "100%", padding: "8px", marginBottom: "10px" }}
          />
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label>Correo Electrónico:</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
            style={{ width: "100%", padding: "8px", marginBottom: "10px" }}
          />
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label>Rol:</label>
          <select
            name="role"
            value={formData.role}
            onChange={handleChange}
            required
            style={{ width: "100%", padding: "8px", marginBottom: "10px" }}
          >
            <option value="">Seleccione un Rol</option>
            <option value="student">Estudiante</option>
            <option value="teacher">Profesor</option>
          </select>
        </div>
        <button type="submit" style={{ padding: "10px 20px" }}>
          Registrar
        </button>
      </form>
      {responseMessage && <p style={{ marginTop: "20px" }}>{responseMessage}</p>}
    </div>
  );
};

export default UserForm;
