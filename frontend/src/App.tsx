import React from 'react';
import Navbar from "./components/Navbar";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Form from 'pages/Form';
import Listing from "pages/Listing";


function App() {
    return (
        <BrowserRouter>
            <Navbar />
            <Routes>
                <Route path="/" element={<Listing />} />
                <Route path="/form">
                    <Route path=":movieId" element={<Form />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
