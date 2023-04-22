import axios from 'axios'



const SHIP_BASE_URL='http://localhost:8080/admin'

const CUSTOMER_BASE_URL='http://localhost:8080/customer'

// export const Service= {

//      getships:()=>{
//         return axios.get(SHIP_BASE_URL + '/' + Viewallships)
//       }
//     }
    export const Service = {
      getships: () => {
        return axios.get(SHIP_BASE_URL + '/viewallShips');
      },
      post:(message)=>{
        return axios.post(SHIP_BASE_URL + '/addShip',message);
      },
      deleteShip:(shipID)=>{
        return axios.delete(SHIP_BASE_URL + '/deleteShip' + '/' + shipID)
      },
      getschedules: () => {
        return axios.get(SHIP_BASE_URL + '/AllSchedule');
      },
      getRoutes: () => {
        return axios.get(SHIP_BASE_URL + '/AllRoute');
      },
      postRoute:(message)=>{
        return axios.post(SHIP_BASE_URL + '/addRoute',message);
      },
      deleteRoute:(routeID)=>{
        return axios.delete(SHIP_BASE_URL + '/deleteRoute' + '/' + routeID)
      },
      getShipById:(shipID)=>{
        return axios.get(SHIP_BASE_URL + '/ship' + '/' + shipID)
      },
      getRouteById:(routeID)=>{
        return axios.get(SHIP_BASE_URL + '/Route' + '/'+ routeID)
      },
      deleteSchedule:(scheduleID)=>{
        return axios.delete(SHIP_BASE_URL + '/deleteSchedule' + '/' + scheduleID)
      },
      postSchedule:(message)=>{
        return axios.post(SHIP_BASE_URL + '/addSchedule',message);
      },
      updateShip:(shipID, data)=>{
        return axios.put(SHIP_BASE_URL + '/' + shipID, data)
      },
      getLogin: async (userId, password) => {
        const response = await axios.get(
          `${SHIP_BASE_URL}/selectUser/${userId}/${password}`
        );
        return response.data;
      },
      getusrById: (id) => {
        return axios.get(`${SHIP_BASE_URL}/userbyid/${id}`);
       
      },
      Addprofile:(data) => {
        return  axios.post(CUSTOMER_BASE_URL + "/addProfile", data);
        
      },
    };
    