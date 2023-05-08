import React, { useState } from 'react';
import Profile from './Profile';
import { useAuth0 } from "@auth0/auth0-react";
import { Link } from 'react-router-dom';
import './Navbar.css';
import Dropdown from './Dropdown';
import LogoutButton from './LogoutButton';
import LoginButton from './LoginButton';
import GetData from './pages/GetData';

function Navbar() {
  const [click, setClick] = useState(false);
  const [dropdown, setDropdown] = useState(false);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const onMouseEnter = () => {
    if (window.innerWidth < 960) {
      setDropdown(false);
    } else {
      setDropdown(true);
    }
  };

  const onMouseLeave = () => {
    if (window.innerWidth < 960) {
      setDropdown(false);
    } else {
      setDropdown(false);
    }
  };

  const {isAuthenticated} = useAuth0();

  if (!isAuthenticated) { 
    // Display when user is logged out - Minimal view
    return (
      <>
        <nav className='navbar'>
          <Link to='/' className='navbar-logo' onClick={closeMobileMenu}>
            Otago Framing
            <i class='fab fa-firstdraft' />
          </Link>
          <div className='menu-icon' onClick={handleClick}>
            <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
          </div>
          <ul className={click ? 'nav-menu active' : 'nav-menu'}>
            <li className='nav-item'>
            </li>
          <LoginButton />
          </ul>
        </nav>
        <h1>Please Click Log in to access the Framing System!</h1>
      </>
    );
  }
  else {
    // Display when user is logged in - Full view
    return (
      <>
        <nav className='navbar'>
          <Link to='/' className='navbar-logo' onClick={closeMobileMenu}>
            Otago Framing
            <i class='fab fa-firstdraft' />
          </Link>
          <div className='menu-icon' onClick={handleClick}>
            <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
          </div>
          <ul className={click ? 'nav-menu active' : 'nav-menu'}>
            <li className='nav-item'>
              <Link to='/' className='nav-links' onClick={closeMobileMenu}>
                Home
              </Link>
            </li>
            <li
              className='nav-item'
              onMouseEnter={onMouseEnter}
              onMouseLeave={onMouseLeave}
            >
              <Link
                to='/admin'
                className='nav-links'
                onClick={closeMobileMenu}
              >
                Admin <i className='fas fa-caret-down' />
              </Link>
              {dropdown && <Dropdown />}
            </li>
            <li className='nav-item'>
              <Link
                to='/reports'
                className='nav-links'
                onClick={closeMobileMenu}
              >
                Reports
              </Link>
            </li>
            <Profile />
            <LogoutButton />
          </ul>
        </nav>
        <GetData />
      </>
    );
  }
}

export default Navbar;