import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import API from "../api";

const EditEmployee = () => {
  const { empid } = useParams();
  const [employee, setEmployee] = useState(null);

  const loadData = async () => {
    const res = await API.get(`/employee/${empid}`);
    setEmployee(res.data);
  };
// eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(() => {
    loadData();
  }, []);

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await API.put("/employee", employee);
    alert("Employee Updated");
  };

  if (!employee) return <h2>Loading...</h2>;

  return (
    <div className="form-container">
      <h2>Edit Employee</h2>

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
        <button className="submit-btn">Save Changes</button>
      </form>
    </div>
  );
};

export default EditEmployee;
