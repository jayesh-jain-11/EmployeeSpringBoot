import React, { useState, useEffect } from "react";
import API from "../api";
import EmployeeCard from "./EmployeeCard";

const Home = () => {
  const [employees, setEmployees] = useState([]);

  const loadEmployees = async () => {
    const res = await API.get("/employees");
    setEmployees(res.data);
  };

  const deleteEmployee = async (empid) => {
    await API.delete(`/employee/${empid}`);
    loadEmployees();
  };

  useEffect(() => {
    loadEmployees();
  }, []);

  return (
    <div className="home-container">
      <h1>Employee Directory</h1>

      <div className="card-grid">
        {employees.map((emp) => (
          <EmployeeCard key={emp.empid} emp={emp} onDelete={deleteEmployee} />
        ))}
      </div>
    </div>
  );
};

export default Home;
