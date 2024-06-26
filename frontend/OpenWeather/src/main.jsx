import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'

import { ChakraProvider } from '@chakra-ui/react'
import WeatherApp from "./WeatherApp.jsx";

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <ChakraProvider>
          <WeatherApp />
      </ChakraProvider>
  </React.StrictMode>,
)
