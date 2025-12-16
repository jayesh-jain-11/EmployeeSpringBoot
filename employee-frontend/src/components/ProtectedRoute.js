import { useContext } from "react";
import { Navigate } from "react-router-dom";
import AuthContext from "../context/AuthContext";

const ProtectedRoute = ({ children }) => {
  const { token, loading } = useContext(AuthContext);

  // wait until AuthContext finishes checking localStorage
  if (loading) return <p>Loading...</p>;

  return token ? children : <Navigate to="/login" replace />;
};

export default ProtectedRoute;
