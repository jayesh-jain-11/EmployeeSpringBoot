import React from "react";
import { Link } from "react-router-dom";

const EmployeeCard = ({ emp, onDelete }) => {
  return (
    <div className="card">
      <h3>{emp.name}</h3>
      <p>
        <b>ID:</b> {emp.empid}
      </p>
      <p>
        <b>Age:</b> {emp.age}
      </p>
      <p>
        <b>Email:</b> {emp.email}
      </p>
      <p>
        <b>Phone:</b> {emp.phone}
      </p>
      <p>
        <b>Dept:</b> {emp.dept}
      </p>
      <p>
        <b>Salary:</b> ₹{emp.salary}
      </p>
      <p>
        <b>Project:</b> {emp.curProject}
      </p>

      <div className="card-actions">
        <Link to={`/edit/${emp.empid}`}>
          <button className="edit-btn">Edit</button>
        </Link>
        <button className="delete-btn" onClick={() => onDelete(emp.empid)}>
          Delete
        </button>
      </div>
    </div>
  );
};

export default EmployeeCard;
