import { useEffect, useState } from "react";
import MovieCard from "./MovieCard";

import "./App.css";
import SearchIcon from "./search.svg";

const API_URL = "http://www.omdbapi.com?apikey=a18bde95";

const App = () => {
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const searchMovies = async (title) => {
    // to call API
    const response = await fetch(`${API_URL}&s=${title}`);
    const data = await response.json();

    setMovies(data.Search);
  };
  useEffect(() => {
    searchMovies("Spiderman");
  }, []);
  return (
    <div className="app">
      <h1>MovieMarket</h1>

      <div className="search">
        <input
          placeholder="Search for movies"
          value={searchTerm}

          // sets searchTerm to whatever the user inputs in the search bar
          onChange={(e) => setSearchTerm(e.target.value)}
        />

        <img src={SearchIcon} 
        alt="search" 
        // Arrow Function: An arrow function is used to define the event handler. This function is executed when the onClick event is triggered.
        // onClick Event: The onClick event is triggered when the user clicks the element to which it's attached. 
        onClick={() => searchMovies(searchTerm)} />
      </div>

      {movies?.length > 0 ? (
        <div className="container">
        {/* iterate over an array of movies and render a component for each movie using the MovieCard component. */}
          {movies.map((movie) => (
            <MovieCard movie={movie} />
          ))}
        </div>
      ) : (
        <div className="empty">
        {/* the message if there are no movies that match the search */}
          <h2>No movies found</h2>
        </div>
      )}
    </div>
  );
};

// we have to export every single one of our components to call it from somewhere else
export default App;
