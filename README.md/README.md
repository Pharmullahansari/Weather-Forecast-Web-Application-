# Full Stack Weather Forecast Application
React (Frontend) + Spring Boot (Backend)

This is a complete full stack Weather Forecast Application using React.js for the frontend and Spring Boot for the backend. The backend connects to the OpenWeather API and returns clean weather data to the React UI.

------------------------------------------------------------

## Features

Frontend (React)
- Search weather for any city
- Shows temperature, feels like temperature, humidity, pressure
- Shows wind speed and visibility
- Modern user interface with gradient design
- Loading and error handling
- Responsive design

Backend (Spring Boot)
- REST API endpoint: /api/weather
- Fetches real-time weather data using OpenWeather API
- Converts raw JSON to clean response model
- Handles invalid city input
- CORS enabled for frontend

------------------------------------------------------------

## Project Structure

Serverside project/
|
├── weather                      (Spring Boot Backend)
│   ├── src/main/java/com/example/weather
│   │   ├── controller
│   │   ├── service
│   │   ├── model
│   │   └── WeatherApplication.java
│   ├── src/main/resources/application.properties
│   └── pom.xml
|
├── weather-frontend             (React Frontend)
│   ├── src
│   │   ├── App.js
│   │   ├── App.css
│   │   └── WeatherApp.jsx
│   ├── public
│   ├── package.json
│   └── package-lock.json
|
└── README.md

------------------------------------------------------------

## Backend Setup (Spring Boot)

1. Go to backend folder
   cd weather

2. Add your OpenWeather API key in:
   src/main/resources/application.properties

   Example:
   spring.application.name=weather
   server.port=8080
   weather.api.key=YOUR_API_KEY
   weather.api.url=https://api.openweathermap.org/data/2.5/weather
   weather.api.units=metric

3. Run the backend
   mvn spring-boot:run

4. Backend URL:
   http://localhost:8080

5. Test API:
   http://localhost:8080/api/weather?city=Delhi

------------------------------------------------------------

## Frontend Setup (React)

1. Go to frontend folder
   cd weather-frontend

2. Install dependencies
   npm install

3. Start the React app
   npm start

4. Frontend will run at:
   http://localhost:3000

------------------------------------------------------------

## API Usage (Frontend to Backend)

React sends request:
GET http://localhost:8080/api/weather?city=CityName

Backend calls:
OpenWeather API → parses response → returns:

Example Response:
{
  "city": "Delhi",
  "country": "IN",
  "temperature": 28,
  "feelsLike": 29,
  "humidity": 62,
  "pressure": 1014,
  "windSpeed": 3.5,
  "visibility": 5000,
  "condition": "clear sky"
}

React displays this result in the UI.

------------------------------------------------------------

## Add Screenshot

Place your screenshot in the project and reference it:
Example:
![Weather Screenshot](./image.png)

Or inside frontend:
![UI](./weather-frontend/image.png)

------------------------------------------------------------

## Technologies Used

Frontend:
- React.js
- CSS3
- JavaScript (ES6)

Backend:
- Spring Boot
- Java
- Maven
- OpenWeather API

------------------------------------------------------------

## How the Application Works (Flow)

React UI → Backend API (/api/weather) → OpenWeather API
          ↑                             |
          |----------- returns data -----|

------------------------------------------------------------

## Future Improvements

- Add weekly forecast
- Add maps support
- Add dark mode
- Deploy backend and frontend online

------------------------------------------------------------

## License

This project is for learning and educational use.
