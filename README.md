# OpenWeatherApp

## Description
OpenWeatherApp is a microservices app that displays the current weather conditions for a specific location using the free OpenWeatherMap API (https://openweathermap.org/api).
<img width="645" alt="Screenshot 2024-03-29 at 2 32 40 PM" src="https://github.com/Neure6676/OpenWeatherApp/assets/72249816/93d35bf0-c6aa-4de9-b863-f8f480e2cc9e">

### Backend: Java Spring Boot 3
Fetch weather data (temperature, feels like, weather description) based on city name or zip code with one entry point, meaning users can input either city name or zip code to a single place, and the app will automatically determine what the input is.

Microservices design:
I developed 3 microservices:
1. OpenWeather service: 
 port 8080
 description: the single entry point with a parameter: location (String). It will determine if user inputed a city name or zip code and call the coresponding service.

2. GetWeatherByCity (ByCity) service: 
 port 8081
 parameter: city
 description: fetch weather data by city name

3. GetWeatherByZip (ByZip) service: 
 port 8082
 parameter: zip
 description: fetch weather data by Zip code

### Frontend: React + Chakra UI

## Demo
1. by city
<img width="852" alt="Screenshot 2024-03-29 at 2 30 24 PM" src="https://github.com/Neure6676/OpenWeatherApp/assets/72249816/33a21ece-a462-4bd2-90dd-2b2ab9fdf5a6">
<img width="784" alt="Screenshot 2024-03-29 at 2 33 51 PM" src="https://github.com/Neure6676/OpenWeatherApp/assets/72249816/3dbf32d6-0ce0-4596-8863-7b2b409dbf0c">




2. by zip
<img width="838" alt="Screenshot 2024-03-29 at 2 31 26 PM" src="https://github.com/Neure6676/OpenWeatherApp/assets/72249816/b959a5a5-6e12-45a1-bac0-f656afa4465d">
<img width="941" alt="Screenshot 2024-03-29 at 2 31 01 PM" src="https://github.com/Neure6676/OpenWeatherApp/assets/72249816/1ec72f3b-4b38-47e2-bb8a-c881636d6588">



