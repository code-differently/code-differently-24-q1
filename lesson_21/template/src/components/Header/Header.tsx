import React from 'react';
import logo from './logo.png';
import './Header.scss';

export const Header: React.FC = () => {
  return (
    <header className="header">
      <div className="header-logo">
        <a href="/">
          <img src={logo} alt="Code Differently Logo" />
        </a>
      </div>
      <ul className="header-top-menu">
        <li>
          <a href="/">Home</a>
        </li>
        <li>
          <a href="/">About</a>
        </li>
        <li>
          <a href="/">Contact</a>
        </li>
      </ul>
      <div className="header-cta">
        <a className="sign-up-button" href="/">
          Sign Up
        </a>
      </div>
    </header>
  );
};
