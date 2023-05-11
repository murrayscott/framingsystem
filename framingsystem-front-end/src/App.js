import React from 'react';
import './App.css';

import { useAuth0 } from "@auth0/auth0-react";
import Navbar from './Components/Navbar';
import Home from './Components/pages/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Admin from './Components/pages/Admin';
import Reports from './Components/pages/Reports';

function App() {

  const {isLoading} = useAuth0();

  if (isLoading) {
      return <div>Loading ...</div>;
    }
  
  // Display when user is logged in
  return (
    <main>
      <header className="column">
      </header>
      <article>
        <div>
          <Router>
          <Navbar />
            <Routes>
              <Route path='/' exact component={Home} />
              <Route path='/admin' exact component={Admin} />
              <Route path='/reports' component={Reports} />
            </Routes>
          </Router>
        </div>
      </article>
      <footer>
      </footer>
    </main>
  )
}

export default App;
