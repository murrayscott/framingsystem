import React from 'react';
import './App.css';
import Menu from './Components/Menu';
import LoginButton from './Components/LoginButton';
import LogoutButton from './Components/LogoutButton';
import Profile from './Components/Profile';
import { useAuth0 } from "@auth0/auth0-react";

function App() {

  const {isLoading,isAuthenticated} = useAuth0();

  if (isLoading) {
      return <div>Loading ...</div>;
    }
  
  if (!isAuthenticated) { 
    // Display when user is logged out - Minimal view
    return (
      <main>
        <header className="column">
          
          <LoginButton />

        </header>
        <body>

        </body>
        <footer>

        </footer>
      </main>
    );
  }
  else {
    // Display when user is logged in
    return (
      <main>
        <header className="column">
          <Menu />
          <LogoutButton />
          <Profile />
        </header>
        <body>
          <div>
           
          </div>
        </body>
        <footer>
          <h3>Footer Content</h3>
        </footer>
      </main>
    )
  }

}

export default App;
