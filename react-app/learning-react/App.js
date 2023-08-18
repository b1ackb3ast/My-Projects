import { useState, useEffect } from 'react';
import "./App.css";




// custom component Person
// const Person = (props) => {
//   return (
//     <>
//       <h1>Name: {props.name}</h1>
//       <h1>Last Name: {props.lastName}</h1>
//       <h2>Age: {props.age}</h2>
//     </>
//   );
// };
const App = () => {
  // the useState hook is a built in React hook that allows you to add state to react components
  // common practice is to call the second variable the same name as first variable with set prefix
  const [counter, setCounter] = useState(0);
  // useEffect has a second parameter, the dependency array
  useEffect(() => {
    alert("You've changed the counter to: " + counter);
  }, [counter]);
  return (
    <div className="App">
      {/* use of custom component */}
      {/* <Person name="John" lastName="Doe" age="30" />
      <Person name="Mary" lastName="Doe" age="24" />
      <Person name="Kevin" lastName="Saji" age="22" /> */}

      

      {/* simple increment and decrement of an integer using buttons (use of useState hook) */}
      <button onClick={() => setCounter((prevCount => prevCount -1))}>-</button>
      <h1>{counter}</h1>
      <button onClick={() => setCounter((prevCount => prevCount +1))}>+</button>
    </div>
  );
};

export default App;

// props (properties) allow you to pass dynamic data through react components
// an event is an action that can be triggered by the user or the system. They can be handled
//NEVER MODIFY STATE MANUALLY, NEVER MUTATE THE STATE
// components, state and props are the 3 most important things in React
// hooks such as useState and useEffect are also important