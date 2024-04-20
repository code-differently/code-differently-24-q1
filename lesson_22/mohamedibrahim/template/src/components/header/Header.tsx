import './Header.scss';
import logoImg from '@/assets/logo.png';
import React from 'react';
import { Nav } from 'react-bootstrap';
import {Link} from 'react-router-dom';
import {NavLink} from 'react-router-dom';


export const Header: React.FC = () => {
  return (
    <header className="header">
      <div className="header-logo">
        <a href="/">
          <img src={logoImg} alt="Code Differently Logo" />
        </a>
      </div>
      <nav id="nav-tabs">
      <ul className="header-top-menu">
        <li>
          <Nav defaultActiveKey={'/'} >
            <NavLink to="/" className={({ isActive, isPending }) => isPending ? "pending" : isActive ? "active" : ""} end>
              Home
            </NavLink>
          </Nav>
        </li>
        <li>
          <NavLink to="/add-program" className={({ isActive, isPending }) => isPending ? "pending" : isActive ? "active" : ""} end>
            Add a Program
          </NavLink>
        </li>
        <li>
          <NavLink to="/about" className={({ isActive, isPending }) => isPending ? "pending" : isActive ? "active" : ""} end>
            About
          </NavLink>
        </li>
        <li>
          <NavLink to="/contact" className={({ isActive, isPending }) => isPending ? "pending" : isActive ? "active" : ""} end>
            Contact
          </NavLink>
        </li>
      </ul>
      </nav>
      <div className="header-cta">
        <a href="/signin" className="sign-up-button">
          Sign Up
        </a>
      </div>
    </header>
  );
};