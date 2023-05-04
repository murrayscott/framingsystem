import React from 'react';
import './App.css';
import LoginButton from './Components/LoginButton';
import LogoutButton from './Components/LogoutButton';
import Profile from './Components/Profile';
import { useAuth0 } from "@auth0/auth0-react";

function App() {

  const {isLoading  } = useAuth0();

  if (isLoading) {
      return <div>Loading ...</div>;
    }

  return (
    <main className="column">
      <header>

       <h3>Auth0 Login</h3>
          <LoginButton />
          <LogoutButton />
          <Profile />
      </header>
      <body>

      </body>
    </main>
  );
}

export default App;
