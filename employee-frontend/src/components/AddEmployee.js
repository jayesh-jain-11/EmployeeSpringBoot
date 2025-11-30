import React, { useState } from "react";
import API from "../api";

const AddEmployee = () => {
  const [employee, setEmployee] = useState({
    empid: "",
    name: "",
    age: "",
    email: "",
    phone: "",
    dept: "",
    salary: "",
    curProject: "",
  });

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await API.post("/employee", employee);
    alert("Employee Added Successfully");
  };

  return (
    <div className="form-container">
      <h2>Add Employee</h2>

      <form onSubmit={handleSubmit}>
        {Object.keys(employee).map((key) => (
          <input
            key={key}
            name={key}
            value={employee[key]}
            onChange={handleChange}
            placeholder={key}
          />
        ))}

        <button type="submit" className="submit-btn">
          Add Employee
        </button>
      </form>
    </div>
  );
};

export default AddEmployee;
