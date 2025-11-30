import axios from "axios";

const API = axios.create({
  baseURL: "http://backend:8080/api"
});


export default API;
