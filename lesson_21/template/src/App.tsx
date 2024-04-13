import React from 'react';
import './App.scss';
import {Header} from './components/Header';
import {Footer} from './components/Footer';
import {Home} from './pages/Home';

export const App: React.FC = () => {
  return (
    <div className="App">
      <Header />
      <div className="main">
        <div className="content">
          <Home />
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default App;
