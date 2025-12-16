import React, { useState, useEffect } from "react";
import API from "../api";
import EmployeeCard from "./EmployeeCard";

const Home = () => {
  const [employees, setEmployees] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  const loadEmployees = async (pageNumber = 0) => {
    const res = await API.get(`/api/employees?page=${pageNumber}&size=5`);
    setEmployees(res.data.data.employees);
    setPage(res.data.data.page);
    setTotalPages(res.data.data.totalPages);
  };

  const deleteEmployee = async (empid) => {
    await API.delete(`/api/employee/${empid}`);
    loadEmployees();
  };

  useEffect(() => {
    loadEmployees(0);
  }, []);

  return (
    <div className="home-container">
      <h1>Employee Directory</h1>

      <div className="card-grid">
        {employees.map((emp) => (
          <EmployeeCard key={emp.empid} emp={emp} onDelete={deleteEmployee} />
        ))}
      </div>

      <div className="pagination">
        <button disabled={page === 0} onClick={() => loadEmployees(page - 1)}>
          Prev
        </button>

        <span>
          {" "}
          Page {page + 1} of {totalPages}{" "}
        </span>

        <button
          disabled={page + 1 === totalPages}
          onClick={() => loadEmployees(page + 1)}
        >
          Next
        </button>
      </div>
    </div>
  );
};

export default Home;
